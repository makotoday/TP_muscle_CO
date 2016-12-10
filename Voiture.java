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
		this.vitesseActuelle = 0;//la voiture est intialement a l'arret
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
		if(this.vitesseActuelle==0)
		{
			this.vitesseActuelle = this.vitesseMaxVoiture;
			return;
		}
		sem.adaptationVoiture(this);//actualise la vitesse de la voiture en fonction de l'état de la sémaphore
		if(sem.getEtatSemaphore()<0)//la voiture sur le segment s'arrete
		{
			return;
		}
		else // changement de segment aleatoire avec les segments de la jonction
		{
			int nbdeplacrest = this.vitesseActuelle;//nombre de déplacement restant
			if(sonSens == SensDep.Gauche )
			{
				if(this.vitesseActuelle<=this.positionVoiture.getPositionActuelle())
				{
					this.positionVoiture.setPositionActuelle(positionVoiture.getPositionActuelle()-vitesseActuelle);
				}else{
					nbdeplacrest = nbdeplacrest -this.positionVoiture.getPositionActuelle() -1;
					sonSegment.getJonctionGauche().addVoitureAttente(this);//la voiture passe la jonction
					if(nbdeplacrest>0)sonSegment.getJonctionGauche().placerVoitures(nbdeplacrest);//la voiture essaye de passer la jonction
				}
			}else //vers la droite
			{
				if(this.vitesseActuelle>sonSegment.getLongueurSegment()-this.positionVoiture.getPositionActuelle())
				{
					this.positionVoiture.setPositionActuelle(positionVoiture.getPositionActuelle()-vitesseActuelle);
				}else{
					nbdeplacrest = nbdeplacrest -this.positionVoiture.getPositionActuelle() -1;
					sonSegment.getJonctionGauche().addVoitureAttente(this);//la voiture passe la jonction
					if(nbdeplacrest>0)sonSegment.getJonctionGauche().placerVoitures(nbdeplacrest);//la voiture essaye de passer la jonction
				}
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
}
