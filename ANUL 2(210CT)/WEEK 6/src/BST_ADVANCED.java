

public class BST_ADVANCED {
	Node root;
	int size;
	class Node{
		int key;
		String data;
		Node parent;
		Node leftC;
		Node rightC;
		int frequency=0;
		
		public Node(String data,int freq){
			this.key=getKeyForString(data);
			this.data=data;
			this.leftC=null;
			this.rightC=null;
			this.parent=null;
			this.frequency=freq;
		}
	}
	public BST_ADVANCED(){
		root=null;
		size=0;
	}
	
	public void add(String data,int freq){
		int key=getKeyForString(data);
		findPlace(null,root,data,key,freq,null);
	}
	public void showPreorder(){
		show(root);
	}
	
	public void findANode(String data){
		int howManyMoveDidItTakeToGetToTheResult=0;
		int keyToLookFor=getKeyForString(data);
		Node currentNode=root;
		if(root==null){
			System.out.println("Tree empty");
		}
		else{
			howManyMoveDidItTakeToGetToTheResult++;
			System.out.print(root.data+" ");
			while(currentNode!=null && currentNode.key!=keyToLookFor){
				if(keyToLookFor>currentNode.key){
					currentNode=currentNode.rightC;
					howManyMoveDidItTakeToGetToTheResult++;
					if(currentNode==null)
						break;
					System.out.print(currentNode.data+" ");
				}
				else if(keyToLookFor<currentNode.key){
					currentNode=currentNode.leftC;
					howManyMoveDidItTakeToGetToTheResult++;
					if(currentNode==null)
						break;
					System.out.print(currentNode.data+" ");
				}
			}
				if(currentNode!=null &&currentNode.key==keyToLookFor){
					System.out.print("|"+currentNode.data+" found."+" It took the algorithm "+
				howManyMoveDidItTakeToGetToTheResult+" steps to get to the node");
					
				}
				else{
					System.out.print("| Not found");
				}
			}
		}
	
	private void show(Node currentNode){
		if(currentNode==root && root==null){
			System.out.println("Tree empty");
		}
		else if(currentNode==null){
			return;
		}
		else{
			show(currentNode.rightC);
			System.out.println(currentNode.data+" appears "+currentNode.frequency+" times");
			show(currentNode.leftC);
		}
	}
	private int getKeyForString(String string){
		char[] letters=string.toCharArray();
		int partialKey=0;
		for(char letter:letters){
			partialKey+=(int) letter;
		}
		return partialKey;
	}
	private Object findPlace(Node parentNode,Node currentNode,String data,int key,int freq,String where){
	    if(currentNode==null && parentNode==null){
	    	Node newNode=new Node(data,freq);
	    	root=newNode;
	    	size++;
	    	return null;
	    }
	    else if(currentNode==null){
			Node newNode=new Node(data,freq);
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
			if(key>=currentNode.key){
				 findPlace( currentNode,currentNode.rightC,data,key,freq,"right");
			}
			else if(key<currentNode.key){
				 findPlace(currentNode,currentNode.leftC,data,key,freq,"left");
			}
		}
		return null;
	}
}
