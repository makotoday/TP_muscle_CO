package controles;

import java.util.Random;

public class CarrefourT extends JonctionCarrefour {

	
	@Override
	public void placerVoitures(int nbDeplacement) {
		
		for(Voiture v : this.voitureAttente)
		{
			Segment segActuel = v.getPositionVoiture().getSegmentActuel();
			int i;
			for( i=0;i<3;i++)
			{
				if(listeSegmentCarrefour.get(i)==segActuel)
				{
					int alea = aleaSaufI(i);
					//On cherche dans quel sens le segment connecte la jonction
					v.getPositionVoiture().setSegmentActuel(listeSegmentCarrefour.get(alea));
					if(listeSegmentCarrefour.get(alea).getJonctionGauche()==this)
					{
						v.getPositionVoiture().setPositionActuelle(nbDeplacement);
					}else{
						v.getPositionVoiture().setPositionActuelle(listeSegmentCarrefour.get(i).getLongueurSegment()-nbDeplacement);
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


	@Override
	public void addSegment(Segment seg) 
	{
		if(this.listeSegmentCarrefour.size()==3) 
		{
			System.out.println("erreur initialisation segment");
			return;
		}
		this.listeSegmentCarrefour.add(seg);
		indiceSegment++;
	}
	
	
}
