package controles;

public class ErreurSegment extends Exception {
	public ErreurSegment() {
		super();
	}
	
	public ErreurSegment(String msg) 
	{
		super(msg);
	}
}
