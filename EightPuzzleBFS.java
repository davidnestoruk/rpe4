package rpe4;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.ArrayList;
import rp13.search.problem.puzzle.EightPuzzle;
import rp13.search.problem.puzzle.EightPuzzleSuccessorFunction;
import rp13.search.problem.puzzle.EightPuzzle.PuzzleMove;
import rp13.search.util.ActionStatePair;


public class EightPuzzleBFS {
	
	private final EightPuzzle m_state;
	
	public EightPuzzleBFS(EightPuzzle _state) {
		m_state = _state;
	}
	
	

	
	public void bfs(EightPuzzle state) {
		
		EightPuzzleSuccessorFunction sf = new EightPuzzleSuccessorFunction();
		List<ActionStatePair<PuzzleMove, EightPuzzle>> successors = new ArrayList<ActionStatePair<PuzzleMove, EightPuzzle>>();
		List<EightPuzzle> explored = new ArrayList<EightPuzzle>();
		
		Queue<EightPuzzle> queue = new LinkedList<EightPuzzle>();
		queue.add(state);
		System.out.println(state);
		
		while(!queue.isEmpty()) {
			EightPuzzle parentState = queue.remove();
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
					queue.add(successor.getState());
				}
				
			}
		}
		
		
	}
	
	
	
	
	public static void main(String[] args) {
		EightPuzzle state = EightPuzzle.randomEightPuzzle();

		EightPuzzleBFS epbfs = new EightPuzzleBFS(state);
		epbfs.bfs(state);
		
	

		
		
	}
	
}
