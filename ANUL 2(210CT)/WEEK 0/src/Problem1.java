
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Problem1 {

	public static void main(String[] args) {
		float a=0,b = 0,c=0,d=0;
		float fractionAonB,fractionConD;
		BufferedReader scanner = new BufferedReader(new InputStreamReader(System.in));
	
		
		System.out.println("Please enter the three numbers a,b,c");
		try{
			
			a=Float.parseFloat(scanner.readLine());
			b=Float.parseFloat(scanner.readLine());
			c=Float.parseFloat(scanner.readLine());
			d=Float.parseFloat(scanner.readLine());
			System.out.println(a);
			System.out.println(b);
			System.out.println(c);
			System.out.println(d);
			System.out.println("------------------------");
			
	}
		catch(Exception e){
			e.printStackTrace();
		}
		fractionAonB=(a/b);
		fractionConD=c/d;
		if(fractionAonB>fractionConD){
			System.out.println(a+"\n"+"===="+"\n"+b+" is bigger");
			System.out.println(fractionAonB);
			
		}
		else{
			System.out.println(c+"\n"+"===="+"\n"+d+" is bigger");
			System.out.println(fractionConD);
		}
		
  }
}
