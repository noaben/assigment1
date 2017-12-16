package matala001;

import java.io.BufferedReader;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
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
	 * @param if we want to filter the data or not
	 * @param filterBy  required parameter to filter by.
	 * @param requiredData the required data specific.
	 * @param weightedMAC name of the new weightedMAC file
	 * @return true if export succeed, false otherwise.
	 */
	public static boolean CSVtoKML(String csvpath, String kmlpath, String filter, String filterBy, String requiredData,String weightedMAC){
		LinkedList<Wifi> listofWifi=listOrganized(csvpath,list(csvpath,filter, filterBy, requiredData),weightedMAC);
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
	 * @param filter if we want to filter or not
	 * @param filterBy required parameter to filter by.
	 * @param requiredData the required data specific.
	 * @return List with Wifi's points from the CSV file
	 */
	
	public static LinkedList <Wifi> list (String csvpath,String filter, String filterBy, String requiredData){
		LinkedList <Wifi> wifis=csvToList(csvpath,filter, filterBy, requiredData);
		return wifis;
	    }
	
	private static LinkedList<Wifi> csvToList(String csvpath,String filter, String filterBy, String requiredData){
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
			    if (arr.length>=9){
			
			    
			    if (filter.equals("filtering")){

			     	Wifi w = new Wifi(arr[0], arr[1], arr[2], arr[3], arr[4], "null", "null", "null", "null");

			     	if(cond.fit(w,  filterBy, requiredData))
				      	for (int i = 0; i < Integer.parseInt(arr[5]); i++) 
                         	wifilist.add(new Wifi(arr[0], arr[1], arr[2], arr[3], arr[4], arr[4*i+6], arr[4*i+7], arr[4*i+8], arr[4*i+9]));

				    str=br.readLine();
			        }
			
			    else{

			    	
					Wifi w = new Wifi(arr[0], arr[1], arr[2], arr[3], arr[4], "null", "null", "null", "null");

					for (int i = 0; i < Integer.parseInt(arr[5]); i++) 
							wifilist.add(new Wifi(arr[0], arr[1], arr[2], arr[3], arr[4], arr[4*i+6], arr[4*i+7], arr[4*i+8], arr[4*i+9]));

					str=br.readLine();
				}
			}
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
	 * the function finds Wifi's points that has the same MAC, and combine them to one point with weighted place. 
	 * the function writes the combined points to new CSV file 
	 * @param csvpath comb_csv
	 * @param wifilist List of wifi's points
	 * @param weightedMAC name of the new weightedMAC file
	 * @return organized LinkedList of the wifi's points
	 */
	
	public static LinkedList <Wifi> listOrganized (String csvpath,LinkedList <Wifi> list,String weightedMAC){
		LinkedList <Wifi> wifis=organize(csvpath, list, weightedMAC);
		return wifis;
	}
	

	private static LinkedList<Wifi> organize(String csvpath,LinkedList<Wifi> wifilist,String weightedMAC){

		LinkedList<Wifi> updateList = new LinkedList<Wifi>();
		LinkedList<MAC> w_center = new LinkedList<MAC>();
		
		while(wifilist.size()>0){ 
			//take the first point in the list
			Wifi max = wifilist.get(0);
			wifilist.removeFirst();
            
		    //remove all the points with the same mac from the list
			for(int i=0; i<wifilist.size(); i++){      
				if(wifilist.get(i).getMAC().equals(max.getMAC())){
					if(Double.parseDouble(max.getSignal())>Double.parseDouble(wifilist.get(i).getSignal())){
						max=wifilist.get(i);
						
					    }
					wifilist.remove(i);
					i--;
				   }
			   }
			w_center.add(findPlaceAlgorithm1(csvpath,max.getMAC()));//getting weighted MAC
			updateList.add(new Wifi(max.getTime(),max.getID(),max.getLAT(),max.getLON(),max.getALT(),max.getSSID(),max.getMAC(),max.getFrequncy(),max.getSignal()));//adding the point with the weighted MAC to new list
			
		    }
		
		//writing the points with weighted MAC to new CSV file

		FileWriter writer;

		try {
			writer = new FileWriter(weightedMAC);

			writer.append(""+','+"MAC"+','+"SSID"+','+"Frequncy"+','+"Signal"+','+"Lat"+','+"Lon"+','+"Alt"+','+"TIME"+','+"Approx. w-center algo1"+',');
			writer.append('\n');
			int i=0;
			
		    while(updateList.size()>i){
			     writer.append(Integer.toString(i)+','+updateList.get(i).getMAC()+','+updateList.get(i).getSSID()+','+updateList.get(i).getFrequncy()+','+updateList.get(i).getSignal()+','+w_center.get(i).getLAT()+','+w_center.get(i).getLON()+','+w_center.get(i).getALT()+','+updateList.get(i).getTime()+','+"Approx. w-center algo1"+',');
			     writer.append('\n');
		         i++;
		         }
		    
		    writer.flush();
		    writer.close();

          	} catch (IOException e) {System.out.println("destination unreachable /n "+e);}
		
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
	 * @param path path to the combined CSV file 
	 * @param mac MAC
	 * @return weighted LAN,LON,ALT of the MAC
	 */
	
	
	public static MAC findPlaceAlgorithm1(String path,String mac){
		return findPlace1(path,mac);
	}
	
	 private static MAC findPlace1(String csvpath, String mac){
		   
		    File file = new File(csvpath);   

			if(!file.exists()) {System.out.println("file don't exist"); return null;}

			//reading from the comb_csv file, and putting the points in a list
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
					
					for (int i = 0; i < Integer.parseInt(arr[5]); i++) {
						wifilist.add(new Wifi(arr[0], arr[1], arr[2], arr[3], arr[4], arr[4*i+6], arr[4*i+7], arr[4*i+8], arr[4*i+9]));
						}
					

					str=br.readLine();
				    }
			   }
			catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();}
			catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			   }

			//finding the points that equals the required MAC
			boolean flag=false;
			int n=0;
		
			LinkedList <Wifi>signals=new LinkedList <Wifi>();
			
	                while((wifilist.size()>n) && !flag){  
	        	        if(wifilist.get(n).getMAC().equals(mac)){
	        		     signals.add(wifilist.get(n));
				     }
	        	         n++;
	                        }
	        
			//finding the 5 points that has the best signal and calculating the weighted MAC
			if (signals.size()>5){
				
				Vector <Wifi>maxSignals=new Vector <Wifi>();
				for (int j=0;j<5;j++){
				     double max=Double.parseDouble(signals.get(0).getSignal());
				     int maxPlace=0;
				     for (int k=1;k<signals.size();k++){
				    	    	 if (Double.parseDouble(signals.get(k).getSignal())<max){
				    	    		 max=Double.parseDouble(signals.get(k).getSignal());
				    	    	     maxPlace=k;
				    	            }
				    	         }
				    maxSignals.add(signals.get(maxPlace));
				    signals.remove(maxPlace);
				    }
			   
				
		                  double weight[]={Math.pow((1/(Double.parseDouble(maxSignals.get(0).getSignal()))),2),Math.pow((1/(Double.parseDouble(maxSignals.get(1).getSignal()))),2),Math.pow((1/(Double.parseDouble(maxSignals.get(2).getSignal()))),2),Math.pow((1/(Double.parseDouble(maxSignals.get(3).getSignal()))),2)};

		                 
		                  double wLAT[]={weight[0]*(Double.parseDouble(maxSignals.get(0).getLAT())),weight[1]*(Double.parseDouble(maxSignals.get(1).getLAT())),weight[2]*(Double.parseDouble(maxSignals.get(2).getLAT())),weight[3]*(Double.parseDouble(maxSignals.get(3).getLAT())),weight[4]*(Double.parseDouble(maxSignals.get(4).getLAT()))};
		                  double wLON[]={weight[0]*(Double.parseDouble(maxSignals.get(0).getLON())),weight[1]*(Double.parseDouble(maxSignals.get(1).getLON())),weight[2]*(Double.parseDouble(maxSignals.get(2).getLON())),weight[3]*(Double.parseDouble(maxSignals.get(3).getLON())),weight[4]*(Double.parseDouble(maxSignals.get(4).getLON()))};
		                  double wAlt[]={weight[0]*(Double.parseDouble(maxSignals.get(0).getALT())),weight[1]*(Double.parseDouble(maxSignals.get(1).getALT())),weight[2]*(Double.parseDouble(maxSignals.get(2).getALT())),weight[3]*(Double.parseDouble(maxSignals.get(3).getALT())),weight[4]*(Double.parseDouble(maxSignals.get(4).getALT()))};
	                          double sum[]={weight[0]+weight[1]+weight[2]+weight[3]+weight[4],wLAT[0]+wLAT[1]+wLAT[2]+wLAT[3]+wLAT[4],wLON[0]+wLON[1]+wLON[2]+wLON[3]+wLON[4],wAlt[0]+wAlt[1]+wAlt[2]+wAlt[3]+wAlt[4]};
	                          double wSum[]={sum[1]/sum[0],sum[2]/sum[0],sum[3]/sum[0]};
	      
	      
	                         MAC macList=new MAC(mac,wSum[0],wSum[1],wSum[2]);
	                         return macList;
			}
			
		       //there are less then 5 points with the same MAC
		       else{
			         double weight[]=new double[signals.size()]; double wLAT[]=new double[signals.size()];double wLON[]=new double[signals.size()];double wAlt[]=new double[signals.size()]; double sum[]={0,0,0,0};
			  
			         for(int p=0;p<signals.size();p++)
				      weight[p]=Math.pow((1/Double.parseDouble(signals.get(p).getSignal())),2);
			  
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
			         MAC macList=new MAC(mac,wSum[0],wSum[1],wSum[2]);
			         return macList;
	                   }
                      }
	
	
	/**
	 * the function gets file with GPS points and file with no GPS points. the function finds estimated location, and writes him into a new file.
	 * @param csvpath path to the unified CSV file 
	 * @param no_gps path to the file with the missing GPS points
	 * @param algo2 path to the file with the estimated place
	 */
	
	public static void findPlaceAlgorithm2(String CSVpath,  String no_gps,String algo2){
		findPlace2( CSVpath,  no_gps,algo2);
	}
	
	private static void findPlace2( String CSVpath,  String no_gps,String algo2){
		
		 FileWriter writer;

	 	   try {
			writer = new FileWriter( algo2);
		
	          	File file1 = new File(no_gps);   

		        if(!file1.exists()) {System.out.println("file don't exist"); }
        
		        FileReader fr1;
		        BufferedReader br1;
		
	        	try {
	        		
	        		//reading data of signal and MAC for every line from the file with no GPS
	        		
		          	fr1 = new FileReader(file1);
			        br1 = new BufferedReader(fr1);
			
			        String str1=br1.readLine();
			        
		        	while(str1!=null){
		     
			              String arr1[]=str1.split(",");
			    
			              String signalPoint[]=new String [Integer.parseInt(arr1[5])]; //array of signals from one line from the no GPS file
		                      String macPoint[]=new String [Integer.parseInt(arr1[5])];//array of matching MAC
		    
		                      int c=0;
		    
			              for (int i=0;i<Integer.parseInt(arr1[5]);i++){
			          	  signalPoint[i]=arr1[9+i*4];
				          macPoint[i]=arr1[7+i*4];
				          }
			        
			       
	                              double signalMatch[]=new double [signalPoint.length];
	                              double diff[]=new double [signalPoint.length];
	                              double w[]=new double [signalPoint.length];
	                              LinkedList <Weight> p=new LinkedList <Weight>();
	    
	                              //reading from the comb_file with GPS data
	            	
		                      File file2 = new File(CSVpath);   

		                      if(!file2.exists()) {System.out.println("file don't exist"); }
        
		                      FileReader fr2;
		                      BufferedReader br2;

		                      try {
			                  fr2 = new FileReader(file2);
			                  br2 = new BufferedReader(fr2);
			       
			                  String str2="";
			                  String[] arr2;
                   
			                  br2.readLine();
			                  str2=br2.readLine();
            
			                  int y=0;
					      
			                  while(str2!=null){
			            	 
			                        arr2=str2.split(",");
				
			                        //reading data of signal and MAC for every line from the combined file
			                
				                String signal[]=new String[Integer.parseInt(arr2[5])];//array of signals from one line from the no combined file
				                String mac[]=new String[Integer.parseInt(arr2[5])];//array of matching MAC
						  
				                for (int i = 0; i < Integer.parseInt(arr2[5]); i++) {
				                     signal[i]=arr2[4*i+9];
				                     mac[i]=arr2[4*i+7];
				                     }
			
				                //comparing data from the no_gps file to the data in the combined file
			                        for (int i=0;i<macPoint.length;i++){
			                        boolean flag=true;
			                     
				                 for (int j=0;j<mac.length;j++){
				                       if (macPoint[i].equals(mac[j]) && flag){
				          	                 signalMatch[i]=Double.parseDouble(signal[j]);//if the MAC matches,take the signal from the combined file
				        	                 diff[i]=Math.max(3,Math.abs(signalMatch[i]-Double.parseDouble(signalPoint[i])));//difference of the signals
				        	                 flag=false;
				                            }
				                        }
				        
				                 if (flag){
				    	              signalMatch[i]=-120; //if the MAC doesn't match,take -120 to be the signal
				           	      diff[i]=100;//if the MAC doesn't match,take 100 to be the diff
				                      }
	
				                 w[i]=10000/(Math.pow(diff[i],0.4)*Math.pow(Double.parseDouble(signalPoint[i]),2));
				
				                }
			
			                        //calculate the weight of the line
				                double weight=1;   
				                for (int i=0;i<w.length;i++){
					             weight*=w[i];
                           
				                     }
	                    
				                //put the weight and the place in p[i]
			    	                p.add(new Weight(Double.parseDouble(arr2[2]),Double.parseDouble(arr2[3]),Double.parseDouble(arr2[4]),weight));
				                str2=br2.readLine();
		                                }
		
		                       } catch (FileNotFoundException e) {
		       	              // TODO Auto-generated catch block
		    	                e.printStackTrace();
		                       } catch (IOException e) {
		    	              // TODO Auto-generated catch block
		    	              e.printStackTrace();
		                       }
		            
		         //take the 4 lines that their weight is the biggest
		         LinkedList <Weight> maxP=new LinkedList <Weight>();
		         int n=4;
		
		         for (int i=0;i<n;i++){
		             maxP.add(new Weight(p.get(i)));
			     for (int j=i+1;j<p.size();j++)
			     if (maxP.get(i).getW()<p.get(j).getW()){
				         	Weight t=new Weight(maxP.get(i));
					        maxP.get(i).setWeight(p.get(j));
					        p.get(j).setWeight(t);
				           }
			       
		             }
		
		        //get the estimated place
		        double weight[]=new double[n];double wLAT[]=new double[n]; double wLON[]=new double[n];double wAlt[]=new double[n];double sum[]=new double[n];
		        for (int i=0;i<n;i++){
		            weight[i]=maxP.get(i).getW();
	                    wLAT[i]=maxP.get(i).getLAT()* weight[i];
	                    wLON[i]=maxP.get(i).getLON()*weight[i];
	                    wAlt[i]=maxP.get(i).getALT()* weight[i];
	                    sum[i]=0;
		            }
		        
		        for (int i=0;i<n;i++){
                            sum[0]+=weight[i];sum[1]+=wLAT[i];sum[2]+=wLON[i];sum[3]+=wAlt[i];}
					
		        double wSum[]={sum[1]/sum[0],sum[2]/sum[0],sum[3]/sum[0]};
			
                        //writing the GPS data to a new file

	        	writer.append(arr1[0]+','+arr1[1]+','+wSum[0]+','+wSum[1]+','+wSum[2]+',');
			
	        	for (int i=5;i<arr1.length;i++)
			      	writer.append(arr1[i]+',');
			
		        writer.append('\n');
		
		        str1=br1.readLine();
		

	
		        }
		    writer.flush();
		    writer.close();	
	        }
		catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	} catch (IOException e) {System.out.println("destination unreachable /n "+e);}

	}

	
}
