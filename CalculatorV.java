package controles;

public class CalculatorV {
	private int to; // date  d'entrée  de la voiture dans le segment 
	private int t1; //date d'arrivée dans devant le capteur 
	private int id_voiture; // l'identifiateur de la voiture
	
	public CalculatorV(){
		to=0; 
		t1=0; 
	}
	
	public CalculatorV(int t0,int ident_voiture ){
		to=t0; 
		t1=0; 
		id_voiture=ident_voiture; 
	}
	
	public void setDatePassage(int date){
		t1=date; 
	}
	
	public double  VitesseVoiture(int distance){
		double result=distance/(t1-to); 
		return result;  
	}
	
	public int getIdentVoiture(){return new Integer(id_voiture);}
	
	public int getT1(){ return new Integer(t1);}
	
	@Override
	public String toString() {
		return "ID voiture : " + id_voiture + "\n";
	}
	
}
