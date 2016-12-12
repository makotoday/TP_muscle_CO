package controles;
import java.util.ArrayList;


public abstract class ElementRegulation {
	

	protected ArrayList<JonctionCarrefour> listCarrefour; 
	
	public ElementRegulation(){
		
		
		listCarrefour=new ArrayList<JonctionCarrefour>(); 
	}
	
	public ArrayList<JonctionCarrefour> getListCarrefour(){
		return listCarrefour; 
	}
	/**
	 * méthode qui applique  l'algorithme  de régulation qui sera  unique à chaque type 
	 * d'élèment de régulation
	 */
	 public abstract   void Regule(); 
	
	 public JonctionCarrefour getJonctionCarrefour(int index){
		 return listCarrefour.get(index); 
	 }
	
	 public void setJonctionCarrefour(JonctionCarrefour carrefour){
		
		 listCarrefour.add(carrefour); 
	 }
	 
}
