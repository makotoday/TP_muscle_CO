package controles;

import java.util.ArrayList;
import java.util.Random;

import controles.Position.SensDep;

public class ReseauRoutier {

	private ArrayList<Segment> listeSegment;
	private ArrayList<Voiture> listeVoiture;
	private ArrayList<Jonction> listeJonction;
	
	public void initReseauRoutier()
	{
		/*definition des jonctions, au total 9*/
		CarrefourXvoies croix = new CarrefourXvoies();
		listeJonction.add(croix);
		CarrefourT[] lesT = new CarrefourT[2];	
		for(int i =0 ;i<2;i++) 
		{
			lesT[i] = new CarrefourT();
			listeJonction.add(lesT[i]);
		}
		
		JonctionSimple[] lesSimples = new JonctionSimple[4];
		for(int i =0 ;i<4;i++) 
		{lesSimples[i] = new JonctionSimple();
				listeJonction.add(lesSimples[i]);
			}
		
		JonctionBarriere[] barrieres = new JonctionBarriere[2];	
		barrieres[0] = new JonctionBarriere(); listeJonction.add(barrieres[0]);
		barrieres[1] = new JonctionBarriere(); listeJonction.add(barrieres[1]);
		
		/*definition des semaphores, au total 10 */
		SemaphoreFeuTricolore[] lesTricolores = new SemaphoreFeuTricolore[4];
		SemaphoreFeuBicolore[]  lesBicolores = new SemaphoreFeuBicolore[3];
		SemaphoreStop[] lesStop = new SemaphoreStop[3];

		
		try {
			listeSegment.add(new Segment(100,null,null,listeJonction.get(7),listeJonction.get(1)));
			listeSegment.add(new Segment(200,lesStop[0],lesBicolores[0],listeJonction.get(1),listeJonction.get(2)));
			listeSegment.add(new Segment(70,null,null,listeJonction.get(2),listeJonction.get(3)));
			listeSegment.add(new Segment(80,null,null,listeJonction.get(3),listeJonction.get(8)));
			listeSegment.add(new Segment(120,lesStop[1],null,listeJonction.get(1),listeJonction.get(4)));
			listeSegment.add(new Segment(140,null,lesTricolores[0],listeJonction.get(4),listeJonction.get(0)));
			listeSegment.add(new Segment(100,lesBicolores[1],lesTricolores[1],listeJonction.get(2),listeJonction.get(0)));
			listeSegment.add(new Segment(220,lesTricolores[3],null,listeJonction.get(0),listeJonction.get(6)));
			listeSegment.add(new Segment(200,lesTricolores[0],null,listeJonction.get(0),listeJonction.get(6)));
		} catch (ErreurSegment e) {
		}
		//creation de 4 voitures placé aleatoirement
		for(int i=0;i<4;i++){
			Voiture v = new Voiture(i+1,(i+1)*15,createPositionAlea());
			listeVoiture.add(v);
			v.setVitesseActuelle(v.getVitesseMaxVoiture());
		}
		
	}
	
	private Position createPositionAlea()
	{
		Random rand = new Random();
		Segment segment = this.listeSegment.get(rand.nextInt(this.listeSegment.size()-1));
		int position = rand.nextInt(segment.getLongueurSegment());
		int sens  = rand.nextInt(2);
		if(sens==1) return new Position(segment,position,SensDep.Droite);
		else return new Position(segment,position,SensDep.Gauche);
	}
	
	public static void main(String agr[]){
		ReseauRoutier res = new ReseauRoutier();
		res.initReseauRoutier();
		
	}
}
	
 