package search;

import rp13.search.interfaces.SuccessorFunction;
import rp13.search.problem.puzzle.EightPuzzle;
import rp13.search.problem.puzzle.EightPuzzle.PuzzleMove;
import rp13.search.problem.puzzle.EightPuzzleSuccessorFunction;
import stringJumble.StringJumble;
import stringJumble.StringJumble.StringMove;
import stringJumble.StringJumbleSuccessorFunction;
import agendas.AgendaQueue;
import agendas.AgendaStack;

public class GenericSearchTest {
	
	public static void main(String[] args) {
		
		//EightPuzzleTest();
		StringJumbleTest();
		
	}
	
	/**
	 * Tests searches on the StringJumble class.
	 */
	private static void StringJumbleTest() {
		String word = "java";
		
		StringJumble startState = StringJumble.randomString(word);
		StringJumble goalState = StringJumble.orderedString(word);
		SuccessorFunction<StringMove, StringJumble> sf = new StringJumbleSuccessorFunction();
		
		/* BREADTH-FIRST-SEARCH */
		AgendaQueue<StringJumble> agenda = new AgendaQueue<StringJumble>();
		
		/* DEPTH FIRST SEARCH */
		//AgendaStack<StringJumble> agenda = new AgendaStack<StringJumble>();
		
		UninformedSearch<StringJumble, StringMove> ui;
		ui = new UninformedSearch<StringJumble, StringMove>(startState, goalState, agenda, sf);
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
		//AgendaQueue<EightPuzzle> agenda = new AgendaQueue<EightPuzzle>();
		
		/* DEPTH FIRST SEARCH */
		AgendaStack<EightPuzzle> agenda = new AgendaStack<EightPuzzle>();
		
		UninformedSearch<EightPuzzle, PuzzleMove> ui;
		ui = new UninformedSearch<EightPuzzle, PuzzleMove>(startState, goalState, agenda, sf);
		ui.search();
	}
}
