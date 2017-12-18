package matala001;



public class Main {


	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String folder="wifiFolder";
		String CSVpath="wificsv.csv";
		
	        combiningData.toCSV(folder, CSVpath);
		
		String KMLpath = "kmlFile.kml";
		
		String filter="no_filtering";
	//	String filter="filtering";
		
                String filterBy = "Place";
             	String requiredData = "34.8160003,32.1628765";
		
	//	String filterBy = "ID";
	//	String requiredData = "ONEPLUS A3010_28_171012";
		
       //       String filterBy = "Time";
       //	String requiredData = "2017-11-01 14:24";
		
		

      	       processingData.listOrganized( "_comb_all_BM2_.csv",processingData.list("_comb_all_BM2_.csv",filter, filterBy, requiredData),"Algo1_4_BM2_comb_all_.csv");
      	       processingData.listOrganized( "_comb_all_BM3_.csv",processingData.list("_comb_all_BM3_.csv",filter, filterBy, requiredData),"Algo1_4_BM3_comb_all_.csv");
               algorithms.findPlaceAlgorithm2( "_comb_all_BM3_.csv", "_comb_no_gps_ts1.csv","Algo2_BM3_TS1_.csv");
               algorithms.findPlaceAlgorithm2( "_comb_all_BM3_.csv", "_comb_no_gps_ts2_.csv","Algo2_BM3_TS2.csv");
               algorithms.findPlaceAlgorithm2( "_comb_all_BM2_.csv", "_comb_no_gps_ts1.csv","Algo2_BM2_TS1.csv");
	       algorithms.findPlaceAlgorithm2( "_comb_all_BM2_.csv", "_comb_no_gps_ts2_.csv","Algo2_BM2_TS2.csv");
		
	}

}
