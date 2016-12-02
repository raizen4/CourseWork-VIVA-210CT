import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Stack;
/*class UnWeightedGraph
	listOfNodes;
	Constructor UnWeightedGraph()
		listOfNodes<- Initialize the arrayList which is of type Node
	
	Function addEdge(from_vertex,to_vertex)
		nodeFromVertex<-get the node with the index "from_vertex" from the listOfNodes
		nodeToVertex<-get the node with the index "to_vertex" from the listOfNodes
		add the nodeToVertex to the list of nodeFromVertex
		add the nodeFromVertex to the list of nodeToVertex
		
		
	Function addNode(data)
		newNode<-create a new node;
		add the newNode to the listOfNodes of the graph 
		
		
	Function getRelatedNodes(index)
			node<-get the node whose index you want to get the relatedNodes of
			for each relatedNode in the  node.relatedNodes
				print the value of that node
				
 	Funtion showGraph()
		for each node in listOfNodes
			print node.data
			for each relatedNode in the node.relatedNodes
				print relatedNode.data
			}
			print empty lane
		}
	}
*/
/*class Node
	relatedNodes
	data
	Constructor Node(value)
		data<-value
		relatedNodes<- create a new arrayList of the type Node
*/
public class UnWeightedGraph {
	ArrayList<Node> listOfNodes;
	public class Node{
		ArrayList<Node> relatedNodes;
		int data;
		public Node(int value){
			data=value;
			relatedNodes=new ArrayList<>();
		}
	}
	
	public UnWeightedGraph(){
		this.listOfNodes=new ArrayList<>();
	}
	
	public void addEdge(int from_vertex,int to_vertex){
		Node nodeFromVertex=listOfNodes.get(from_vertex);
		Node nodeToVertex=listOfNodes.get(to_vertex);
		nodeFromVertex.relatedNodes.add(nodeToVertex);
		nodeToVertex.relatedNodes.add(nodeFromVertex);
		
	}
	public void addNode(int data){
		Node newNode=new Node(data);
		listOfNodes.add(newNode);
	}
	public void getRelatedNodes(int index){
		Node node=listOfNodes.get(index);
		for(Node relatedNode: node.relatedNodes){
			System.out.print(relatedNode.data+" ");
		}
	}
	
	public void showGraph(){
		for(Node node:listOfNodes){
			System.out.print(node.data+": ");
			for(Node relatedNode:node.relatedNodes){
				System.out.print(relatedNode.data+" ");
			}
			System.out.println();
		}
	}
	public void DFS(int whereToBeginFrom){
		boolean[] arrayOfVisitedNodes=new boolean[listOfNodes.size()];
		for(int i=0;i<arrayOfVisitedNodes.length;i++){
			arrayOfVisitedNodes[i]=false;
		}
		dfs(whereToBeginFrom,arrayOfVisitedNodes);
	}
	public void BFS(int whereToBeginFrom){
		LinkedList<Node>queue=new LinkedList<>();
		bfs(whereToBeginFrom,new boolean[listOfNodes.size()],queue);
	}
	
	public String isStronglyConnected(){
		for(int vertex1=0;vertex1<listOfNodes.size();++vertex1){
			for(int vertex2=0;vertex2<listOfNodes.size();++vertex2){
				if(vertex1==vertex2){
					continue;
				}
				else{
					if(isPath(vertex1,vertex2)==null){
						return"NO";
					}
				}
			}
		}
		return "YES";
	}
	
	public ArrayList<Integer> isPath(int vertex1,int vertex2){
		boolean[] booleanArray=new boolean[listOfNodes.size()];
		LinkedList<Node>queue=new LinkedList<>();
		boolean found=false;
		ArrayList<Integer> path=new ArrayList<>();
		queue.add(listOfNodes.get(vertex1));
		booleanArray[vertex1]=true;
		while(queue.size()!=0){
			Node currentNode=queue.poll();
			if(listOfNodes.indexOf(currentNode)==vertex2)
			{	found=true;
				path.add(currentNode.data);
				System.out.print("Path found ");
				break;
			}
			path.add(currentNode.data);
			for(Node relatedNode:currentNode.relatedNodes){
				if(booleanArray[listOfNodes.indexOf(relatedNode)]!=true){
					booleanArray[listOfNodes.indexOf(relatedNode)]=true;
					queue.add(relatedNode);
					
				}
			}
			
		}
		if(found==true){
		try{
    			PrintWriter writer = new PrintWriter("the-file-name.txt", "UTF-8");
   			writer.println(path.toString);
    			writer.close();
			} catch (IOException e) {}
		return path;
		
		}
		else{
			System.out.println("There is no path between these vertices");
			return null;
		}
	}
	private void bfs(int index, boolean[]booleanArray,LinkedList<Node> currentQueue){
		currentQueue.add(listOfNodes.get(index));
		booleanArray[index]=true;
		while(currentQueue.size()!=0){
			Node currentNode=currentQueue.poll();
			System.out.print(currentNode.data+" ");
			for(Node relatedNode:currentNode.relatedNodes){
				if(booleanArray[listOfNodes.indexOf(relatedNode)]!=true){
					booleanArray[listOfNodes.indexOf(relatedNode)]=true;
					currentQueue.add(relatedNode);
					
				}
			}
			
		}
	}
	private void dfs(int index,boolean[]booleanArray){
		Node currentNode=listOfNodes.get(index);
		if(booleanArray[index]==true){
			return;
		}
		else{
		System.out.print(currentNode.data+" ");
		booleanArray[index]=true;
		for(Node relatedNode:currentNode.relatedNodes){
			int indexOfRelatedNode=listOfNodes.indexOf(relatedNode);
			if(booleanArray[indexOfRelatedNode]==false){
				dfs(indexOfRelatedNode,booleanArray);
			}
		}
		
		}
	
	}
}
