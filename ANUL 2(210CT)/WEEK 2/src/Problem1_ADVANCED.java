import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Problem1_ADVANCED {
	public static void main(String...args){
		BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
		String firstWord=null;
		String secondWord=null;
		System.out.println("Enter the first string");
		try{
			firstWord=reader.readLine();
			System.out.println("Enter the second string");
			secondWord=reader.readLine();
		}
		catch(Exception e){
			e.printStackTrace();
		}
		System.out.println(subpointC(firstWord,secondWord));
	}
	
	public static String subpointA(String first,String second){
		StringBuilder builder=new StringBuilder();
		char[] letters=first.toCharArray();
		HashMap<Character,Integer> hashmap=new HashMap<>();
		for(char letter:letters){
			if(!(hashmap.containsKey(letter))){
				hashmap.put(letter, 1);
			}
		}
		letters=null;
		letters=second.toCharArray();
		for(char letter:letters){
			if(hashmap.containsKey(letter)){
				builder.append(letter);
				hashmap.remove(letter);
				
			}
		}
		return builder.toString();
	}
	
	public static String subpointB(String first,String second){
		StringBuilder builder=new StringBuilder();
		builder.append(first+second);
		String newString=builder.toString();
		char[] letters=newString.toCharArray();
		HashMap<Character,Integer> hashmap=new HashMap<>();
		for(char letter:letters){
			if(!(hashmap.containsKey(letter))){
				hashmap.put(letter, 1);
			}
		}
		builder=new StringBuilder();
		for(Map.Entry<Character, Integer> entry:hashmap.entrySet()){
			builder.append(entry.getKey());
		}
		
		return builder.toString();
	}
	
	public static String subpointC(String first,String second){
		StringBuilder builder=new StringBuilder();
		char[] letters=first.toCharArray();
		HashMap<Character,Integer> hashmap=new HashMap<>();
		for(char letter:letters){
			if(!(hashmap.containsKey(letter))){
				hashmap.put(letter, 1);
			}
		}
		letters=null;
		letters=second.toCharArray();
		for(char letter:letters){
			if(hashmap.containsKey(letter)){
				hashmap.remove(letter);
				
			}
		}
		for(Map.Entry<Character, Integer>entry:hashmap.entrySet()){
			builder.append(entry.getKey());
		}
		return builder.toString();
		
	}
}
