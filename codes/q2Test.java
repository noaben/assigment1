package munche;

import static org.junit.Assert.*;
import java.io.File;
import java.io.FileWriter;
import java.util.LinkedList;

import org.junit.Test;

public class q2Test {
		
	/*
	 * Checking function "protected static boolean legit(String str)"
	 */
	
	//missing data of the wifi's point 
	@Test
	public void test1(){
		String str1="WIFI,47";
		assertFalse("not legit, has only 2 fields",q2.legit(str1));
		}
	
	//more data than required. can be incorrect.
	@Test
	public void test2(){
		String str2="WIFI,47,35.20928742,32.10346077,-61,44,2017-11-07 15:49,[ESS],727,Ariel_University,1c:b9:c4:16:d2:8c,7890";
		assertFalse("not legit, has more than 11 fields",q2.legit(str2));
		}
	
	////the data is equal to the number of fields required
	@Test
	public void test3(){
		String str3="WIFI,47,35.20928742,32.10346077,-61,44,2017-11-07 15:49,[ESS],727,Ariel_University,1c:b9:c4:16:d2:8c";
		assertTrue("legit, has exactly 11 fields",q2.legit(str3));
	}
	
	
	/*
	 * Checking function "protected static String getFileFormat(File f)"
	 */
	
	
	//the file doesn't exist
	@Test
	public void test4(){
		File f =new File("test.csv");
		assertEquals("the file doesn't exist so we don't need it","",q2.getFileFormat(f));
	}
	
	//the file has csv's format
	@Test
	public void test5(){
		File f=new File("testFolder1");
		File []files=f.listFiles();
		try{
		assertEquals("correct. there is an existing csv's file in the folder","csv",q2.getFileFormat(files[0]));
		}
		catch(NullPointerException ex)  {System.out.print("no files");}
	}
	
	//the file hasn't csv's format
	@Test
	public void test6(){
		File f=new File("testFolder2");
		File []files=f.listFiles();
		try{
		assertNotEquals("incorrect. there is an existing file in the folder, but not csv","csv",q2.getFileFormat(files[0]));
		}
		catch(NullPointerException ex) {System.out.print("no files");}
	}
	
	/*
	 * Checking function "protected static File [] findCsvFiles (String folderPath)"
	 */
	
	//folder path doesn't exist
	
	File[] file1=q2.findCsvFiles("testFolder3");
	
	@Test
	public void test7(){
		assertNull("Null",q2.findCsvFiles ("abc"));
	}
	
	//folder exists. no files in folder

	@Test
	public void test8(){
		assertNull("Null",q2.findCsvFiles ("testFolder4"));
	}
	
	//folder exists. no csv's files in folder
	
		@Test
		public void test9(){
		assertNull("Null",q2.findCsvFiles ("testFolder2"));
		}
	
	//there are csv's files in folder
	
		@Test
		public void test10(){
			File[] files=new File[2];
			files[0]=new File("wifiFolder/wiglewifi_20171107153506.csv");
			files[1]=new File("wifiFolder/wiglewifi_20171107165504.csv");
			assertArrayEquals(files,q2.findCsvFiles ("wifiFolder"));
		}

		
		/*
		 * Checking function "protected static LinkedList<Wifi> fileToList(File[] listOfFiles)"
		 */
		@Test
		public void test11(){
		LinkedList<Wifi> wifis = new LinkedList<Wifi>();
	    wifis.add(new Wifi("2017-10-30 12:06","ONEPLUS A3010_28_171012","32.10439236","35.20449021","661","Ariel_University","24:c9:a1:36:55:f8","11","-54"));
	    wifis.add(new Wifi("2017-10-30 12:06","ONEPLUS A3010_28_171012","32.10439236","35.20449021","661","Ariel_University","8c:0c:90:30:05:58","11","-62"));
	    wifis.add(new Wifi("2017-10-30 12:06","ONEPLUS A3010_28_171012","32.10439236","35.20449021","661","Ariel_University","8c:0c:90:2e:f0:d8","1","-79"));
	    wifis.add(new Wifi("2017-10-30 12:06","ONEPLUS A3010_28_171012","32.10439236","35.20449021","661","Ariel_University","24:c9:a1:36:56:e8","6","-76"));
	    wifis.add(new Wifi("2017-10-30 12:06","ONEPLUS A3010_28_171012","32.10439236","35.20449021","661","not_your_wifi","a0:ab:1b:63:40:be","2","-79"));
	    wifis.add(new Wifi("2017-10-30 12:06","ONEPLUS A3010_28_171012","32.10439236","35.20449021","661","island-365C30","24:c9:a1:76:5c:33","12","-81"));
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
	    wifis.add(new Wifi("2017-11-01 14:32","ONEPLUS A301_28_171012","32.1043647","35.20460212","638","Ariel_University","8c:0c:90:2e:f0:d8","1","-74"));
	    wifis.add(new Wifi("2017-11-01 14:32","ONEPLUS A3010_28_171012","32.10444352","35.20453609","650","IP-COM_051AB8","d8:38:0d:05:1a:b9","4","-81"));
	    wifis.add(new Wifi("2017-11-01 14:32","ONEPLUS A3010_28_171012","32.10444352","35.20453609","650","Ariel_University","24:c9:a1:35:aa:08","11","-87"));
	    wifis.add(new Wifi("2017-11-01 14:32","ONEPLUS A3010_28_171012","32.10448447","35.20453355","651","Ariel_University","24:c9:a1:36:55:f8","11","-72"));
	    wifis.add(new Wifi("2017-11-01 14:32","ONEPLUS A3010_28_171012","32.10448447","35.20453355","651","Ariel_University","24:c9:a1:36:2f:38","1","-86"));
	    wifis.add(new Wifi("2017-11-01 14:32","ONEPLUS A3010_28_171012","32.10448447","35.20453355","651","not_your_wifi","a0:ab:1b:63:40:be","2","-96"));

	    for (int i=0;i<wifis.size();i++)
	    assertTrue(q2.fileToList(q2.findCsvFiles ("testFolder1")).get(i).equals(wifis.get(i)));
	    assertEquals(wifis.size(),q2.fileToList(q2.findCsvFiles ("testFolder1")).size());
		}
		
		
		//@Test
		  //  public void noID(){
			//assertThrows(IndexOutOfBoundsException.class,() -> q2.fileToList(file1));
		//}

		
			// TODO Auto-generated method stub
			

	//folder path doesn't exist
	
	/*@Test
	public void test7(){
	
	//LinkedList <Wifi> list=null;
	//the first line of the data is incorrect
	/*@Test
	public void test7(){
		try{
		String str="WigleWifi-1.4,appRelease=2.26,model=Nexus 5,release=6.0.1";
		String display = str.split(",")[5].split("=")[1];
		fail("incorrect");
		}
		catch(IndexOutOfBoundsException ex) {System.out.print("unexepted CSV content format");}
	}
	
	
	// test infinity
		@Test(timeout=5500)
		public void test8() {
			q2.infinity();
		}*/
	
	

}
