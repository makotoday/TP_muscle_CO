package controles;

import java.util.ArrayList;

public abstract class Jonction {
	
	protected int longueurJonction = 1;
	protected ArrayList<Voiture> voitureAttente;
	protected ArrayList<Semaphore> listeSemaphore;
	protected int indiceSegment = 0; //aide � initialiser les segments
	
	Jonction()
	{
		voitureAttente=new ArrayList<Voiture>();
		listeSemaphore=new ArrayList<Semaphore>(); 
	}
	
	/*selon le type de jonctions, va replacer les voitures sur des segments aleatoire avec des position
	 * correspondant au nombre d'unit� de d�placement restant
	 */
	public abstract void placerVoitures(int nbDeplacement);
	
	public void addVoitureAttente(Voiture v){
		voitureAttente.add(v);
	}
	
	//public abstract void addSegment(Segment seg);
	/**
	 * Methode permettant de  supprimer une voiture de la liste  de 
	 * voiture 
	 * @param index
	 */
	public void RemoveVoitureAttent(int index){
		voitureAttente.remove(index); 
	}
	
	public Voiture getVoitureAttente(int index){
		return voitureAttente.get(index); 
	}
	
	
	
}
