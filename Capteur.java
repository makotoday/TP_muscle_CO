package controles;

import controles.Position.SensDep;

public interface Capteur {

	/**
	 * méthode fait avance le temps  qui s'écoule pur le capteur d'une unité de temps 
	 */
	public void AvanceTemps();
	/**
	 * la méthode prend la position de la voiture et verifie si elle se trouve au niveau 
	 * du capteur 
	 * si oui elle retourne false, sinon true 
	 * @param voiture_position
	 * @return
	 */
	public boolean VoiturePasse(int voiture_position, SensDep lesens, int id_voiture); 
	/**
	 * signale  s'il  y a une information à envoyer . 
	 * @return
	 */
	public boolean EnvoieInfo(); 
	
	
}
