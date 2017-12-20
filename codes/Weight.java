package matala001;

public class Weight {
	
	//class with data of weight and GPS. the weight symbolize the similarity to other data. 
	
	private double LAT;
	private double LON;
	private double ALT;
	private double W;
  
    Weight(double LAT,double LON,double ALT,double W){
    	this.LAT=LAT;
    	this.LON=LON;
    	this.ALT=ALT;
    	this.W=W;
        }
    
    Weight(Weight other){
    	this.LAT=other.LAT;
    	this.LON=other.LON;
    	this.ALT=other.ALT;
    	this.W=other.W;
       }

   public void setWeight(Weight other){
	   this.LAT=other.LAT;
       this.LON=other.LON;
       this.ALT=other.ALT;
       this.W=other.W;
       }
    
	public double getALT (){
	    return this.ALT;
    	}
	
	public double getLAT (){
		 return this.LAT;
	     }
	
	public double getLON (){
		 return this.LON;
	    }
	
	public double getW (){
	    return this.W;
	    }
	
	public String toString (){
		   return "W: "+this.W+" LAT: "+this.LAT+" LON: "+this.LON+" ALT: "+ this.ALT;
		}
}
