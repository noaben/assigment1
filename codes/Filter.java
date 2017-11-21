package munche;


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
	  boolean fit(Object object, String data, String eq);

}
