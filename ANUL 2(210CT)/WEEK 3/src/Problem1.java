import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.nio.file.attribute.AclEntry.Builder;
import java.util.ArrayList;

public class Problem1 {
	static String reversedSentence="";
 public static void main(String...args) throws Exception{
	 String sentenceEntered="";
	 BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
	 System.out.println("Please enter the sentence which you want to reverse");
	 sentenceEntered=reader.readLine();
	 System.out.println(inverseSentence(sentenceEntered));
	 
	 
 }
 /* The time complexity of this algorithm is O(n) because i first go in the sentence and create words which
  *  i add into an array and then i print the array in inverse order. The space complexity is also O(n).
  * 
  * 
  * inverseSentence(sentenceToInvese)
  * 	letters<-create an array of letters from the sentence given which is of a type string
  * 	invertedArray=create an arrayList of strings
  *     builder=create a new StringBuilder object which works like a stringBuffer
  *     for each letter in the letters
  *     	if letters[i]≠' ' && i≠ lenght of array
  *     		append letter to stringBuilder to create a word
  *     	else if i=length of array
  *     		append letter to builder
  *     		append space to builder
  *      	 	append this word to the invertedArray
  *         else
  *         	if i< lenghth of array
  *         		 add space to the builder
  *         	add this word to the invertedArray
  *         	builder takes another new StringBuilder object so a new word can be assigned to it and added into the invertedArray
  */
 public static String inverseSentence(String sentenceToInverse){
	 char[] letters=sentenceToInverse.toCharArray();
	 ArrayList<String> invertedArray=new ArrayList<>();
	 StringBuilder builder=new StringBuilder();
	 for(int i=0;i<letters.length;++i){
		 if(letters[i]!=' ' && i!=letters.length-1){
			 builder.append(letters[i]);
			 
		 }
		 else if(i==letters.length-1){
			     builder.append(letters[i]);
			     builder.append(" ");
				 invertedArray.add(builder.toString());
			 }
		 else{
			 if(i<=letters.length-1){
				 builder.append(" ");
			 }
			 invertedArray.add(builder.toString());
			 builder=new StringBuilder();
		 }
	 }
	 builder=new StringBuilder();
	for(int i=invertedArray.size()-1;i>=0;--i){
		builder.append(invertedArray.get(i));
	}
	return reversedSentence=builder.toString();
}
}