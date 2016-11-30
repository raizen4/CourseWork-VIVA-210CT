
public class SparseMatrix {
	private int[][] matrix;
	private int columns;
	private int rows;
	
	
	public SparseMatrix(int[][] matrixToHold,int numberOfColumns, int numberOfRows){
		int numberOfZeros=0;
		int numberDifferentFromZeros=0;
		for(int i=0;i<numberOfRows;++i){
			for(int j=0;j<numberOfColumns;++j){
				if(matrixToHold[i][j]!=0){
					numberDifferentFromZeros++;	
				}
				else{
					numberOfZeros++;
				}
			}
		}
		if(numberOfZeros>numberDifferentFromZeros){

		this.rows=numberOfRows;
		this.columns=numberOfColumns;
		matrix=new int[rows][columns];
		for(int i=0;i<rows;++i){
			for(int j=0;j<columns;++j){
				matrix[i][j]=matrixToHold[i][j];
			}
		}
		}
		else{
			System.out.println("That is not a sparse matrix");
		}
	}
	
	public int getElement(int row,int column){
		return matrix[row][column];
	}
	
	public int getNumberOfColumns(){
		return this.columns;
	}
	
	public int getNumberOfRows(){
		return this.rows;
	}
	
	public static SparseMatrix addMatrices(SparseMatrix matrixA,SparseMatrix matrixB){
		
		int howManyRowsA=matrixA.getNumberOfRows();
		int howManyRowsB=matrixB.getNumberOfRows();
		int howManyColumnsA=matrixA.getNumberOfColumns();
		int howManyColumnsB=matrixB.getNumberOfColumns();
		int[][] newMatrix;
		if(howManyRowsA==howManyRowsB && howManyColumnsA==howManyColumnsB ){
			newMatrix=new int[howManyRowsA][howManyColumnsA];
			for(int i=0;i<howManyRowsA;++i){
				for(int j=0;j<howManyColumnsA;++j){
					newMatrix[i][j]=matrixA.getElement(i,j)+matrixB.getElement(i,j);
				}
			}
			return new SparseMatrix(newMatrix,howManyColumnsA,howManyColumnsA);
		}
		else{
			System.out.println("the matrices don t have the same number of rows or columns");
			return null;
		}
		
		
	}
	public static SparseMatrix subtractMatrices(SparseMatrix matrixA,SparseMatrix matrixB){
		int howManyRowsA=matrixA.getNumberOfRows();
		int howManyRowsB=matrixB.getNumberOfRows();
		int howManyColumnsA=matrixA.getNumberOfColumns();
		int howManyColumnsB=matrixB.getNumberOfColumns();
		int[][] newMatrix;
		if(howManyRowsA==howManyRowsB && howManyColumnsA==howManyColumnsB ){
			newMatrix=new int[howManyRowsA][howManyColumnsA];
			for(int i=0;i<howManyRowsA;++i){
				for(int j=0;j<howManyColumnsA;++j){
					newMatrix[i][j]=matrixA.getElement(i,j)-matrixB.getElement(i,j);
				}
			}
			return new SparseMatrix(newMatrix,howManyColumnsA,howManyColumnsA);
		}
		else{
			System.out.println("the matrices don t have the same number of rows or columns");
			return null;
		}
		
	}
	
	public static SparseMatrix multiplyMatrices(SparseMatrix matrixA,SparseMatrix matrixB){
		int howManyColumnsA=matrixA.getNumberOfColumns();
		int howManyRowsB=matrixB.getNumberOfRows();
		if(howManyColumnsA!=howManyRowsB){			
			System.out.println("the multiplication of these matrices is undefined");
			return null;
		}
		else{
			int[][] newMatrix=new int[matrixA.getNumberOfRows()][matrixB.getNumberOfColumns()];
			for(int i=0;i<matrixA.getNumberOfRows();++i){
				for(int j=0;j<matrixB.getNumberOfColumns();++j){
					int partialResult=0;
					for(int k=0;k<matrixB.getNumberOfRows();++k){
						partialResult+=(matrixA.getElement(i,k)*matrixB.getElement(k,j));
					}
					newMatrix[i][j]=partialResult;
				}
			}
			return new SparseMatrix(newMatrix,matrixB.getNumberOfColumns(),matrixA.getNumberOfRows());
		}
		
	}
	
	public String toString() {
		StringBuilder builder=new StringBuilder();
		for(int i=0;i<this.rows;++i){
			for(int j=0;j<this.columns;++j){
			  builder.append(matrix[i][j]+ " ");
			}
			builder.append("\n");
		}
		return builder.toString();
	} 
}
