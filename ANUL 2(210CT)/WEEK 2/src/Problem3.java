import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Problem3 {
	
	public static void main(String...args){
	ArrayList<int[][]> listOfMatrices=new ArrayList<>();
	Problem3MatrixOperationClass operations=new Problem3MatrixOperationClass();
	BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
	int howManyMatrices=0;
	int howManyMatricesHaveBeenEntered=0;
	int rowsAndColumns=0;
	int[][] result;
	System.out.println("insert the number of matrices to be put in the array initially");
	try {
		howManyMatrices=Integer.parseInt(reader.readLine());
	} catch (NumberFormatException e) {
		e.printStackTrace();
	} catch (IOException e) {
		e.printStackTrace();
	}
	int count=0;
	while(howManyMatricesHaveBeenEntered!=howManyMatrices){
		try {
			System.out.println("Insert the number of rows and columns for the "+(howManyMatricesHaveBeenEntered+1)+" matrix");
			rowsAndColumns = Integer.parseInt(reader.readLine());
		} catch (NumberFormatException e) {	
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		int[][]matrixToEnter =new int[rowsAndColumns][rowsAndColumns];
		for(int i=0;i<rowsAndColumns;++i){
			for(int j=0;j<rowsAndColumns;++j){
				System.out.println("Enter the element "+i+" "+j+":");
				try {
					matrixToEnter[i][j]=Integer.parseInt(reader.readLine());
				} catch (Exception e) {
					e.printStackTrace();
				} 
			}
		}
		listOfMatrices.add(matrixToEnter);
		howManyMatricesHaveBeenEntered++;

}
	result=Problem3MatrixOperationClass.substractMatrices
			(Problem3MatrixOperationClass.multiplyMatrices(listOfMatrices.get(0),listOfMatrices.get(1) ,rowsAndColumns,0), 
					Problem3MatrixOperationClass.multiplyMatrices(listOfMatrices.get(0), listOfMatrices.get(1), rowsAndColumns, 2), rowsAndColumns);
	
	for(int i=0;i<rowsAndColumns;++i){
		for(int j=0;j<rowsAndColumns;++j){
			System.out.print(result[i][j]+ " ");
		}
		System.out.println();
	}
}
	}