import org.eclipse.jdt.annotation.Nullable;
//The overall runtime of this algorithm is O(n^3) because the most demanding one is the multiply of the matrices which takes 3 for's in order to be done, the other 2 operations take only O(n^2)
public class Problem3MatrixOperationClass {

	public Problem3MatrixOperationClass(){
		
	}
	/* int[][] addMatrices(int[][]matrixA,int[][]matrixB,int howBigAreThey)
	 * 		int[][] newMatrix=new int[howBigAreThey][howBigAreThey]
	 * 		for row from 0 to howBigAreThey
	 * 			for column from 0 to howBigAreThey
	 * 				newMatrix[row][column]=matrixA[row][column]+matrixB[row][column]
	 *  	return newMatrix
	 */
	public static int[][] addMatrices(int[][]matrixA,int[][]matrixB,int howBigAreThey){
		int[][] newMatrix=new int[howBigAreThey][howBigAreThey];
		for(int i=0;i<howBigAreThey;++i){
			for(int j=0;j<howBigAreThey;++j){
				newMatrix[i][j]=matrixA[i][j]+matrixB[i][j];
			}
		}
		return newMatrix;
	}
	/* int[][] substractMatrices(int[][]matrixA,int[][]matrixB,int howBigAreThey)
	 * 		int[][] newMatrix<-new int[howBigAreThey][howBigAreThey]
	 * 		for row from 0 to howBigAreThey
	 * 			for column from 0 to howBigAreThey
	 * 				newMatrix[row][column]<-matrixA[row][column]-matrixB[row][column]
	 *  	return newMatrix
	 */
	public static int[][] substractMatrices(int[][]matrixA,int[][]matrixB,int howBigAreThey){
		int[][] newMatrix=new int[howBigAreThey][howBigAreThey];
		for(int i=0;i<howBigAreThey;++i){
			for(int j=0;j<howBigAreThey;++j){
				newMatrix[i][j]=matrixA[i][j]-matrixB[i][j];
			}
		}
		return newMatrix;
		
	}
	/* int[][] multiplyMatrices(int[][]matrixA,int[][]matrixB,int howBigAreThey, @Nullable int scalarToMultiplyResultOfMatrices)
	 * 		int[][] newMatrix <- new int[howBigAreThey][howBigAreThey]
	 * 		for rowInA from 0 to howBigAreThey
	 * 			for columnInA from 0 to howBigAreThey
	 * 				int partialResult<-0
	 * 				for rowMatrixB from 0 to howBigAreThey
	 * 					partialResult<-partialResult +(matrixA[rowInA][rowMatrixB]+matrixB[rowMatrixB][columnInA]
	 * 				newMatrix[rowInA][columnInA]<-partialResult
	 * 		if scalarToMultiplyResultOfMatrices <-null	
	 * 			return newMatrix
	 * 		else
	 * 			for rowInA from 0 to howBigAreThey
	 * 				for columnInA from 0 to howBigAreThey
	 * 					newMatrix[rowInA][columnInA]<-newMatrix[rowInA][columnInA] *scalarToMultiplyResultOfMatrices;
	 */
	public static int[][] multiplyMatrices(int[][]matrixA,int[][]matrixB,int howBigAreThey, @Nullable int scalarToMultiplyResultOfMatrices ){
		int[][] newMatrix=new int[howBigAreThey][howBigAreThey];
		for(int i=0;i<howBigAreThey;++i){
			for(int j=0;j<howBigAreThey;++j){
				int partialResult=0;
				for(int k=0;k<howBigAreThey;++k){
					partialResult+=(matrixA[i][k]*matrixB[k][j]);
				}
				newMatrix[i][j]=partialResult;
			}
		}
		if(scalarToMultiplyResultOfMatrices==0){
			return newMatrix;
		}
		else{
			  for(int i=0;i<howBigAreThey;++i){
				for(int j=0;j<howBigAreThey;++j){
					newMatrix[i][j]*=scalarToMultiplyResultOfMatrices;
				}
			  }
			}
		return newMatrix;
			
		}
	}

