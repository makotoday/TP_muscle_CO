package controles;

import controles.Position.SensDep;

public class Voiture 
{
	private int idVoiture;
	private int longueurVoiture;
	private int vitesseMaxVoiture;
	private int vitesseActuelle;
	private Position positionVoiture;
	
	
	public Voiture(int id, int vmax, Position pos )
	{
		this.idVoiture = id;
		this.longueurVoiture = 1;
		this.vitesseActuelle = 0;//initialement à l'arret
		this.vitesseMaxVoiture = vmax;
		
	}
	
	public void deplacement()
	{
		Semaphore sem;
		Segment sonSegment = this.positionVoiture.getSegmentActuel();
		SensDep sonSens = this.positionVoiture.getSensDeplacement();
		Jonction saJonction;
		if(sonSens==SensDep.Gauche)
		{
			sem = sonSegment.getSemaphoreGauche();
			saJonction = sonSegment.getJonctionGauche();
		}
		else
		{
			sem = sonSegment.getSemaphoreDroit();
			saJonction = sonSegment.getJonctionDroite();
		}

		sem.adaptationVoiture(this);//actualise la vitesse de la voiture en fonction de l'état de la sémaphore
		int nbdeplacrest = this.vitesseActuelle;//nombre de déplacement restant
			if(sonSens == SensDep.Gauche )
			{
				if(this.vitesseActuelle>this.positionVoiture.getPositionActuelle())
				{
					this.positionVoiture.setPositionActuelle(positionVoiture.getPositionActuelle()-vitesseActuelle);
					
				}else if(sem.getEtatSemaphore()!=-1){
					nbdeplacrest = nbdeplacrest - this.positionVoiture.getPositionActuelle()-1;
					sonSegment.getJonctionGauche().addVoitureAttente(this);//la voiture passe la jonction
					if(nbdeplacrest>0)sonSegment.getJonctionGauche().placerVoitures(nbdeplacrest);//la voiture essaye de passer la jonction
				}
			}else if(sonSens == SensDep.Droite)
			{
				if(this.vitesseActuelle<sonSegment.getLongueurSegment()-this.positionVoiture.getPositionActuelle())
				{
					this.positionVoiture.setPositionActuelle(positionVoiture.getPositionActuelle()+vitesseActuelle);
				}else if(sem.getEtatSemaphore()!=-1){
						nbdeplacrest = nbdeplacrest -this.positionVoiture.getPositionActuelle() -1;
						sonSegment.getJonctionGauche().addVoitureAttente(this);
						if(nbdeplacrest>0)sonSegment.getJonctionGauche().placerVoitures(nbdeplacrest);	
					}
			}
	}
	
	public Position getPositionVoiture() {
		return positionVoiture;
	}

	public void setVitesseActuelle(int vitesseActuelle) {
		this.vitesseActuelle = vitesseActuelle;
	}

	public int getIdVoiture() {
		return idVoiture;
	}

	public int getVitesseActuelle() {
		return this.vitesseActuelle;
	}

	public int getVitesseMaxVoiture() {
		return vitesseMaxVoiture;
	}
}
