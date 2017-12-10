package matala001;


public class Main {


	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String folder="wifiFolder";
		String CSVpath="WifiCsv.csv";
		
		q2.toCSV(folder, CSVpath);

		
		String KMLpath = "kmlFile.kml";
		
                String filterBy = "Place";
         	String requiredData = "35.20453609,32.10444352";
		
		//String filterBy = "ID";
		//String requiredData = "ONEPLUS A3010_28_171012";
		
      //        String filterBy = "Time";
      //	String requiredData = "2017-11-01 14:24";
		
		
		q3.CSVtoKML(CSVpath, KMLpath, filterBy, requiredData);
		
	        MAC m=q3.findPlaceAlgorithm1(CSVpath,"e0:10:7f:49:37:fc");
		System.out.println(m.toString());
		
		System.out.println(q3.findPlaceAlgorithm2(CSVpath,"-60","f8:d1:11:b1:92:93","-75","74:da:38:97:66:9d","-90","ec:08:6b:38:0d:dd"));

	}

}
