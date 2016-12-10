package simulateur;

import java.util.ArrayList;

public class Segment 
{
	private int longueurSegment;
	private Semaphore semaphoreDroit;
	private Semaphore semaphoreGauche;
	private ArrayList<CapteurVitesse> listeCapteurVitesse;
	private ArrayList<CapteurPresence> listeCapteurPresence;
	private ArrayList<Voiture> listeVoiture;
	
	public Segment(int l, Semaphore sd, Semaphore sg) throws ErreurSegment
	{
		if(l<=0)
			throw new ErreurSegment("Longueur Segment invalide");
		longueurSegment=l;
		semaphoreDroit=sd;
		semaphoreGauche=sg;
		listeCapteurVitesse = new ArrayList<CapteurVitesse>();
		listeCapteurPresence = new ArrayList<CapteurPresence>();
		listeVoiture = new ArrayList<Voiture>();
	}
	
	public int getLongueurSegment()
	{
		return longueurSegment;
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
