import java.util.ArrayList;
import java.util.Vector;

public class Problem1 {
	
	public static void main(String...args){
		int[] sequence=new int[]{1,2,3,4,1,5,6,7,8,3,11,12,13,14,10};
		int maximumFoundLenght=0;
		int currentLenght=0;
		ArrayList<Vector> arrayOfMaximumLenght=new ArrayList<>();
		Vector<Integer> currentSequence=new Vector<>();
		for(int i=0;i<sequence.length;++i){
			if(i==0){
				currentSequence.addElement(sequence[i]);
				currentLenght=1;
				
			}
			else{
			if(sequence[i]>currentSequence.get(currentSequence.size()-1)){
					currentSequence.add(sequence[i]);
					currentLenght++;
				}
			else if(sequence[i]<currentSequence.get(currentSequence.size()-1)){
				System.out.println(currentSequence);
				if(currentLenght>=maximumFoundLenght){
					maximumFoundLenght=currentLenght;
					System.out.println(maximumFoundLenght);
					arrayOfMaximumLenght.add(currentSequence);
					int lastElementOfArrayOfMaximumLenght=arrayOfMaximumLenght.size()-1;
					if(arrayOfMaximumLenght.size()-1>0 && arrayOfMaximumLenght.get(lastElementOfArrayOfMaximumLenght).size()-1>arrayOfMaximumLenght.get(lastElementOfArrayOfMaximumLenght-1).size()-1){
						arrayOfMaximumLenght.remove(lastElementOfArrayOfMaximumLenght-1);
					}
					currentSequence=new Vector<>();
					currentSequence.add(sequence[i]);
					currentLenght=1;
				}
				else{
					currentSequence=new Vector<>();
					currentSequence.add(sequence[i]);
					currentLenght=1;
				}
			}
			}
			}
		System.out.println(arrayOfMaximumLenght);
	
			}
		
	}
	

