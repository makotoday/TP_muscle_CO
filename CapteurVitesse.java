package controles;

import java.util.ArrayList;

import controles.Position.SensDep;


public class CapteurVitesse implements Capteur {

	private int position; 
	private boolean info; 
	private int tempscourant; 
	private int long_segment; 
	private SensDep sens;
	private double vitesse; 
	private ArrayList<CalculatorV> vitesse_v; 
	
	public CapteurVitesse(){
		info=false; 
		tempscourant=0; 
		position=0; 
		vitesse_v=new ArrayList<CalculatorV>();
		
	}
	public CapteurVitesse(int position_capt, SensDep lesens){
		position=position_capt; 
		sens=lesens; 
		info=false; 
		tempscourant=0; 
		vitesse_v=new ArrayList<CalculatorV>(); 
	}
	
	public void setCoteCapteur(SensDep senscapt) {sens=senscapt; }
	public void setLongeurSegment(int long_segt) {long_segment=long_segt; }
	public int  getTemps() {return tempscourant; }
	public void setTemps(int temps) {tempscourant=temps; }
	public void setPosition(int posit_capt) {position=posit_capt; }
	public int  getPositionCapteur(){return new Integer(position); }
	
	
	public void AvanceTemps(){
		tempscourant++; 
	}
	
	public boolean VoiturePasse(int voiture_position, SensDep lesens,int id_voiture){
		if(voiture_position>=position && lesens==sens){
			 
			if(Contient(id_voiture)==true){
				System.out.print("passage par la methode Contient  \n"); 
				if(getCalculator(id_voiture).getT1()!=0){
					System.out.print("passage dans le cote false \n"); 
					info=false; 
					return false; 
				}else{
					getCalculator(id_voiture).setDatePassage(tempscourant); 
					System.out.print("passage dans le cote true  \n"); 
					info=true; 
					return true; 
				}
			}
		}
		info=false; 
		return false; 
	}
	
	public boolean EnvoieInfo(){
		return info; 
	}
	
	/**
	 * La méthode permet de verifier que dans la liste l'element est bien existant 
	 * @param id_voiture
	 * @param index
	 * @return
	 */
	private boolean Contient(int id_voiture){
		for (CalculatorV tmp : vitesse_v){
			if(tmp.getIdentVoiture()==id_voiture)return true; 
			
		}
		return false; 
	}
	
	public  CalculatorV getCalculator(int id_voiture){
		for (CalculatorV tmp : vitesse_v){
			if(tmp.getIdentVoiture()==id_voiture)return tmp;  
		}
		
		return null; 
	}
	
	
	
	
/**
 * Ajoute un CalculatorV  à la liste des calulatorV  
 * @param calculator
 */

	public void addCalcultor(CalculatorV calculator){
		vitesse_v.add(calculator); 
	}

	public static void main(String agr[]){
		CapteurVitesse cap; 
		cap=new CapteurVitesse(20,SensDep.Droite ); 
		cap.addCalcultor(new CalculatorV(2,1));
		cap.addCalcultor(new CalculatorV(4,2)); 
		cap.addCalcultor(new CalculatorV(1,3));
		cap.AvanceTemps(); 
		int p_v=10; 
		int p_v1=5; 
		int p_v2=2; 
		while(cap.getTemps()!=10){
			
			System.out.print("test 1 \n"); 
			System.out.print(cap.VoiturePasse(p_v, SensDep.Droite, 1)+"\n");
			System.out.print(cap.VoiturePasse(p_v1, SensDep.Droite, 2)+"\n"); 
			System.out.print(cap.VoiturePasse(p_v2, SensDep.Droite, 3)+"\n"); 
			
			if(cap.EnvoieInfo()==true){
				//for (CalculatorV tmp: cap.vitesse_v){
					//if(tmp.getT1()!=0)System.out.print(tmp+"     vitesse : "+tmp.VitesseVoiture(cap.position)+"\n");
					//else System.out.print("Pas de  Presence  de voiture pour "+tmp+ "\n"); 
				//}
			}else System.out.print("Le capteur n'envoie pas d'information \n"); 
			System.out.print("Id voiture : 1"+"  position : "+p_v+"\n"); 
			System.out.print("Id voiture : 2"+"  position : "+p_v1+"\n");
			System.out.print("Id voiture : 3"+"  position : "+p_v2+"\n"); 
			cap.AvanceTemps(); 
			p_v=p_v+5; 
			p_v1=p_v1+5; 
			p_v2=p_v2+5;
			System.out.print("------------------------------------------------------------------------------------------------------------------------\n"); 
		}
		
		 
		
	}

	public double CalculVitesse(int index){ return vitesse_v.get(index).VitesseVoiture(position);}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + long_segment;
		result = prime * result + position;
		result = prime * result + ((sens == null) ? 0 : sens.hashCode());
		result = prime * result
				+ ((vitesse_v == null) ? 0 : vitesse_v.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CapteurVitesse other = (CapteurVitesse) obj;
		if (long_segment != other.long_segment)
			return false;
		if (position != other.position)
			return false;
		if (sens != other.sens)
			return false;
		if (vitesse_v == null) {
			if (other.vitesse_v != null)
				return false;
		} else if (!vitesse_v.equals(other.vitesse_v))
			return false;
		return true;
	}
	
	
	
}
