import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Problem1_ADVANCED {

	
	public static void main(String...args) throws IOException{
		BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
		ArrayList<Cube> listOfOriginalCubes=new ArrayList<>();
		ArrayList<Cube> tower=new ArrayList<>();
		int howManyCubesDoesUserWant=0,howManyCubesDoesUserEntered=0;
		int length;
		String color;
		System.out.println("Enter how many cubes do you want");
		howManyCubesDoesUserWant=Integer.parseInt(reader.readLine());
		while(howManyCubesDoesUserEntered!=howManyCubesDoesUserWant){
			System.out.println("Enter the cube number"+howManyCubesDoesUserEntered);
			System.out.print("Enter the length ");
			length=Integer.parseInt(reader.readLine());
			System.out.println();
			System.out.print("Enter the color ");
			color=reader.readLine();
			System.out.println();
			Cube newCube=new Cube(length,color);
			listOfOriginalCubes.add(newCube);
			howManyCubesDoesUserEntered++;
		}
		returnNextMaxCubeOfDifferentColor(listOfOriginalCubes,tower);
		for(Cube cube:tower){
			System.out.print(cube.getLength()+" "+cube.getColor());
			System.out.println();
			
		}
	}
	
	public static ArrayList<Cube> returnNextMaxCubeOfDifferentColor(ArrayList<Cube> array,ArrayList<Cube> arrayOfTowers){
		int max=-36000;
		Cube cubeMax=null;
		for(Cube cube:array){
			if(cube.getLength()>max && arrayOfTowers.size()==0){
				max=cube.getLength();
				cubeMax=cube;
			}
			else{
			if(cube.getLength()>max && !(cube.getColor().matches(arrayOfTowers.get(arrayOfTowers.size()-1).getColor())) 
					&& cube.getLength()<arrayOfTowers.get(arrayOfTowers.size()-1).getLength()){
				max=cube.getLength();
				cubeMax=cube;
			}
			}
		}
		if(cubeMax!=null){
			arrayOfTowers.add(cubeMax);
			array.remove(cubeMax);
			return returnNextMaxCubeOfDifferentColor(array,arrayOfTowers);
		}
		else{
			return arrayOfTowers;
		}
		
	}
}

