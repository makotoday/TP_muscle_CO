package controles;

import java.util.ArrayList;

public class CarrefourXvoies extends JonctionCarrefour {
	
	private ArrayList<Segment> listeSegmentCarrefour;

	@Override
	public void placerVoitures(int nbDeplacement) {

		for(Voiture v : this.voitureAttente)
		{
			Segment segActuel = v.getPositionVoiture().getSegmentActuel();
			int i;
			for( i=0;i<listeSegmentCarrefour.size();i++)
			{
				if(this.listeSegmentCarrefour.get(i)==segActuel)
				{
					int alea = aleaSaufI(i);
					//On cherche dans quel sens le segment connecte la jonction
					v.getPositionVoiture().setSegmentActuel(this.listeSegmentCarrefour.get(alea));
					if(this.listeSegmentCarrefour.get(i).getJonctionGauche()==this)
					{
						v.getPositionVoiture().setPositionActuelle(nbDeplacement);
					}else{
						v.getPositionVoiture().setPositionActuelle(this.listeSegmentCarrefour.get(i).getLongueur()-nbDeplacement);
					}
					break;
				}
			}	
			if(i==3) {
				System.out.println("erreur de coherence dans les segments");
				return;
			}
		}	
	}

}
