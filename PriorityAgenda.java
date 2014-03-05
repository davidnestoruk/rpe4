package agendas;


import java.util.Comparator;
import java.util.Iterator;
import java.util.PriorityQueue;

import rp13.search.interfaces.Agenda;

public class PriorityAgenda<ActionStatePair> implements Agenda<ActionStatePair> {
	
	Comparator compare = new QueueComparator();
	PriorityQueue<ActionStatePair> queue = new PriorityQueue<ActionStatePair>(10, compare);
	
	@Override
	public Iterator<ActionStatePair> iterator() {
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
