package matala01;



/**
 * The Class was created to organize several CSV files to one organized CSV file
 * 
 * @author Ben and Noa 
 * @since 11-2017
 */

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedList;

public class q2 {

	/**
	 * This method creates one CSV file from folder of csv's files which includes wifi's points.
	 * print "succeed" message if export succeed. "failed" otherwise.
	 * @param folderPath path of the folder with the data of the application "wiGLE"
	 * @param CSVpath the name of the new csv's file
	 * 
	 */
	protected static void toCSV(String folderPath, String CSVpath) {
		File []listOfFiles=findCsvFiles(folderPath);
		LinkedList<Wifi> listofWifi=fileToList(listOfFiles);
		if( listToCSV(listofWifi, CSVpath))
			System.out.println("export to CSV succeed!");
		else System.out.println("failed export to CSV.");
	}

	/**
	 * 
	 * @param folderPath path of the folder with the data of the application "wiGLE" 
	 * @return array of csv's files
	 */

	protected static File [] findCsvFiles (String folderPath){


		File folder = new File(folderPath);            //get access to the folder in the path. the folder is in the workspace.
		File[] files = folder.listFiles();             //array of files in folder
		int count=0;

		try{
			count=files.length;  //number of files
		}
		catch(NullPointerException ex){
			System.out.println("folder doesn't exist");
			return null;

		}
		//no files in folder. 
		if (count==0) {
			System.out.println("No files in folder");
			return null;
		}

		count=0;
		for (int i = 0; i < files.length; i++) { 			 
			if(getFileFormat(files[i]).equals("csv"))
				count++;
		}

		//no csv's files in the folder.
		if (count==0) {
			System.out.println("No csv's files in folder");
			return null;
		}


		File[] listOfFiles = new File[count]; // array of files with csv's format
		int j=0;
		for (int i = 0; i < files.length; i++) { 
			if(getFileFormat(files[i]).equals("csv")){
				listOfFiles[j]=files[i]; j++;}
		}

		return listOfFiles;
	}

	
	/** clarify file format
	 * @param File
	 * @return the file's format
	 * 
	 */
	protected static String getFileFormat(File f) {

		if(!f.exists()) return "";
		String fileName = f.getName();
		int dotIndex = fileName.lastIndexOf('.');
		return (dotIndex == -1) ? "" : fileName.substring(dotIndex + 1);
	}

	
	/**
	 * 
	 * @param listOfFiles array of csv's files with data of the application "wiGLE" 
	 * @return LinkedList of wifi's points
	 */

	protected static LinkedList<Wifi> fileToList(File[] listOfFiles){

		
		//reading file

		FileReader fr;      //enter into the file
		BufferedReader br;  //read line
		String str="";


		LinkedList<Wifi> wifis = new LinkedList<Wifi>();   //LinkedList of wifi's points


		if(listOfFiles==null){
			return wifis;
		}

		for(int i=0; i<listOfFiles.length; i++){

			try {  
				fr = new FileReader(listOfFiles[i]);
				br = new BufferedReader(fr);

				str= br.readLine();

				String display = str.split(",")[5].split("=")[1]; //get ID


				br.readLine();      //jump row
				str= br.readLine();

				String[] a;

				while(str!=null){
					if(legit(str)){
						a=str.split(",");
						if(Wifi.correct(a[3],display ,a[6],a[7],a[8],a[1],a[0],a[4],a[5])){
							wifis.add(new Wifi(a[3],display ,a[6],a[7],a[8],a[1],a[0],a[4],a[5]));
						}
					}
					str=br.readLine();
				}

				br.close();
				fr.close();
			}
			
			catch(NumberFormatException e) {System.out.print("unexepted CSV content format, file "+"#"+listOfFiles[i].getName()+"\n" );}
			catch(IOException ex) {System.out.print("Error reading file \n" + ex);} 
		}

		return wifis;

	}
	
	
	/** check input
	 * @param String of one wifi's data
	 * @return true if there are 11 fields of data, false otherwise
	 * 
	 */
	protected static boolean legit(String str){

		if((str.equals("")||(str.isEmpty()))) return false; //line is empty
		if(str.split(",").length!=11) return false;  		//not enough columns

		return true;
	}

	

	/**
	 * method to write list of wifi's points to CSV file
	 * @param wifis List of all wifi's points
	 * @param CSVpath destination
	 * @return true if succeed.
	 */
	protected static boolean listToCSV(LinkedList<Wifi> wifis, String CSVpath) {

		FileWriter writer;
		if(wifis.size()==0) return false; 

		try {
			writer = new FileWriter(CSVpath);

			writer.append("Time"+','+"ID"+','+"Lat"+','+"Lon"+','+"Alt"+','+"#WiFi"+',');

			for(int i =1; i<=10; i++){
				writer.append("SSID"+i+',');
				writer.append("MAC"+i+',');
				writer.append("Frequncy"+i+',');
				writer.append("Signal"+i+',');
			}
			writer.append('\n');

			//checking if the time,ID,LAT,LON,ALT of the wifis in the LinkeList matches to the first. if yes, puts them in the same line. 
			while(wifis.size()>=1){
				LinkedList<Wifi> line = new LinkedList<Wifi>();
				line.add(wifis.getFirst());
				wifis.removeFirst();

				for(int i=0; i<wifis.size(); i++){

					if((line.getFirst().getTime().equals(wifis.get(i).getTime()))           //Time
							&&(line.getFirst().getID().equals(wifis.get(i).getID()))   		//ID
							&&(line.getFirst().getLAT().equals(wifis.get(i).getLAT()))     //LAT
							&&(line.getFirst().getLON().equals(wifis.get(i).getLON()))     //LON
							&&(line.getFirst().getALT().equals(wifis.get(i).getALT())))    //ALT
					{

						line.add(wifis.get(i));
						wifis.remove(i);
						i--;
					}
				}

				//keep the best 10 points in every line
				for(int i=0; i<line.size(); i++){    //bubble sort
					for( int j=1; j<line.size(); j++){

						if(Integer.parseInt(line.get(j).getSignal())>Integer.parseInt(line.get(j-1).getSignal())){
							Wifi tmp = line.get(j);
							line.set(j, line.get(j-1));
							line.set(j-1, tmp);
						}
					}
				}

				while(line.size()>10){  
					line.remove(10);
				}


				//write the best points to the file

				writer.append(line.get(0).getTime()+',');    //write the data that similar
				writer.append(line.get(0).getID()+',');   
				writer.append(line.get(0).getLAT()+',');
				writer.append(line.get(0).getLON()+',');
				writer.append(line.get(0).getALT()+',');
				writer.append(line.size()+""+',');       //the amount of wifis


				for(int l=0; l<line.size(); l++){              //write the data of each wifi
					writer.append(line.get(l).getSSID()+',');   
					writer.append(line.get(l).getMAC()+',');
					writer.append(line.get(l).getFrequncy()+',');
					writer.append(line.get(l).getSignal()+',');


				}

				writer.append('\n');
			}
			writer.flush();
			writer.close();

		} catch (IOException e) {System.out.println("destination unreachable /n "+e); return false;}
		return true;
	}


}



