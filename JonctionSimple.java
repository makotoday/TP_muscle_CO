package simulateur;

public class JonctionSimple extends Jonction {
	
	private Segment segmentDroit;//exactement 2 segments
	private Segment segmentGauche;
		
	public JonctionSimple()
	{	}
	

	public Segment getSegmentDroit() {
		return segmentDroit;
	}

	public void setSegmentDroit(Segment segmentDroit) {
		this.segmentDroit = segmentDroit;
	}

	public Segment getSegmentGauche() {
		return segmentGauche;
	}

	public void setSegmentGauche(Segment segmentGauche) {
		this.segmentGauche = segmentGauche;
	}

	@Override
	public void placerVoitures(int nbDeplacement) {
		Segment segmentVoiture;
		for(Voiture v : voitureAttente)
		{
			segmentVoiture = v.getPositionVoiture().getSegmentActuel();
			if(segmentVoiture==segmentDroit)
			{
				v.getPositionVoiture().getSegmentActuel().retirerVoitureSurSegment(v); //On retire la voiture de la liste de voiture presente sur le segment
				v.getPositionVoiture().setSegmentActuel(segmentGauche);
				v.getPositionVoiture().getSegmentActuel().ajouterVoitureSurSegment(v); // on l'ajoute dans la liste des voitures présentes sur le nouveau segment
				//ce qui reste à parcourir pendant l'unité de temps à la voiture sur le nouveau segment :
				v.getPositionVoiture().setPositionActuelle(segmentGauche.getLongueurSegment()-nbDeplacement);
			}
			else if(segmentVoiture==segmentGauche)
			{
				v.getPositionVoiture().getSegmentActuel().retirerVoitureSurSegment(v); //On retire la voiture de la liste de voiture presente sur le segment
				v.getPositionVoiture().setSegmentActuel(segmentDroit);
				v.getPositionVoiture().getSegmentActuel().ajouterVoitureSurSegment(v);// on l'ajoute dans la liste des voitures présentes sur le nouveau segment
				v.getPositionVoiture().setPositionActuelle(nbDeplacement);
			}else
			{
				System.out.println("erreur de coherence des segments");
			}
		}
		
	}

}