package search;


import java.util.List;
import java.util.ArrayList;
import rp13.search.interfaces.Agenda;
import rp13.search.interfaces.SuccessorFunction;
import rp13.search.util.ActionStatePair;


public class UninformedSearch<StateT, ActionT> {
	
	StateT startState;
	StateT goalState;
	Agenda<StateT> agenda;
	SuccessorFunction<ActionT, StateT> sf;
	
	public UninformedSearch(StateT _startState, StateT _goalState, Agenda<StateT> _agenda, SuccessorFunction<ActionT, StateT> _sf) {
		this.startState = _startState;
		this.goalState = _goalState;
		this.agenda = _agenda;
		this.sf = _sf;
	}

	public void search() {
		
		List<ActionStatePair<ActionT, StateT>> successors = new ArrayList<ActionStatePair<ActionT, StateT>>();
		List<StateT> explored = new ArrayList<StateT>();
		
		agenda.push(startState);
		System.out.println(startState);
		
		while(!agenda.isEmpty()) {
			StateT parentState = agenda.pop();
			explored.add(parentState);
			sf.getSuccessors(parentState, successors);
			
			for (ActionStatePair<ActionT, StateT> successor : successors) {
				if(explored.contains(successor.getState())) {
					continue;
				} else if(successor.getState().equals(goalState)) {
					System.out.println(successor.getState());
					System.exit(0);
				} else {
					//System.out.println(successor);
					explored.add(successor.getState());
					agenda.push(successor.getState());
				}
				
			}
		}
		
		
	}
	
	
}
