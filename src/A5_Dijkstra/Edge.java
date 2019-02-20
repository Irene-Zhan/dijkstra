package A5_Dijkstra;

public class Edge{
	long id;
	String sLabel;
	String dLabel;
	long weight;
	String eLabel;
	
	Edge(long idNum, String sLabel, String dLabel, long weight, String eLabel){
		id = idNum;
		this.sLabel = sLabel;
		this.dLabel = dLabel;
		this.weight = weight;
		this.eLabel = eLabel;
	}
	public String toString() {
		//+sLabel +" --> " + weight+" --> "+ dLabel
		return " (" + id+ ")  " +"--> " + weight;
		
	}
	
}