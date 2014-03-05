package stringJumble;

import java.util.ArrayList;
import java.util.Collections;
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
	private int firstIndex = 0;
	private int secondIndex = 0;

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
				
		// Shuffles the arraylist.
		Collections.shuffle(chars);
		
		// Loops through randomized character array appending each character to a string.
		for (Character c : chars) {
			sb.append(c);
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
	public void makeMove(int firstIndex, int secondIndex) {
		// Splits the characters of that string up into a character array.
		char[] chars = currentString.toCharArray();
		
		// Saves the character at firstIndex into a temporary variable.
		char temp = chars[firstIndex];
		
		// Swaps the two characters.
		chars[firstIndex] = chars[secondIndex];
		chars[secondIndex] = temp;
		
		// Changes the current string variable to the newly modified string.
		currentString = new String(chars);
		
	}
	
	/**
	 * Swaps two characters in the currentString at two random indices.
	 */
	public void randomMove() {
		Random RANDOM = new Random();
		firstIndex = RANDOM.nextInt(originalString.length());
		if(firstIndex == secondIndex) {
			secondIndex = RANDOM.nextInt(originalString.length());	
		}
		
		makeMove(firstIndex, secondIndex);
		
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

	// TESTING
	public static void main(String[] args) {
		StringJumble sj = new StringJumble("antidisestablishmentarianism");
		System.out.println(randomString("antidisestablishmentarianism"));
	}
}
