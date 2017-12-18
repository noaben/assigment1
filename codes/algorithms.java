package noa;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Vector;

public class algorithms {


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
			   
				
		        double weight[]={Math.pow((1/(Double.parseDouble(maxSignals.get(0).getSignal()))),2),Math.pow((1/(Double.parseDouble(maxSignals.get(1).getSignal()))),2),Math.pow((1/(Double.parseDouble(maxSignals.get(2).getSignal()))),2),Math.pow((1/(Double.parseDouble(maxSignals.get(3).getSignal()))),2),Math.pow((1/(Double.parseDouble(maxSignals.get(4).getSignal()))),2)};

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

		     
			        fr2 = new FileReader(file2);
			        br2 = new BufferedReader(fr2);
			       
			        String str2="";
			        String[] arr2;
                   
			        br2.readLine();
			        str2=br2.readLine();
			        
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
		} 
	} catch (IOException e) {System.out.println("destination unreachable /n "+e);}

	}

}
