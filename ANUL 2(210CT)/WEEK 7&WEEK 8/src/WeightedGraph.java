import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.PriorityQueue;

public class WeightedGraph {

	ArrayList<Node> listOfNodes;
	
	 class Node{
		int data;
		HashMap<Node,Integer> relatedNodesAndWeights;
		
		public Node(int data){
			this.data=data;
			relatedNodesAndWeights=new HashMap<>();
		}
	}
	public WeightedGraph(){
		listOfNodes=new ArrayList<>();
	}
	
	public void addEdge(int from_vertex,int to_vertex,int weight){
		Node nodeFromVertex=listOfNodes.get(from_vertex);
		Node nodeToVertex=listOfNodes.get(to_vertex);
		nodeFromVertex.relatedNodesAndWeights.put(nodeToVertex, weight);
		
		
	}
	public void addNode(int data){
		Node newNode=new Node(data);
		listOfNodes.add(newNode);
	}
	public void getRelatedNodes(int vertex){
		Node node=listOfNodes.get(vertex);
		for(Node relatedNode: node.relatedNodesAndWeights.keySet()){
			System.out.print(relatedNode.data+" ");
		}
	}
	
	public ArrayList<Node>getNeighbourForThisNode(Node nodeToRetrieveNeighboursFor){
		ArrayList<Node> neighbours=new ArrayList<>();
		for(Node neighbour:nodeToRetrieveNeighboursFor.relatedNodesAndWeights.keySet()){
			neighbours.add(neighbour);
		}
		return neighbours;
	}
	
	public void printPath(HashMap<Node,Node>pathTraversed,Node startNode,Node endNode){
		//create a empty array
		ArrayList<Node> path=new ArrayList<>();
		//begin with the end of the hashMap so we will finish by adding the path traversed reversed
		Node current=endNode;
		path.add(current);
		while(current!=startNode){
			//as long as we haven t reached the start node go to the parent of the current node and add it to the list
			current=pathTraversed.get(current);
			path.add(current);
		}
		//print the list normally, from the first index to the last
		System.out.print("Path is: ");
		for(int i=path.size()-1;i>=0;--i){
			System.out.print(path.get(i).data+" ");
		}
		
	}
	
	public void DijkstraSearch(int vertexToBegin,int vertexToEnd){
		//create an hashmap which will keep track of the path that will be traversed
		HashMap<Node,Node> cameFrom=new HashMap<>();
		//create a hashmap which will keep track of the lowest cost for each node
		HashMap<Node,Integer> costSoFar=new HashMap<>();
		//a comparator for the priority queue needed because the priority queue default comparator didn't know how to compare to nodes
		Comparator <Node> comparator=new comparatorForPriorityQueue();
		//the priority queue in which we will have all discovered nodes that wait to be visited based on their cost from the root
		PriorityQueue<Node> frontier=new PriorityQueue<>(comparator);
		Node nodeToBegin=listOfNodes.get(vertexToBegin);
		Node nodeToEnd=listOfNodes.get(vertexToEnd);
		costSoFar.put(nodeToBegin, 0);
		cameFrom.put(nodeToBegin, null);
		frontier.add(nodeToBegin);
		Node current=null;
		while (!frontier.isEmpty()){
			 current=frontier.poll();
			if (current==nodeToEnd)
					break;
			for (Node nextNeighbour: getNeighbourForThisNode(current)){
				int new_cost=costSoFar.get(current)+current.relatedNodesAndWeights.get(nextNeighbour);
				if(!cameFrom.containsKey(nextNeighbour) || new_cost<costSoFar.get(nextNeighbour)){//if we haven t already visited that node or the new cost for that node is less than the current best cost for that node
					costSoFar.put(nextNeighbour, new_cost);
					frontier.add(nextNeighbour);
					cameFrom.put(nextNeighbour, current);
				}
			}
		}
		if(current!=nodeToEnd){
			System.out.println("No path found between these vertices");
			
		}
		else{
			printPath(cameFrom,nodeToBegin,nodeToEnd);
		}
	}
	
	public void showGraph(){
		for(Node node:listOfNodes){
			System.out.print(node.data+": ");
			for(Node relatedNode:node.relatedNodesAndWeights.keySet()){
				System.out.print(relatedNode.data+"("+node.relatedNodesAndWeights.get(relatedNode)+")"+" ");
				
			}
			System.out.println();
		}
	}
}
