package gridPuzzle;

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
	}
	
	
	
	public void makeMove(GridMove move) {
		if(isValidMove(move)) {
			
		}
	}
	
	/**
	 * Where or not the move is valid. i.e. will it take the agent outside of the grid?
	 * @param move The move it is trying to make.
	 * @return Returns whether or not the move is valid.
	 */
	public boolean isValidMove(GridMove move) {
		
		if(move.x_move > width || move.x_move < width ) {
			return false;
		} else if(move.y_move > height || move.y_move < height) {
			return false;
		}
		
		return true;
	}
	
	
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		
		for(int i=0; i<height; i++) {
			if(i!=0) {
				sb.append("\n");
			}
			for(int j=0; j<=width; j++) {
				if(i==agent_y && j==agent_x) {
					
				}
				if(i!=0) {
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
		GridPuzzle gp = new GridPuzzle(5, 5, 1, 2);
		System.out.println(gp.toString());
	}
	
	
}
