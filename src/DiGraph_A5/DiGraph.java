package DiGraph_A5;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class DiGraph implements DiGraphInterface {
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
	edges.put(idNum, n);
	map.get(sLabel).put(dLabel, n);
	return true;
	
}

@Override
public boolean delNode(String label) {
	// TODO Auto-generated method stub
	if(!nodes.containsKey(label)) {
		return false;
	}
	nodes_id.remove(nodes.get(label));// remove node_id
	nodes.remove(label);// remove node from node collection
	Collection<Edge> e = map.get(label).values(); //all edges going out of delnode
	edges.values().removeAll(e); // remove edges going out of delnode
	map.remove(label);// remove node from map
	Collection<Edge> to_node = new HashSet<Edge>();
	for(Map<String, Edge> m: map.values()) {
		if(m.containsKey(label)) {
			to_node.add(m.get(label)); // find all the edges' destination is delnode
			m.values().remove(m.get(label)); // delete edges going into the delnode from map
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
		edges.values().remove(e); //delete edge form edges collection
        	map.get(sLabel).values().remove(e); //delete edge form map
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
  

}