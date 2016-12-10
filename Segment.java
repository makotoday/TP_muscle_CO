package simulateur;

import java.util.ArrayList;

import controles.CapteurPresence;
import controles.CapteurVitesse;

public class Segment 
{
	private Semaphore semaphoreDroit;
	private Semaphore semaphoreGauche;
	private ArrayList<CapteurVitesse> listeCapteurVitesse;
	private ArrayList<CapteurPresence> listeCapteurPresence;
	private ArrayList<Voiture> listeVoiture;
	
	public Segment(Semaphore sd, Semaphore sg)
	{
		semaphoreDroit=sd;
		semaphoreGauche=sg;
		listeCapteurVitesse = new ArrayList<CapteurVitesse>();
		listeCapteurPresence = new ArrayList<CapteurPresence>();
		listeVoiture = new ArrayList<Voiture>();
	}
	
	public Semaphore getSemaphoreDroit() {
		return semaphoreDroit;
	}

	public void setSemaphoreDroit(Semaphore semaphoreDroit) {
		this.semaphoreDroit = semaphoreDroit;
	}

	public Semaphore getSemaphoreGauche() {
		return semaphoreGauche;
	}

	public void setSemaphoreGauche(Semaphore semaphoreGauche) {
		this.semaphoreGauche = semaphoreGauche;
	}

	public ArrayList<CapteurVitesse> getListeCapteurVitesse() {
		return listeCapteurVitesse;
	}

	public ArrayList<CapteurPresence> getListeCapteurPresence() {
		return listeCapteurPresence;
	}

	public ArrayList<Voiture> getListeVoiture() {
		return listeVoiture;
	}

	public void ajouterVoitureSurSegment(Voiture v)
	{
		this.listeVoiture.add(v);
	}
	
	public void ajouterCapteurPresenceSurSegment(CapteurPresence cp)
	{
		this.listeCapteurPresence.add(cp);
	}
	
	public void ajouterCapteurVitesseSurSegment(CapteurVitesse cv)
	{
		this.listeCapteurVitesse.add(cv);
	}
	
	
	

}
