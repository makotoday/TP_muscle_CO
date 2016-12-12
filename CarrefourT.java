package simulateur;

public class CarrefourT extends JonctionCarrefour {
	
	private Segment segmentDroit;
	private Segment segmentGauche;
	private Segment segmentMilieu;
	
	public CarrefourT()
		{super();}
	
	public Segment getSegmentDroit() {
		return segmentDroit;
	}
	public void setSegmentDroit(Segment segmentDroit) {
		this.segmentDroit = segmentDroit;
	}
	public Segment getSegmentGauche() {
		return segmentGauche;
	}
	public void setSegmentGauche(Segment segmentGauche) {
		this.segmentGauche = segmentGauche;
	}
	public Segment getSegmentMilieu() {
		return segmentMilieu;
	}
	public void setSegmentMilieu(Segment segmentMilieu) {
		this.segmentMilieu = segmentMilieu;
	}
	
	

}
