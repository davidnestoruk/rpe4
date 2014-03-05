package agendas;

import rp13.search.util.ActionStatePair;

public class ASPComparable<ActionT, StateT> extends ActionStatePair<ActionT, StateT> implements Comparable<ASPComparable<ActionT, StateT>> {
	
	/**
	 * Constructor
	 * @param _action The action.
	 * @param _state The state.
	 */
	public ASPComparable(ActionT _action, StateT _state) {
		super(_action, _state);
	}


	@Override
	/*
	 * (non-Javadoc)
	 * @see java.lang.Comparable#compareTo(java.lang.Object)
	 */
	public int compareTo(ASPComparable<ActionT, StateT> asp) {
		// Initialises the equal chars variable.
		int equalChars = 0;
		
		// Stores the string value of both node states into variables
		String thisString = this.getState().toString();
		String thatString = asp.getState().toString();
		
		// Converts both strings to character arrays.
		char[] thisArray = thisString.toCharArray();
		char[] thatArray = thatString.toCharArray();
		
		// Loops through arrays checking how many characters are in the same position.
		for(int i=0; i<thisString.length(); i++) {
			if(thisArray[i] == thatArray[i]) {
				equalChars++;
			}
		}
		
		// Returns the amount of characters in the same position.
		return equalChars;
	}

}
