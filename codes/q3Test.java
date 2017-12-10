package matala001;

import static org.junit.Assert.*;

import java.util.LinkedList;

import org.junit.Test;

/**
 * Tests for class q3
 * @author Ben and Noa
 *
 */

public class q3Test {
	
	/**
	 * testing the filter (by place) function- by comparing the number of filtered points we are excepting to get.
	 **/
	
	
	@Test
	public void test1() {
	    assertEquals("the excpected points that comply with the filter request are equal to the actual points",20,q3.list("wifiTester.csv", "Place", "34.8160003,32.1628765").size());
	    assertEquals("the excpected points that comply with the filter request are equal to the actual points",2095,q3.list("wifiTester.csv", "Place", "34.8045678,32.16824833").size());
	    assertEquals("the excpected points that comply with the filter request are equal to the actual points",469,q3.list("wifiTester.csv", "Place", "34.8123452,32.1734854").size());
	}
	
	/**
	 * testing the filter (by time) function- by comparing the number of filtered points we are excepting to get.
	 **/
	
	@Test
	public void test2() {
	    assertEquals("the excpected points that comply with the filter request are equal to the actual points",255,q3.list("wifiTester.csv", "Time", "2017-10-27 16:19").size());
	    assertEquals("the excpected points that comply with the filter request are equal to the actual points",80,q3.list("wifiTester.csv", "Time", "2017-10-27 16:40").size());
	    assertEquals("the excpected points that comply with the filter request are equal to the actual points",248,q3.list("wifiTester.csv", "Time", "2017-10-27 16:23").size());

	}
	
	/**
	 * testing the findPlaceAlgorithm1- by comparing the place we are excepting to get to the one that the program calculates.
	 **/
	
	@Test
	public void test3() {
	        MAC mac1=new MAC("88:dc:96:17:c0:9e",32.1625599,34.8082105,33.5356201);
		assertTrue("The required MAC is the same that we excepted ",q3.findPlaceAlgorithm1("wifiTester.csv","88:dc:96:17:c0:9e").equals(mac1));
		MAC mac2=new MAC("14:ae:db:3d:b1:55",32.1671223,34.8081163,39.6266474);
		assertTrue("The required MAC is the same that we excepted ",q3.findPlaceAlgorithm1("wifiTester.csv","14:ae:db:3d:b1:55").equals(mac2));
		MAC mac3=new MAC("e0:10:7f:49:37:fc",32.1617363,34.8091938,19.8406876);
		assertTrue("The required MAC is the same that we excepted ",q3.findPlaceAlgorithm1("wifiTester.csv","e0:10:7f:49:37:fc").equals(mac3));
	}
	

	/**
	 * testing the findPlaceAlgorithm2- by comparing the place we are excepting to get to the one that the program calculates.
	 **/
	
	@Test
	public void test4() {
		assertTrue("The required MAC is the same that we excepted ",q3.findPlaceAlgorithm2("wifiTester.csv","-60","74:da:38:50:77:f2","-70","a0:63:91:69:f6:af","-91","98:e7:f4:c6:4b:37").equals("LAT: 32.1687209 LON: 34.8132144 ALT: 37.5722597"));
		assertTrue("The required MAC is the same that we excepted ",q3.findPlaceAlgorithm2("wifiTester.csv","-60","f8:d1:11:b1:92:93","-75","74:da:38:97:66:9d","-90","ec:08:6b:38:0d:dd").equals("LAT: 32.1681005 LON: 34.8101392 ALT: 26.0928673"));

	}
	
	

}
