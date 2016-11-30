import java.util.ArrayList;
import java.util.Collections;

public class Problem2_ADVANCED {

	
	public static void main(String...args){
		ArrayList<Integer>array=new ArrayList<>();
		array.add(-5);
		array.add(-2);
		array.add(-121);
		array.add(4);
		array.add(22);
		array.add(1);
		array.add(0);
		array.add(3);
		int positionWanted=520;
		QuickSortMthSmallestElement(array,positionWanted,0,array.size()-1);
		try{
			System.out.println(array.get(positionWanted));
		}
		catch(Exception e){
				System.out.println("No such number exists");
		}
		
	}
	
	
	public static void QuickSortMthSmallestElement(ArrayList<Integer>array,int positionWanted,int beginIndex,int endIndex){
		
		if(beginIndex>=endIndex || array.size()==0 ){
			return;
	     }
		else{
		int pivot=(beginIndex+endIndex)/2;
		int i=beginIndex;
		int j=endIndex;
		while(i<=j){
			while(array.get(i)<array.get(pivot)){
				++i;
			}
			while(array.get(j)>array.get(pivot)){
				--j;
			}
			if(i<=j){
				int temp=array.get(i);
				array.set(i,array.get(j));
				array.set(j, temp);
				++i;
				--j;
			}
		}
		//If we still have a left side
		if(beginIndex<j){
		QuickSortMthSmallestElement(array,positionWanted,beginIndex,j);
		}
		//if we still have a right side
		if(i<endIndex)
		QuickSortMthSmallestElement(array,positionWanted,i,endIndex);
		}
}
}

