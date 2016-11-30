import java.io.BufferedReader;
import java.io.InputStreamReader;
/*PSEUDOCODE of function checkForSquare
 * 
 * int[] checkForSquare(int numberToCheckFor)
 * 		int numberFound<-null;
 * 		for i from 0 to numberToCheckFor
 * 			if (i*i)>numberToCheck
 * 				 numberFound <-(i-1)*(i-1)
 * 				return new array which contains i and numberFound
 * 			if (i*i)=numberToCheck
 * 			      numberFound <-i*i
 * 				return new array which contains i and numberFound
 * 		return null
 * 
 *
 * 
 */
public class Problem1 {

	public static void main(String...args){
		int numberToSearchPerfectSquareOf=0;
		int[] numberFound=new int[2];
		BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
		System.out.println("enter the number.I will show you the biggest square number less than this number");
		try{
		numberToSearchPerfectSquareOf=Integer.parseInt(reader.readLine());
		}
		catch(Exception e){
			e.printStackTrace();
		}
		numberFound=checkForSquare(numberToSearchPerfectSquareOf);
		System.out.println("the perfect square i found was "+numberFound[0]+" which means "+ numberFound[1] );
	}
	
	public static int[] checkForSquare(int numberToCheck){
		int numberFound;
		for(int i=0;i<numberToCheck;++i){
			if(i*i>numberToCheck){
				 numberFound=(i-1)*(i-1);
				return new int[]{i-1,numberFound};
			}
			else{
				if(i*i==numberToCheck){
					 numberFound=(i)*(i);
					return new int[]{i,numberFound};
				}
			}
		}
		return null;
	}
}
