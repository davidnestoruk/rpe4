/**
 * 
 */
package rp13.search.util;

/**
 * A class to store an action and the state it has produced together.
 * 
 * @author nah
 * 
 */
public class ActionStatePair<ActionT, StateT> {

	private final ActionT m_action;
	private final StateT m_state;
	private ActionStatePair<ActionT, StateT> m_parent;

	/**
	 * Construct the pair from input values.
	 * 
	 * @param _action
	 * @param _state
	 */
	public ActionStatePair(ActionT _action, StateT _state) {
		m_action = _action;
		m_state = _state;
	}

	/**
	 * Get action.
	 * 
	 * @return
	 */
	public ActionT getAction() {
		return m_action;
	}

	/**
	 * Get state.
	 * 
	 * @return
	 */
	public StateT getState() {
		return m_state;
	}
	
	/**
	 * Get's parent state.
	 * @return Returns the parent state to the current state.
	 */
	public ActionStatePair<ActionT, StateT> getParent() {
		return m_parent;
	}
	
	/**
	 * Sets the parent.
	 */
	public void setParent(ActionStatePair<ActionT, StateT> m_asp) {
		this.m_parent = m_asp;
	}

	
	@Override 
	public boolean equals(Object _that) {
		if(_that instanceof ActionStatePair) {
			ActionStatePair<?, ?> that = (ActionStatePair<?, ?>) _that;
			return this.getState().equals(that.getState()) && this.getAction().equals(that.getAction());
		}
		else {
			return false;
		}
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(m_state);
		if (m_action != null) {
			sb.append("\n -> \n");
			sb.append(m_action);
		}

		return sb.toString();
	}
	

	
}
