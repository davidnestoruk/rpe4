package agendas;
import java.util.Iterator;
import java.util.Stack;

import rp13.search.interfaces.Agenda;


public class AgendaStack implements Agenda<Object> {
	
	Stack<Object> stack = new Stack<Object>();

	@Override
	public Iterator iterator() {
		return stack.iterator();
	}

	@Override
	public void push(Object _item) {
		stack.push(_item);
	}
	
	@Override
	public Object pop() {
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
	public boolean contains(Object _item) {
		if(stack.contains(_item)) {
			return true;
		} else {
			return false;
		}
	}

}
