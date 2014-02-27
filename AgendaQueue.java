package agendas;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

import rp13.search.interfaces.Agenda;


public class AgendaQueue implements Agenda<Object> {

	Queue<Object> queue = new LinkedList<Object>();
	
	@Override
	public Iterator iterator() {
		return queue.iterator();
	}

	@Override
	public void push(Object _item) {
		queue.add(_item);
	}

	@Override
	public Object pop() {
		return queue.remove();
	}

	@Override
	public boolean isEmpty() {
		if(queue.isEmpty()) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public boolean contains(Object _item) {
		if(queue.contains(_item)) {
			return true;
		} else {
			return false;
		}
	}

}
