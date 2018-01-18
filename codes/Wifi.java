package matalaMunche;

import de.micromata.opengis.kml.v_2_2_0.Document;
import de.micromata.opengis.kml.v_2_2_0.TimeStamp;

/**
 * class for one wifi's point
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
	 * @param MAC the wifi's BSSID address
	 * @param frequncy the wifi's Channel
	 * @param signal the wifi's signal
	 */
	
	public Wifi (String time, String ID, String LAT, String LON, String ALT, String SSID, String MAC, String frequncy, String signal){
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
	 * check if the wifi's data is standard
	 * @param time the time
	 * @param ID is the display
	 * @param LAT the wifi's Current Latitude
	 * @param LON the wifi's Current Longitude
	 * @param ALT the wifi's AltitudeMeters
	 * @param SSID the wifi's SSID
	 * @param MAC the wifi's MAC address
	 * @param frequncy the wifi's Channel
	 * @param signal the wifi's signal
	 * 
	 * @return true if the data is standard false if not
	 */
	
	public static boolean correct(String time, String ID, String LAT, String LON, String ALT, String SSID, String MAC, String frequncy, String signal){
        
                if (!MAC.substring(2,3).equals(":") || !MAC.substring(5,6).equals(":") || !MAC.substring(8,9).equals(":") || !MAC.substring(11,12).equals(":") || !MAC.substring(14,15).equals(":")) return false;
        
                try{Double.parseDouble(ALT);}
		catch (NumberFormatException e){return false;}
        
		try{Integer.parseInt(signal);}
		catch (NumberFormatException e){return false;} //the application has attempted to convert a string to one of the numeric types, but that the string does not have the appropriate format.
        
		try{Integer.parseInt(frequncy);}
		catch (NumberFormatException e){return false;}
		
		if(signal.equals("-113")) return false;
		
		try{ Double.parseDouble(LAT);}
		catch (NumberFormatException e){return false;}
		
		try{ Double.parseDouble(LON);}
		catch (NumberFormatException e){return false;}
		
		if (time.substring(0,4).equals("1970")) return false;
		
		return true;
	}


	/**
	 * check if the Wifi's data equals to other Wifi's data
	 * @param other other Wifi
	 * @return true if the data is the same, false otherwise
	 */
	
	public  boolean equals(Wifi other){
		return (this.Time.equals(other.Time) && this.ID.equals(other.ID) && this.LAT.equals(other.LAT) && this.LON.equals(other.LON) && this.ALT.equals(other.ALT) && this.SSID.equals(other.SSID) && this.MAC.equals(other.MAC)&&  this.frequncy.equals(other.frequncy) && this.signal.equals(other.signal));
	}
	
	/** 
	 * @return wifi's time
	 */
	public String getTime() {
		return Time;
	}
	/** 
	 * @return wifi's ID
	 */
	public String getID() {
		return ID;
	}
	/** 
	 * @return wifi's LAT
	 */
	public String getLAT() {
		return LAT;
	}
	/** 
	 * @return wifi's LON
	 */
	public String getLON() {
		return LON;
	}
	/** 
	 * @return wifi's ALT
	 */
	public String getALT() {
		return ALT;
	}
	/** 
	 * @return wifi's SSID
	 */
	public String getSSID() {
		return SSID;
	}
	/** 
	 * @return wifi's MAC
	 */
	public String getMAC() {
		return MAC;
	}
	/** 
	 * @return wifi's getFrequncy
	 */
	public String getFrequncy() {
		return frequncy;
	}
	/** 
	 * @return wifi's signal
	 */
	public String getSignal() {
		return signal;
	}
	
	/**
	 * Used to get the wifi's coordinates, split by ","
	 * @return Wifi's coordinates.
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
