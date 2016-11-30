import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Problem2 {
	static int howManyZerosShouldBeShown=0;
	public static void main(String...args){
		int factorial=0;
		int copyOfFactorial=0;
		boolean shouldRun=true;
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Please enter the factorial whose number of  trailing 0's you want to see");
		try {
			factorial=Integer.parseInt(reader.readLine());
			copyOfFactorial=factorial;
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		while(shouldRun){
			if(factorial<5){
				howManyZerosShouldBeShown=0;
				shouldRun=false;
			}
			else if(factorial<25){
				howManyZerosShouldBeShown=factorial/5;
				shouldRun=false;
				
			}
			else{
				howManyZerosForBigFactorials(copyOfFactorial);
				shouldRun=false;
			}
	
		}
		if(howManyZerosShouldBeShown==0){
			 System.out.println("The number has no trailing 0's");
		}
		else{
			for(int i=0;i<howManyZerosShouldBeShown;++i){
				   System.out.print(0);
			   }
		}
	}
	
	public static int howManyZerosForBigFactorials(int number){
		if(number%5!=0 && number/5==0){
			return howManyZerosShouldBeShown;
		}
		else{
			howManyZerosShouldBeShown+=number/5;
			return howManyZerosForBigFactorials(number/5);
		}
		
	}

}
