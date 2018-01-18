package matalaMunche;

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
         * @param n number of strongest points
	 * @param mac MAC
	 * @return weighted LAN,LON,ALT of the MAC
	 */
	



	public static MAC findPlaceAlgorithm1(String path, String mac,int n){
		return findPlace1(path, mac,n);
	       }
	
	 private static MAC findPlace1(String csvpath, String mac,int n){
		   
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
			int t=0;
		
			LinkedList <Wifi>signals=new LinkedList <Wifi>();
			
	                while((wifilist.size()>t) && !flag){  
	        	      if(wifilist.get(t).getMAC().equals(mac)){
	        		     signals.add(wifilist.get(t));
	  
	        	      }
	        	 t++;
	             }
	        
     

			//finding the n points that has the best signal and calculating the weighted MAC
			if (signals.size()>n){
				
				Vector <Wifi>maxSignals=new Vector <Wifi>();
				for (int j=0;j<n;j++){
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

                                double weight[]=new double[n]; double wLAT[]=new double[n]; double wLON[]=new double[n]; double wAlt[]=new double[n]; double sum[]={0,0,0,0};
                        
                                for (int i=0;i<n;i++){
                                    weight[i]=Math.pow((1/(Double.parseDouble(maxSignals.get(i).getSignal()))),2);
                                    wLAT[i]=weight[i]*(Double.parseDouble(maxSignals.get(i).getLAT()));
                                    wLON[i]=weight[i]*(Double.parseDouble(maxSignals.get(i).getLON()));
                                    wAlt[i]=weight[i]*(Double.parseDouble(maxSignals.get(i).getALT()));

                                    }

			        for (int i=0;i<n;i++){
                                      sum[0]+=weight[i];sum[1]+=wLAT[i];sum[2]+=wLON[i];sum[3]+=wAlt[i];}
                       
		        
	                        double wSum[]={sum[1]/sum[0],sum[2]/sum[0],sum[3]/sum[0]};
	      
	                        MAC macList=new MAC(mac,wSum[0],wSum[1],wSum[2]);
	                        return macList;
			       }
			
		        //there are less then n points with the same MAC
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
     * @param n number of similar data
     * @param norm norm
	 * @param sig_diff power of sig_diff
	 * @param power power 
	 * @param algo2 path to the file with the estimated place
	 */
	
	public static void findPlaceAlgorithm2(String CSVpath,  String no_gps,int n,double norm,double sig_diff,double power,String algo2){
		findPlace2( CSVpath,  no_gps,n,norm,sig_diff,power,algo2);
	}
	
	private static void findPlace2( String CSVpath,  String no_gps,int n,double norm,double sig_diff,double power,String algo2){
		
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

                               boolean flag2=false; //no match at all the file

			        
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
                                                         flag2=true;
				                         }
				                  }
				        
				             if (flag){
				    	          signalMatch[i]=-120; //if the MAC doesn't match,take -120 to be the signal
				           	  diff[i]=100;//if the MAC doesn't match,take 100 to be the diff
				                  }
	
				             w[i]=norm/(Math.pow(diff[i],sig_diff)*Math.pow(Double.parseDouble(signalPoint[i]),power));
				
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
		
		        
		            
		         //take the n lines that their weight is the biggest
		         LinkedList <Weight> maxP=new LinkedList <Weight>();
		          
                         if (flag2){
				 
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
		             double weight[]=new double[n];double wLAT[]=new double[n]; double wLON[]=new double[n];double wAlt[]=new double[n];double sum[]={0,0,0,0};
		             for (int i=0;i<n;i++){
		                  weight[i]=maxP.get(i).getW();
	                          wLAT[i]=maxP.get(i).getLAT()* weight[i];
	                          wLON[i]=maxP.get(i).getLON()*weight[i];
	                          wAlt[i]=maxP.get(i).getALT()* weight[i];
	       
		                  }
		        
		           
		             for (int i=0;i<maxP.size();i++)
		        	 System.out.println(maxP.get(i));
		        
		             for (int i=0;i<n;i++){
                                 sum[0]+=weight[i];sum[1]+=wLAT[i];sum[2]+=wLON[i];sum[3]+=wAlt[i];}
		        	
                             double wSum[]={sum[1]/sum[0],sum[2]/sum[0],sum[3]/sum[0]};
                         
			
                             //writing the GPS data to a new file
                      
	        	    writer.append(arr1[0]+','+arr1[1]+','+wSum[0]+','+wSum[1]+','+wSum[2]+',');}
                        else
                            writer.append(arr1[0]+','+arr1[1]+','+null+','+null+','+null+',');
			
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
	

	/**
	 * the function gets file with GPS points and file with no GPS points. the function finds estimated location, and writes him into a new file.
	 * @param csvpath path to the unified CSV file 
	 * @param no_gps string of no_gps data
     * @param n number of similar data
	 * @param norm norm
	 * @param sig_diff power of sig_diff
	 * @param power power
	 * return string with data of the place
	 */
	
	public static String findPlaceAlgorithm2(String CSVpath,  String no_gps,int n,double norm,double sig_diff,double power){
		return findPlace2( CSVpath,  no_gps,n,norm,sig_diff,power);
	}


    private static String findPlace2( String CSVpath,  String no_gps,int n,double norm,double sig_diff,double power) {
	
	
	     
		String arr1[]=no_gps.split(",");
		    
		String signalPoint[]=new String [Integer.parseInt(arr1[5])]; //array of signals from one line from the no GPS file
	        String macPoint[]=new String [Integer.parseInt(arr1[5])];//array of matching MAC
	    
	    
		for (int i=0;i<Integer.parseInt(arr1[5]);i++){
		          signalPoint[i]=arr1[9+i*4];
			  macPoint[i]=arr1[7+i*4];
			  System.out.println(signalPoint[i]+" "+macPoint[i]);
			       
		         }
		       
                double signalMatch[]=new double [signalPoint.length];
                double diff[]=new double [signalPoint.length];
                double w[]=new double [signalPoint.length];
                LinkedList <Weight> p=new LinkedList <Weight>();
   
                boolean flag2=false;
               //reading from the comb_file with GPS data
           	    try{
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
                                                         flag2=true;
			                                 }
			                        }
			        
			             if (flag){
			    	             signalMatch[i]=-120; //if the MAC doesn't match,take -120 to be the signal
			           	     diff[i]=100;//if the MAC doesn't match,take 100 to be the diff
			                     }

			                 w[i]=norm/(Math.pow(diff[i],sig_diff)*Math.pow(Double.parseDouble(signalPoint[i]),power));
			
			              }
		
		                //calculate the weight of the line
			        double weight=1;   
			        for (int i=0;i<w.length;i++){
				     weight*=w[i];
			            }
			            
			       //put the weight and the place in p[i]
		    	   p.add(new Weight(Double.parseDouble(arr2[2]),Double.parseDouble(arr2[3]),Double.parseDouble(arr2[4]),weight));
			       str2=br2.readLine();
	              }}
		        catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} 
           	 catch (IOException eL) {
					// TODO Auto-generated catch block
					eL.printStackTrace();
				} 
	        
	        
	            
	         //take the n lines that their weight is the biggest
	         LinkedList <Weight> maxP=new LinkedList <Weight>();
	          
             if (flag2){
	         for (int i=0;i<n;i++){
	         	  maxP.add(new Weight(p.get(i)));
		          for (int j=i+1;j<p.size();j++)
		              if (maxP.get(i).getW()<p.get(j).getW()){
			         	Weight t=new Weight(maxP.get(i));
				        maxP.get(i).setWeight(p.get(j));
				        p.get(j).setWeight(t);
			           }
		       
	            }
	            
	        for (int i=0;i<maxP.size();i++)
	        	 System.out.println(maxP.get(i));
	
	        //get the estimated place
	        double weight[]=new double[n];double wLAT[]=new double[n]; double wLON[]=new double[n];double wAlt[]=new double[n];double sum[]={0,0,0,0};
	        for (int i=0;i<n;i++){
	            weight[i]=maxP.get(i).getW();
                    wLAT[i]=maxP.get(i).getLAT()* weight[i];
                    wLON[i]=maxP.get(i).getLON()*weight[i];
                    wAlt[i]=maxP.get(i).getALT()* weight[i];
      
	            }
	        
	        for (int i=0;i<n;i++){
                sum[0]+=weight[i];sum[1]+=wLAT[i];sum[2]+=wLON[i];sum[3]+=wAlt[i];}
	        	
                double wSum[]={sum[1]/sum[0],sum[2]/sum[0],sum[3]/sum[0]};
                int lat=(int)(wSum[0]*1000000); int lon=(int)(wSum[1]*1000000); int alt=(int)(wSum[2]*1000000);
                double lat1=(double)lat/1000000; double lon1=(double)lon/1000000; double alt1=(double)alt/1000000;
           
		return "Lat: "+lat1+" Lon: "+lon1+" Alt: "+alt1;}
	    
     return"Lat: "+null+" Lon: "+null+" Alt: "+null;
                  
              
     }

     /**
      * the function gets file with GPS points and file with no GPS points. the function finds estimated location, and writes him into a new file.
      * @param csvpath path to the unified CSV file 
      * @param data1 first data of mac and signal
      * @param data2 second data of mac and signal
      * @param data3 third data of mac and signal 
      * @param n number of similar data 
      * @param norm norm
      * @param sig_diff power of sig_diff
      * @param power power
      * return string with data of the place
     **/
    
    public static String findPlaceAlgorithm2(String CSVpath,  String data1, String data2,String data3,int n,double norm,double sig_diff,double power){
	    return findPlace2( CSVpath,data1,data2,data3,n,norm,sig_diff,power);
        }

    private static String findPlace2( String CSVpath,  String data1, String data2,String data3,int n,double norm,double sig_diff,double power) {
	
	 int counter=0;
	 if (!(data1.equals(""))) counter++;
	 if (!(data2.equals(""))) counter++;
	 if (!(data3.equals(""))) counter++;
	

	
        String signalPoint[]=new String [counter]; //array of signals from one line from the no GPS file
        String macPoint[]=new String [counter];//array of matching MAC

        if (counter>=1){
      	    signalPoint[0]=data1.split(",")[1];
            macPoint[0]=data1.split(",")[0];
           }
    
        if (counter>=2){
            signalPoint[1]=data2.split(",")[1];
            macPoint[1]=data2.split(",")[0];
           }
    
        if (counter>=3){
            signalPoint[2]=data3.split(",")[1];
            macPoint[2]=data3.split(",")[0];
            }
   
         double signalMatch[]=new double [signalPoint.length];
         double diff[]=new double [signalPoint.length];
         double w[]=new double [signalPoint.length];
         LinkedList <Weight> p=new LinkedList <Weight>();

         boolean flag2=false;
         //reading from the comb_file with GPS data
	     try{
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
                     for (int i=0;i<counter;i++){
                         boolean flag=true;
                         for (int j=0;j<mac.length;j++){
                               if (macPoint[i].equals(mac[j]) && flag){
          	                      signalMatch[i]=Double.parseDouble(signal[j]);//if the MAC matches,take the signal from the combined file
        	                      diff[i]=Math.max(3,Math.abs(signalMatch[i]-Double.parseDouble(signalPoint[i])));//difference of the signals
        	                      flag=false;
                                  flag2=true;
                                  }
                               }
        
                         if (flag){
    	                      signalMatch[i]=-120; //if the MAC doesn't match,take -120 to be the signal
           	              diff[i]=100;//if the MAC doesn't match,take 100 to be the diff
                             }

                         w[i]=norm/(Math.pow(diff[i],sig_diff)*Math.pow(Double.parseDouble(signalPoint[i]),power));

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
	     }
            catch (FileNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	       } 
	    catch (IOException eL) {
		// TODO Auto-generated catch block
		eL.printStackTrace();
	       } 
	    
           //take the n lines that their weight is the biggest
           LinkedList <Weight> maxP=new LinkedList <Weight>();
  
          if (flag2){
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
         double weight[]=new double[n];double wLAT[]=new double[n]; double wLON[]=new double[n];double wAlt[]=new double[n];double sum[]={0,0,0,0};
         for (int i=0;i<n;i++){
             weight[i]=maxP.get(i).getW();
             wLAT[i]=maxP.get(i).getLAT()* weight[i];
             wLON[i]=maxP.get(i).getLON()*weight[i];
             wAlt[i]=maxP.get(i).getALT()* weight[i];

          }
   
         for (int i=0;i<n;i++){
             sum[0]+=weight[i];sum[1]+=wLAT[i];sum[2]+=wLON[i];sum[3]+=wAlt[i];}
	
         double wSum[]={sum[1]/sum[0],sum[2]/sum[0],sum[3]/sum[0]};
     
         int lat=(int)(wSum[0]*1000000); int lon=(int)(wSum[1]*1000000); int alt=(int)(wSum[2]*1000000);
         double lat1=(double)lat/1000000; double lon1=(double)lon/1000000; double alt1=(double)alt/1000000;
     
	 return "Lat: "+lat1+" Lon: "+lon1+" Alt: "+alt1;}
     
     return "Lat: "+null+" Alt: "+null+" Lon: "+null;
      
  
     }

}
