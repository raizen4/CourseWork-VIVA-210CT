
public class Problem1_ADVANCED {	   
	static int paths = 0;
	    public static void main(String[] ar)
	    {
	    	 int[][] a=new int[][]
	    	  {
		    	{1,1,1,0,0}
		       ,{1,0,0,0,0}
		       ,{1,0,0,0,0}
		       ,{0,0,0,1,1}
		       };
	       
	        System.out.println(search(a,3,2));
	    }

	    public static int search(int[][] matrix,int i, int j)
	    {
	        if(!exist(matrix,i,j))
	            return 0;
	        else if(matrix[i][j] == 1)
	        	return 0;
	        if(i == 0 && j ==4)
	        {
	           paths++;
	           System.out.print("("+i+","+j+")"+" ");
	           System.out.println();
	           return 0;
	        }
	        System.out.print("("+i+","+j+")"+" ");
	        matrix[i][j] = 1;
	        search(matrix,i+1,j);
	        search(matrix,i-1,j);
	        search(matrix,i,j+1);
	        search(matrix,i,j-1);
	       return paths;
	    }

	    public static boolean exist(int[][] a, int i, int j)
	    {
	        return i>=0 && j >=0 && i < a.length && j < a[i].length;
	    }   
	}

