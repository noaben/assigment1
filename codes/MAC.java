package matala001;

public class MAC {
	
	//class with data of MAC and GPS
	
	
	private String ADRESS;
	private double LAT;
	private double LON;
	private double ALT;
	
	public MAC (){
		this.ADRESS ="0";
		this.LAT =0;
		this.LON =0;
		this.ALT =0;
	}

	public MAC (String ADRESS,double LAT, double LON, double ALT){
		this.ADRESS =ADRESS;
		this.LAT =LAT;
		this.LON =LON;
		this.ALT =ALT;
	}

	
	public boolean equals(MAC other){
		return this.ADRESS.equals(other.ADRESS) && this.LAT==other.LAT && this.LON==other.LON && this.ALT==other.ALT;
	}
	public void setMAC (String ADRESS){
	    this.ADRESS =ADRESS;
	}
	
	public void setLAT (double LAT){
	    this.LAT =LAT;
	}
	
	public void setLON (double LON){
	    this.LON =LON;
	}
	
	public void setALT (double ALT){
	    this.ALT =ALT;
	}
	public String getMAC (){
	    return getMAC ();
	}
	
	public double getLAT (){
		 return this.LAT;
	}
	
	public double getLON (){
		 return this.LON;
	}
	
	public double getALT (){
		 return this.ALT;
	}
	
	public String toString (){
	   return "MAC: "+ADRESS+" LAT: "+LAT+" LON: "+LON+" ALT: "+ ALT;
	}
	

}
