package controles;

import java.util.ArrayList;

public class Segment 
{
	private int longueurSegment;
	private Semaphore semaphoreDroit;
	private Semaphore semaphoreGauche;
	private Jonction jonctionDroite;
	private Jonction jonctionGauche;
	private ArrayList<CapteurVitesse> listeCapteurVitesse;
	private ArrayList<CapteurPresence> listeCapteurPresence;
	private ArrayList<Voiture> listeVoiture;
	
	public Segment(int l, Semaphore sg, Semaphore sd, Jonction jg, Jonction jd) throws ErreurSegment
	{
		if(l<=0)throw new ErreurSegment("Longueur Segment invalide");
		longueurSegment=l;
		jonctionDroite=jd;
		jonctionGauche=jg;
		jonctionDroite.addSegment(this);
		jonctionGauche.addSegment(this);
		if(sd!=null)
		{
			semaphoreDroit=sd;
			semaphoreDroit.setSegment(this);
			jonctionDroite.addSemaphore(semaphoreDroit);
		}
		if(sg!=null)
		{
			semaphoreGauche=sg;
			semaphoreGauche.setSegment(this);
			jonctionGauche.addSemaphore(semaphoreGauche);
		}
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

	public Jonction getJonctionDroite() {
		return jonctionDroite;
	}

	public void setJonctionDroite(Jonction jonctionDroite) {
		this.jonctionDroite = jonctionDroite;
	}

	public Jonction getJonctionGauche() {
		return jonctionGauche;
	}

	public void setJonctionGauche(Jonction jonctionGauche) {
		this.jonctionGauche = jonctionGauche;
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
	
	public void retirerVoitureSurSegment(Voiture v)
	{
		for (Voiture c : listeVoiture)
		{
			if(c.getIdVoiture() == v.getIdVoiture())
				listeVoiture.remove(v);
		}
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
