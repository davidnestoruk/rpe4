package stringJumble;

public class StringJumbleMove {
	
	private int firstIndex;
	private int secondIndex;

	public StringJumbleMove(int firstIndex, int secondIndex) {
		this.firstIndex = firstIndex;
		this.secondIndex = secondIndex;
	}
	
	@Override
	public String toString() {
		String moveIndices = "(" + firstIndex + ", " + secondIndex + ")";
		return moveIndices;
	}
	
}
