package gridPuzzle;

public class Block<ActionT> {

	private final int xcoord;
	private final int ycoord;
	private final ActionT action;
	
	
	public Block(int xcoord, int ycoord, ActionT action){
		this.action = action;
		this.xcoord = xcoord;
		this.ycoord = ycoord;
	}
	
	public int xcoord(){
		return xcoord;
	}
	
	public int ycoord(){
		return ycoord;
	}
	
	public ActionT action() {
		return action;
	}

	
	
}
