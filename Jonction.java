package controles;

import java.util.ArrayList;

public abstract class Jonction {
	
	protected int longueurJonction = 1;
	protected ArrayList<Voiture> voitureAttente;
	protected ArrayList<Semaphore> listeSemaphore;
	protected int indiceSegment = 0; //aide à initialiser les segments
	
	Jonction()
	{
		
	}
	
	/*selon le type de jonctions, va replacer les voitures sur des segments aleatoire avec des position
	 * correspondant au nombre d'unité de déplacement restant
	 */
	public abstract void placerVoitures(int nbDeplacement);
	
	public void addVoitureAttente(Voiture v){
		voitureAttente.add(v);
	}
	
	public abstract void addSegment(Segment seg);
	
}
