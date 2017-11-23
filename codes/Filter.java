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
	 * @param req requierd data
	 */
	  boolean fit(Object object, String data, String req);

}
