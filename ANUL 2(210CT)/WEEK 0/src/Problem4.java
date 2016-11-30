import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Problem4 {
 public static void main(String...args){
	 String wordToBeSplitted = null;
	 int beginingIndex=0;
	 int howManyLetters=0;
	 BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));

	 
	 
	 System.out.println("Please enter the String to be modified,"
	 		+ "then the begining index and how many letters should be skypped");
	 try {
		wordToBeSplitted=reader.readLine();
		beginingIndex=Integer.parseInt(reader.readLine());
		howManyLetters=Integer.parseInt(reader.readLine());
		
	} catch (IOException e) {
		e.printStackTrace();
	}
	 System.out.println(trimTheWord(wordToBeSplitted,beginingIndex,howManyLetters));
 }
 	
 public static String trimTheWord(String wordToBeModified,int beginIndex,int howManyLetters){
	 StringBuilder myBuilder=new StringBuilder(wordToBeModified.length()-howManyLetters);
	int hasSkyppedTheNumberOfLettersRequired=howManyLetters;
	for(int i=0;i<wordToBeModified.length();++i){
		if(i==beginIndex-1){
			myBuilder.append(wordToBeModified.charAt(i));
			for(int j=i+1;j<wordToBeModified.length() && hasSkyppedTheNumberOfLettersRequired!=0 ;++i){
				i=j;
				hasSkyppedTheNumberOfLettersRequired--;
			}
		}
		else{
			myBuilder.append(wordToBeModified.charAt(i));
		}
	}
	 return myBuilder.toString();
 }
}
