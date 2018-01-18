package matalaMunche;


/**
 * 
 * @author NoaHadad
 * 
 *
 */
 interface Filter {
	
	 
	/**
	 * 
	 * @param wifi the object with the data
	 * @param data filtered data
	 * @param req required data
	 */
	  boolean fit(Wifi wifi, String data, String req);

}