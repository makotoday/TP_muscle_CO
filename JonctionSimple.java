package controles;

public class JonctionSimple extends Jonction {
	
	private Segment segmentDroit;//exactement 2 segments
	private Segment segmentGauche;
		
	public JonctionSimple()
	{
		
	}

	@Override
	public void placerVoitures(int nbDeplacement) {
		Segment segmentVoiture;
		for(Voiture v : voitureAttente)
		{
			segmentVoiture = v.getPositionVoiture().getSegmentActuel();
			if(segmentVoiture==segmentDroit)
			{
				v.getPositionVoiture().setSegmentActuel(segmentGauche);
				//ce qui reste � parcourir pendant l'unit� de temps � la voiture sur le nouveau segment :
				v.getPositionVoiture().setPositionActuelle(segmentGauche.getLongueur()-nbDeplacement);
			}else if(segmentVoiture==segmentGauche)
			{
				v.getPositionVoiture().setSegmentActuel(segmentDroit);
				v.getPositionVoiture().setPositionActuelle(nbDeplacement);
			}else{
				System.out.println("erreur de coherence des segments");
				return;
			}
		}
		
	}

}
