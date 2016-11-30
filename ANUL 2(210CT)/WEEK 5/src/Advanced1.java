
public class Advanced1 {

	public static void main(String...args){
		int[][] matrixForTest=new int[][]{
			{0,2,-1},
			{1,0,2},
			{0,4,-1}
		};
		matrixAtNthPower(matrixForTest,3,1);
	}
	public static Object matrixAtNthPower(int[][]matrix,int wantedPower,int currentPower){
		if(wantedPower==currentPower || wantedPower==1){
			for(int i=0;i<matrix.length;++i){
				for(int j=0;j<matrix.length;++j){
					System.out.print(matrix[i][j]+" ");
				}
				System.out.println();
			}
			return null;
		}
		else{
			int[][]newMatrix=new int[matrix.length][matrix.length];
			for(int i=0;i<matrix.length;++i){
				for(int j=0;j<matrix.length;++j){
					int partialResult=0;
					for(int k=0;k<matrix.length;++k){
						partialResult+=(matrix[i][k]*matrix[k][j]);
					}
					newMatrix[i][j]=partialResult;
				}
		}
			return matrixAtNthPower(newMatrix,wantedPower,currentPower=currentPower+1);
	}
	}
}
