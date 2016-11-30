import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class iLikeParentheticals {

	public static void main(String...args){
		String sentenceToAnalyze=null;
		BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
		int openingPosition=0;
		System.out.println("Please introduce the sentence and the position of the desired paranthesis");
		try 
		{
			sentenceToAnalyze=reader.readLine();
			openingPosition=Integer.parseInt(reader.readLine());
		} 
		catch (IOException e) {
			e.printStackTrace();
		}
		}
	
	
	public static int matchParanthesis(String sentence){
		
		for(int i=0,j=sentence.length();i<=sentence.length() && j>=0;++i,--j){
			
			if(sentence.matches())
			}
				
			}
		return 0;
	}
}
