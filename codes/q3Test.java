package munche;

import static org.junit.Assert.*;

import org.junit.Test;

public class q3Test {
	
	String data1="ID";
	String data2="TIME";
	String data3="PLACE";
	String data4="Alt";
	Wifi w = new Wifi("oppo_df_3","2017-7-7 16:51","32.33333","35.33333","45","Arielu","6.6.6","10","-50");
	String required1="noala";
	

	@Test
	public void test() {
		try{
		assertFalse(q3.fit(w,data1,required1));
	}

}
