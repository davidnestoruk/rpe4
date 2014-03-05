package agendas;

import java.util.Comparator;
import rp13.search.util.ActionStatePair;




public class QueueComparator implements Comparator<ActionStatePair>{
	
	@Override
	public int compare(ActionStatePair node1, ActionStatePair node2) {
		
		if(node1.getHValue() > node2.getHValue()) {
			return 1;
		} else if(node1.getHValue() == node2.getHValue()) {
			return 0;
		} else {
			return -1;
		}

		
	}
}
