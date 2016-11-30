import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Problem_ADVANCED {
	
	
 public static void main(String...args){
	 int[][] coefficientMatrix=new int[3][3];
	 int[][]cloneOfTheMatrix=new int[3][3];
	 int[] equationResultColumn=new int[3];
	 int determinantOfTheMatrix;
	 BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
	 
	 System.out.println("enter the coefficients of each equation as follow aX +bY+cZ=d .The matrix can only be 3X3");
	 for(int i=0;i<3;++i){
		 for(int j=0;j<3;++j){
			 try {
				coefficientMatrix[i][j]=Integer.parseInt(reader.readLine());
			} catch (NumberFormatException | IOException e) {
				e.printStackTrace();
			}
		 }
		 try {
			equationResultColumn[i]=Integer.parseInt(reader.readLine());
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	 }
	 determinantOfTheMatrix=(coefficientMatrix[0][0]*coefficientMatrix[1][1]*coefficientMatrix[2][2])
			 +(coefficientMatrix[1][0]*coefficientMatrix[2][1]*coefficientMatrix[0][2])+
			 (coefficientMatrix[0][1]*coefficientMatrix[1][2]*coefficientMatrix[2][0])-
			 (coefficientMatrix[0][2]*coefficientMatrix[1][1]*coefficientMatrix[2][0])-
			 (coefficientMatrix[1][2]*coefficientMatrix[2][1]*coefficientMatrix[0][0])-
			 (coefficientMatrix[1][0]*coefficientMatrix[0][1]*coefficientMatrix[2][2]);

     ArrayList<Integer> SolutionsFound=new ArrayList<>();
     int j=0;
	 while(SolutionsFound.size()!=3){
		 int solution=0;
		 int  partialDeterminantOfMatrixForSolutions1=0;
		for(int l=0;l<3;++l){
			for(int c=0;c<3;++c ){
				cloneOfTheMatrix[l][c]=coefficientMatrix[l][c];
			}
		}
		 for(int i=0;i<3;++i){
			 cloneOfTheMatrix[i][j]=equationResultColumn[i];
		 }
		 partialDeterminantOfMatrixForSolutions1=( cloneOfTheMatrix[0][0]* cloneOfTheMatrix[1][1]* cloneOfTheMatrix[2][2])
				 +( cloneOfTheMatrix[1][0]* cloneOfTheMatrix[2][1]* cloneOfTheMatrix[0][2])+
				 ( cloneOfTheMatrix[0][1]* cloneOfTheMatrix[1][2]* cloneOfTheMatrix[2][0])-
				 ( cloneOfTheMatrix[0][2]* cloneOfTheMatrix[1][1]* cloneOfTheMatrix[2][0])-
				 ( cloneOfTheMatrix[1][2]* cloneOfTheMatrix[2][1]* cloneOfTheMatrix[0][0])-
				 (cloneOfTheMatrix[1][0]*cloneOfTheMatrix[0][1]*cloneOfTheMatrix[2][2]);
		  solution=partialDeterminantOfMatrixForSolutions1/determinantOfTheMatrix;
		 SolutionsFound.add(solution);
		 j++;
		 
	 }
	 
	 for(int i=0;i<SolutionsFound.size();++i){
		 System.out.println(SolutionsFound.get(i));
	 }
 }	
}
