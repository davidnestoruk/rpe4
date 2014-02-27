package search;


import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.ArrayList;

import rp13.search.interfaces.Agenda;
import rp13.search.interfaces.SuccessorFunction;
import rp13.search.problem.puzzle.EightPuzzle;
import rp13.search.problem.puzzle.EightPuzzleSuccessorFunction;
import rp13.search.problem.puzzle.EightPuzzle.PuzzleMove;
import rp13.search.util.ActionStatePair;


public class UninformedSearch {

	public void search(Object state, Agenda<Object> agenda, SuccessorFunction sf) {
		
		List<ActionStatePair<PuzzleMove, EightPuzzle>> successors = new ArrayList<ActionStatePair<PuzzleMove, EightPuzzle>>();
		List<EightPuzzle> explored = new ArrayList<EightPuzzle>();
		
		
		agenda.push(state);
		System.out.println(state);
		
		while(!agenda.isEmpty()) {
			parentState = agenda.pop();
			explored.add(parentState);
			sf.getSuccessors(parentState, successors);
			
			for (ActionStatePair<PuzzleMove, EightPuzzle> successor : successors) {
				if(explored.contains(successor.getState())) {
					continue;
				} else if(successor.getState().equals(EightPuzzle.orderedEightPuzzle())) {
					System.out.println(successor.getState());
					System.exit(0);
				} else {
					System.out.println(successor);
					explored.add(successor.getState());
					agenda.push(successor.getState());
				}
				
			}
		}
		
		
	}
	
	
	
	
	public static void main(String[] args) {
		EightPuzzle state = EightPuzzle.randomEightPuzzle();

		EightPuzzleBFS epbfs = new EightPuzzleBFS(state);
		epbfs.search(state);
		
	

		
		
	}
	
}
