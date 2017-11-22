package matala01;

import static org.junit.Assert.*;

import java.util.LinkedList;

import org.junit.Test;

/**
 * Tests for class q3
 * @author Ben and Noa
 *
 */

public class q3Test {
	
	/*
     *testing function "protected static LinkedList<Wifi> csvtoList(String csvpath, String filterBy, String requiredData)"
	 */
	
	//filtering by Place
	@Test
	public void test1() {
		LinkedList<Wifi> wifis = new LinkedList<Wifi>();
	    wifis.add(new Wifi("2017-11-01 14:32","ONEPLUS A3010_28_171012","32.10444352","35.20453609","650","IP-COM_051AB8","d8:38:0d:05:1a:b9","4","-81"));
	    wifis.add(new Wifi("2017-11-01 14:32","ONEPLUS A3010_28_171012","32.10444352","35.20453609","650","Ariel_University","24:c9:a1:35:aa:08","11","-87"));
	    assertEquals("both of the linkedList have the same size",wifis.size(),q3.csvtoList("actualCsv.csv", "Place", "35.20453609,32.10444352").size());
	    for (int i=0;i<wifis.size();i++)
		assertTrue("every Wifi's point in the excepted list is eqvivalent to the wifi's point in its place in the actual list"
				   ,wifis.get(i).equals(q3.csvtoList("actualCsv.csv", "Place", "35.20453609,32.10444352").get(i)));	
	}
	
	//filtering by Time
	@Test
	public void test2() {
		LinkedList<Wifi> wifis = new LinkedList<Wifi>();
	    wifis.add(new Wifi("2017-11-01 14:24","ONEPLUS A3010_28_171012","32.10432911","35.20458677","645","Rami Levy","42503_6701_4464097","0","-77"));
	    wifis.add(new Wifi("2017-11-01 14:24","ONEPLUS A3010_28_171012","32.10432911","35.20458677","645","Ariel_University","24:c9:a1:33:3d:08","6","-90"));
	    wifis.add(new Wifi("2017-11-01 14:24","ONEPLUS A3010_28_171012","32.1043617","35.20456408","640","Rami Levy","42503_6701_4464097","0","-71"));
	    assertEquals("both of the linkedList have the same size",wifis.size(),q3.csvtoList("actualCsv.csv", "Time", "2017-11-01 14:24").size());
	    for (int i=0;i<wifis.size();i++)
		assertTrue("every Wifi's point in the excepted list is eqvivalent to the wifi's point in its place in the actual list"
,                  wifis.get(i).equals(q3.csvtoList("actualCsv.csv", "Time", "2017-11-01 14:24").get(i)));	
	}
	
	/*
     *	testing function "protected static LinkedList<Wifi> organize(LinkedList<Wifi> wifilist)"
     */
	
	@Test
	public void test3() {
		LinkedList<Wifi> wifis = new LinkedList<Wifi>();
	    wifis.add(new Wifi("2017-11-01 14:24","ONEPLUS A3010_28_171012","32.10432911","35.20458677","645","Rami Levy","42503_6701_4464097","0","-77"));
	    wifis.add(new Wifi("2017-11-01 14:24","ONEPLUS A3010_28_171012","32.10432911","35.20458677","645","Ariel_University","24:c9:a1:33:3d:08","6","-90"));
	    assertEquals("both of the linkedList have the same size",wifis.size(),q3.organize(q3.csvtoList("actualCsv.csv", "Time", "2017-11-01 14:24")).size());
	    for (int i=0;i<wifis.size();i++)
		assertTrue("every Wifi's point in the excepted list is eqvivalent to the wifi's point in its place in the actual list",
				wifis.get(i).equals(q3.organize(q3.csvtoList("actualCsv.csv", "Time", "2017-11-01 14:24")).get(i)));	
	}
	
	/*
	 * testing function "kml(LinkedList<Wifi> updateList, String path)"
	 */ 
	
	@Test
	public void test4() {
		LinkedList<Wifi> wifis = new LinkedList<Wifi>();
		assertFalse("gets empty list-return false",q3.kml(wifis,"kmlTest.kml"));
	}
	
	@Test
	public void test5() {
		LinkedList<Wifi> wifis = new LinkedList<Wifi>();
	    wifis.add(new Wifi("2017-11-01 14:24","ONEPLUS A3010_28_171012","32.10432911","35.20458677","645","Rami Levy","42503_6701_4464097","0","-77"));
		assertTrue("The list isn't empty. we can create a file",q3.kml(wifis,"kmlTest.kml"));
	}
	

}
