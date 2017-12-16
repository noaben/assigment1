package matala001;

import static org.junit.Assert.*;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
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
		
	    assertEquals("the excpected points that comply with the filter request are equal to the actual points",20,q3.list("wifiTester.csv","filtering", "Place", "34.8160003,32.1628765").size());
	    assertEquals("the excpected points that comply with the filter request are equal to the actual points",2095,q3.list("wifiTester.csv","filtering", "Place", "34.8045678,32.16824833").size());
	    assertEquals("the excpected points that comply with the filter request are equal to the actual points",469,q3.list("wifiTester.csv","filtering", "Place", "34.8123452,32.1734854").size());
	}
	
	/**
	 * testing the filter (by time) function- by comparing the number of filtered points we are excepting to get.
	 **/
	
	@Test
	public void test2() {
	    assertEquals("the excpected points that comply with the filter request are equal to the actual points",255,q3.list("wifiTester.csv","filtering", "Time", "2017-10-27 16:19").size());
	    assertEquals("the excpected points that comply with the filter request are equal to the actual points",80,q3.list("wifiTester.csv","filtering", "Time", "2017-10-27 16:40").size());
	    assertEquals("the excpected points that comply with the filter request are equal to the actual points",248,q3.list("wifiTester.csv","filtering", "Time", "2017-10-27 16:23").size());

	}
	
	/**
	 * testing the findPlaceAlgorithm1- by comparing the place we are excepting to get to the one that the program calculates.
	 **/
	
	@Test
	public void test3() {
		
	    MAC mac1=q3.findPlaceAlgorithm1("wifiTester.csv","88:dc:96:17:c0:9e");
	    assertTrue((32.1623059-((int)(mac1.getLAT()*10000000))/10000000.0000000)==0);
	    assertTrue((34.8085222-((int)(mac1.getLON()*10000000))/10000000.0000000)==0);
            assertTrue((27.2660323-((int)(mac1.getALT()*10000000))/10000000.0000000)==0);

            MAC mac2=q3.findPlaceAlgorithm1("wifiTester.csv","14:ae:db:3d:b1:55");
            assertTrue((32.1671457-((int)(mac2.getLAT()*10000000))/10000000.0000000)==0);
	    assertTrue((34.8080293-((int)(mac2.getLON()*10000000))/10000000.0000000)==0);
            assertTrue((39.9270507-((int)(mac2.getALT()*10000000))/10000000.000000)==0);
        
	    MAC mac3=q3.findPlaceAlgorithm1("wifiTester.csv","e0:10:7f:49:37:fc");
	    assertTrue((32.1617363-((int)(mac3.getLAT()*10000000))/10000000.0000000)==0);
	    assertTrue((34.8091938-((int)(mac3.getLON()*10000000))/10000000.0000000)==0);
            assertTrue((19.8406876-((int)(mac3.getALT()*10000000))/10000000.0000000)==0);


	}
	

	/**
	 * testing the findPlaceAlgorithm2- by comparing the place we are excepting to get to the one that the program estimates.
	 **/
	
	@Test
	public void test4() {
		
        q3.findPlaceAlgorithm2("wifiTester.csv", "testFile_q3_algo2.csv","testResult_q3_algo2.csv");
		
        try{
            FileReader fr = new FileReader("testResult_q3_algo2.csv");
		    BufferedReader br = new BufferedReader(fr );
         
		    String str1=br.readLine();
		    String arr1[]=str1.split(",");
		    assertEquals("32.1687228",arr1[2].substring(0,10));
		    assertEquals("34.8130289",arr1[3].substring(0,10));
	            assertEquals("36.6164242",arr1[4].substring(0,10));
	   
		    String str2=br.readLine();
		    String arr2[]=str2.split(",");
		    assertEquals("32.1680658",arr2[2].substring(0,10));
		    assertEquals("34.8101188",arr2[3].substring(0,10));
		    assertEquals("27.1140817",arr2[4].substring(0,10));
           }
		
	   catch(IOException ex) {
		   System.out.print("Error reading file \n" + ex);} 
	       }
	
}
	
	

