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
		if ((pos.getSensDeplacement()==SensDep.Gauche&&pos.getPositionActuelle()==0)
		||(pos.getSensDeplacement()==SensDep.Droite&&pos.getPositionActuelle()==pos.getSegmentActuel().getLongueurSegment()))
		{
			if(v.getVitesseActuelle()==0)
			{
				v.setVitesseActuelle(v.getVitesseMaxVoiture());
				this.etatSemaphore = 1;
			}
			else// la voiture s'arrete au stop
			{
				v.setVitesseActuelle(0);
				this.etatSemaphore = -1;
			}
		}else if(v.getVitesseActuelle()==0){
			v.setVitesseActuelle(v.getVitesseMaxVoiture());
		}
	
	}
	
	public void changementEtat()
	{
		//pas de changement d'état pour un stop
	}
	
}
