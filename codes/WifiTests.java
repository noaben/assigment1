package munche;

import static org.junit.Assert.*;

import org.junit.Test;

public class WifiTests {

	String TIME="2017-7-7 16:51";
	String LAT="32.33333";
	String LON="35.33333";
	String ID="oppo_df_3";
	String ALT="45";
	String SSID="Arielu";
	String MAC="6.6.6";
	String frequncy="10";
	String signal="-50";
	
	//the data of the wifi's point is full
	@Test (timeout=0)
	public void test1() {
		Wifi w = new Wifi(ID,TIME,LAT,LON,ALT,SSID,MAC,frequncy,signal);
		assertTrue("full data",Wifi.correct(w.getTime(), w.getID(), w.getLAT(), w.getLON(), w.getALT(), w.getSSID(), w.getMAC(), w.getFrequncy(), w.getSignal()));
	}
	
	//the data of the wifi's point is incomplete. 
	@Test (timeout=0)
	public void test2() {
		Wifi w2 = new Wifi(ID,TIME,LAT,LON,ALT,SSID,"",frequncy,signal);
		assertFalse("missing data. 'MAC' has no value", Wifi.correct(w2.getTime(), w2.getID(), w2.getLAT(), w2.getLON(), w2.getALT(), w2.getSSID(), w2.getMAC(), w2.getFrequncy(), w2.getSignal()));
	}
	
	//the data of the wifi's point is incomplete. 
	@Test (timeout=0)
	public void test3() {
		Wifi w3 = new Wifi(ID,TIME,LAT,LON,ALT,SSID,"null",frequncy,signal);
		assertFalse("missing data. 'MAC' is null", Wifi.correct(w3.getTime(), w3.getID(), w3.getLAT(), w3.getLON(), w3.getALT(), w3.getSSID(), w3.getMAC(), w3.getFrequncy(), w3.getSignal()));
	}
	
	//the data of the wifi's signal is incorrect.
	@Test (timeout=0)
	public void test4() {
		Wifi w4 = new Wifi(ID,TIME,LAT,LON,ALT,SSID,MAC,frequncy,"-113");
		assertFalse("input incorrect. The value of signal is a mistake",Wifi.correct( w4.getTime(), w4.getID(), w4.getLAT(), w4.getLON(), w4.getALT(), w4.getSSID(), w4.getMAC(), w4.getFrequncy(), w4.getSignal()));
	}
	
	//the data of the wifi's LAT is incorrect.
	@Test (timeout=0)
	public void test5() {
		Wifi w5 = new Wifi(ID,TIME,"NJN",LON,ALT,SSID,MAC,frequncy,signal);
		assertFalse("input incorrect. we need to be able to convert to float the value of LAT",Wifi.correct(w5.getTime(), w5.getID(), w5.getLAT(), w5.getLON(), w5.getALT(), w5.getSSID(), w5.getMAC(), w5.getFrequncy(), w5.getSignal()));
	}
	
	//the data of the wifi's LON is incorrect.
	@Test (timeout=0)
	public void test6() {
		Wifi w6 = new Wifi(ID,TIME,LAT,"SBG",ALT,SSID,MAC,frequncy,signal);
		assertFalse("input incorrect. we need to be able to convert to float the value of LON",Wifi.correct(w6.getTime(), w6.getID(), w6.getLAT(), w6.getLON(), w6.getALT(), w6.getSSID(), w6.getMAC(), w6.getFrequncy(), w6.getSignal()));
	}
	
	//the data of the wifi's date is incorrect.
	@Test (timeout=0)
	public void test7() {
		Wifi w7 = new Wifi(ID,"1970-9-9 12:54",LAT,"SBG",ALT,SSID,MAC,frequncy,signal);
		assertFalse("input incorrect. the year is 1970, and we are now in 2017",Wifi.correct(w7.getTime(), w7.getID(), w7.getLAT(), w7.getLON(), w7.getALT(), w7.getSSID(), w7.getMAC(), w7.getFrequncy(), w7.getSignal()));
	}
	
	//the "NumberFormatException" is the correct exception when we can't convert string to number's format.
	//@Test
	/*public void test8() {
			try{
			String frequncy="abc";
			int freq=Integer.parseInt(frequncy);
			fail("it should cause 'NumberFormatException'");
			}
		    catch(NumberFormatException e){
		       	assertTrue(true);
		
		}
		}*/
			
}
