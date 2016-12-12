package controles;

import java.util.ArrayList;
import java.util.Random;

public abstract class JonctionCarrefour extends Jonction {
	
protected ArrayList<Segment> listeSegmentCarrefour; 
	
	
	JonctionCarrefour(){
		super(); 
		listeSegmentCarrefour=new ArrayList<Segment>(); 
	}

	public boolean AddSegment(Segment segment){
		
		listeSegmentCarrefour.add(segment); 
		return true; 
	}
	
	public Segment getSegment(int index){
		return listeSegmentCarrefour.get(index); 
	}
	
	protected int aleaSaufI(int i)
	{
		Random rand = new Random();
		int numsegment;
		do{
		numsegment = rand.nextInt(3);//renvoie un nombre aleatoire dans [0, 2]
		}while(i==numsegment);
		return numsegment;
	}

}
