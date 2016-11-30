
public class Problem1_WEEK8_DIJKSTRA {

	
	public static void main(String...args){
		WeightedGraph graph=new WeightedGraph();
		graph.addNode(0);
		graph.addNode(1);
		graph.addNode(2);
		graph.addNode(3);
		graph.addNode(4);
		graph.addNode(5);
		graph.addEdge(0, 1,1);
		graph.addEdge(1, 2,5);
		graph.addEdge(2, 4,1);
		graph.addEdge(4, 3,3);
		graph.addEdge(3, 1,4);
		graph.addEdge(3, 0,6);
		graph.addEdge(2, 0,2);
		graph.addEdge(0, 3,3);
		graph.addEdge(4, 5, 6);
		graph.showGraph();
		graph.DijkstraSearch(3, 5);
		
	}
}
