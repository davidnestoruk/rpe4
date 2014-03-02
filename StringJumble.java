package stringJumble;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

/**
 * A class that represents a string which can be in an ordered state
 * or random state.
 * 
 * @author DavidNestoruk
 */
public class StringJumble {
	
	private final String originalString;
	public String currentString;

	/**
	 * Constructor
	 * 
	 * @param originalString The original string passed.
	 */
	public StringJumble(String originalString) {
		this.originalString = originalString;
		this.currentString = originalString;
	}
	
	/**
	 * Explicit enumeration of swaps the string can take.
	 * 
	 * @author DavidNestoruk
	 */
	public enum StringMove {
		ZEROONE(0, 1), ZEROTWO(0, 2), ZEROTHREE(0, 3), ONETWO(1, 2), ONETHREE(1, 3), TWOTHREE(2, 3);
		
		private final int firstIndex;
		private final int secondIndex;
		
		private StringMove(int firstIndex, int secondIndex) {
			this.firstIndex = firstIndex;
			this.secondIndex = secondIndex;
		}
		
		private static final StringMove[] VALUES = values();
		
		private static final int SIZE = VALUES.length;
		
		private static final Random RANDOM = new Random();
		
		public static StringMove randomMove() {
			int pick = (int) Math.max(
					Math.ceil(RANDOM.nextDouble() * SIZE) - 1, 0);

			return VALUES[pick];
		}
	}
	
	
	
	/**
	 * Creates a string with the value of the original string at object creation.
	 * 
	 * @return Returns the string in it's original state.
	 */
	public static StringJumble orderedString(String _originalString) {
		return new StringJumble(_originalString);
	}
	
	/**
	 * Creates a string using the original string passed, and randomly changing the character positions.
	 * 
	 * @return Returns the original string with it's characters in a random order.
	 */
	public static StringJumble randomString(String _originalString) {
		StringBuilder sb = new StringBuilder();
		Random RANDOM = new Random();
		
		// Creates an arraylist to hold all the characters.
		ArrayList<Character> chars = new ArrayList<Character>();
		// For each character in the character array, adds it to the newly created arraylist.
		for(char c : _originalString.toCharArray()) {
			chars.add(c);
		}
		
		// While the chars arraylist is not empty, appends a random character to a new string.
		while(!chars.isEmpty()) {
			int listSize = chars.size();
			int randomIndex = RANDOM.nextInt(listSize);
			sb.append(chars.get(randomIndex));
			chars.remove(randomIndex);
		}
		
		StringJumble jumbledString = new StringJumble(sb.toString());
		
		// Returns the jumbled string as type StringJumble.
		return jumbledString;
	}
	
	/**
	 * Swaps the characters at index 'firstIndex' and index 'secondIndex'.
	 * 
	 * @param move The move which is to be applied to the string.
	 */
	public void makeMove(StringMove move) {
		// Splits the characters of that string up into a character array.
		char[] chars = currentString.toCharArray();
		
		// Saves the character at firstIndex into a temporary variable.
		char temp = chars[move.firstIndex];
		
		// Swaps the two characters.
		chars[move.firstIndex] = chars[move.secondIndex];
		chars[move.secondIndex] = temp;
		
		// Changes the current string variable to the newly modified string.
		currentString = new String(chars);
		
	}
	
	/**
	 * Swaps two characters in the currentString at two random indices.
	 */
	public void randomMove() {
		StringMove move = StringMove.randomMove();
		makeMove(move);
	}
	
	@Override
	public String toString() {
		return currentString;
	}
	
	/**
	 * A check to see whether two states are equal.
	 * @return Returns whether or not this is equal to the parameter _that.
	 */
	@Override
	public boolean equals(Object _that ) {
		if(_that instanceof StringJumble) {
			StringJumble that = (StringJumble) _that;
			
			return this.currentString.equals(that.currentString);
		}
		
		return false;
	}
}
