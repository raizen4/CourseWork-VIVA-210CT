import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class CodeChallange {

	public static void main(String...args) throws NumberFormatException, IOException{
		int numberOfGenerations=0;
		BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
		String[][] arrayOfFlowers=new String[5][5];
		System.out.println("Enter the initial state of the garden");
		for(int i=0;i<5;++i){
			for(int j=0;j<5;++j){
				System.out.println("Enter the element "+i+" "+j+":");
					arrayOfFlowers[i][j]=reader.readLine();
			}
		}
		for(int i=0;i<5;++i){
			for(int j=0;j<5;++j){
				System.out.print(arrayOfFlowers[i][j]+" ");	
			}
			System.out.println();
		}
		System.out.println("Enter how many generations do you want");
		numberOfGenerations=Integer.parseInt(reader.readLine());
		
	}
	
	public static void transformGarden(String[][] gardenToTransform,int numberOfStepsForward){
		for(int i=1;i<=numberOfStepsForward;++i){
			for(int row=0;row<5;row++){
				for(int column=0;column<5;column++){
					if(gardenToTransform[row][column].matches("F")){
						gardenToTransform[row][column]="H";
					
					}
					else if(gardenToTransform[row][column].matches("I")){
						gardenToTransform[row][column]="F";
						if(row==0 && column==0){
							if()
						}
					}
					else if(gardenToTransform[row][column].matches("F"));
				}
			}
		}
		
	}
	
	public int[] checkNeighbours(int row,int column){
		boolean left=true,below=true,above=true,right=true;
		int[] neighbourValues=new int[4];
		if(row-1<0 ){
			above=false;
		}
		else if(row+1>4){
			below=false;
		}
		if(column+1>4){
			right=false;
		}
		else if(column-1<0){
			left=false;
		}
		
	}
}
