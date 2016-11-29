package controles;

public abstract class Semaphore {

	protected Segment segmentSemaphore; //Inutile si on garde sempahoreDroit/Gauche dans Segment
	protected int sensSemaphore; //Idem
	protected int couleurSemaphore; //-1 pour rouge/stop; 0 pour orange; 1 pour vert
	
}
