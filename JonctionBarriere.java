package simulateur;

public class JonctionBarriere extends Jonction {
	
	private Segment segmentFini;
	
	public JonctionBarriere()
	{	super(); 	}
	
	public void setSegment(Segment s)
	{
		segmentFini=s;
	}
	
	public Segment getSegmentFini()
	{
		return segmentFini;
	}
	
	public void notifie(Voiture v)
	{
		System.out.println("la voiture Id"+v.getIdVoiture()+"essaye de traverser une barriere");
	}

	public void placerVoitures(int nbDeplacement)  ///!!Changer le sens de deplacement!!!
	{
		for(Voiture v : this.voitureAttente)
		{
			notifie(v);
			v.setVitesseActuelle(0);//la voiture s'arrete a la barriere
			this.voitureAttente.remove(v);
		}
	}
}