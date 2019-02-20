package A5_Dijkstra;

import java.util.Arrays;
public class DiGraphPlayground {
	
  public static void main (String[] args) {
	  //exTest();
	  //ShortestTest2();
	  //test();
	  /*
	  DiGraph a = new DiGraph();
	  System.out.println(a.addNode(2,"a"));
	  System.out.println(a.addEdge(1, "a", "a", 6, null));
	  System.out.println(Arrays.toString(a.shortestPath("a")));
	  System.out.println(a.delNode("a"));
	  System.out.println(a.addNode(1, "a"));
	  System.out.println(a.delNode("a"));
	  System.out.println(a.delNode("a"));
	  System.out.println(a.addNode(1, "a"));
	  System.out.println(a.delNode("a"));
	  System.out.println(a.numNodes());
	  a.addNode(1, "a");
	  System.out.println(a.addNode(3, "b"));
	  System.out.println(Arrays.toString(a.shortestPath("a")));
	  System.out.println(a.addEdge(1, "a", "b", 4, null));
	  System.out.println(Arrays.toString(a.shortestPath("a")));
	  a.addNode(2, "c");
	  System.out.println(a.addEdge(7, "a", "c", 9, null));
	  System.out.println(Arrays.toString(a.shortestPath("a")));
	  System.out.println(a.delEdge("a", "b"));
	  System.out.println(a.delEdge("a", "b"));*/	
	  ShortTest();
    }
  public static void ShortTest() {
	  	DiGraph q = new DiGraph();
	  	q.addNode(2, "a");
		q.addNode(6, "b");
		q.addNode(4, "c");
		q.addNode(3, "d");
		q.addNode(9, "e");
		q.addNode(11, "f");
		q.addNode(21, "g");
		System.out.println(Arrays.toString(q.shortestPath("a")));
		q.addEdge(7, "a", "d", 7);
		q.addEdge(3, "a", "c", 6);
		q.addEdge(71, "d", "g", 1);
		q.addEdge(72, "c", "g", 4);
		q.addEdge(8, "e", "b", 3);
		q.addEdge(712, "f", "e", 4);
		q.addEdge(23, "d", "f", 2);
		q.addEdge(74, "g", "b", 5);
		q.addEdge(4, "g", "f");
		System.out.println(Arrays.toString(q.shortestPath("a")));

	  
  }
  	public static void test() {
  		DiGraph q = new DiGraph();
  		q.addNode(2, "a");
  		q.addNode(6, "b");
  		q.addNode(4, "c");
  		q.addNode(3, "d");
  		q.addNode(9, "e");
  		q.addNode(11, "f");
  		q.addNode(21, "g");
  		System.out.println(q.numNodes());
  		q.delNode("b");
  		System.out.println(q.numNodes());
  		q.addNode(6, "b");
  		System.out.println(q.numNodes());;
  		System.out.println(Arrays.toString(q.shortestPath("b")));
  		q.addEdge(1, "b", "a", 3,null);
  		q.addEdge(3, "b", "e", 4,null);
  		System.out.println(Arrays.toString(q.shortestPath("b")));
  		
  		q.addEdge(0, "a", "e", 1,null);
  		q.addEdge(7, "a", "d", 5,null);
  		q.addEdge(4, "d", "f", 6,null);
  		q.addEdge(98, "e", "c", 2,null);
  		q.addEdge(9, "b", "a", 8,null);
  		q.addEdge(10, "e", "d", 7,null);
  		System.out.println(q.numEdges());
  		System.out.println(q.numNodes());
  		System.out.println(Arrays.toString(q.shortestPath("b")));
  	}
  
    public static void exTest(){
      DiGraph d = new DiGraph();
      d.addNode(1, "b");
      d.addNode(3, "c");
      d.addNode(7, "a");
      d.addNode(0, "e");
      d.addNode(4, "d");
      d.addNode(6, "f");
      d.addEdge(0, "a", "b", 0, null);
      d.addEdge(25, "a", "c", 0, null);
      d.addEdge(24, "a", "d", 0, null);
      d.addEdge(23, "a", "e", 0, null);
      d.addEdge(22, "a", "f", 0, null);
      d.addEdge(21, "b", "a", 0, null);
      d.addEdge(20, "b", "c", 0, null);
      d.addEdge(19, "b", "d", 0, null);
      d.addEdge(18, "b", "e", 0, null);
      d.addEdge(17, "b", "f", 0, null);
      d.addEdge(16, "c", "a", 0, null);
      d.addEdge(15, "c", "b", 0, null);
      d.addEdge(14, "c", "f", 0, null);
      d.addEdge(13, "c", "d", 0, null);
      d.addEdge(12, "c", "e", 0, null);
      d.addEdge(71, "d", "a", 0, null);
      d.addEdge(72, "d", "b", 0, null);
      d.addEdge(73, "d", "c", 0, null);
      d.addEdge(75, "d", "e", 0, null);
      d.addEdge(76, "d", "f", 0, null);
      d.addEdge(31, "e", "a", 0, null);
      d.addEdge(32, "e", "b", 0, null);
      d.addEdge(33, "e", "c", 0, null);
      d.addEdge(34, "e", "d", 0, null);
      d.addEdge(35, "e", "f", 0, null);
      d.addEdge(41, "f", "a", 0, null);
      d.addEdge(42, "f", "b", 0, null);
      d.addEdge(43, "f", "c", 0, null);
      d.addEdge(44, "f", "d", 0, null);
      d.addEdge(45, "f", "e", 0, null);
      /*
       del Node Test 
      System.out.println(d.numEdges());
      System.out.println(d.numNodes());
      System.out.println(d.delNode("d"));
      System.out.println(d.numEdges());
      System.out.println(d.numNodes());
      System.out.println(d.map);
      System.out.println(d.delNode("e"));
      System.out.println(d.numEdges());
      System.out.println(d.numNodes());
      System.out.println(d.map);
      System.out.println(d.delNode("a"));
      System.out.println(d.numEdges());
      System.out.println(d.numNodes());
      System.out.println(d.map);
      System.out.println(d.delNode("b"));
      System.out.println(d.numEdges());
      System.out.println(d.numNodes());
      System.out.println(d.map);
      System.out.println(d.delNode("f"));
      System.out.println(d.numEdges());
      System.out.println(d.numNodes());
      System.out.println(d.map);
      del Edge Test;
      System.out.println(d.delEdge("a", "b"));
      System.out.println(d.numEdges());
      System.out.println(d.delEdge("a", "b"));
      System.out.println(d.numEdges());
      System.out.println(d.delEdge("b", "z"));
      System.out.println(d.numEdges());
      System.out.println(d.delEdge("b", "f"));
      System.out.println(d.numEdges());
      System.out.println(d.delEdge("a", "c"));
      System.out.println(d.numEdges());
      System.out.println(d.delEdge("a", "d"));
      System.out.println(d.delEdge("b", "d"));
      System.out.println(d.delEdge("c", "d"));
      System.out.println(d.delEdge("d", "d"));
      System.out.println(d.delEdge("e", "d"));
      System.out.println(d.delEdge("a", "f"));
      System.out.println(d.delEdge("b", "f"));
      System.out.println(d.delEdge("c", "f"));
      System.out.println(d.delEdge("d", "f"));
      System.out.println(d.delEdge("e", "f"));
      System.out.println(d.delEdge("a", "e"));
      System.out.println(d.delEdge("b", "e"));
      System.out.println(d.delEdge("c", "e"));
      System.out.println(d.delEdge("d", "e"));
      System.out.println(d.delEdge("e", "e"));
      System.out.println(d.delEdge("c", "b"));
      System.out.println(d.numEdges()); */
    
   
    }
    public static void ShortestTest() {
    	DiGraph z = new DiGraph();
    	z.addNode(0, "ral");
    	z.addNode(4, "dur");
    	z.addNode(1, "pit");
  	z.addNode(7, "los");
  	z.addNode(3, "gra");
  	z.addNode(11, "cary");
    	z.addNode(36, "chap");
  	z.addNode(27, "hill");
  	z.addNode(5, "carr");
  	z.addNode(9, "sanf");
  	  z.addEdge(0, "ral", "dur", 14, null);
  	  z.addEdge(90, "dur", "hill", 9, null);
  	  z.addEdge(45, "chap", "gra", 25, null);
  	  z.addEdge(23, "chap", "carr", 1, null);
  	  z.addEdge(111, "carr", "cary", 32, null);
  	  z.addEdge(35, "cary", "ral", 3, null);
  	  z.addEdge(56, "pit", "cary", 17, null);
  	  z.addEdge(7, "pit", "sanf", 15, null);
  	  z.addEdge(2, "sanf", "los",3012, null);
  	  System.out.println(Arrays.toString(z.shortestPath("pit")));
    }
    public static void ShortestTest2() {
    	DiGraph v = new DiGraph();
    	v.addNode(0, "a");
    	v.addNode(3, "p");
    	v.addNode(5, "g");
    	v.addNode(7, "e");
    	/*
    	v.addEdge(0, "p", "a",10,null);
    v.addEdge(4, "p", "g",4,null);
    	v.addEdge(5, "a", "e",100,null);
    	v.addEdge(6, "a", "p",9,null);
    	v.addEdge(7, "e", "a",3,null);
    v.addEdge(8, "g", "a",15,null);
    v.addEdge(9, "p", "e",8,null);
    	v.addEdge(10, "g", "p",2,null);
     v.addEdge(1, "a", "g",12,null);
     v.addEdge(2, "g", "e",1,null);
     v.addEdge(3, "e", "p",6,null);*/
    	System.out.println(Arrays.toString(v.shortestPath("p")));
    }
  
}
