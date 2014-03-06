package gridPuzzle;

import java.util.ArrayList;
import java.util.Random;

public class GridPuzzle {

	
	public enum GridMove {
		UP(0, -1), DOWN(0, 1), LEFT(-1, 0), RIGHT(1, 0);
		
		private final int x_move;
		private final int y_move;
		
		private GridMove(int x, int y) {
			x_move = x;
			y_move = y;
		}
		
		/**
		 * Cached result of values such that copy isn't done every time.
		 */
		private static final GridMove[] VALUES = values();
		
		/**
		 * Count of values in list.
		 */
		private static final int SIZE = VALUES.length;
		
		/**
		 * RNG
		 */
		private static final Random RANDOM = new Random();
		
		/**
		 * Returns a move selected at random.
		 */
		public static GridMove randomMove() {
			int pick = (int) Math.max(
					Math.ceil(RANDOM.nextDouble() * SIZE) - 1, 0);
			
			return VALUES[pick];
		}
	}
	
	// Initialises the grid array.
	int[][] gridArray;
	
	// Initialises the height and width variables
	int height;
	int width;
	
	//Initialises where the agent is.
	int agent_x;
	int agent_y;
	
	//Initialises blocks array
	ArrayList<Block<GridMove>> blocks;
	
	/**
	 * Constructor
	 * @param x The width of the grid.
	 * @param y The height of the grid.
	 */
	public GridPuzzle(int height, int width, int agent_x, int agent_y) {
		this.height = height;
		this.width = width;
		gridArray = new int[width][height];
		
		this.agent_x = agent_x;
		this.agent_y = agent_y;
		initialiseBlocks();
	}
	
	/**
	 * Gets the current position.
	 * @return An array containing the both the robots x and y positions.
	 */
	public int[] getCurrentPos() {
		return new int[] {this.agent_x, this.agent_y};
	}
	
	/**
	 * Sets the current position.
	 */
	public void setCurrentPos(int x, int y) {
		this.agent_x = x;
		this.agent_y = y;
	}
	
	/**
	 * Applies a move to the robot.
	 * @param move The move to make.
	 */
	public void makeMove(GridMove move) {
		if(isValidMove(move)) {
			setCurrentPos(agent_x + move.x_move, agent_y + move.y_move);
		}
	}
	
	/**
	 * A grid puzzle with a random agent position.
	 * @param width The desired width of the grid puzzle.
	 * @param height The desired height of the grid puzzle.
	 * @return Returns a new grid puzzle with set width and height and a random agent position.
	 */
	public static GridPuzzle randomGridPuzzle(int width, int height) {
		Random RANDOM = new Random();
		int agent_x = RANDOM.nextInt(width);
		int agent_y = RANDOM.nextInt(height);
		
		return new GridPuzzle(width, height, agent_x, agent_y);
	}
	
	/**
	 * Where or not the move is valid. i.e. will it take the agent outside of the grid?
	 * @param move The move it is trying to make.
	 * @return Returns whether or not the move is valid.
	 */
	public boolean isValidMove(GridMove move) {
		int new_x = agent_x + move.x_move;
		int new_y = agent_y + move.y_move;
		
		if(new_x <= 0 || new_y <= 0) {
			return false;
		} else if(new_x > width || new_y > height) {
			return false;
		} else if(this.isBlocked(agent_x, agent_y, move)) {
			System.out.println("This path is blocked!");
			return false;
		}
		
		return true;
	}
	
	/**
	 * Initialises all the blocks on the grid.
	 */
	private void initialiseBlocks(){
		blocks = new ArrayList<Block<GridMove>>();
 
		blocks.add(new Block<GridMove>(2,1,GridMove.DOWN));
		blocks.add(new Block<GridMove>(3,1,GridMove.RIGHT));
		blocks.add(new Block<GridMove>(4,1,GridMove.LEFT));
		blocks.add(new Block<GridMove>(1,2,GridMove.DOWN));
		blocks.add(new Block<GridMove>(2,2,GridMove.UP));
		blocks.add(new Block<GridMove>(1,3,GridMove.UP));
		blocks.add(new Block<GridMove>(3,3,GridMove.RIGHT));
		blocks.add(new Block<GridMove>(4,3,GridMove.LEFT));
		blocks.add(new Block<GridMove>(4,3,GridMove.DOWN));
		blocks.add(new Block<GridMove>(6,3,GridMove.UP));
		blocks.add(new Block<GridMove>(4,4,GridMove.UP));
		blocks.add(new Block<GridMove>(7,4,GridMove.DOWN));
		blocks.add(new Block<GridMove>(2,5,GridMove.DOWN));
		blocks.add(new Block<GridMove>(3,5,GridMove.DOWN));
		blocks.add(new Block<GridMove>(5,5,GridMove.DOWN));
		blocks.add(new Block<GridMove>(1,6,GridMove.DOWN));
		blocks.add(new Block<GridMove>(2,6,GridMove.UP));
		blocks.add(new Block<GridMove>(3,6,GridMove.UP));
		blocks.add(new Block<GridMove>(5,6,GridMove.UP));
		blocks.add(new Block<GridMove>(3,6,GridMove.RIGHT));
		blocks.add(new Block<GridMove>(6,6,GridMove.RIGHT));
		blocks.add(new Block<GridMove>(4,6,GridMove.LEFT));
		blocks.add(new Block<GridMove>(7,6,GridMove.LEFT));
		blocks.add(new Block<GridMove>(1,7,GridMove.UP));
		blocks.add(new Block<GridMove>(5,7,GridMove.DOWN));
		blocks.add(new Block<GridMove>(6,7,GridMove.DOWN));
		blocks.add(new Block<GridMove>(5,8,GridMove.UP));
		blocks.add(new Block<GridMove>(6,8,GridMove.UP));
	}
	
	
	/**
	 * Whether or not the path is blocked.
	 * @return True or false whether the path is blocked.
	 */
	public boolean isBlocked(int agent_x, int agent_y, GridMove move) {
		Block<GridMove> block = new Block<GridMove>(agent_x, agent_y, move);
		
		for (Block<GridMove> b : blocks) {
			if((block.xcoord() == b.xcoord()) && (block.ycoord() == b.ycoord()) && (block.action() == b.action())) {
				return true;
			}
		}
		
		return false;
	}
	
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		
		for(int i=0; i<=height; i++) {
			if(i!=0) {
				sb.append("\n");
			}
			for(int j=0; j<=width; j++) {
				if(i==agent_y && j==agent_x) {
					sb.append("x ");
				}
				
				if(i!=0 && !(i==agent_y && j==agent_x)) {
					sb.append("| ");
				}
				
				
				if(j!=width) {
					if(i!=0) {
						sb.append("__ ");
					} else {
						sb.append("  __ ");
					}
				}
				
			}
			sb.append("\n");
		}
		
		return sb.toString();
	}
	
	// Testing
	public static void main(String[] args) {
		//GridPuzzle gp = new GridPuzzle(8, 10, 3, 2);
		GridPuzzle gp = GridPuzzle.randomGridPuzzle(5, 5);
		System.out.println(gp);
	}
	
	
}
