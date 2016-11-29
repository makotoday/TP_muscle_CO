package controles;

import java.util.Random;

public class CarrefourT extends JonctionCarrefour {
	
	private Segment[] segmentsT;
	/* segmentsT :
	 * indice 0 pour segment gauche
	 * indice 1 pour segment droit
	 * indice 2 pour segment milieu
	 */
	public CarrefourT()
	{
		segmentsT = new Segment[3];
		
	}
	
	
	@Override
	public void placerVoitures(int nbDeplacement) {
		
		for(Voiture v : this.voitureAttente)
		{
			Segment segActuel = v.getPositionVoiture().getSegmentActuel();
			int i;
			for( i=0;i<3;i++)
			{
				if(segmentsT[i]==segActuel)
				{
					int alea = aleaSaufI(i);
					//On cherche dans quel sens le segment connecte la jonction
					v.getPositionVoiture().setSegmentActuel(segmentsT[alea]);
					if(segmentsT[alea].getJonctionGauche()==this)
					{
						v.getPositionVoiture().setPositionActuelle(nbDeplacement);
					}else{
						v.getPositionVoiture().setPositionActuelle(segmentsT[i].getLongueur()-nbDeplacement);
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
