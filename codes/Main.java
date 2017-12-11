package matala001;



public class Main {


	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String folder="wifiFolder";
		String CSVpath="wificsv.csv";
		String algo2="Algo2.csv";
		String no_gps="no_gps.csv";
		String weightedMAC="Algo1.csv";
		
		q2.toCSV(folder, CSVpath);

		
		String KMLpath = "kmlFile.kml";
		
		String filter="no_filtering";
	//	String filter="filtering";
		
                String filterBy = "Place";
           	String requiredData = "34.8160003,32.1628765";
		
      //	String filterBy = "ID";
      //	String requiredData = "ONEPLUS A3010_28_171012";
		
      //        String filterBy = "Time";
      //   	String requiredData = "2017-11-01 14:24";
		
		
	        q3.CSVtoKML(CSVpath, KMLpath,filter, filterBy, requiredData,weightedMAC);
		
	        q3.findPlaceAlgorithm2( CSVpath,  no_gps,algo2);
		
	        q3.CSVtoKML("comb_BM1.csv", "BM1_kml.kml",filter, filterBy, requiredData,"Algo1_test_BM1_comb_all_.csv");
	
		q2.toCSV("BM1_4", "BM1_4_comb.csv");
		
		q3.findPlaceAlgorithm2( "BM1_4_comb.csv",  "no_gps_BM1_3.csv", "Algo2_test_BM1_4_3.csv");
		
	}

}
