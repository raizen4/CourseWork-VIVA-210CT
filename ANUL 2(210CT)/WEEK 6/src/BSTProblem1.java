
public class BSTProblem1 {
	Node root;
	int size;
	class Node{
		int data;
		Node parent;
		Node leftC;
		Node rightC;
		boolean visited=false;
		
		public Node(int data){
			this.data=data;
			this.leftC=null;
			this.rightC=null;
			this.parent=null;
		}
	}
	public BSTProblem1(){
		root=null;
		size=0;
	}
	
	public void add(int data){
		findPlace(null,root,data,null);
		
	}
	
	
	public void inOrderIterative(){
		Node currentNode=root;
		if(root==null){
			System.out.println("Tree empty");
		}
		else{
			boolean flagToBacktrackBackToTheLastVisitedNode=false;
			while(currentNode!=null){
				if(currentNode.visited==true){
					//backtrack
					currentNode=currentNode.parent;
					continue;
				}
				
				while(currentNode.leftC!=null && !currentNode.leftC.visited){
					currentNode=currentNode.leftC;
				}
				System.out.print(currentNode.data+" ");
				currentNode.visited=true;
				while(currentNode.rightC!=null  && !currentNode.rightC.visited){
					currentNode=currentNode.rightC;
					if(currentNode.leftC==null &&currentNode.rightC!=null){
						/*this case comes when i go on the right subtree of the root and the entire right subtree is basically a linked list.
						I have in this case to print each node as i go in the right subtree.
						*/
						System.out.print(currentNode.data+" ");
						currentNode.visited=true;
						currentNode=currentNode.rightC;
						//variable to signal that after i get out of this loop i will have to backtrack to the last known unvisited node
						flagToBacktrackBackToTheLastVisitedNode=true;
					}
					if(currentNode.leftC!=null){
						/*this case comes when for a specific node i still have a lesser node than that(on the right subtree). 
						 * in this case i just go on that node and break this while so i can output the node
						 */
						currentNode=currentNode.leftC;
						break;
					}
				}
				if(flagToBacktrackBackToTheLastVisitedNode==true){
					flagToBacktrackBackToTheLastVisitedNode=false;
					//now go back in the main condition and backtrack to the last unvisited node
					continue;
				}
				if(currentNode.visited==true){
					continue;
				}
				else{
				System.out.print(currentNode.data+" ");
				currentNode.visited=true;
				}
			}
		}
	}
	
	private Object findPlace(Node parentNode,Node currentNode,int data,String where){
	    if(currentNode==null && parentNode==null){
	    	Node newNode=new Node(data);
	    	root=newNode;
	    	size++;
	    	return null;
	    }
	    else if(currentNode==null){
			Node newNode=new Node(data);
			currentNode=newNode;
			currentNode.parent=parentNode;
			if(where.matches("left")){
			parentNode.leftC=currentNode;
			}
			else if(where.matches("right")){
				parentNode.rightC=currentNode;
			}
			size++;
			return null;
		}
		else{
			if(data>currentNode.data){
				 findPlace( currentNode,currentNode.rightC,data,"right");
			}
			else if(data<currentNode.data){
				 findPlace(currentNode,currentNode.leftC,data,"left");
			}
		}
		return null;
	}
	
	
}
