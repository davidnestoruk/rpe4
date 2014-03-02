package search;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import rp13.search.interfaces.Agenda;
import rp13.search.interfaces.SuccessorFunction;
import rp13.search.problem.puzzle.EightPuzzle;
import rp13.search.problem.puzzle.EightPuzzle.PuzzleMove;
import rp13.search.util.ActionStatePair;


public class UninformedSearch<StateT, ActionT> {
	
	StateT startState;
	StateT goalState;
	Agenda<ActionStatePair<ActionT, StateT>> agenda;
	SuccessorFunction<ActionT, StateT> sf;
	boolean goalFound = false;
	EightPuzzle puzzle;
	
	public UninformedSearch(StateT _startState, StateT _goalState, Agenda<ActionStatePair<ActionT, StateT>> _agenda, SuccessorFunction<ActionT, StateT> _sf) {
		this.startState = _startState;
		this.goalState = _goalState;
		this.agenda = _agenda;
		this.sf = _sf;
		puzzle = new EightPuzzle((EightPuzzle) startState);
	}

	public void search() {
		/* Instantiating lists for successors, explored set, and path */
		List<ActionStatePair<ActionT, StateT>> successors = new ArrayList<ActionStatePair<ActionT, StateT>>();
		List<StateT> explored = new ArrayList<StateT>();
		List<ActionT> path = new ArrayList<ActionT>();
		
		ActionStatePair<ActionT, StateT> originalASP = new ActionStatePair<ActionT, StateT>(null, startState);
		agenda.push(originalASP);
		System.out.println("START STATE: \n" + startState);
		
		while(!agenda.isEmpty() && !goalFound) {
			ActionStatePair<ActionT, StateT> parentState = agenda.pop();
			explored.add(parentState.getState());
			
			// Get successors of queue pop and put them in successors list
			sf.getSuccessors(parentState.getState(), successors);
			
			// For each successor in successors list
			for (ActionStatePair<ActionT, StateT> successor : successors) {
				
				// Check to see if we have visited this state already
				if(explored.contains(successor.getState())) {
					continue;
				} 
				
				// Node to potentially expand
				else {

					//System.out.println(successor);
					successor.setParent(parentState);
					
					// Check if this state is the goal state
					if(successor.getState().equals(goalState)) {
						System.out.println(successor.getState());
						goalFound = true;
						path.add(successor.getAction());
						ActionStatePair<ActionT, StateT> pathNode = successor;
						
						// Populating path arraylist with actions required to get from the start state to the goal state.
						while(pathNode.getParent() != null) {
							pathNode = pathNode.getParent();
							
							// If not root node, add to path 
							if(pathNode != null && pathNode.getAction() != null) {
								path.add(pathNode.getAction());	
							}
						}
						
						// We have found our goal, return to main execution flow
						break;
					}
					
					explored.add(successor.getState());
					agenda.push(successor);
					
				}
							
				
			}
		}
		
		// Reverses the path list and displays it.
		Collections.reverse(path);
		System.out.println("Path: " + path.toString());
	}
	
	
	
	
}
