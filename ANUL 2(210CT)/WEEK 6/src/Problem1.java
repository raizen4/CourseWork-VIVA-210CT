
public class Problem1 {
	public static void main(String...args){
		BSTProblem1  test=new BSTProblem1();
		test.add(10);
		test.add(7);
		test.add(5);
		test.add(9);
		test.add(33);
		test.add(11);
		test.add(6);
		test.inOrderIterative();
		System.out.println();
		BSTProblem1  test1=new BSTProblem1();
		test1.add(10);
		test1.add(5);
		test1.add(7);
		test1.add(9);
		test1.add(6);
		test1.add(11);
		test1.add(33);
		test1.add(12);
		test1.add(13);
		test1.add(44);
		test1.add(43);
		test1.add(46);
		test1.add(45);
		test1.add(50);
		test1.inOrderIterative();
	}
 
 
}
