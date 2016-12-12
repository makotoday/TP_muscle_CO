package controles;

public abstract class Semaphore 
{
	protected int etatSemaphore; //-1 pour rouge/stop; 0 pour orange; 1 pour vert/passer
	protected Segment sonSegment;
    
	public Semaphore()
	{
		etatSemaphore = -1;
	}
	
	void adaptationVoiture(Voiture v)
	{
		
		if (etatSemaphore==0)
		{
			v.setVitesseActuelle(v.getVitesseActuelle() / 2);
		}
	}
	
	public int getEtatSemaphore()
	{
		return etatSemaphore;
	}

	public void setSegment(Segment seg)
	{
		this.sonSegment = seg;
	}
	
	public abstract void setEtatSemaphore(int e) throws ErreurSemaphore;
	
	public abstract void changementEtat();
}
