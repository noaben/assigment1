package matala01;



import java.io.BufferedReader;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedList;


import java.io.File;
import java.io.FileNotFoundException;

import de.micromata.opengis.kml.v_2_2_0.AltitudeMode;
import de.micromata.opengis.kml.v_2_2_0.Document;
import de.micromata.opengis.kml.v_2_2_0.Kml;
import de.micromata.opengis.kml.v_2_2_0.KmlFactory;

/**
 * 
 * @author Ben and Noa
 *
 */
public class q3 implements Filter{

	/**
	 * This method read CSV file with wifi points, filter it by data parameters and export to KML file.
	 *  print succeed message if export succeed. "failed" otherwise.
	 * 
	 * @param csvpath path to the csv file
	 * @param kmlpath name to the new KML file
	 * @param filterBy  required parameter to filter by.
	 * @param requiredData the required data specific.
	 */
	public static void CSVtoKML(String csvpath, String kmlpath, String filterBy, String requiredData){
		LinkedList<Wifi> listofWifi=csvtoList(csvpath, filterBy, requiredData);
		boolean s= kml(listofWifi, kmlpath);
		if(s) System.out.println("export to KML succeed!");
		else System.out.println("failed export to KML.");

	}


	/**
	 * This method reads from the csv's file , filters the required wifi's points, and put them in the LinkedList
	 * @param csvpath The path to the CSV file
	 * @param filterBy required parameter to filter by.
	 * @param requiredData the required data specific.
	 * @return List with Wifi's points from the CSV file
	 */
	protected static LinkedList<Wifi> csvtoList(String csvpath, String filterBy, String requiredData){
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
	 * @param Object that tested 
	 * @param data parameter for filter
	 * @param required data
	 * @return true if wifi compliance with conditions, false if isn't
	 */
	@Override
	public boolean fit(Wifi wifi, String data, String req) {
	
			if(data.equals("ID")){
				if(wifi.getID().equals(req)) return true;
			}
			if(data.equals("Time")){
				if(wifi.getTime().equals(req)) return true;
			}
			if(data.equals("Place")){
				if(wifi.getCoordinates().equals(req))
					return true;
			}
		
		return false;

	}
	
	/**
	 * if Wifi's have the same MAC- the one with the best signal will be kept in the linkedList 
	 * @param wifilist List of wifi's points
	 * @return organized LinkedList of the wifi's points
	 */
	protected static LinkedList<Wifi> organize(LinkedList<Wifi> wifilist){

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
			updateList.add(max);
		}

		return updateList;
	}


	/**
	 * this method creates the kml file 
	 * @param newlist  list of all wifi that need to be presented
	 * @param path of the kml file
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
