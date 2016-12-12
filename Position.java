package simulateur;

public class Position {

	private Segment segmentActuel;
	private int positionActuelle;// equivalent a la distance par rapport a l'extremite droite du segment
	
	public enum SensDep
	{
		Gauche("Gauche"),
		Droite("Droite");
		private String sens;
		private SensDep(String sens)
		{
			this.sens = sens;
		}
	}
	
	private SensDep sensDeplacement;// -1 vers la gauche (donc vers 0) 1 vers la droite (vers taillesegment)

	public Position(Segment segact,int dist,SensDep sens) throws ErreurSegment
	{
		if(segact.getLongueurSegment() > dist)
			throw new ErreurSegment("Erreur : voiture hors segment");
		else
			this.segmentActuel = segact;
			this.positionActuelle = dist;
			this.sensDeplacement = sens;
	}

	public Segment getSegmentActuel() {
		return segmentActuel;
	}

	public void setSegmentActuel(Segment segmentActuel) {
		this.segmentActuel = segmentActuel;
	}

	public int getPositionActuelle() {
		return positionActuelle;
	}

	public void setPositionActuelle(int positionActuelle) {
		this.positionActuelle = positionActuelle;
	}

	public SensDep getSensDeplacement() {
		return sensDeplacement;
	}

	public void setSensDeplacement(SensDep sensDeplacement) {
		this.sensDeplacement = sensDeplacement;
	}
	
}