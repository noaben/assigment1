package noa;

import static org.junit.Assert.*;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import org.junit.Test;

public class processingDataTest {


	/**
	 * testing the filter (by place) function- by comparing the number of filtered points we are excepting to get.
	 **/
	
	
	@Test
	public void test1() {
		
	    assertEquals("the excpected points that comply with the filter request are equal to the actual points",20,processingData.list("wifiTester.csv","filtering", "Place", "34.8160003,32.1628765").size());
	    assertEquals("the excpected points that comply with the filter request are equal to the actual points",2095,processingData.list("wifiTester.csv","filtering", "Place", "34.8045678,32.16824833").size());
	    assertEquals("the excpected points that comply with the filter request are equal to the actual points",469,processingData.list("wifiTester.csv","filtering", "Place", "34.8123452,32.1734854").size());
	}
	
	/**
	 * testing the filter (by time) function- by comparing the number of filtered points we are excepting to get.
	 **/
	
	@Test
	public void test2() {
	    assertEquals("the excpected points that comply with the filter request are equal to the actual points",255,processingData.list("wifiTester.csv","filtering", "Time", "2017-10-27 16:19").size());
	    assertEquals("the excpected points that comply with the filter request are equal to the actual points",80,processingData.list("wifiTester.csv","filtering", "Time", "2017-10-27 16:40").size());
	    assertEquals("the excpected points that comply with the filter request are equal to the actual points",248,processingData.list("wifiTester.csv","filtering", "Time", "2017-10-27 16:23").size());

	}
	
}
	
	

