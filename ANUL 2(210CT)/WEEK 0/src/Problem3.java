import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Problem3 {

	
	public static void main(String...args){
		float x=0;
		int result=0;
		BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Please enter the number");
		try {
			x=Float.parseFloat(reader.readLine());
		} catch (NumberFormatException | IOException e) {
			e.printStackTrace();
		}
		int intNumber=intNumber=Integer.parseInt(String.valueOf(x).substring(0, 1));
		if(intNumber<-2){
			result=(int) (Math.pow(intNumber, 2)+4*intNumber+4);
	
		}
		else if(intNumber==0){
			result=0;
		}
		else if(x>-2){
			result=(int) Math.pow(intNumber, 2)+5*intNumber;
		}
		System.out.println("the result is "+result);
	}
}
