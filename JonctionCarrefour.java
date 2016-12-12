package controles;

import java.util.ArrayList;
import java.util.Random;

public abstract class JonctionCarrefour extends Jonction {
	
	protected ArrayList<Segment> listeSegmentCarrefour;
	
	public JonctionCarrefour()
	{
		listeSegmentCarrefour = new ArrayList<Segment>();
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
	
	public abstract void addSegment(Segment seg);

	public Segment getSegment(int i) {
		return this.listeSegmentCarrefour.get(i);
	}

}
