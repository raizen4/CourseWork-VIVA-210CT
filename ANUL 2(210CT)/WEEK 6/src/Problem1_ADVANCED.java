
public class Problem1_ADVANCED {
	public static void main(String...args){
		BST_ADVANCED test=new BST_ADVANCED();
		test.add("Paula", 100000);//499
		test.add("Cocolino", 10);//822
		test.add("this", 7);//440
		test.add("Angmar", 6);//598
		test.add("Sauron", 20);//632
		test.showPreorder();
		test.findANode("Gogomanu");
	}
}
