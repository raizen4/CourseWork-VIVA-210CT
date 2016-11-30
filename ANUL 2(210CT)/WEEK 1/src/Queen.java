
public class Queen {
	private int initialRow;
    //private int[][] chessTable;
    //private int tableLenght;
  public Queen(int iPos){
	  this.initialRow=iPos;
  }  
  	 public int getInitialRow(){
  		 return this.initialRow;
  	 }
	 public int isSafeToPutQueenThere(int row,int column,int[][] chessTable,int howBigIsChessTable){
		 int currentRow=row;
		 if(currentRow>howBigIsChessTable-1){
			 return -1;
		 }
		 else{
			 int result=checkThePlace(row,column,chessTable,howBigIsChessTable);
			 if(result!=-1)
			 {  
				
				 return result;
			 }
			 else{
				 currentRow++;
			 return isSafeToPutQueenThere(currentRow,column,chessTable,howBigIsChessTable);
		 }

		 }
  }
	 
	 
	 private int checkThePlace(int row,int column,int[][] chessTable,int howBigIsChessTable){
		 //on the same row;
		 for(int i=0;i<column;++i) 
			{
				if(chessTable[row][i]==1 ){
					return -1;}
			}
			//on the big diagonal upper
			for(int i=row-1,j=column-1;i>=0 && j>=0;--i,--j){
				if(i<0 || j<0){
					return -1;
				}
				if(chessTable[i][j]==1){
					return -1;}
			}
			//on the second diagonal lower
			for(int i=row+1,j=column-1;i<howBigIsChessTable &&j>=0;i++,j--){
				if(chessTable[i][j]==1){
					
					return -1;}
			}
			return row;
	 }
	 
}
