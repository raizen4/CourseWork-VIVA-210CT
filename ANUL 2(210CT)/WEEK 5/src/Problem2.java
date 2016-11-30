
public class Problem2 {
	public static void main(String...args){
		MyLinkedList list=new MyLinkedList();
		list.add(3);
		list.add(5);
		list.add(7);
		System.out.println(list);
		list.delete(5);
		System.out.println(list);
		list.delete(3);
		System.out.println(list);
		list.add(5);
		list.add(10);
		System.out.println(list);
		list.delete(10);
		System.out.println(list);
		
		
	}
}
