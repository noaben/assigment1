package matala01;


import static org.junit.Assert.*;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;

import org.junit.Test;

/**
 * Tests for class q2
 * @author Ben and Noa
 *
 */

public class q2Test {
	
	
	
	/*
	 * testing function "protected static File [] findCsvFiles (String folderPath)"
	 */

	
	@Test
	public void test1(){
		assertNull("folder path doesn't exist",q2.findCsvFiles ("abc"));
	    }


	@Test
	public void test2(){
		assertNull("folder exists. no files in folder",q2.findCsvFiles ("testFolder1"));
	    }
	
	
	@Test
	public void test3(){
		assertNull("folder exists. no csv's files in folder",q2.findCsvFiles ("testFolder2"));
		}

	
	@Test
	public void test4(){
		File[] files=new File[2];
		files[0]=new File("wifiFolder/wiglewifi_20171107153506.csv");
		files[1]=new File("wifiFolder/wiglewifi_20171107165504.csv");
		assertArrayEquals("there are csv's files in folder",files,q2.findCsvFiles ("wifiFolder"));
		}

	

	/*
	 * testing function "protected static String getFileFormat(File f)"
	 */
		
		
	
	@Test
	public void test5(){
	     File f =new File("test.csv");
	     assertEquals("the file doesn't exist","",q2.getFileFormat(f));
	}
		
		
	@Test
	public void test6(){
	     File f=new File("testFolder3");
	     File []files=f.listFiles();
	     try{
	    	assertEquals("correct. there is an existing csv's file in the folder","csv",q2.getFileFormat(files[0]));
	        }
	       catch(NullPointerException ex)  {System.out.print("no files");}
	 }
		
	
	@Test
	public void test7(){
	     File f=new File("testFolder2"); 
	     File []files=f.listFiles();
		 try{
		 assertNotEquals("incorrect. there is an existing file in the folder, but not csv","csv",q2.getFileFormat(files[0]));
			}
		 catch(NullPointerException ex) {System.out.print("no files");}
    }
		
		

	/*
	 * testing function "protected static LinkedList<Wifi> fileToList(File[] listOfFiles)"
	 */
		@Test
		public void test8(){
		LinkedList<Wifi> wifis = new LinkedList<Wifi>();
	    wifis.add(new Wifi("2017-10-30 12:06","ONEPLUS A3010_28_171012","32.10439236","35.20449021","661","Ariel_University","24:c9:a1:36:55:f8","11","-54"));
	    wifis.add(new Wifi("2017-10-30 12:06","ONEPLUS A3010_28_171012","32.10439236","35.20449021","661","Ariel_University","8c:0c:90:30:05:58","11","-62"));
	    wifis.add(new Wifi("2017-10-30 12:06","ONEPLUS A3010_28_171012","32.10439236","35.20449021","661","Ariel_University","8c:0c:90:2e:f0:d8","1","-79"));
	    wifis.add(new Wifi("2017-10-30 12:06","ONEPLUS A3010_28_171012","32.10439236","35.20449021","661","Ariel_University","24:c9:a1:36:56:e8","6","-76"));
	    wifis.add(new Wifi("2017-10-30 12:06","ONEPLUS A3010_28_171012","32.10439236","35.20449021","661","Ariel_University","24:c9:a1:35:a5:e8","6","-94"));
	    wifis.add(new Wifi("2017-10-30 12:06","ONEPLUS A3010_28_171012","32.10439236","35.20449021","661","not_your_wifi","a0:ab:1b:63:40:be","2","-79"));
	    wifis.add(new Wifi("2017-10-30 12:06","ONEPLUS A3010_28_171012","32.10439236","35.20449021","661","island-365C30","24:c9:a1:76:5c:33","12","-81"));
	    wifis.add(new Wifi("2017-10-30 12:06","ONEPLUS A3010_28_171012","32.10439236","35.20449021","661","Ariel_University","24:c9:a1:35:a5:e8","6","-94"));
	    wifis.add(new Wifi("2017-10-30 12:06","ONEPLUS A3010_28_171012","32.10439236","35.20449021","661","Ariel_University","8c:0c:90:2f:ca:48","11","-80"));
	    wifis.add(new Wifi("2017-10-30 12:06","ONEPLUS A3010_28_171012","32.10439236","35.20449021","661","Rami Levy","42503_6701_4464091","0","-77"));
	    wifis.add(new Wifi("2017-10-30 12:06","ONEPLUS A3010_28_171012","32.10439236","35.20449021","661","Ariel_University","24:c9:a1:35:a5:e8","6","-94"));
	    wifis.add(new Wifi("2017-10-30 12:06","ONEPLUS A3010_28_171012","32.10445161","35.20447579","651","Ariel_University","24:c9:a1:36:2f:38","1","-88"));
	    wifis.add(new Wifi("2017-10-30 12:07","ONEPLUS A3010_28_171012","32.10445169","35.2044872","651","Rami Levy","42503_6701_4464097","0","-79"));
	    wifis.add(new Wifi("2017-10-30 12:07","ONEPLUS A3010_28_171012","32.10445131","35.20448783","651","Ariel_University","24:c9:a1:35:a5:e8","6","-85"));
	    wifis.add(new Wifi("2017-10-30 12:07","ONEPLUS A3010_28_171012","32.10445268","35.20449161","652","Ariel_University","24:c9:a1:36:52:f8","1","-87"));
	    wifis.add(new Wifi("2017-10-30 12:09","ONEPLUS A3010_28_171012","32.10443776","35.20454223","652","Ariel_University","8c:0c:90:30:05:58","11","-56"));
	    wifis.add(new Wifi("2017-10-30 12:09","ONEPLUS A3010_28_171012","32.10443226","35.20454484","652","Ariel_University","24:c9:a1:35:aa:08","11","-93"));
	    wifis.add(new Wifi("2017-10-30 23:42","ONEPLUS A3010_28_171012","32.10437744","35.20460922","659","Ariel_University","8c:0c:90:2f:ca:48","11","-88"));
	    wifis.add(new Wifi("2017-10-30 23:42","ONEPLUS A3010_28_171012","32.10437744","35.20460922","659","Rami Levy","42503_6701_4464091","0","-69"));
	    wifis.add(new Wifi("2017-10-30 23:42","ONEPLUS A3010_28_171012","32.10440975","35.20463836","656","Ariel_University","8c:0c:90:2e:f0:d8","1","-82"));
	    wifis.add(new Wifi("2017-10-30 23:42","ONEPLUS A3010_28_171012","32.10437866","35.20459091","666","not_your_wifi","a0:ab:1b:63:40:be","2","-86"));
	    wifis.add(new Wifi("2017-10-30 23:42","ONEPLUS A3010_28_171012","32.10437426","35.20457751","658","Ariel_University","24:c9:a1:36:2f:38","1","-83"));
	    wifis.add(new Wifi("2017-11-01 14:24","ONEPLUS A3010_28_171012","32.10432911","35.20458677","645","Ariel_University","24:c9:a1:33:3d:08","6","-90"));
	    wifis.add(new Wifi("2017-11-01 14:24","ONEPLUS A3010_28_171012","32.10432911","35.20458677","645","Rami Levy","42503_6701_4464097","0","-77"));
	    wifis.add(new Wifi("2017-11-01 14:24","ONEPLUS A3010_28_171012","32.1043617","35.20456408","640","Rami Levy","42503_6701_4464097","0","-71"));
	    wifis.add(new Wifi("2017-11-01 14:25","ONEPLUS A3010_28_171012","32.10436408","35.20456039","640","Ariel_University","24:c9:a1:36:56:f8","6","-84"));
	    wifis.add(new Wifi("2017-11-01 14:25","ONEPLUS A3010_28_171012","32.10436408","35.20456039","640","Ariel_University","24:c9:a1:33:3d:08","6","-84"));
	    wifis.add(new Wifi("2017-11-01 14:25","ONEPLUS A3010_28_171012","32.10436268","35.20456102","640","island-365C30","24:c9:a1:76:5c:33","12","-80"));
	    wifis.add(new Wifi("2017-11-01 14:26","ONEPLUS A3010_28_171012","32.10436063","35.20456187","640","Ariel_University","24:c9:a1:33:3d:08","6","-76"));
	    wifis.add(new Wifi("2017-11-01 14:27","ONEPLUS A3010_28_171012","32.1043398","35.20452306","642","Ariel_University","8c:0c:90:2e:f0:d8","1","-80"));
	    wifis.add(new Wifi("2017-11-01 14:27","ONEPLUS A3010_28_171012","32.10439696","35.20460419","648","Ariel_University","24:c9:a1:36:56:e8","6","-88"));
	    wifis.add(new Wifi("2017-11-01 14:32","ONEPLUS A3010_28_171012","32.10437635","35.20460505","638","Ariel_University","24:c9:a1:36:56:e8","6","-80"));
	    wifis.add(new Wifi("2017-11-01 14:32","ONEPLUS A3010_28_171012","32.1043647","35.20460212","638","Ariel_University","8c:0c:90:30:05:58","11","-59"));
	    wifis.add(new Wifi("2017-11-01 14:32","ONEPLUS A3010_28_171012","32.1043647","35.20460212","638","Ariel_University","8c:0c:90:2e:f0:d8","1","-74"));
	    wifis.add(new Wifi("2017-11-01 14:32","ONEPLUS A3010_28_171012","32.10444352","35.20453609","650","IP-COM_051AB8","d8:38:0d:05:1a:b9","4","-81"));
	    wifis.add(new Wifi("2017-11-01 14:32","ONEPLUS A3010_28_171012","32.10444352","35.20453609","650","Ariel_University","24:c9:a1:35:aa:08","11","-87"));
	    wifis.add(new Wifi("2017-11-01 14:32","ONEPLUS A3010_28_171012","32.10448447","35.20453355","651","Ariel_University","24:c9:a1:36:55:f8","11","-72"));
	    wifis.add(new Wifi("2017-11-01 14:32","ONEPLUS A3010_28_171012","32.10448447","35.20453355","651","Ariel_University","24:c9:a1:36:2f:38","1","-86"));
	    wifis.add(new Wifi("2017-11-01 14:32","ONEPLUS A3010_28_171012","32.10448447","35.20453355","651","not_your_wifi","a0:ab:1b:63:40:be","2","-96"));

	    for (int i=0;i<wifis.size();i++)
	    assertTrue(q2.fileToList(q2.findCsvFiles ("testFolder3")).get(i).equals(wifis.get(i)));
	    assertEquals(wifis.size(),q2.fileToList(q2.findCsvFiles ("testFolder3")).size());
		}
	
	
		
	/*
	 * testing function "protected static boolean legit(String str)"
	 */
	
 
	@Test
	public void test9(){
		String str1="WIFI,47";
		assertFalse("not legit, has only 2 fields",q2.legit(str1));
		}
	
	
	@Test
	public void test10(){
		String str2="WIFI,47,35.20928742,32.10346077,-61,44,2017-11-07 15:49,[ESS],727,Ariel_University,1c:b9:c4:16:d2:8c,7890";
		assertFalse("not legit, has more than 11 fields",q2.legit(str2));
		}
	

	@Test
	public void test11(){
		String str3="WIFI,47,35.20928742,32.10346077,-61,44,2017-11-07 15:49,[ESS],727,Ariel_University,1c:b9:c4:16:d2:8c";
		assertTrue("legit, has exactly 11 fields",q2.legit(str3));
	}
	
	
	/*
	 * testing function "protected static boolean listToCSV(LinkedList<Wifi> wifis, String CSVpath)"
	 */
		
	@Test 
	public void test12(){ 
	
	q2.listToCSV(q2.fileToList(q2.findCsvFiles ("testFolder3")),"actualCsv.csv");
	    try {  
	    	LinkedList<Wifi> exp = new LinkedList<Wifi>();
	    	
			FileReader frExpected = new FileReader("expectedCsv.csv");
			BufferedReader brExpected = new BufferedReader(frExpected );

			String strExpected= brExpected.readLine();
			
			FileReader frActual = new FileReader("actualCsv.csv");
			BufferedReader brActual = new BufferedReader(frActual );

			String strActual= brActual.readLine();
			
			while(strExpected!=null && strActual!=null ){
				assertEquals(strExpected,strActual);
				strExpected= brExpected.readLine();
		        strActual= brActual.readLine();
			    }
			
			if ((strExpected==null && strActual!=null) || (strActual==null && strExpected!=null))
				assertTrue("number of lines in the file are different",false);
	        }
		 	catch(IOException ex) {
				System.out.print("Error reading file \n" + ex);} 
		    }
	
     }