package matala001;

/**
 * 
 * @author NoaHadad
 * 
 *
 */
 interface Filter {
	
	 
	/**
	 * 
	 * @param object that need to be exam
	 * @param data parameter of filtering
	 * @param eq required data
	 */
	  boolean fit(Wifi wifi, String data, String req);

}
