package controles;

public class JonctionBarriere extends Jonction {
	
	private Segment segmentFini;
	
	public JonctionBarriere()
	{
		
	}
	public void notifie(Voiture v)
	{
		System.out.println("la voiture Id"+v.getIdVoiture()+"essaye de traverser une barriere");
	}

	public void placerVoitures(int nbDeplacement) {
		for(Voiture v : this.voitureAttente)
		{
			notifie(v);
			v.setVitesseActuelle(0);//la voiture s'arrete a la barriere
			this.voitureAttente.remove(v);
		}
	}
}
