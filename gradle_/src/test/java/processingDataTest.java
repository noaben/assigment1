package matalaMunche;

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
		
	    assertEquals("the excpected points that comply with the filter request are equal to the actual points",20,processingData.list("wifiTester.csv","filtering", "Place1", "34.8160003,32.1628765","yes").size());
	    assertEquals("the excpected points that comply with the filter request are equal to the actual points",2095,processingData.list("wifiTester.csv","filtering", "Place1", "34.8045678,32.16824833","yes").size());
	    assertEquals("the excpected points that comply with the filter request are equal to the actual points",469,processingData.list("wifiTester.csv","filtering", "Place1", "34.8123452,32.1734854","yes").size());
	
	    assertEquals("the excpected points that comply with the filter request are equal to the actual points",151,processingData.list("wifiTester.csv","filtering", "Place", "31.16811955,34.80267393,31,32.16811782,34.80613712,37","yes").size());
	    assertEquals("the excpected points that comply with the filter request are equal to the actual points",3683,processingData.list("wifiTester.csv","filtering", "Place", "31.16811955,34.80267393,31,32.16811782,34.80613712,37","not").size());

	}
	
	/**
	 * testing the filter (by time) function- by comparing the number of filtered points we are excepting to get.
	 **/
	
	@Test
	public void test2() {

	    assertEquals("the excpected points that comply with the filter request are equal to the actual points",1440,processingData.list("wifiTester.csv","filtering", "Time", "27-10-2017 16:23 27-10-2017 16:36","yes").size());
	    assertEquals("the excpected points that comply with the filter request are equal to the actual points",2394,processingData.list("wifiTester.csv","filtering", "Time", "27-10-2017 16:23 27-10-2017 16:36","not").size());

	    }
	
	/**
	 * testing the 2 filters operations
	 **/
	
	@Test
	public void test3() {
	    assertEquals("the excpected points that comply with the filter request are equal to the actual points",138,processingData.list("wifitester.csv","filtering", "Place", "31.16811955,34.80267393,31,32.16811782,34.80613712,37","yes", "Time", "27-10-2017 16:23 27-10-2017 16:36","yes", "and","yes").size());
	    assertEquals("the excpected points that comply with the filter request are equal to the actual points",1453,processingData.list("wifitester.csv","filtering", "Place", "31.16811955,34.80267393,31,32.16811782,34.80613712,37","yes", "Time", "27-10-2017 16:23 27-10-2017 16:36","yes", "or","yes").size());
	    assertEquals("the excpected points that comply with the filter request are equal to the actual points",3696,processingData.list("wifitester.csv","filtering", "Place", "31.16811955,34.80267393,31,32.16811782,34.80613712,37","yes", "Time", "27-10-2017 16:23 27-10-2017 16:36","yes", "and","not").size());
	    assertEquals("the excpected points that comply with the filter request are equal to the actual points",2381,processingData.list("wifitester.csv","filtering", "Place", "31.16811955,34.80267393,31,32.16811782,34.80613712,37","yes", "Time", "27-10-2017 16:23 27-10-2017 16:36","yes", "or","not").size());
	    
		assertEquals("the excpected points that comply with the filter request are equal to the actual points",2381,processingData.list("wifitester.csv","filtering", "Place", "31.16811955,34.80267393,31,32.16811782,34.80613712,37","not", "Time", "27-10-2017 16:23 27-10-2017 16:36","not", "and","yes").size());
	    assertEquals("the excpected points that comply with the filter request are equal to the actual points",3696,processingData.list("wifitester.csv","filtering", "Place", "31.16811955,34.80267393,31,32.16811782,34.80613712,37","not", "Time", "27-10-2017 16:23 27-10-2017 16:36","not", "or","yes").size());
	    assertEquals("the excpected points that comply with the filter request are equal to the actual points",1453,processingData.list("wifitester.csv","filtering", "Place", "31.16811955,34.80267393,31,32.16811782,34.80613712,37","not", "Time", "27-10-2017 16:23 27-10-2017 16:36","not", "and","not").size());
	    assertEquals("the excpected points that comply with the filter request are equal to the actual points",138,processingData.list("wifitester.csv","filtering", "Place", "31.16811955,34.80267393,31,32.16811782,34.80613712,37","not", "Time", "27-10-2017 16:23 27-10-2017 16:36","not", "or","not").size());
	
	    assertEquals("the excpected points that comply with the filter request are equal to the actual points",1302,processingData.list("wifitester.csv","filtering", "Place", "31.16811955,34.80267393,31,32.16811782,34.80613712,37","not", "Time", "27-10-2017 16:23 27-10-2017 16:36","yes", "and","yes").size());
	    assertEquals("the excpected points that comply with the filter request are equal to the actual points",3821,processingData.list("wifitester.csv","filtering", "Place", "31.16811955,34.80267393,31,32.16811782,34.80613712,37","not", "Time", "27-10-2017 16:23 27-10-2017 16:36","yes", "or","yes").size());
	    assertEquals("the excpected points that comply with the filter request are equal to the actual points",2532,processingData.list("wifitester.csv","filtering", "Place", "31.16811955,34.80267393,31,32.16811782,34.80613712,37","not", "Time", "27-10-2017 16:23 27-10-2017 16:36","yes", "and","not").size());
	    assertEquals("the excpected points that comply with the filter request are equal to the actual points",13,processingData.list("wifitester.csv","filtering", "Place", "31.16811955,34.80267393,31,32.16811782,34.80613712,37","not", "Time", "27-10-2017 16:23 27-10-2017 16:36","yes", "or","not").size());
    
	    assertEquals("the excpected points that comply with the filter request are equal to the actual points",13,processingData.list("wifitester.csv","filtering", "Place", "31.16811955,34.80267393,31,32.16811782,34.80613712,37","yes", "Time", "27-10-2017 16:23 27-10-2017 16:36","not", "and","yes").size());
        assertEquals("the excpected points that comply with the filter request are equal to the actual points",2532,processingData.list("wifitester.csv","filtering", "Place", "31.16811955,34.80267393,31,32.16811782,34.80613712,37","yes", "Time", "27-10-2017 16:23 27-10-2017 16:36","not", "or","yes").size());
	    assertEquals("the excpected points that comply with the filter request are equal to the actual points",3821,processingData.list("wifitester.csv","filtering", "Place", "31.16811955,34.80267393,31,32.16811782,34.80613712,37","yes", "Time", "27-10-2017 16:23 27-10-2017 16:36","not", "and","not").size());
	    assertEquals("the excpected points that comply with the filter request are equal to the actual points",1302,processingData.list("wifitester.csv","filtering", "Place", "31.16811955,34.80267393,31,32.16811782,34.80613712,37","yes", "Time", "27-10-2017 16:23 27-10-2017 16:36","not", "or","not").size());
	    }



	}
	

	
	

