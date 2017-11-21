package munche;

interface q2prototypes {
	
	public void toCSV(String folderPath, String CSVpath);
	private LinkedList<Wifi> fileToList(String folderPath);
	private boolean ListtoCSV(LinkedList<Wifi> wifis, String CSVpath);
	
}
