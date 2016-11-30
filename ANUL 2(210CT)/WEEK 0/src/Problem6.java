import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Problem6 {

	
	public static void main(String...args) throws NumberFormatException, IOException{
		int maxPosition=0, max=-36000,minPosition=0,min=36000;
		ArrayList<Integer> inputList=new ArrayList<>();
		BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Please eneter as many numbers as you want. When you are done type finish");
		String line;
		boolean shouldContinue=true;
		while(shouldContinue){
			line=reader.readLine();
			if(line.matches("finish")){
				shouldContinue=false;
				continue;
			}
			else{
			inputList.add(Integer.parseInt(line));
			}
		
		}
		for(int i=0;i<inputList.size();++i){
			if(inputList.get(i)>max){
				max=inputList.get(i);
				maxPosition=i;
			}
			if(inputList.get(i)<min){
				min=inputList.get(i);
				minPosition=i;
			}
		}
		System.out.println("Min of the array is "+min+" and it is on position"+ minPosition+" and the max of the array is "
				+max+" and it is on the positon "+ maxPosition);
		
	}
}
