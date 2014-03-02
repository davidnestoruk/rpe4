package stringJumble;

import java.util.ArrayList;
import java.util.List;

import rp13.search.interfaces.SuccessorFunction;
import rp13.search.util.ActionStatePair;

public class StringJumbleSuccessorFunction implements
		SuccessorFunction<StringJumbleMove, StringJumble> {

	/**
	 * 
	 * Get the possible successors of an eight-puzzle state. Only returns legal
	 * moves.
	 * 
	 */
	
	public void getSuccessors(StringJumble _state,
			List<ActionStatePair<StringJumbleMove, StringJumble>> _successors) {

		assert (_successors != null);
		int stringLength = _state.toString().length();

		for(int i=0; i<stringLength; i++) {
			for(int j=i; j<stringLength; j++) {
				if(i == j) {
					continue;
				}
				
				StringJumbleMove move = new StringJumbleMove(i, j);
				
				// create a copy of the input state as we don't want to change
				// it
				StringJumble successor = new StringJumble(_state.toString());
				// apply the move
				successor.makeMove(i, j);
				// store the move and action together in a pair and add to
				
				// successor list
				_successors
						.add(new ActionStatePair<StringJumbleMove, StringJumble>(
								move, successor));
			}
		}

	}
	
	public static void main(String[] args) {
		StringJumble state = StringJumble.orderedString("hello");
		StringJumbleSuccessorFunction successorFn = new StringJumbleSuccessorFunction();

		// successors are added to the end of this list by the successor
		// function
		List<ActionStatePair<StringJumbleMove, StringJumble>> successors = new ArrayList<ActionStatePair<StringJumbleMove, StringJumble>>();
		;
		// get the successors of the given state
		successorFn.getSuccessors(state, successors);

		for (ActionStatePair<StringJumbleMove, StringJumble> successor : successors) {

			System.out.println("Applied move " + successor.getAction()
					+ " and got:");

			System.out.println(successor.getState());

		}
	}


}
