package A5_Dijkstra;

import java.util.Comparator;

public class PathComparator implements Comparator<ShortestPathInfo>{
	@Override
	public int compare(ShortestPathInfo o1, ShortestPathInfo o2) {
		// TODO Auto-generated method stub
		 if (o1.getTotalWeight() < o2.getTotalWeight()) {
	            return -1;
	        }
	        if (o1.getTotalWeight() > o2.getTotalWeight()) {
	           return 1;
	        }
	        return 0;
	}
}