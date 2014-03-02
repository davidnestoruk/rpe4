package stringJumble;

import java.util.ArrayList;
import java.util.List;

import rp13.search.interfaces.SuccessorFunction;
import rp13.search.problem.puzzle.EightPuzzle;
import rp13.search.problem.puzzle.EightPuzzleSuccessorFunction;
import rp13.search.problem.puzzle.EightPuzzle.PuzzleMove;
import rp13.search.util.ActionStatePair;
import stringJumble.StringJumble.StringMove;

public class StringJumbleSuccessorFunction implements
		SuccessorFunction<StringMove, StringJumble> {

	/**
	 * 
	 * Get the possible successors of an eight-puzzle state. Only returns legal
	 * moves.
	 * 
	 */
	
	public void getSuccessors(StringJumble _state,
			List<ActionStatePair<StringMove, StringJumble>> _successors) {

		assert (_successors != null);

		// for each of the moves that are available
		for (StringMove move : StringMove.values()) {

			// create a copy of the input state as we don't want to change
			// it
			StringJumble successor = new StringJumble(_state.toString());
			// apply the move
			successor.makeMove(move);
			// store the move and action together in a pair and add to
			// successor list
			_successors
					.add(new ActionStatePair<StringJumble.StringMove, StringJumble>(
							move, successor));
		}

	}
	
	public static void main(String[] args) {
		StringJumble state = StringJumble.orderedString("java");
		StringJumbleSuccessorFunction successorFn = new StringJumbleSuccessorFunction();

		// successors are added to the end of this list by the successor
		// function
		List<ActionStatePair<StringMove, StringJumble>> successors = new ArrayList<ActionStatePair<StringMove, StringJumble>>();
		;
		// get the successors of the given state
		successorFn.getSuccessors(state, successors);

		for (ActionStatePair<StringMove, StringJumble> successor : successors) {

			System.out.println("Applied move " + successor.getAction()
					+ " and got:");

			System.out.println(successor.getState());

		}
	}


}
