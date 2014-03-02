package search;

import rp13.search.interfaces.SuccessorFunction;
import rp13.search.problem.puzzle.EightPuzzle;
import rp13.search.problem.puzzle.EightPuzzle.PuzzleMove;
import rp13.search.problem.puzzle.EightPuzzleSuccessorFunction;
import rp13.search.util.ActionStatePair;
import stringJumble.StringJumble;
import stringJumble.StringJumbleMove;
import stringJumble.StringJumbleSuccessorFunction;
import agendas.AgendaQueue;

public class GenericSearchTest {
	
	public static void main(String[] args) {
		
		EightPuzzleTest();
		//StringJumbleTest();
		
	}
	
	/**
	 * Tests searches on the StringJumble class.
	 */
	private static void StringJumbleTest() {
		String word = "test";
		
		StringJumble startState = StringJumble.randomString(word);
		StringJumble goalState = StringJumble.orderedString(word);
		SuccessorFunction<StringJumbleMove, StringJumble> sf = new StringJumbleSuccessorFunction();
		
		/* BREADTH-FIRST-SEARCH */
		AgendaQueue<ActionStatePair<StringJumbleMove, StringJumble>> agenda = new AgendaQueue<ActionStatePair<StringJumbleMove, StringJumble>>();
		
		/* DEPTH FIRST SEARCH */
		//AgendaStack<ActionStatePair<StringJumbleMove, StringJumble>> agenda = new AgendaStack<ActionStatePair<StringJumbleMove, StringJumble>>();
		
		UninformedSearch<StringJumble, StringJumbleMove> ui;
		ui = new UninformedSearch<StringJumble, StringJumbleMove>(startState, goalState, agenda, sf);
		ui.search();
	}
	
	/**
	 * Tests searches on the EightPuzzle class.
	 */
	private static void EightPuzzleTest() {
		EightPuzzle startState = EightPuzzle.randomEightPuzzle();
		EightPuzzle goalState = EightPuzzle.orderedEightPuzzle();
		SuccessorFunction<PuzzleMove, EightPuzzle> sf = new EightPuzzleSuccessorFunction();
		
		/* BREADTH-FIRST-SEARCH */
		AgendaQueue<ActionStatePair<PuzzleMove, EightPuzzle>> agenda = new AgendaQueue<ActionStatePair<PuzzleMove, EightPuzzle>>();
		
		/* DEPTH FIRST SEARCH */
		//AgendaStack<ActionStatePair<PuzzleMove, EightPuzzle>> agenda = new AgendaStack<ActionStatePair<PuzzleMove, EightPuzzle>>();
		
		UninformedSearch<EightPuzzle, PuzzleMove> ui;
		ui = new UninformedSearch<EightPuzzle, PuzzleMove>(startState, goalState, agenda, sf);
		ui.search();
	}
}
