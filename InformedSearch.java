package search;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import rp13.search.interfaces.SuccessorFunction;
import rp13.search.util.ActionStatePair;
import agendas.PriorityAgenda;

public class InformedSearch<StateT, ActionT> {
	

	StateT startState;
	StateT goalState;
	PriorityAgenda<ActionStatePair<ActionT, StateT>> agenda;
	SuccessorFunction<ActionT, StateT> sf;
	List<ActionT> path = new ArrayList<ActionT>();
	boolean goalFound = false;
	int g_value;
	
	public InformedSearch(StateT startState, StateT goalState, PriorityAgenda<ActionStatePair<ActionT, StateT>> agenda, 
							SuccessorFunction<ActionT, StateT> sf) {
		this.startState = startState;
		this.goalState = goalState;
		this.agenda = agenda;
		this.sf = sf;
		g_value = 0;
	}
	
	// Search algorithm
	public void search() {
		List<ActionStatePair<ActionT, StateT>> successors = new ArrayList<ActionStatePair<ActionT, StateT>>();
		List<StateT> explored = new ArrayList<StateT>();
		
		ActionStatePair<ActionT, StateT> originalASP = new ActionStatePair<ActionT, StateT>(null, startState);
		ActionStatePair<ActionT, StateT> goalASP = new ActionStatePair<ActionT, StateT>(null, goalState);
		agenda.push(originalASP);
		System.out.println("START STATE: \n" + startState);
		System.out.println("Working...");
		
		while(!agenda.isEmpty() && !goalFound) {
			ActionStatePair<ActionT, StateT> parentState = agenda.pop();
			explored.add(parentState.getState());
			g_value += hce(parentState, goalASP);
			
			// Get successors of queue pop and put them in successors list
			sf.getSuccessors(parentState.getState(), successors);
			
			// For each successor in successors list
						for (ActionStatePair<ActionT, StateT> successor : successors) {
							successor.setHValue(g_value + hce(successor, goalASP));
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
									ActionStatePair<ActionT, StateT>pathNode = successor;
									
									// Populating path arraylist with actions required to get from the start state to the goal state.
									while(pathNode.getParent() != null) {
										pathNode = pathNode.getParent();
										
										// If not root node, add to path 
										if(pathNode != null && pathNode.getAction() != null) {
											path.add(pathNode.getAction());	
										}
									}
									
									// We have found our goal, return to main execution flow
									System.out.println("Finished.");
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

	
	/**
	 * Sets the heuristic value of the current state.
	 * @param initialState The current state.
	 * @param goalState The goal state.
	 */
	public int hce(ActionStatePair<ActionT, StateT> currentState, ActionStatePair<ActionT, StateT> goalState) {
		currentState.setHValue(currentState.compareTo(goalState));
		return currentState.getHValue();
	}
	
}

