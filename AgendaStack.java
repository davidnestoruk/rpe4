package agendas;
import java.util.Iterator;
import java.util.Stack;

import rp13.search.interfaces.Agenda;


public class AgendaStack<ActionStatePair> implements Agenda<ActionStatePair> {
	
	Stack<ActionStatePair> stack = new Stack<ActionStatePair>();

	@Override
	public Iterator iterator() {
		return stack.iterator();
	}

	@Override
	public void push(ActionStatePair _item) {
		stack.push(_item);
	}
	
	@Override
	public ActionStatePair pop() {
		return stack.pop();
	}

	@Override
	public boolean isEmpty() {
		if(stack.isEmpty()) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public boolean contains(ActionStatePair _item) {
		if(stack.contains(_item)) {
			return true;
		} else {
			return false;
		}
	}

}
