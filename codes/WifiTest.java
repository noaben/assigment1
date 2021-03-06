package matalaMunche;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * Tests for class Wifi
 * @author Ben and Noa
 *
 */

public class WifiTest {

	String TIME="2017-7-7 16:51";
	String LAT="32.33333";
	String LON="35.33333";
	String ID="oppo_df_3";
	String ALT="45";
	String SSID="Arielu";
	String MAC="6.6.6";
	String frequncy="10";
	String signal="-50";
	
	
	//testing the correctness of the wifi data
	
	@Test
	public void test1() {
		Wifi w = new Wifi(TIME,ID,LAT,LON,ALT,SSID,MAC,frequncy,signal);
		assertTrue("full data",Wifi.correct(w.getTime(), w.getID(), w.getLAT(), w.getLON(), w.getALT(), w.getSSID(), w.getMAC(), w.getFrequncy(), w.getSignal()));
		Wifi w2 = new Wifi(TIME,ID,LAT,LON,ALT,SSID,"",frequncy,signal);
		assertFalse("missing data. 'MAC' has no value", Wifi.correct(w2.getTime(), w2.getID(), w2.getLAT(), w2.getLON(), w2.getALT(), w2.getSSID(), w2.getMAC(), w2.getFrequncy(), w2.getSignal()));
		Wifi w4 = new Wifi(TIME,ID,LAT,LON,ALT,SSID,MAC,frequncy,"-113");
		assertFalse("input incorrect. The value of signal is a mistake",Wifi.correct( w4.getTime(), w4.getID(), w4.getLAT(), w4.getLON(), w4.getALT(), w4.getSSID(), w4.getMAC(), w4.getFrequncy(), w4.getSignal()));
		Wifi w5 = new Wifi(TIME,ID,"NJN",LON,ALT,SSID,MAC,frequncy,signal);
		assertFalse("input incorrect. we need to be able to convert to float the value of LAT",Wifi.correct(w5.getTime(), w5.getID(), w5.getLAT(), w5.getLON(), w5.getALT(), w5.getSSID(), w5.getMAC(), w5.getFrequncy(), w5.getSignal()));
		Wifi w6 = new Wifi(TIME,ID,LAT,"SBG",ALT,SSID,MAC,frequncy,signal);
		assertFalse("input incorrect. we need to be able to convert to float the value of LON",Wifi.correct(w6.getTime(), w6.getID(), w6.getLAT(), w6.getLON(), w6.getALT(), w6.getSSID(), w6.getMAC(), w6.getFrequncy(), w6.getSignal()));
	    Wifi w7 = new Wifi("1970-9-9 12:54",ID,LAT,"SBG",ALT,SSID,MAC,frequncy,signal);
		assertFalse("input incorrect. the year is 1970, and we are now in 2017",Wifi.correct(w7.getTime(), w7.getID(), w7.getLAT(), w7.getLON(), w7.getALT(), w7.getSSID(), w7.getMAC(), w7.getFrequncy(), w7.getSignal()));
	}
	
	//testing function "public  boolean equals(Wifi other)"
	
	@Test 
	public void test2() {
		Wifi w8 = new Wifi("1970-9-9 12:54",ID,LAT,LON,"46",SSID,MAC,frequncy,signal);
		Wifi w9 = new Wifi("1970-9-9 12:54",ID,LAT,LON,"43",SSID,MAC,frequncy,signal);
		assertFalse("the ALT's data isn't the same",w8.equals(w9));
	
		Wifi w10 = new Wifi("1970-9-9 12:54",ID,LAT,LON,ALT,SSID,MAC,frequncy,"-90");
		Wifi w11 = new Wifi("1970-9-9 12:54",ID,LAT,LON,ALT,SSID,MAC,frequncy,"-97");
		assertFalse("the signal's data isn't the same",w10.equals(w11));
	
		Wifi w12 = new Wifi("1970-9-9 12:54",ID,LAT,LON,ALT,SSID,MAC,frequncy,"-90");
		Wifi w13 = new Wifi("1970-9-9 12:54",ID,LAT,LON,ALT,SSID,MAC,frequncy,"-90");
		assertTrue("all the Wifi's data is the same",w12.equals(w13));
	}
	
	
	//testing function  "public String getCoordinates()""
	@Test 
	public void test3() {
		Wifi w = new Wifi(TIME,ID,LAT,LON,ALT,SSID,MAC,frequncy,signal);
		assertEquals("getting the correct coordinates","35.33333,32.33333",w.getCoordinates());
	
		Wifi w1 = new Wifi(TIME,ID,LAT,LON,ALT,SSID,MAC,frequncy,signal);
		assertNotEquals("getting the wrong coordinates","35.67545,32.33333",w1.getCoordinates());
	}
	
	//testing the get's functions
		
	@Test 
	public void test4() {
	
		Wifi wifi=new Wifi(TIME,ID,LAT,LON,ALT,SSID,MAC,frequncy,signal);
		assertEquals("the same",TIME,wifi.getTime());
		assertEquals("the same",LAT,wifi.getLAT());
		assertEquals("the same",ID,wifi.getID());
		assertEquals("the same",LON,wifi.getLON());
		assertEquals("the same",ALT,wifi.getALT());
		assertEquals("the same",LON,wifi.getLON());
		assertEquals("the same",SSID,wifi.getSSID());
		assertEquals("the same",MAC,wifi.getMAC());
		assertEquals("the same",frequncy,wifi.getFrequncy());
		assertEquals("the same",signal,wifi.getSignal());
	}
	
	
		
		
	
}
