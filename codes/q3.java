package matala001;
//q3

import java.io.BufferedReader;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Vector;

import de.micromata.opengis.kml.v_2_2_0.Document;
import de.micromata.opengis.kml.v_2_2_0.Kml;
import de.micromata.opengis.kml.v_2_2_0.KmlFactory;

/**
 * 
 * @author Ben and Noa
 *
 */
public class q3 implements Filter{

	/***
	 * This method read CSV file with wifi's points, filter it by data parameters and export to KML file.
	 *  print succeed message if export succeed. "failed" otherwise.
	 * 
	 * @param csvpath path to the CSV file
	 * @param kmlpath name to the new KML file
	 * @param filterBy  required parameter to filter by.
	 * @param requiredData the required data specific.
	 * @return true if export succeed, false otherwise.
	 */
	public static boolean CSVtoKML(String csvpath, String kmlpath, String filterBy, String requiredData){
		LinkedList<Wifi> listofWifi=listOrganized(csvpath,list(csvpath, filterBy, requiredData));
		boolean s= kml(listofWifi, kmlpath);
		if(s){
			System.out.println("export to KML succeed!");
			return true;
		    }
		else {
			System.out.println("failed export to KML.");
			return false;
		}
		
	}
	
	/**
	 * This method reads from the csv's file , filters the required wifi's points, and put them in the LinkedList
	 * @param csvpath The path to the CSV file
	 * @param filterBy required parameter to filter by.
	 * @param requiredData the required data specific.
	 * @return List with Wifi's points from the CSV file
	 */
	
	public static LinkedList <Wifi> list (String csvpath, String filterBy, String requiredData){
		LinkedList <Wifi> wifis=csvToList(csvpath, filterBy, requiredData);
		return wifis;
	    }
	
	private static LinkedList<Wifi> csvToList(String csvpath, String filterBy, String requiredData){
		File file = new File(csvpath);   

		if(!file.exists()) {System.out.println("file don't exist"); return null;}

		FileReader fr;
		BufferedReader br;
		LinkedList<Wifi> wifilist=new LinkedList<Wifi>();

		try {
			fr = new FileReader(file);
			br = new BufferedReader(fr);
			String str="";
			String[] arr;

			Filter cond = new q3();

			br.readLine();
			str=br.readLine();

			while(str!=null){

				arr=str.split(",");

				Wifi w = new Wifi(arr[0], arr[1], arr[2], arr[3], arr[4], "null", "null", "null", "null");

				if(cond.fit(w,  filterBy, requiredData)){
					for (int i = 0; i < Integer.parseInt(arr[5]); i++) {

						wifilist.add(new Wifi(arr[0], arr[1], arr[2], arr[3], arr[4], arr[4*i+6], arr[4*i+7], arr[4*i+8], arr[4*i+9]));

					}
				}

				str=br.readLine();
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

			
		return wifilist;

	}


	/**
	 * @param Wifi the object with the data
	 * @param data filterd data
	 * @param required data
	 * @return true if wifi compliance with conditions, false if isn't
	 */
	@Override
	public boolean fit(Wifi wifi, String data, String req) {
	
			if(data.equals("ID")){
				if(wifi.getID().equals(req)) return true;
			}
			if(data.equals("Time")){
				if(req.equals(wifi.getTime().substring(0,16))) return true;
			}
			if(data.equals("Place")){
				if(Math.sqrt(Math.pow(Double.parseDouble(wifi.getLON())-Double.parseDouble(req.split(",")[0]),2)+Math.pow(Double.parseDouble(wifi.getLAT())-Double.parseDouble(req.split(",")[1]),2))<0.005)
					return true;
			}
		
		return false;

	}
	
	
	/**
	 * if Wifi's have the same MAC- the one with the best signal will be kept in the linkedList 
	 * @param wifilist List of wifi's points
	 * @return organized LinkedList of the wifi's points
	 */
	
	public static LinkedList <Wifi> listOrganized (String csvpath,LinkedList <Wifi> list){
		LinkedList <Wifi> wifis=organize(csvpath, list);
		return wifis;
	}
	

	private static LinkedList<Wifi> organize(String csvpath,LinkedList<Wifi> wifilist){

		LinkedList<Wifi> updateList = new LinkedList<Wifi>();

		while(wifilist.size()>0){   			
			Wifi max = wifilist.get(0);
			wifilist.removeFirst();

			for(int i=0; i<wifilist.size(); i++){      
				if(wifilist.get(i).getMAC().equals(max.getMAC())){
					if(Integer.parseInt(max.getSignal())>Integer.parseInt(wifilist.get(i).getSignal())){

						max=wifilist.get(i);

					}
					wifilist.remove(i);
					i--;
				}
			}
			MAC m=findPlaceAlgorithm1(csvpath,max.getMAC());
			updateList.add(new Wifi(max.getTime(),max.getID(),Double.toString(m.getLAT()),Double.toString(m.getLON()),Double.toString(m.getALT()),max.getSSID(),max.getMAC(),max.getFrequncy(),max.getSignal()));
		}

		return updateList;
	}


	/**
	 * this method creates the KML file 
	 * @param newlist  list of wifis that need to be presented
	 * @param path of the KML file
	 */
	private static boolean kml(LinkedList<Wifi> updateList, String path) {

		if((updateList==null)||(updateList.size()==0)) return false;

		Kml kml=KmlFactory.createKml();

		Document doc = kml.createAndSetDocument().withName("wifi");

		for(int i=0; i<updateList.size(); i++){
			updateList.get(i).kmlGenerator(doc);
		}


		try {
			kml.marshal(new File(path));
		} catch (FileNotFoundException e) {
			System.out.println("Error creating file");
			return false;
		}


		return true;
	}

	
	/**
	 * @param path path to the unified CSV file 
	 * @param mac MAC
	 * @return weighted LAN,LON,ALT of the MAC
	 */
	
	
	public static MAC findPlaceAlgorithm1(String path,String mac){
		return findPlace1(path,mac);
	}
	
	 private static MAC findPlace1(String csvpath, String mac){
		   
		    File file = new File(csvpath);   

			if(!file.exists()) {System.out.println("file don't exist"); return null;}

			FileReader fr;
			BufferedReader br;
			LinkedList<Wifi> wifilist=new LinkedList<Wifi>();

			try {
				fr = new FileReader(file);
				br = new BufferedReader(fr);
				String str="";
				String[] arr;

				br.readLine();
				str=br.readLine();

				while(str!=null){

					arr=str.split(",");

					Wifi w = new Wifi(arr[0], arr[1], arr[2], arr[3], arr[4], "null", "null", "null", "null");

					for (int i = 0; i < Integer.parseInt(arr[5]); i++) {
						wifilist.add(new Wifi(arr[0], arr[1], arr[2], arr[3], arr[4], arr[4*i+6], arr[4*i+7], arr[4*i+8], arr[4*i+9]));
						}
					

					str=br.readLine();
				}
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}


			
			boolean flag=false;
			int n=0;
		
			LinkedList <Wifi>signals=new LinkedList <Wifi>();
			
	                while((wifilist.size()>n) && !flag){  
	        	    if(wifilist.get(n).getMAC().equals(mac)){
	        		 signals.add(wifilist.get(n));
	        	         flag=true;
	        	         }
	        	     n++;
	                }
	        
			for(int i=n; i<wifilist.size(); i++){      
				if(wifilist.get(i).getMAC().equals(mac)){
						signals.add(wifilist.get(i));
					    }
				}
			
		
					
			if (signals.size()>4){
				
				Vector <Wifi>maxSignals=new Vector <Wifi>();
				for (int j=0;j<4;j++){
				     int max=Integer.parseInt(signals.get(0).getSignal());
				     int maxPlace=0;
				     for (int k=1;k<signals.size();k++){
				    	    	 if (Integer.parseInt(signals.get(k).getSignal())<max){
				    	    		 max=Integer.parseInt(signals.get(k).getSignal());
				    	    	     maxPlace=k;
				    	            }
				    	         }
				    maxSignals.add(signals.get(maxPlace));
				    signals.remove(maxPlace);
				    }
				
		       double weight[]={Math.pow((1.0000000/(Integer.parseInt(maxSignals.get(0).getSignal()))),2),Math.pow((1.000000/(Integer.parseInt(maxSignals.get(1).getSignal()))),2),Math.pow((1.000000/(Integer.parseInt(maxSignals.get(2).getSignal()))),2),Math.pow((1.000000/(Integer.parseInt(maxSignals.get(3).getSignal()))),2)};
		       double wLAT[]={weight[0]*(Double.parseDouble(maxSignals.get(0).getLAT())),weight[1]*(Double.parseDouble(maxSignals.get(1).getLAT())),weight[2]*(Double.parseDouble(maxSignals.get(2).getLAT())),weight[3]*(Double.parseDouble(maxSignals.get(3).getLAT()))};
		       double wLON[]={weight[0]*(Double.parseDouble(maxSignals.get(0).getLON())),weight[1]*(Double.parseDouble(maxSignals.get(1).getLON())),weight[2]*(Double.parseDouble(maxSignals.get(2).getLON())),weight[3]*(Double.parseDouble(maxSignals.get(3).getLON()))};
		       double wAlt[]={weight[0]*(Double.parseDouble(maxSignals.get(0).getALT())),weight[1]*(Double.parseDouble(maxSignals.get(1).getALT())),weight[2]*(Double.parseDouble(maxSignals.get(2).getALT())),weight[3]*(Double.parseDouble(maxSignals.get(3).getALT()))};
	               double sum[]={weight[0]+weight[1]+weight[2]+weight[3],wLAT[0]+wLAT[1]+wLAT[2]+wLAT[3],wLON[0]+wLON[1]+wLON[2]+wLON[3],wAlt[0]+wAlt[1]+wAlt[2]+wAlt[3]};
	               double wSum[]={sum[1]/sum[0],sum[2]/sum[0],sum[3]/sum[0]};
	               MAC macList=new MAC(mac,(int)(wSum[0]*10000000)/10000000.0000000,(int)(wSum[1]*10000000)/10000000.0000000,(int)(wSum[2]*10000000)/10000000.0000000);
	               return macList;
			
			}
			
		  else{
			  double weight[]=new double[signals.size()]; double wLAT[]=new double[signals.size()];double wLON[]=new double[signals.size()];double wAlt[]=new double[signals.size()]; double sum[]={0,0,0,0};
			  for(int p=0;p<signals.size();p++)
				      weight[p]=Math.pow((1.000000/(Integer.parseInt(signals.get(p).getSignal()))),2);
				      for(int p=0;p<signals.size();p++){
				    	  wLAT[p]=weight[p]*(Double.parseDouble(signals.get(p).getLAT()));
				    	  wLON[p]=weight[p]*(Double.parseDouble(signals.get(p).getLON()));
				    	  wAlt[p]=weight[p]*(Double.parseDouble(signals.get(p).getALT()));
				          }
				      for(int p=0;p<signals.size();p++){
				    	  sum[0]+=weight[p];
				          sum[1]+=wLAT[p];
				    	  sum[2]+=wLON[p];
				    	  sum[3]+=wAlt[p];
				      }
				      double wSum[]={sum[1]/sum[0],sum[2]/sum[0],sum[3]/sum[0]};
				      MAC macList=new MAC(mac,(int)(wSum[0]*10000000)/10000000.0000000,(int)(wSum[1]*10000000)/10000000.0000000,(int)(wSum[2]*10000000)/10000000.0000000);
				      return macList;
		   }
	}
	
	
	/**
	 * @param csvpath path to the unified CSV file 
	 * @param signal1 signal
	 * @param mac1 the mac where we received signal1
	 * @param signal2 signal
	 * @param mac2 the mac where we received signal2
	 * @param signal3 signal
	 * @param mac3 the mac where we received signal3
	 * @return weighted place
	 */
	
	public static String findPlaceAlgorithm2(String csvpath,String signal1,String mac1,String signal2,String mac2,String signal3,String mac3){
		return findPlace2(csvpath, signal1,mac1,signal2, mac2, signal3, mac3);
	}
	

	private static String findPlace2(String csvpath,String signal1,String mac1,String signal2,String mac2,String signal3,String mac3){
	    String signalPoint[]={signal1,signal2,signal3};
	    String macPoint[]={mac1,mac2,mac3};
	    
	    double signalMatch[]=new double [signalPoint.length];
	    double diff[]=new double [signalPoint.length];
	    double w[]=new double [signalPoint.length];
	    LinkedList <Weight> p=new LinkedList <Weight>();
	    
		File file = new File(csvpath);   

		if(!file.exists()) {System.out.println("file don't exist"); return null;}
        
		FileReader fr;
		BufferedReader br;

		try {
			fr = new FileReader(file);
			br = new BufferedReader(fr);
			String str="";
			String[] arr;

			br.readLine();
			str=br.readLine();
            
			while(str!=null){
				arr=str.split(",");
				
				String signal[]=new String[Integer.parseInt(arr[5])];
				String mac[]=new String[Integer.parseInt(arr[5])];
				for (int i = 0; i < Integer.parseInt(arr[5]); i++) {
				signal[i]=arr[4*i+9];
				mac[i]=arr[4*i+7];
		
				}
			
			    for (int i=0;i<macPoint.length;i++){
			         boolean flag=true;
				     for (int j=0;j<mac.length;j++){
				          if (macPoint[i].equals(mac[j]) && flag){
				        	  signalMatch[i]=Double.parseDouble(signal[j]);
				        	  diff[i]=Math.max(3,Math.abs(signalMatch[i]-Double.parseDouble(signalPoint[i])));
				        	  flag=false;
				          }
				     }
				     if (flag){
				    	 signalMatch[i]=-120; 
				    	 diff[i]=100;
				         }
	
				     w[i]=10000/(Math.pow(diff[i],0.4)*Math.pow(Double.parseDouble(signalPoint[i]),2));
				
				     }
			
				 double weight=1;   
				 for (int i=0;i<w.length;i++){
					 weight*=w[i];

				 }
	
				 p.add(new Weight(Double.parseDouble(arr[2]),Double.parseDouble(arr[3]),Double.parseDouble(arr[4]),weight));
				 str=br.readLine();
			}
		
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		LinkedList <Weight> maxP=new LinkedList <Weight>();
		
		for (int i=0;i<3;i++){
			maxP.add(new Weight(p.get(i)));
			for (int j=i+1;j<p.size();j++)
				if (maxP.get(i).getW()<p.get(j).getW()){
					Weight t=new Weight(maxP.get(i));
					maxP.get(i).setWeight(p.get(j));
					p.get(j).setWeight(t);
				}
		    }
		
		
		 double weight[]={maxP.get(0).getW(),maxP.get(1).getW(),maxP.get(2).getW()};
	         double wLAT[]={maxP.get(0).getLAT()* weight[0],maxP.get(1).getLAT()* weight[1],maxP.get(2).getLAT()* weight[2]};
	         double wLON[]={maxP.get(0).getLON()*weight[0],maxP.get(1).getLON()* weight[1],maxP.get(2).getLON()* weight[2]};
	         double wAlt[]={maxP.get(0).getALT()* weight[0],maxP.get(1).getALT()* weight[1],maxP.get(2).getALT()* weight[2]};
                 double sum[]={weight[0]+weight[1]+weight[2],wLAT[0]+wLAT[1]+wLAT[2], wLON[0]+ wLON[1]+ wLON[2],wAlt[0]+wAlt[1]+wAlt[2]};
                 double wSum[]={(int)(sum[1]/sum[0]*10000000)/10000000.0000000,(int)(sum[2]/sum[0]*10000000)/10000000.0000000,(int)(sum[3]/sum[0]*10000000)/10000000.0000000};
         
  
                 return "LAT: "+wSum[0]+" LON: "+wSum[1]+" ALT: "+wSum[2];

	}

	
}
