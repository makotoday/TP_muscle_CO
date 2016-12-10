package simulateur;

import java.util.Random;

public abstract class JonctionCarrefour extends Jonction 
{
	
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
