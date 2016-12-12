package simulateur;

public class SemaphoreFeuBicolore extends Semaphore 
{
	public SemaphoreFeuBicolore()
	{
		super();
	}
	
	public void setEtatSemaphore(int e) throws ErreurSemaphore
	{
		if(e != -1 || e!=1)
			throw new ErreurSemaphore("Etat du Semaphore Invalide");
		else
			etatSemaphore=e;
	}
	
	public void changementEtat()
	{
		if(etatSemaphore == -1)
			etatSemaphore = 1;
		else if(etatSemaphore == 1)
			etatSemaphore = 0;
	}

}
