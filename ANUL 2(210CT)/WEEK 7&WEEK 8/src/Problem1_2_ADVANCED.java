
public class Problem1_2_ADVANCED {
	
	public static void main(String...args){
		UnWeightedGraph graph=new UnWeightedGraph();
		graph.addNode(0);
		graph.addNode(1);
		graph.addNode(2);
		graph.addNode(3);
		graph.addNode(4);
		graph.addNode(5);
		graph.addNode(6);
		graph.addEdge(0, 2);
		graph.addEdge(0, 3);
		graph.addEdge(1, 3);
		graph.addEdge(1, 4);
		graph.addEdge(2, 3);
		graph.addEdge(2, 4);
		graph.addEdge(5, 6);
		graph.showGraph();
		graph.DFS(4);
		System.out.println();
		graph.DFS(2);
		System.out.println();
		graph.BFS(4);
		System.out.println();
		System.out.println(graph.isPath(0, 1));
		System.out.println(graph.isStronglyConnected());
		
		
	}
}
