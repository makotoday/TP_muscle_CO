package controles;

import controles.Position.SensDep;

public class SemaphoreStop extends Semaphore 
{
	public SemaphoreStop()
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
    
	@Override void adaptationVoiture(Voiture v)
	{
		Position pos = v.getPositionVoiture(); 
		//Pour un stop, si la voiture est au bout du segment, elle peut repartir si elle était à l'arret sinon elle s'arrete
		if (v.getVitesseActuelle()==0&&((pos.getSensDeplacement()==SensDep.Gauche&&pos.getPositionActuelle()==0)
		||(pos.getSensDeplacement()==SensDep.Droite&&pos.getPositionActuelle()==pos.getSegmentActuel().getLongueurSegment())))
		{
				v.setVitesseActuelle(v.getVitesseMaxVoiture());
				this.etatSemaphore = 1;

		}else this.etatSemaphore = -1;
		
	}
	
	public void changementEtat()
	{
		
	}
	
}
