package matalaMunche;

import java.awt.EventQueue;
import java.io.File;
import java.util.ArrayList;
import java.util.LinkedList;

public class Main {
    
	

	public static void main(String[] args) {
		
		// TODO Auto-generated method stub
		
		LinkedList <Wifi> data_base=new LinkedList <Wifi> ();
		LinkedList <Wifi> data_not_filtered=new LinkedList <Wifi> ();
		ArrayList <File> folder=new ArrayList <File>();
		ArrayList <Long> folder_last_modified=new ArrayList <Long>();
		ArrayList <File> combs=new ArrayList <File>();
		ArrayList <Long> combs_last_modified=new ArrayList <Long>();
		ArrayList <connectSQL> sql=new ArrayList <connectSQL>();
		ArrayList <String> sql_last=new ArrayList <String>();
		String s[]=new String [9];
		s[0]="0";//number of items that been filtered
		
		
		int loop=1;
		
		EventQueue.invokeLater(new Runnable(){
                    public void run(){
			 synchronized(data_base){   
                            frame1 window = new frame1(data_base,data_not_filtered,folder,folder_last_modified,combs,combs_last_modified,sql,sql_last,s);
	    	            window.frame.setVisible(true);
			   }
		       }
                   }
		);
		
		Thread a=new Thread(new Runnable() {
			
				  public void run() {
					  
				        
					  while (loop==1){
				           synchronized(data_base){   
						try {
							
							
							boolean flag=false;
							int i=0;
							if (!flag && i<folder.size() && folder.size()==folder_last_modified.size()){
						     	for (;i<folder.size();i++){
								    if (folder.get(i).lastModified()!=folder_last_modified.get(i)){
									    flag=true;
								            }
						      	            }
							   }
						
							i=0;
							if (!flag && i<combs.size() && combs.size()==combs_last_modified.size()){
						     	    for (;i<combs.size();i++){
								    if (combs.get(i).lastModified()!=combs_last_modified.get(i)){
									    flag=true;
					     	                            }
						                     }
							   }
							
							i=0;
							if (!flag && i<sql.size() && sql.size()==sql_last.size() && !sql.get(i).lastModified().equals(null)){
						     	    for (;i<sql.size();i++){
						     		String date=sql.get(i).lastModified();
								if (!date.equals(sql_last.get(i))){
									 flag=true;
								         }
						      	        }
							    }
							
							if (flag){
							
								i=0;
							    
								data_base.clear();
								folder_last_modified.clear();
								combs_last_modified.clear();
								
								for (;i<folder.size();i++){
									folder_last_modified.add(folder.get(i).lastModified());
									data_base.addAll(combiningData.list(folder.get(i).getName()));
								        }
								i=0;
								for (;i<combs.size();i++){
									combs_last_modified.add(combs.get(i).lastModified());
									data_base.addAll(processingData.list(combs.get(i).getName(),"no_filtering","","",""));
								        }
								
								
                                                                i=0;
								for (;i<sql.size();i++){
									sql_last.add(sql.get(i).lastModified());
									data_base.addAll(sql.get(i).getData());
								        }

                                                                
							        if (s[0].equals("0") ){
								    combiningData.listToCsv(data_base, "c.csv");
								    data_base.clear();
								    data_base.addAll(processingData.list("c.csv", "no_filtering", s[2], s[3], s[1]));
							            }
									
								
							       if (s[0].equals("1") ){
								    data_not_filtered.clear();
								    data_not_filtered.addAll(data_base);
								    combiningData.listToCsv(data_base, "c.csv");
								    data_base.clear();
								    data_base.addAll(processingData.list("c.csv", "filtering", s[2], s[3], s[1]));
							            }
							      
							       if (s[0].equals("2") ){
								    data_not_filtered.clear();
								    data_not_filtered.addAll(data_base);
								    combiningData.listToCsv(data_base, "c.csv");
								    data_base.clear();
								    data_base.addAll(processingData.list("c.csv", "filtering", s[2], s[3], s[1],s[5],s[6],s[4],s[7],s[8]));
							            }
							
							
							       int m=(int)(Math.random()*20000);
							       Thread.sleep(m);
							       }
						}
						catch (NullPointerException el){}
						catch (Exception e) {
							e.printStackTrace();
					               }
					  
					      }	 
			        }
			 } 	  
		  });
		   
	
	 a.start();
	}

		
		 
	//	String folder="wifiFolder";
	//	String CSVpath="wificsv.csv";
	//	String weightedMac="weightedMac.csv";
		
	//	LinkedList <Wifi> data_base=combiningData.list(folder);

	//    combiningData.toCSV(folder, CSVpath);
		
	//	String KMLpath = "kmlFile.kml";
		
		
	//	String filter="no_filtering";
	//	String filter="filtering";
		
        //      String filterBy = "Place";
        //      String requiredData = "34.8160003,32.1628765";
		
	//	String filterBy = "ID";
	//	String requiredData = "ONEPLUS A3010_28_171012";
		
       //       String filterBy = "Time";
       //	String requiredData = "2017-11-01 14:24";
		
		
       //       processingData.CSVtoKML(CSVpath, KMLpath, filter, filterBy, requiredData,5, weightedMac,"yes");
		
      //        processingData.listOrganized( "_comb_all_BM2_.csv",processingData.list("_comb_all_BM2_.csv",filter, filterBy, requiredData,"yes"),4,"Algo1_4_BM2_comb_all_.csv");
      //        processingData.listOrganized( "_comb_all_BM3_.csv",processingData.list("_comb_all_BM3_.csv",filter, filterBy, requiredData,"yes"),4,"Algo1_4_BM3_comb_all_.csv");
      //        algorithms.findPlaceAlgorithm2( "_comb_all_BM3_.csv", "_comb_no_gps_ts1.csv",4,10000,0.4,2,"Algo2_BM3_TS1_.csv");
      //        algorithms.findPlaceAlgorithm2( "_comb_all_BM3_.csv", "_comb_no_gps_ts2_.csv",4,10000,0.4,2,"Algo2_BM3_TS2.csv");
      //        algorithms.findPlaceAlgorithm2( "_comb_all_BM2_.csv", "_comb_no_gps_ts1.csv",4,10000,0.4,2,"Algo2_BM2_TS1.csv");
      //        algorithms.findPlaceAlgorithm2( "_comb_all_BM2_.csv", "_comb_no_gps_ts2_.csv",4,10000,0.4,2,"Algo2_BM2_TS2.csv");
		
}
