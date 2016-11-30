import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Problem2_ADVANCED {
 
	
	
	public static void main(String...args){
		ArrayList<SparseMatrix> listOfMatrices=new ArrayList<>();
		BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
		int howManyMatrices=0;
		int howManyMatricesHaveBeenEntered=0;
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
			int rows=0;
			int columns=0;
			try {
				System.out.println("Insert the number of rows for the "+(howManyMatricesHaveBeenEntered+1)+" matrix");
				rows = Integer.parseInt(reader.readLine());
				System.out.println("Insert the number of columns for the "+(howManyMatricesHaveBeenEntered+1)+" matrix");
			    columns=Integer.parseInt(reader.readLine());
			} catch (NumberFormatException e) {	
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
			int[][]matrixToEnter =new int[rows][columns];
			for(int i=0;i<rows;++i){
				for(int j=0;j<columns;++j){
					System.out.println("Enter the element "+i+" "+j+":");
					try {
						matrixToEnter[i][j]=Integer.parseInt(reader.readLine());
					} catch (Exception e) {
						e.printStackTrace();
					} 
				}
			}
			listOfMatrices.add(new SparseMatrix(matrixToEnter,columns,rows));
			howManyMatricesHaveBeenEntered++;
			System.out.println(listOfMatrices.get(count));
			count++;
		}
		listOfMatrices.add(SparseMatrix.multiplyMatrices(listOfMatrices.get(0), listOfMatrices.get(1)));
		System.out.println("Result is");
		System.out.println(listOfMatrices.get(2));
		
		for(int i=0;i<listOfMatrices.size();++i){
			System.out.println(listOfMatrices.get(i));
		}
		
	}
	
}
