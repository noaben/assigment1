package munche;


public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String folder="testFolder1";
		String CSVpath="WifiCsv.csv";
		
		q2.toCSV(folder, CSVpath);

		
		String KMLpath = "kmlFile.kml";
		
//		String filterBy = "Place";
//		String requiredData = "35.18686777,32.10449167";
		
		String filterBy = "ID";
		String requiredData = "ONEPLUS A3010_28_171012";
		
//		String filterBy = "Time";
//		String requiredData = "2017-11-07 16:38:02";
		
		
		q3.CSVtoKML(CSVpath, KMLpath, filterBy, requiredData);
		
		
		
	}

}
