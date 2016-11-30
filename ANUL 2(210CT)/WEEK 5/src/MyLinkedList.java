
public class MyLinkedList {
	Node head;
	int size;
	private class Node{
		protected int data;
		Node next;
		public Node(int data){
			this.data=data;
		}
		
	}
	public MyLinkedList(){
		head=null;
		size=0;
	}
	public void add(int data){
		Node newNode=new Node(data);
		if(head==null){
			head=newNode;
			size++;
			
		}
		else{
			Node currentNode=head;
			while(currentNode.next!=null){
				currentNode=currentNode.next;
			}
			currentNode.next=newNode;
			size++;
		}
		
	}
	public String delete(int data){
		if(head==null){
			return "list is empty";
		}
		else{
			
			if(head.data==data){
				Node tempNode=head.next;
				head.next=null;
				head=tempNode;
				size--;
				return "data deleted";
			}
			else{
				Node previousNode=head;
				Node currentNode=head.next;
				do{
					if(currentNode.data==data){
						previousNode.next=currentNode.next;
						currentNode.next=null;		
						size--;
					}
					previousNode=currentNode;
					currentNode=currentNode.next;
				}while(currentNode!=null);
				return "data is not in the list";
			}
		}
	}
	public int getLenght(){
		return this.size;
	}
	public String toString(){
		StringBuilder builder=new StringBuilder();
		Node currentNode=head;
		if(head==null){
			builder.append(" ");
			return builder.toString();
		}
		else{
			while(currentNode!=null){
				builder.append(currentNode.data+" ");
				currentNode=currentNode.next;
			}
		}
		return builder.toString();
		
	}
	
}
