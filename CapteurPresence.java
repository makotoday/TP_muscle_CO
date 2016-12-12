package controles;

import java.util.ArrayList;

import controles.Position.SensDep;

public class CapteurPresence implements Capteur {

	private  int m_position; 
	private int tempscourant; 
	private boolean info; 
	private SensDep sens; 
	private ArrayList<Integer> id;//liste  de voiture dans la taille est sera limité à 10 
	
	public CapteurPresence(){
		m_position=0; 
		tempscourant=0; 
		info=false; 
		id=new ArrayList<Integer>(); 
		
		
	}
	public CapteurPresence(int position, SensDep lesens){
		m_position=position; 
		tempscourant=0; 
		info=false; 
		sens=lesens; 
		id=new ArrayList<Integer>(); 
		
	}
	
	public void AvanceTemps(){
		tempscourant++; 
	}
	/**
	 * 
	 */
	public boolean VoiturePasse(int voiture_position, SensDep sens_voiture, int id_voiture){
		if( voiture_position >= m_position && sens_voiture==sens){
			if(id.isEmpty()==true){
				id.add(id_voiture); 
				info=true; 
				return true; 
			}else {
				if(id.contains(id_voiture)==true){
					info=false; 
					return false; 
				}else{
					info=true; 
					id.add(id_voiture); 
					return true; 
				}
			}
		}else{
			info=false; 
			return false; 
		}
	}
	/**
	 * retourne  la variable d'etat Info qui est  un boolean, true  s'il a capté quelquechose sinon false;
	 * @return boolean  
	 */
	public  boolean EnvoieInfo(){
		return info; 
	}
	 /**
	  * modifie le cote du capteur sur le segment 
	  * @param senscapt
	  */
	public void setCoteCapteur(SensDep senscapt){
		sens=senscapt; 
	}
	
	
	
	public int  getTemps(){return tempscourant; }
	public void setTemps(int temps){tempscourant=temps; }
	
	public void ReInitList(){
		
		for(int index=0; index <id.size(); index++){
			id.remove(index); 
		}
	}
	public void ReInitInfo(){ info=false; }

	
	public static void main(String agr[]){
		
		CapteurPresence cap; 
		cap=new CapteurPresence(40,SensDep.Gauche); 
		int position_v=0; 
		int tab[]=new int[10];
		for(int i=0; i<10; i++){
			tab[i]=i+1; 
		}
		System.out.print("TEST 1 : \n"); 
		System.out.print(cap.VoiturePasse(20, SensDep.Gauche, tab[1])+"\n"); 
		System.out.print(cap.VoiturePasse(30, SensDep.Droite, tab[1])+"\n");
		System.out.print(cap.VoiturePasse(40, SensDep.Droite, tab[1])+"\n");
		
		System.out.print("TEST 2 : \n");
		System.out.print(cap.VoiturePasse(20, SensDep.Gauche, tab[2])+"\n"); 
		System.out.print(cap.VoiturePasse(41, SensDep.Gauche, tab[3])+"\n");
		System.out.print(cap.VoiturePasse(40, SensDep.Droite, tab[5])+"\n");
		cap.AvanceTemps(); 
		cap.AvanceTemps(); 
		System.out.print("le  tmeps courant : "+ cap.getTemps()+" unite \n");
		
	}
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + m_position;
		result = prime * result + ((sens == null) ? 0 : sens.hashCode());
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
		CapteurPresence other = (CapteurPresence) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (m_position != other.m_position)
			return false;
		if (sens != other.sens)
			return false;
		return true;
	}
	
	
	
	
}
 
