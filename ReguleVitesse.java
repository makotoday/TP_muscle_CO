package controles;

import controles.Position.SensDep;

/**
 * la classe sert à reguler  la vitesse  dans circulation 
 * en se basant sur le capteur  de vitesse 
 */
public class ReguleVitesse extends ElementRegulation {

	private int limite; 
	/**
	 *Constructeur, construisant l'objet et mettant la limite à 30 
	 */
	public ReguleVitesse(){
		super();
		limite=30; 
	}
	
	public ReguleVitesse(int limite_vitesse){
		super(); 
		limite=limite_vitesse; 
	}
	
	
	public void Regule(){
		
		int tailej=listCarrefour.size(); 
		for(int i=0; i<tailej;i++){
			AppliqueLimite(i); 
		}
	}
	
	private void AppliqueLimite(int index){
		
		JonctionCarrefour tmp=listCarrefour.get(index); 
		int taille=tmp.listeSegmentCarrefour.size();
		for(int i=0; i<taille;i++){
			ModifieSemaphore(tmp.getSegment(i)); 
		}
		
	}



	private void ModifieSemaphore(Segment seg){
		boolean Continue=true; 
		for(CapteurVitesse capt : seg.getListeCapteurVitesse()){
			if(Continue==true){
				
				for(Voiture voit : seg.getListeVoiture()){
					if(true==capt.VoiturePasse(voit.getPositionVoiture().getPositionActuelle(), voit.getPositionVoiture().getSensDeplacement(), voit.getIdVoiture())){
						if(capt.CalculVitesse_id(voit.getIdVoiture())>limite){
							Ralentir(seg,capt.getCoteCapteur());
							Continue=false; 
							break; 
						}
					}
				}
				
				
				
			}else break; 
			
		}
	}

	/**
	 * La methode met le  semaphore en mode arreter, afin  d'arreter la  circulation 
	 */
	private void Ralentir(Segment seg, SensDep sens){
		if(sens==SensDep.Droite){
			if(seg.getSemaphoreDroit().getEtatSemaphore()!=-1)seg.getSemaphoreDroit().changementEtat(); 
		}
		if(sens==SensDep.Gauche){
			if(seg.getSemaphoreGauche().getEtatSemaphore()!=-1)seg.getSemaphoreGauche().changementEtat(); 
		}
	}


}
