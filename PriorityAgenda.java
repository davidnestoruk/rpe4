package agendas;

import java.util.Iterator;

import rp13.search.interfaces.SortedAgenda;

public class PriorityAgenda<ActionT, StateT> implements SortedAgenda<ASPComparable<ActionT, StateT>> {

	@Override
	public void push(ASPComparable<ActionT, StateT> _item) {
		
	}

	@Override
	public ASPComparable<ActionT, StateT> pop() {
		return null;
	}

	@Override
	public boolean isEmpty() {
		return false;
	}

	@Override
	public boolean contains(ASPComparable<ActionT, StateT> _item) {
		return false;
	}

	@Override
	public Iterator<ASPComparable<ActionT, StateT>> iterator() {
		return null;
	}

	@Override
	public void sort() {
		
	}

}
