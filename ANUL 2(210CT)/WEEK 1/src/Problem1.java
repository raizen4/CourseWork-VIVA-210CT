import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Random;

public class Problem1 {

	public static void main(String...args){
		BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
		ArrayList<Integer> arrayToModify=new ArrayList<>();
		System.out.println("Please enter the numbers in the array.Enter finish when you are done");
		try {
			String lane=reader.readLine();
			while(!(lane.matches("finish"))){
				arrayToModify.add(Integer.parseInt(lane));
				lane=reader.readLine();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println(arrayToModify.size());
		for(int d=0;d<5;++d){
			shuffleIt(arrayToModify);
			for(int j=0;j<arrayToModify.size();++j){
				System.out.println(arrayToModify.get(j));
			}
			System.out.println("====================");
		}
	}
	//Durstenfeld algorithm(a modern variant of Fisher-Yates). You basically go through the entire array(let's say a) 
	//and for each i in the array, you choose a random integer j(such that i<=j<n(where n is the lenght)) 
	//which is the position with who you will change i( swap(a[i] with a[j]).
	//It is an in-place algorithm which has a O(n) time complexity and constant O(1) space complexity.
	public static void shuffleIt(ArrayList<Integer> arrrayToShuffle){
		int temp=0;
		Random random=new Random();
		int lenght=arrrayToShuffle.size();
	    for(int i=0;i<lenght-1;++i){
	    	temp=arrrayToShuffle.get(i);
	    	int randomInteger=i+random.nextInt((lenght-1)-i+1);
	    	arrrayToShuffle.set(i,arrrayToShuffle.get(randomInteger));
	    	arrrayToShuffle.set(randomInteger, temp);
	    	
	    	
	    	
	    }
	}
}
