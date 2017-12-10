package matala001;


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
	
	/**
	 * testing the function that finds if there are CSV's files in the folder.
	 **/
		
	@Test
	public void test1(){
		assertFalse("folder path doesn't exist",q2.toCSV("abc","csvTestFile.csv"));
		assertFalse("folder exists. no files in folder",q2.toCSV("testFolder1","csvTestFile.csv"));
		assertFalse("folder exists. no csv's files in folder",q2.toCSV ("testFolder2","csvTestFile.csv"));
		assertTrue("there are csv's files in folder",q2.toCSV("testFolder3","wifiTester.csv"));
	    }

	
	/**
	 * testing if the CSV file that the function retrieves has the same number of lines  that we are excepting to get
	 **/
		
	@Test 
	public void test2(){ 
	
	    if (q2.toCSV("testFolder3","wifiTester.csv")==false)
		    assertTrue(false);
	    
	        int count=0;
	        
	        try {  
		    	 
	        
	        FileReader fr = new FileReader("wifiTester.csv");
			BufferedReader br = new BufferedReader(fr );
	    
			while (br.readLine()!=null)
	    		count++;
			
	        }
		 	catch(IOException ex) {
				System.out.print("Error reading file \n" + ex);} 
		    
	
	    assertEquals(count,739);
		
	    
	    if (q2.toCSV("BM1_wifiscans","BM1.csv")==false)
		    assertTrue(false);
	    
	        count=0;
	        
	        try {  
		    	 
	        
	        FileReader fr1 = new FileReader("BM1.csv");
			BufferedReader br1 = new BufferedReader(fr1);
	    
			while (br1.readLine()!=null)
	    		count++;
			
	        }
		 	catch(IOException ex) {
				System.out.print("Error reading file \n" + ex);} 
		    
	
	    assertEquals(count,348);
	    
	    if (q2.toCSV("BM2_wifiscans","BM2.csv")==false)
		    assertTrue(false);
	    
	        count=0;
	        
	        try {  
		    	 
	        
	        FileReader fr2 = new FileReader("BM2.csv");
			BufferedReader br2 = new BufferedReader(fr2 );
	    
			while (br2.readLine()!=null)
	    		count++;
			
	        }
		 	catch(IOException ex) {
				System.out.print("Error reading file \n" + ex);} 
		    
	
	    assertEquals(count,387);
	    
	    if (q2.toCSV("BM3_wifiscans","BM3.csv")==false)
		    assertTrue(false);
	    
	        count=0;
	        
	        try {  
		    	 
	        
	        FileReader fr3 = new FileReader("BM3.csv");
			BufferedReader br3 = new BufferedReader(fr3 );
	    
			while (br3.readLine()!=null)
	    		count++;
			
	        }
		 	catch(IOException ex) {
				System.out.print("Error reading file \n" + ex);} 
		    
	
	    assertEquals(count,107);
	
	
	
	
	   }
  }

	
	   }
  }
