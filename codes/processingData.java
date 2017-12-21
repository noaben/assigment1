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
	public static boolean CSVtoKML(String csvpath, String kmlpath, String filter, String filterBy, String requiredData,int n,String weightedMAC){
		LinkedList<Wifi> listofWifi=listOrganized(csvpath,list(csvpath,filter, filterBy, requiredData),n,weightedMAC);
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

			Filter cond = new processingData();

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
