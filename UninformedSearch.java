package search;


import java.util.ArrayList;
import java.util.List;

import rp13.search.interfaces.Agenda;
import rp13.search.interfaces.SuccessorFunction;
import rp13.search.util.ActionStatePair;


public class UninformedSearch<StateT, ActionT> {
	
	StateT startState;
	StateT goalState;
	Agenda<ActionStatePair<ActionT, StateT>> agenda;
	SuccessorFunction<ActionT, StateT> sf;
	boolean goalFound = false;
	
	public UninformedSearch(StateT _startState, StateT _goalState, Agenda<ActionStatePair<ActionT, StateT>> _agenda, SuccessorFunction<ActionT, StateT> _sf) {
		this.startState = _startState;
		this.goalState = _goalState;
		this.agenda = _agenda;
		this.sf = _sf;
	}

	public void search() {
		
		List<ActionStatePair<ActionT, StateT>> successors = new ArrayList<ActionStatePair<ActionT, StateT>>();
		List<StateT> explored = new ArrayList<StateT>();
		List<ActionT> path = new ArrayList<ActionT>();
		
		agenda.push(new ActionStatePair<ActionT, StateT>(null, startState));
		System.out.println(startState);
		
		while(!agenda.isEmpty() && !goalFound) {
			ActionStatePair<ActionT, StateT> parentState = agenda.pop();
			explored.add(parentState.getState());
			sf.getSuccessors(parentState.getState(), successors);
			
			for (ActionStatePair<ActionT, StateT> successor : successors) {
				if(explored.contains(successor.getState())) {
					continue;
				} else if(successor.getState().equals(goalState)) {
					System.out.println(successor.getState());
					goalFound = true;
					ActionStatePair<ActionT, StateT> pathNode = successor;
					while(pathNode.getAction() != null) {
						path.add(pathNode.getAction());
						pathNode = pathNode.getParent();
					}
					break;
				} else {
					System.out.println(successor);
					successor.setParent(parentState);
					explored.add(successor.getState());
					agenda.push(successor);
				}
				
			}
		}
		System.out.println(path.toString());
	}
	
	
	
	
}
