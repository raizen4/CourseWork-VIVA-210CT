import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Problem1_ADVANCED {
	
	
	
	public static void main(String...args){
		int howManyEgsDoesEachAlienLayDaily=0;
		int afterHowManyDaysDoEggsHatch=0;
		int numberOfDays=0;
		int[] arrayOfDaysAndAliens;
		BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Tell me how many egs does each alien lay daily, after how much time do the eggs"
				+ " hatch and also the number of days you want to count to see how many aliens are then");
		System.out.println("NOTICE!!!!!:the indexes begin from 0,so add 1 from the number of days you want,say you want day 30,type 31");
		try{
			howManyEgsDoesEachAlienLayDaily=Integer.parseInt(reader.readLine());
			afterHowManyDaysDoEggsHatch=Integer.parseInt(reader.readLine());
			numberOfDays=Integer.parseInt(reader.readLine());
			
		}
		catch(Exception e){
			e.printStackTrace();
		}
		arrayOfDaysAndAliens=new int[numberOfDays];
		for(int i=0;i<arrayOfDaysAndAliens.length;++i){
			if(i-afterHowManyDaysDoEggsHatch<1){
				arrayOfDaysAndAliens[i]=1;
			}
			else {
					arrayOfDaysAndAliens[i]+=(arrayOfDaysAndAliens[i-afterHowManyDaysDoEggsHatch]*howManyEgsDoesEachAlienLayDaily)
							+arrayOfDaysAndAliens[i-1];
				}
				
				
			
			System.out.print("Result for position "+i+" is "+arrayOfDaysAndAliens[i]+" ");
			}	
	}
	
}
