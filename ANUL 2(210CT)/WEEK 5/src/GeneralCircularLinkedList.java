

public class GeneralCircularLinkedList {
		@SuppressWarnings("rawtypes")
		Node head;
		@SuppressWarnings("rawtypes")
		Node tail;
		int size;

		private class Node {
			String data;
			Node nextNode;

			public Node(String data) {
				this.data = data;
			}
			
		}

		public GeneralCircularLinkedList() {
			this.head = null;
			this.tail = null;
			this.size = 0;
		}

		public void add(String data) {
			/*
			 * casses: 1)list empty 2)list not empty
			 */
			Node node = new Node(data);
			if (head == null) {
				head = node;
				head.nextNode=head;
				size++;

			} else {
				Node previousNode;
				Node currentNode = head;
				do{ previousNode=currentNode;
					currentNode = currentNode.nextNode;
				}while(currentNode!=head);
				previousNode.nextNode=node;
				tail=node;
				node.nextNode=head;
				size++;
			}

		}

		public Node find(String data) { /*
									 * casses: 1)element is the head 2)element is in
									 * the fucking list 3)element is not in the list
									 */
			Node traversenode = head;
			if (traversenode.data.matches( data)) {
				System.out.println("Element " + data + " has been found in the list");
				return traversenode;
			} else {
				while (traversenode.nextNode!=head) {
					traversenode = traversenode.nextNode;
					if (traversenode.data.matches(data)) {
						System.out.println("Element " + data + " has been found in the list");
						return traversenode;
					}
				}
			}
			return null;

		}

		public int getsize() {
			return size;
		}

		public String toString(){
			StringBuilder builder=new StringBuilder();
			Node currentNode=head;
			if(head==null){
				builder.append(" ");
				return builder.toString();
			}
			else{
				do{
					builder.append(currentNode.data+" ");
					
					currentNode=currentNode.nextNode;
				}while(currentNode!=head);
			}
			return builder.toString();
			
		}
		

		public void remove(String data) {
			/*
			 * casses: 1)remove first element 2)remove an random element 3)remove
			 * the last element
			 */
			if (head.data.matches( data)) {
				Node temp=head.nextNode;
				head.nextNode=null;
				head=temp;
				tail.nextNode=head;
				size--;
			} 
			  else {
				   Node currentNode=head;
				   Node previousNode;
				 
				  do
				   {   previousNode=currentNode;
					   currentNode=currentNode.nextNode;
				   }while(  currentNode!=head && !(currentNode.data.matches(data)));
				   if(currentNode==head)
				   { System.out.println("element "+ data+" not in the list");}
				   else{
					   if(currentNode==tail){
						   tail=previousNode;
					   }
					   Node temp=currentNode.nextNode;			   
					   previousNode.nextNode=temp;
					   currentNode.nextNode=null;
					   size--;
				   }
	          
			}

		}
		
		
		public void removeNthElement(String nameToStart){
			int indexToRemove=this.size;
			int currentIndex=1;
			Node nodeToStartFrom=this.find(nameToStart);
			Node currentNode=nodeToStartFrom;
			while(this.size>1){
				currentNode=currentNode.nextNode;
				currentIndex++;
				if(currentIndex%indexToRemove==0){
					
					if(currentNode.data.matches(nodeToStartFrom.data)){
						nodeToStartFrom=currentNode.nextNode;
						this.remove(currentNode.data);
						currentNode=nodeToStartFrom;
						currentIndex=1;
					}
					else{
						this.remove(currentNode.data);
						currentNode=nodeToStartFrom;
						currentIndex=1;
						
					}
				}
			}
			System.out.println("Winner is "+ this.toString());
			
			
		}
	}

