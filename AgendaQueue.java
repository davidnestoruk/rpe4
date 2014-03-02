package agendas;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

import rp13.search.interfaces.Agenda;


public class AgendaQueue<ActionStatePair> implements Agenda<ActionStatePair> {

	Queue<ActionStatePair> queue = new LinkedList<ActionStatePair>();
	
	@Override
	public Iterator iterator() {
		return queue.iterator();
	}

	@Override
	public void push(ActionStatePair _item) {
		queue.add(_item);
	}

	@Override
	public ActionStatePair pop() {
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
	public boolean contains(ActionStatePair _item) {
		if(queue.contains(_item)) {
			return true;
		} else {
			return false;
		}
	}

}
