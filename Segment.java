package controles;

import java.util.ArrayList;

import controles.CapteurPresence;
import controles.CapteurVitesse;

public class Segment {
	
	private int longueur;// longueur du segement 
	private Semaphore semaphoreDroit;
	private Semaphore semaphoreGauche;
	private Jonction JonctionGauche;//le segment est connecté forcément à 2 jonctions. 
	private Jonction JonctionDroite;
	private ArrayList<CapteurVitesse> listeCapteurVitesse;
	private ArrayList<CapteurPresence> listeCapteurPresence;
	
	public Segment(int longueur)
	{
		this.longueur = longueur;
	}
	
	public Semaphore getSemaphoreDroit() {
		return semaphoreDroit;
	}

	public Semaphore getSemaphoreGauche() {
		return semaphoreGauche;
	}

	public int getLongueur() {
		return longueur;
	}

	public Jonction getJonctionGauche() {
		return JonctionGauche;
	}


	public Jonction getJonctionDroite() {
		return JonctionDroite;
	}
	

}
