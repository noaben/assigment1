package matala001;


public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String folder="wifiFolder";
		String CSVpath="WifiCsv.csv";
		
		q2.toCSV(folder, CSVpath);

		
		String KMLpath = "kmlFile.kml";
		
//		String filterBy = "Place";
	//	String requiredData = "35.20453609,32.10444352";
		
		String filterBy = "ID";
		String requiredData = "ONEPLUS A3010_28_171012";
		
	//String filterBy = "Time";
	//	String requiredData = "2017-11-01 14:24";
		
		
		q3.CSVtoKML(CSVpath, KMLpath, filterBy, requiredData);
		
		
		
	}

}
