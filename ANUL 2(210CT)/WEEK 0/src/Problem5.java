import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;

public class Problem5 {

	public static void main(String...args){
		int day;
		int month;
		int year;
		int[] result=new int[2];
		BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Please enter the DAY/MONTH?YEAR AS DD/M/YYYY");
		try{
			day=Integer.parseInt(reader.readLine());
			month=Integer.parseInt(reader.readLine());
			year=Integer.parseInt(reader.readLine());
			result=howManyDaysHavePassed(day,month,year);
			for(int i=0;i<result.length;++i){
				if(i==0){
					System.out.println(result[i]+" Have passed");
				}
				else{
					System.out.println(result[i]+" Are left");
				}
			}
			
		}
		catch(Exception e){
			e.printStackTrace();
		}
		
	}
	
	
	public static int[] howManyDaysHavePassed(int day,int month,int year){
		HashMap<Integer,Integer> map=new HashMap<>();
		int[] daysPassedDaysRemainded=new int[2];
		int partialResult=0;
		if(year%4==0 || (year%100==0 && year%400==0)){
			map.put(2, 29);
			for(int i=1;i<=12;++i){
				if(i==2){
					continue;
				}
				else{
					if(i%2==0){
				    map.put(i,31);
					}
					else{
						map.put(i,30);
					}
				}
			}
		}
		else {
			map.put(2,28);
			for(int i=1;i<=12;++i){
				if(i==2){
					continue;
				}
				else{
					if(i%2==0){
				    map.put(i,31);
					}
					else{
						map.put(i,30);
					}
				}
			}
		}
		//Finding how many days are left +how may days have passed
		for(int i=1;i<=month;i++)
		{ 
			if(i!=month){
		partialResult+=map.get(i);
			}
		else{
			partialResult+=day;
			 daysPassedDaysRemainded[0]=partialResult;
			 if(map.get(2)==28){
				 partialResult=366-partialResult;
			 }
			 else{
				 partialResult=365-partialResult;
			 }
			 daysPassedDaysRemainded[1]=partialResult; 
		}
		}
	     return  daysPassedDaysRemainded;
		
	}
}
