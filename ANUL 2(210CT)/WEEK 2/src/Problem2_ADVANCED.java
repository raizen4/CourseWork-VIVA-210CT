import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;


public class Problem2_ADVANCED {
	private static Set cartesianProduct;
	private static ArrayList<Set> arrayOfSets=new ArrayList<>();
	public static void main(String...args) throws IOException, InterruptedException{
		BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
		int numberOfSetsWanted=0;
		int numberOfSetsEntered=0;
		System.out.println("How many sets do you want to enter?");
		try{
			numberOfSetsWanted=Integer.parseInt(reader.readLine());
		}
		catch(Exception e){
			e.printStackTrace();
		}
		while(numberOfSetsEntered!=numberOfSetsWanted){
			Set set=new Set();
			int x;
			String line="";
			System.out.println("enter the pairs for the set. Press finish when you are done with this set");
			while(!(line=reader.readLine()).matches("finish")){
				try{
					ArrayList<Integer>arrayList=new ArrayList<>();
					arrayList.add(x=Integer.parseInt(line));
					Set.Pair pair=new Set.Pair();
					pair.addValuesToPair(arrayList);
					set.addValueToSet(pair);
					System.out.println("value entered");
					
				}
				catch(Exception e){
					e.printStackTrace();
				}
			}
			arrayOfSets.add(set);
			System.out.println(set);
			numberOfSetsEntered++;
			
		}
		System.out.println(arrayOfSets.toString());
		cartesianProductOfNSets(arrayOfSets,0,arrayOfSets.size());
		System.out.println(cartesianProduct.toString());
	}
	
	public static Set cartesianProductOfNSets(ArrayList<Set> arrayOfSets,int currentSize,int lenOfArrayOfSets) throws InterruptedException{
		if(currentSize==0){
			cartesianProduct=Set.cartesianProductOfTwoSets(arrayOfSets.get(currentSize),arrayOfSets.get(currentSize+1));
		    return cartesianProductOfNSets(arrayOfSets,currentSize=currentSize+2,lenOfArrayOfSets);
		}
		else if(currentSize==lenOfArrayOfSets || currentSize>lenOfArrayOfSets){
			return cartesianProduct;
			
		}
		
		else{ 
			cartesianProduct=Set.cartesianProductOfTwoSets(cartesianProduct, arrayOfSets.get(currentSize));
		    return cartesianProductOfNSets(arrayOfSets,currentSize=currentSize+1,lenOfArrayOfSets);
			}
		}
	}
	

