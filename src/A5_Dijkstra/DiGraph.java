package A5_Dijkstra;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;

public class DiGraph implements DiGraph_Interface {
  // in here go all your data and methods for the graph
	Map<String,Long> nodes;
	Set<Long> nodes_id;
	Map<Long,Edge> edges;
	Map<String,Map<String,Edge>> map;
	

  public DiGraph ( ) { // default constructor
    // explicitly include this
    // we need to have the default constructor
    // if you then write others, this one will still be there
		nodes = new HashMap<String, Long>();
		nodes_id = new HashSet<Long>();
		map = new HashMap<String, Map<String, Edge>>();
		edges = new HashMap<Long, Edge>();
  }

@Override
public boolean addNode(long idNum, String label) {
	// TODO Auto-generated method stub
	if(nodes.containsKey(label) || label == null) { // check whether label is unique
		return false;
	}
	if(nodes_id.contains(idNum) || idNum < 0) { // check whether id is unique
		return false;
	}
	nodes_id.add(idNum); //add id
	nodes.put(label, idNum); // add to nodes collection
	map.put(label, new HashMap<String,Edge>()); // add to map
	return true;
}

@Override
public boolean addEdge(long idNum, String sLabel, String dLabel, long weight, String eLabel) {
	// TODO Auto-generated method stub
	if(idNum < 0 || !nodes.containsKey(sLabel) || !nodes.containsKey(dLabel) || edges.containsKey(idNum)) { 
		return false;
	}
	if(map.get(sLabel).containsKey(dLabel)) {
		return false;
	}
	Edge n = new Edge(idNum, sLabel, dLabel, weight, eLabel); 
	edges.put(idNum, n); // add to edge collection
	map.get(sLabel).put(dLabel, n); // add to map
	return true;
	
}
public boolean addEdge(long idNum,String sLabel, String dLabel) {
	return addEdge(idNum, sLabel, dLabel, 1, null);
	
}
public boolean addEdge(long idNum,String sLabel, String dLabel, long weight) {
	return addEdge(idNum, sLabel, dLabel, weight, null);
	
}
public boolean addEdge(long idNum,String sLabel, String dLabel, String eLabel) {
	return addEdge(idNum, sLabel, dLabel, 1, null);
	
}

@Override
public boolean delNode(String label) {
	// TODO Auto-generated method stub
	if(!nodes.containsKey(label)) {
		return false;
	}
	nodes_id.remove(nodes.get(label)); // remove node_id
	nodes.remove(label); //remove node from node collection
	Collection<Edge> e = map.get(label).values(); //all edges going out of delnode
	edges.values().removeAll(e); //remove edges going out of delnode from edge collection
	map.remove(label); // remove node from map
	Collection<Edge> to_node = new HashSet<Edge>(); // contain edges going into node
	for(Map<String, Edge> m: map.values()) {
		if(m.containsKey(label)) {
			to_node.add(m.get(label)); // find all the edges' destination is delnode
			m.values().remove(m.get(label)); //delete edges going into the delnode from map
		}
	}
	edges.values().removeAll(to_node); // delete edges going into the delnode from edge collection
    return true;
	
}

@Override
public boolean delEdge(String sLabel, String dLabel) {
	// TODO Auto-generated method stub
	if(!nodes.containsKey(sLabel) || !nodes.containsKey(dLabel)) {
		return false;
	}
	if(map.get(sLabel).isEmpty()) {  // check if any edge at all go out from sLabel node
		return false;
	}
	if(map.get(sLabel).containsKey(dLabel)) { // edge exist
		Edge e = map.get(sLabel).get(dLabel);
		edges.values().remove(e); //delete edge from edges collection
        	map.get(sLabel).values().remove(e); //delete edge from map
        	return true;
	}
	return false;
	
}

@Override
public long numNodes() {
	// TODO Auto-generated method stub
	return nodes.size();
}

@Override
public long numEdges() {
	// TODO Auto-generated method stub
	return edges.size();
}
  

@Override
public ShortestPathInfo[] shortestPath(String label) {
	// TODO Auto-generated method stub
	if(!nodes.containsKey(label)) {  //check if entered label is on map
		return null;
	}
	ShortestPathInfo[] dijkstra = new ShortestPathInfo[nodes.size()];  // create the array to be returned
	dijkstra[0] = new ShortestPathInfo(label, 0);  // add shortest path to self
	Comparator<ShortestPathInfo> comparator = new PathComparator();
    PriorityQueue<ShortestPathInfo> paths = new PriorityQueue<ShortestPathInfo> (10, comparator); // initialize PQ
    for (Iterator<Edge> q = map.get(label).values().iterator(); q.hasNext();) { // push all adjacent nodes to PQ
    			Edge d = q.next();
    			paths.add(new ShortestPathInfo(d.dLabel, d.weight));
    		}
    Set<String> known = new HashSet<String>();
    known.add(label); //start node is known
    int i=1; // dijkstra index
    outerloop:
    while(!paths.isEmpty()) {
    		String ver = paths.peek().getDest();
    		while(known.contains(ver)) {
    			paths.remove(); // remove if node is already known
    			if(paths.isEmpty()) {
    				break outerloop;
    			}
    			ver = paths.peek().getDest();
    		}
    		long dv = paths.peek().getTotalWeight();
    		dijkstra[i] = paths.peek(); i++; //add to array
    		paths.remove();// pop the first unknown from PR
    		known.add(ver);// set node known
    		for (Iterator<Edge> k = map.get(ver).values().iterator(); k.hasNext();) {
    			Edge t = k.next();
    			paths.add(new ShortestPathInfo(t.dLabel, t.weight+dv));
        		}  
    }
    if(dijkstra[nodes.size()-1] == null) { // if any nodes cannot be reached
    		Set<String> unreached = new HashSet<String>(map.keySet());
    		unreached.removeAll(known);
    		for (Iterator<String> z = unreached.iterator();z.hasNext();) {
    			dijkstra[i] = new ShortestPathInfo(z.next(), -1);
    			i++;
    		}
    }
    return dijkstra;
}


}