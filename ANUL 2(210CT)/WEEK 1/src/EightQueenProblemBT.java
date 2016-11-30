
public class EightQueenProblemBT {
	public static void main(String...args) throws InterruptedException{
		int[][]chessTable=new int[4][4];
		int[] solution=new int[4];
	
		for(int i=0;i<solution.length;++i){
			solution[i]=0;
		}
		for(int i=0;i<4;++i){
			for(int j=0;j<4;++j){
				chessTable[i][j]=0;
			}
			}
		int column=0;
		while(column>=0){
			System.out.println("We are working on column "+column);
			if(column==solution.length){
				boolean shouldUpdatePreviousColumnAfterFinishing=false;
				printSolution(solution);
				column-=1;
				for(int i=0;i<4;++i){
					for(int j=0;j<4;++j){
						System.out.print(chessTable[i][j]+" ");
					}
					System.out.println();
					}
				
				while(shouldUpdatePreviousColumnAfterFinishing=updatePreviousColumnsIfNeeded(column,chessTable,4,solution)){
					updatePreviousColumnsIfNeeded(column=column-1,chessTable,4,solution);
				}
				
				
			}
			else{
			int initialRow=solution[column];
			Queen queen=new Queen(initialRow);
			int positionforColumnFound=queen.isSafeToPutQueenThere(initialRow, column, chessTable, 4);
			if(positionforColumnFound!=-1){
				solution[column]=positionforColumnFound;
				System.out.print("i have put queen on row:"+solution[column]);
				System.out.println();
				chessTable[solution[column]][column]=1;
				for(int i=0;i<4;++i){
					for(int j=0;j<4;++j){
						System.out.print(chessTable[i][j]+" ");
					}
					System.out.println();
					}
				column++;
			}
			else{
				boolean shouldUpdatePreviousColumn=false;
				System.out.print("had to go back one level down ");
				System.out.println();
			    solution[column]=0;
				for(int row=0;row<4;++row){
					chessTable[row][column]=0;
				}
				column-=1;
				while(shouldUpdatePreviousColumn=updatePreviousColumnsIfNeeded(column,chessTable,4,solution)){
					updatePreviousColumnsIfNeeded(column-1,chessTable,4,solution);
					column-=1;
				}
				for(int i=0;i<4;++i){
					for(int j=0;j<4;++j){
						System.out.print(chessTable[i][j]+" ");
					}
					System.out.println();
					}
			}
			Thread.sleep(1000);
		}
	}
		}
	
	public static void printSolution(int[]solutionTable){
		for(int j=0;j<solutionTable.length;++j){
			System.out.print(solutionTable[j]+" ");
			
	}
		System.out.println();
}
	public static boolean updatePreviousColumnsIfNeeded(int column,int[][] chessTable,int howBigIsChessTable,int[]solutionArray){
		 if(column-1>0 &&  solutionArray[column]+1>3   ){
			 chessTable[ solutionArray[column]][column]=0;
			 solutionArray[column]=0;
			 return true;
		 }
	
		 else {
			 if(column<0)
				 return false;
			 chessTable[solutionArray[column]][column]=0;
			 solutionArray[column]+=1;
			 return false;	 
		 }
		 
		 
	 }
}
