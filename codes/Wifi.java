package lesson1;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import de.micromata.opengis.kml.v_2_2_0.Document;

import de.micromata.opengis.kml.v_2_2_0.AltitudeMode;
import de.micromata.opengis.kml.v_2_2_0.Kml;
import de.micromata.opengis.kml.v_2_2_0.KmlFactory;
import de.micromata.opengis.kml.v_2_2_0.TimeStamp;


/**
 * class for one wifi point
 * @author benho
 *@since 11-2017
 *
 */

public class Wifi {
	private String Time;
	private String ID;
	private String LAT;
	private String LON;
	private String ALT;
	private String SSID;
	private String MAC;
	private String frequncy;
	private String signal;

	

	
	/**
	 * class constructor
	 * @param time the time
	 * @param ID is the display
	 * @param LAT the wifi's Current Latitude
	 * @param LON the wifi's Current Longitude
	 * @param ALT the wifi's AltitudeMeters
	 * @param SSID the wifi's SSID
	 * @param MAC the wifi's BSSID adress
	 * @param frequncy the wifi's Channel
	 * @param signal the wifi's signal
	 */
	public Wifi (String time, String ID, String LAT, String LON, 
			String ALT, String SSID, String MAC, String frequncy, String signal){
		this.Time =time;
		this.ID =ID;
		this.LAT =LAT;
		this.LON =LON;
		this.ALT =ALT;
		this.SSID =SSID;
		this.MAC =MAC;
		this.frequncy =frequncy;
		this.signal =signal;
	}

	
	
	/**
	 * check if the wifi data is standard
	 * @param time the time
	 * @param ID is the display
	 * @param LAT the wifi's Current Latitude
	 * @param LON the wifi's Current Longitude
	 * @param ALT the wifi's AltitudeMeters
	 * @param SSID the wifi's SSID
	 * @param MAC the wifi's MAC adress
	 * @param frequncy the wifi's Channel
	 * @param signal the wifi's signal
	 * 
	 * @return true if ok false if abnormal
	 */
	public static boolean correct(String time, String ID, String LAT, String LON, 
			String ALT, String SSID, String MAC, String frequncy, String signal){

		try{Integer.parseInt(signal);}
		catch (NumberFormatException e){return false;} 

		if(signal.equals("-113")) return false;
		
		try{ Double.parseDouble(LAT);}
		catch (NumberFormatException e){return false;}
		
		try{ Double.parseDouble(LON);}
		catch (NumberFormatException e){return false;}
		

		if(time.substring(0, 4).equals("1970")) return false;

		return true;
	}


	/** 
	 * @return wifi time
	 */
	public String getTime() {
		return Time;
	}
	/** 
	 * @return wifi ID
	 */
	public String getID() {
		return ID;
	}
	/** 
	 * @return wifi LAT
	 */
	public String getLAT() {
		return LAT;
	}
	/** 
	 * @return wifi LON
	 */
	public String getLON() {
		return LON;
	}
	/** 
	 * @return wifi ALT
	 */
	public String getALT() {
		return ALT;
	}
	/** 
	 * @return wifi SSID
	 */
	public String getSSID() {
		return SSID;
	}
	/** 
	 * @return wifi MAC
	 */
	public String getMAC() {
		return MAC;
	}
	/** 
	 * @return wifi getFrequncy
	 */
	public String getFrequncy() {
		return frequncy;
	}
	/** 
	 * @return wifi signal
	 */
	public String getSignal() {
		return signal;
	}
	
	/**
	 * Used to get the wifi coordinates, split by ","
	 * @return wifi coordinates.
	 */
	public String getCoordinates(){
		try{ Double.parseDouble(LAT);}
		catch (NumberFormatException e){return "";}
		
		try{ Double.parseDouble(LON);}
		catch (NumberFormatException e){return "";}
		
		return this.LON+","+this.LAT;
		
	}
	
	
	public void kmlGenerator(Document doc){
		
		String s="<br/><b>MAC: </b>"+MAC+"<br/><b>Alt: </b>"+ALT+"<br/><b>Channel: </b>"
						+ ""+frequncy+"<br/><b>Signal: </b>"+signal+"dBm<br/><b>Time: </b>"
								+ ""+Time;
		TimeStamp ts=new TimeStamp();
		ts.withWhen(this.Time.split(" ")[0]+'T'+this.Time.split(" ")[1]);
		doc.createAndAddPlacemark()
		   .withName(this.SSID)
		   .withVisibility(true)
		   .withOpen(true)
		   .withDescription(s)
		   .withStyleUrl("#green")
		   .withTimePrimitive(ts)
		   .createAndSetPoint()
		   .addToCoordinates(getCoordinates());
		 
	}



}
