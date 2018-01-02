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
public class processingData implements Filter{

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
	public static boolean CSVtoKML(String csvpath, String kmlpath, String filter, String filterBy, String requiredData,int n,String weightedMAC,String operation){
		LinkedList<Wifi> listofWifi=listOrganized(csvpath,list(csvpath,filter, filterBy, requiredData,operation),n,weightedMAC);
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
	 * @param operation if we want to get the required data or not the required data
	 * @return List with Wifi's points from the CSV file
	 */
	
	public static LinkedList <Wifi> list (String csvpath,String filter, String filterBy, String requiredData,String operation){
		LinkedList <Wifi> wifis=csvToList(csvpath,filter, filterBy, requiredData,operation);
		return wifis;
	    }
	
	private static LinkedList<Wifi> csvToList(String csvpath,String filter, String filterBy, String requiredData,String operation){
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

			Filter cond = new processingData();

			br.readLine();
			str=br.readLine();
            
			
			while(str!=null){

			  arr=str.split(",");
			  if (arr.length>=9){
			
			    
			    if (filter.equals("filtering")){

			     	Wifi w = new Wifi(arr[0], arr[1], arr[2], arr[3], arr[4], "null", "null", "null", "null");
                                 
                    if (operation.equals("yes")){

			        	if(cond.fit(w,  filterBy, requiredData))
				         	for (int i = 0; i < Integer.parseInt(arr[5]); i++) 
                        wifilist.add(new Wifi(arr[0], arr[1], arr[2], arr[3], arr[4], arr[4*i+6], arr[4*i+7], arr[4*i+8], arr[4*i+9]));
			     	      
				        str=br.readLine();
                        }
                    if (operation.equals("not")){

			     	    if(!cond.fit(w,  filterBy, requiredData))
				         	for (int i = 0; i < Integer.parseInt(arr[5]); i++) 
                         	     wifilist.add(new Wifi(arr[0], arr[1], arr[2], arr[3], arr[4], arr[4*i+6], arr[4*i+7], arr[4*i+8], arr[4*i+9]));
                            str=br.readLine();
                        }
			       }
			    
			    else{
			    	Wifi w = new Wifi(arr[0], arr[1], arr[2], arr[3], arr[4], "null", "null", "null", "null");
			    	for (int i = 0; i < Integer.parseInt(arr[5]); i++) 
                     	wifilist.add(new Wifi(arr[0], arr[1], arr[2], arr[3], arr[4], arr[4*i+6], arr[4*i+7], arr[4*i+8], arr[4*i+9]));
			    	str=br.readLine();
		     	   
			       }
			    }
			  }
		    }
		 catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

			
		return wifilist;

	}
	
    	/**
	     * This method reads from the csv's file , filters the required wifi's points, and put them in the LinkedList
	     * @param csvpath The path to the CSV file
	     * @param filter if we want to filter or not
	     * @param filterBy1 first parameter required to filter by.
	     * @param requiredData1 the required data from parameter 1
	     * @param operatin1 if we wan to get the requiredData1 or not the requiredData1
	     * @param filterBy2 second parameter required to filter by.
	     * @param requiredData2 the required data from parameter 2
	     * @param operatin2 if we wan to get the requiredData2 or not the requiredData1
	     * @param operation if we want to get the required data or not the required data
	     * @param operation_between if we want to do "and" or "or" between the 2 filters
	     * @param operation_yes_not if we want to get the data filtered by the demands or not the  data
	     * @return List with Wifi's points from the CSV file
	     */
	
	    public static LinkedList<Wifi> list(String csvpath,String filter, String filterBy1, String requiredData1,String operation1, String filterBy2, String requiredData2,String operation2, String operation_between,String operation_yes_not){
	    	return csvToList(csvpath,filter, filterBy1,  requiredData1,operation1,  filterBy2,  requiredData2, operation2,  operation_between,operation_yes_not);
	    		 
	    }

        private static LinkedList<Wifi> csvToList(String csvpath,String filter, String filterBy1, String requiredData1,String operation1, String filterBy2, String requiredData2,String operation2, String operation_between,String operation_yes_not){
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

			Filter cond = new processingData();

			br.readLine();
			str=br.readLine();
            
			
			while(str!=null){

			    arr=str.split(",");
			    if (arr.length>=9){
			

			     	Wifi w = new Wifi(arr[0], arr[1], arr[2], arr[3], arr[4], "null", "null", "null", "null");

                    if ((operation_yes_not.equals("yes") && operation_between.equals("and") && operation1.equals("yes") && operation2.equals("yes")) || (operation_yes_not.equals("not") && operation_between.equals("or") && operation1.equals("not") && operation2.equals("not"))) {
                    		if(cond.fit(w,  filterBy1, requiredData1) && cond.fit(w,  filterBy2, requiredData2))
		      	                for (int i = 0; i < Integer.parseInt(arr[5]); i++) 
                 	                wifilist.add(new Wifi(arr[0], arr[1], arr[2], arr[3], arr[4], arr[4*i+6], arr[4*i+7], arr[4*i+8], arr[4*i+9]));
                          str=br.readLine();
			              }
                    
                    if ((operation_yes_not.equals("yes") && operation_between.equals("and") && operation1.equals("not") && operation2.equals("yes")) || (operation_yes_not.equals("not") && operation_between.equals("or") && operation1.equals("yes") && operation2.equals("not"))) {
                		if(!cond.fit(w,  filterBy1, requiredData1) && cond.fit(w,  filterBy2, requiredData2))
	      	                for (int i = 0; i < Integer.parseInt(arr[5]); i++) 
             	                wifilist.add(new Wifi(arr[0], arr[1], arr[2], arr[3], arr[4], arr[4*i+6], arr[4*i+7], arr[4*i+8], arr[4*i+9]));
                      str=br.readLine();
		              }
                    
                    if ((operation_yes_not.equals("yes") && operation_between.equals("and") && operation1.equals("not") && operation2.equals("not")) || (operation_yes_not.equals("not") && operation_between.equals("or") && operation1.equals("yes") && operation2.equals("yes"))) {
                		if(!cond.fit(w,  filterBy1, requiredData1) && !cond.fit(w,  filterBy2, requiredData2))
	      	                for (int i = 0; i < Integer.parseInt(arr[5]); i++) 
             	                wifilist.add(new Wifi(arr[0], arr[1], arr[2], arr[3], arr[4], arr[4*i+6], arr[4*i+7], arr[4*i+8], arr[4*i+9]));
                      str=br.readLine();
		              }
                    
                    if ((operation_yes_not.equals("yes") && operation_between.equals("and") && operation1.equals("yes") && operation2.equals("not")) || (operation_yes_not.equals("not") && operation_between.equals("or") && operation1.equals("not") && operation2.equals("yes"))) {
                		if(cond.fit(w,  filterBy1, requiredData1) && !cond.fit(w,  filterBy2, requiredData2))
	      	                for (int i = 0; i < Integer.parseInt(arr[5]); i++) 
             	                wifilist.add(new Wifi(arr[0], arr[1], arr[2], arr[3], arr[4], arr[4*i+6], arr[4*i+7], arr[4*i+8], arr[4*i+9]));
                      str=br.readLine();
		              }
                    if ((operation_yes_not.equals("not") && operation_between.equals("and") && operation1.equals("yes") && operation2.equals("yes")) || (operation_yes_not.equals("yes") && operation_between.equals("or") && operation1.equals("not") && operation2.equals("not"))) {
                		if(!(cond.fit(w,  filterBy1, requiredData1) && cond.fit(w,  filterBy2, requiredData2)))
	      	                for (int i = 0; i < Integer.parseInt(arr[5]); i++) 
             	                wifilist.add(new Wifi(arr[0], arr[1], arr[2], arr[3], arr[4], arr[4*i+6], arr[4*i+7], arr[4*i+8], arr[4*i+9]));
                      str=br.readLine();
		              }
                
                if ((operation_yes_not.equals("not") && operation_between.equals("and") && operation1.equals("not") && operation2.equals("yes")) || (operation_yes_not.equals("yes") && operation_between.equals("or") && operation1.equals("yes") && operation2.equals("not"))) {
            		if(!(!cond.fit(w,  filterBy1, requiredData1) && cond.fit(w,  filterBy2, requiredData2)))
      	                for (int i = 0; i < Integer.parseInt(arr[5]); i++) 
         	                wifilist.add(new Wifi(arr[0], arr[1], arr[2], arr[3], arr[4], arr[4*i+6], arr[4*i+7], arr[4*i+8], arr[4*i+9]));
                  str=br.readLine();
	              }
                
                if ((operation_yes_not.equals("not") && operation_between.equals("and") && operation1.equals("not") && operation2.equals("not")) || (operation_yes_not.equals("yes") && operation_between.equals("or") && operation1.equals("yes") && operation2.equals("yes"))) {
            		if(!(!cond.fit(w,  filterBy1, requiredData1) && !cond.fit(w,  filterBy2, requiredData2)))
      	                for (int i = 0; i < Integer.parseInt(arr[5]); i++) 
         	                wifilist.add(new Wifi(arr[0], arr[1], arr[2], arr[3], arr[4], arr[4*i+6], arr[4*i+7], arr[4*i+8], arr[4*i+9]));
                  str=br.readLine();
	              }
                
                if ((operation_yes_not.equals("not") && operation_between.equals("and") && operation1.equals("yes") && operation2.equals("not")) || (operation_yes_not.equals("yes") && operation_between.equals("or") && operation1.equals("not") && operation2.equals("yes"))) {
            		if(!(cond.fit(w,  filterBy1, requiredData1) && !cond.fit(w,  filterBy2, requiredData2)))
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
	
			if(data.equals("Device")){
				
				if(wifi.getID().equals(req)) return true;
			    }
			
			//filter by lower-upper bound
			if(data.equals("Time")){
				
				String year1=req.substring(6,10); String year2=req.substring(23,27); String month1=req.substring(3,5); String month2=req.substring(20,22);String day1=req.substring(0,2);
				String day2=req.substring(17,19);String hour1=req.substring(11,13);String hour2=req.substring(28,30);String minute1=req.substring(14,16);String minute2=req.substring(31,33);
				String year=wifi.getTime().substring(0,4);String month=wifi.getTime().substring(5,7);String day=wifi.getTime().substring(8,10);String hour=wifi.getTime().substring(11,13);String minute=wifi.getTime().substring(14,16);
				
				int a[]=new int[5];int b[]=new int[5];int c[]=new int[5];;
                try{
				 a[0]=Integer.parseInt(year1);a[1]=Integer.parseInt(month1);a[2]=Integer.parseInt(day1);a[3]=Integer.parseInt(hour1);a[4]=Integer.parseInt(minute1); //lower bound
				 c[0]=Integer.parseInt(year2);c[1]=Integer.parseInt(month2);c[2]=Integer.parseInt(day2);c[3]=Integer.parseInt(hour2);c[4]=Integer.parseInt(minute2); //upper bound
				 b[0]=Integer.parseInt(year);b[1]=Integer.parseInt(month);b[2]=Integer.parseInt(day);b[3]=Integer.parseInt(hour);b[4]=Integer.parseInt(minute);} //data filtered
                catch(Exception e1) {
				// TODO Auto-generated catch block
				
			 }
				
				if ((a[0]==b[0]) && (a[1]==b[1])  && (a[2]==b[2])  && (a[3]==b[3])  && (a[4]==b[4])) return true;
				if ((c[0]==b[0]) && (c[1]==b[1])  && (c[2]==b[2])  && (c[3]==b[3])  && (c[4]==b[4])) return true;
				System.out.println("0");
				return date_filter (a,b,c,0);
			}
			
			//filter by radius  
			if(data.equals("Place1")){
				if(Math.sqrt(Math.pow(Double.parseDouble(wifi.getLON())-Double.parseDouble(req.split(",")[0]),2)+Math.pow(Double.parseDouble(wifi.getLAT())-Double.parseDouble(req.split(",")[1]),2))<0.005)
					return true;
			    }
			
			//filter by lower-upper bound
			if(data.equals("Place")){
				if ((Double.parseDouble(wifi.getLAT())>=Double.parseDouble(req.split(",")[0])) && (Double.parseDouble(wifi.getLAT())<=Double.parseDouble(req.split(",")[3])) && (Double.parseDouble(wifi.getLON())>=Double.parseDouble(req.split(",")[1])) && (Double.parseDouble(wifi.getLON())<=Double.parseDouble(req.split(",")[4])) && (Double.parseDouble(wifi.getALT())>=Double.parseDouble(req.split(",")[2])) && (Double.parseDouble(wifi.getALT())<=Double.parseDouble(req.split(",")[5]))){
					System.out.println(0);
					return true;}
			   }
			
		
		return false;

	}

	/**
	 * @param a array of lower bound values: year,month,day,hour,minute
	 * @param b array of wifi point that need to be filtered , the values in the array are: year,month,day,hour,minute
	 * @param c array of upper bound values: year,month,day,hour,minute
	 * @return true if wifi point is between the values, false if isn't
	 */

	private boolean date_filter(int []a1,int[]b1,int[]c1,int i){
		
		if (i<5){
	       if ((a1[i]<b1[i]) && (b1[i]<c1[i])) return true;
	       else if ((a1[i]==b1[i]) && (b1[i]==c1[i])) return date_filter(a1,b1,c1,i+1);
	       else if ((a1[i]==b1[i]) && (b1[i]<c1[i])) return date_filter1(a1,b1,i+1);
	       else if ((a1[i]<b1[i]) && (b1[i]==c1[i])) return date_filter2(b1,c1,i+1);
		}
		return false;
	}
	
	private boolean date_filter1(int []a1,int[]b1,int i){
		if (i<5){
	       if (a1[i]<b1[i]) return true;
	       else if (a1[i]==b1[i]) return date_filter1(a1,b1,i+1);
		}
		return false;
	}
	
	private boolean date_filter2(int[]b1,int[]c1,int i){
		if (i<5){
		       if (b1[i]<c1[i]) return true;
		       else if (b1[i]==c1[i]) return date_filter2(b1,c1,i+1);
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
	
	public static LinkedList <Wifi> listOrganized (String csvpath,LinkedList <Wifi> list,int n,String weightedMAC){
		LinkedList <Wifi> wifis=organize(csvpath, list,n, weightedMAC);
		return wifis;
	}
	

	private static LinkedList<Wifi> organize(String csvpath,LinkedList<Wifi> wifilist,int n,String weightedMAC){

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
			w_center.add(algorithms.findPlaceAlgorithm1(csvpath,max.getMAC(),n));//getting weighted MAC
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

	
	
}
