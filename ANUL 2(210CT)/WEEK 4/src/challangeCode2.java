import java.util.ArrayList;

public class challangeCode2 {

	public static void main(String...args) throws InterruptedException{
		int[][]matrix=new int[][]
				{
			{1,3,5,7},
			{4,2,9,6},
			{3,6,4,2},
			{6,4,1,9},
				};
		int[][]matrix2=new int[][]
			{
				{1,3,2,4,3},
				{0,7,6,2,1},
				{7,5,4,4,3},
				{7,2,2,2,4},
				{0,1,0,5,8},
			};
				findAllPaths(matrix,1,2,matrix[1][2],-1,new ArrayList<Integer>());
				System.out.println("---------------------------");
				findAllPaths(matrix2,1,2,matrix2[1][2],-1,new ArrayList<Integer>());
		
	}
	
	public static void findAllPaths(int[][]matrix,int x,int y,int initialElevation,int currentElevation,ArrayList<Integer>listOfPaths) throws InterruptedException{
		if(currentElevation==-1){
			currentElevation=initialElevation;
		}
		if((x+1>matrix.length-1 || x-1<0) || (y+1>matrix[0].length-1 || y-1<0)){
			listOfPaths.add(currentElevation);
			System.out.print(listOfPaths);
			System.out.println(" end");
			listOfPaths.remove(listOfPaths.size()-1);
			Thread.sleep(1000);
			return;
		}
		else{
			
			ArrayList<int[]> list=new ArrayList<>();
			list=giveMeValidNeighbours(matrix,x,y,currentElevation);
			if(list.isEmpty()){
				listOfPaths.remove(listOfPaths.size()-1);
				return ;
			}
			else{
				
			for(int[] index:list){
				if(!listOfPaths.contains(initialElevation)){
					listOfPaths.add(initialElevation);
				}
				else{
				listOfPaths.add(currentElevation);
				}
				findAllPaths(matrix,index[1],index[2],initialElevation,index[0],listOfPaths);
				if(listOfPaths.size()-1>=0)
					listOfPaths.remove(listOfPaths.size()-1);
			}
			
			return ;
			}
		}
		
	}
	
	public static   ArrayList<int[]> giveMeValidNeighbours(int[][]matrix,int x,int y,int currentElevation){
		ArrayList<int[]> list=new ArrayList<>();
		
		if(matrix[x+1][y]<currentElevation){
			list.add(new int[]{matrix[x+1][y],x+1,y});
		}
		if(matrix[x-1][y]<currentElevation)
			list.add(new int[]{matrix[x-1][y],x-1,y});
		if(matrix[x][y-1]<currentElevation){
			list.add(new int[]{matrix[x][y-1],x,y-1});
		}
		if(matrix[x][y+1]<currentElevation){
			list.add(new int[]{matrix[x][y+1],x,y+1});
		}
		return list;
	}
}
