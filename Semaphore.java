package controles;

public abstract class Semaphore 
{
	protected int etatSemaphore; //-1 pour rouge/stop; 0 pour orange; 1 pour vert/passer
	protected Segment sonSegment;
    
	public Semaphore()
	{
		etatSemaphore = -1;
	}
	
	void adaptationVoiture(Voiture v)//adaptation de la vitesse pour les feux
	{
		if (etatSemaphore==-1)
		{
			v.setVitesseActuelle(0);
		}
		
		if (etatSemaphore==0)
		{
			v.setVitesseActuelle(v.getVitesseActuelle() / 2);
		}
	}
	
	public int getEtatSemaphore()
	{
		return etatSemaphore;
	}

	public abstract void setEtatSemaphore(int e) throws ErreurSemaphore;
	
	public abstract void changementEtat();
}
