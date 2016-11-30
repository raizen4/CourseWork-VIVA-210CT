import java.util.ArrayList;

public class ChallengeCode {
 
	
	public static void main(String...args){
		int[][] matrix=new int[][]{{1,2,3},{4,5,6},{7,8,9}};
		for(int i=0;i<3;++i){
			for(int j=0;j<3;++j){
				System.out.print(matrix[i][j]+ " ");
			}
			System.out.println();
		}
		
		int row=0;
		int column=0;
		for(int i=0;i<9;++i){
			if(row==0 && column<=2){
				if(column==2){
					row++;
				}
				else{
				System.out.println(matrix[row][column]);
				column++;
				}
			}
			
		}
	}
	
}
