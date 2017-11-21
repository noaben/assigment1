package munche;



/**
 * The purpose of this class is to test the Wifi's class
 * @author NoaHadad
 * 
 *
 */

public class WifiTest {

		// TODO Auto-generated method stub

		String TIME="2017-7-7 16:51";
		String LAT="32.33333";
		String LON="35.33333";
		String ID="oppo_df_3";
		String ALT="45";
		String SSID="Arielu";
		String MAC="6.6.6";
		String frequncy="10";
		String signal="-50";



		Wifi w = new Wifi(ID,TIME,LAT,LON,ALT,SSID,MAC,frequncy,signal);
		Wifi w2 = new Wifi(ID,TIME,"null",LON,ALT,SSID,MAC,frequncy,signal);
		Wifi w3 = new Wifi(ID,TIME,LAT,"null",ALT,SSID,MAC,frequncy,signal);
		Wifi w4 = new Wifi(ID,TIME,LAT,LON,ALT,SSID,MAC,frequncy,"-113");

		public void test1() {
			assertTrue(Wifi.correct(w.getTime(), w.getID(), w.getLAT(), w.getLON(), w.getALT(), w.getSSID(), w.getMAC(), w.getFrequncy(), w.getSignal());
		}
		boolean ok=Wifi.correct(w.getTime(), w.getID(), w.getLAT(), w.getLON(), w.getALT(), w.getSSID(), w.getMAC(), w.getFrequncy(), w.getSignal());
		System.out.println(ok); 
		System.out.println(w.getCoordinates());

		ok=Wifi.correct(w2.getTime(), w2.getID(), w2.getLAT(), w2.getLON(), w2.getALT(), w2.getSSID(), w2.getMAC(), w2.getFrequncy(), w2.getSignal());
		System.out.println(ok); 
		System.out.println(w2.getCoordinates());

		ok=Wifi.correct(w3.getTime(), w3.getID(), w3.getLAT(), w3.getLON(), w3.getALT(), w3.getSSID(), w3.getMAC(), w3.getFrequncy(), w3.getSignal());
		System.out.println(ok); 
		System.out.println(w2.getCoordinates());
		
		ok=Wifi.correct(w4.getTime(), w4.getID(), w4.getLAT(), w4.getLON(), w4.getALT(), w4.getSSID(), w4.getMAC(), w4.getFrequncy(), w4.getSignal());
		System.out.println(ok); 
		System.out.println(w3.getCoordinates());


	}


