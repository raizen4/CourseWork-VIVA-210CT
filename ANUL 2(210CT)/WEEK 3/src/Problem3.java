import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Problem3 {

	static char[] vowels=new char[]{'a','e','i','o','u'};
	
	public static void main(String...args) throws IOException{
		String wordEntered;
		BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
		System.out.println("enter the word, the output will be the word without any vowels");
		wordEntered=reader.readLine();
		String wordWithoutVowels=removeVowels(wordEntered,new StringBuilder(),wordEntered.length(),0);
		System.out.println(wordWithoutVowels);
	}
	/*removeVowels(wordToModify,StringBuilder builder,lenOfTheWord,currentPos)
	 * 	if currentPos=lenOfTheWord
	 * 		return builder
	 *  else
	 *     if isTheLetterVowel(wordToModify.charAt(currentPos),vowels)=false
	 *     	append char at that index to the builder
	 *      move on the next char in the word
	 *     else
	 *       move on the next char in the word
	 *       
	 *       
	 *isTheLetterVowel( letter, vowels)
	 * for each vowel in vowels
	 *  if letter=vowel
	 *    return true
	 * return false
	 * 
	 */
	public static String removeVowels(String wordToModify,StringBuilder builder,int lenOfTheWord,int currentPos){
		if(currentPos==lenOfTheWord){
			return builder.toString();
		}
		else{
			if(isTheLetterVowel(wordToModify.charAt(currentPos),vowels )==false){
				builder.append(wordToModify.charAt(currentPos));
				return removeVowels(wordToModify,builder,lenOfTheWord,currentPos+1);
			}
			else{
				return removeVowels(wordToModify,builder,lenOfTheWord,currentPos+1);
			}
		}
	}
	
	public static boolean isTheLetterVowel(char letter,char[] vowels){
		for(int i=0;i<vowels.length;++i){
			if(letter==vowels[i]){
				return true;
			}
		}
		return false;
	}
	
}
