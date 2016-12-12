package controles;
import java.util.ArrayList;


public abstract class ElementRegulation {
	

	protected ArrayList<JonctionCarrefour> listCarrefour; 
	protected ArrayList<Segment> listSegment; 
	
	public ElementRegulation(){
		
		
		listCarrefour=new ArrayList<JonctionCarrefour>(); 
		listSegment= new ArrayList<Segment>(); 
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
	 
	public void getListSegment(ArrayList<Segment> seg){
		listSegment=seg; 
	}
	 
}
