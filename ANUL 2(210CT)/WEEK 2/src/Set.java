import java.util.ArrayList;

public class Set {
	private ArrayList<Pair> arrayOfValuesForSet=new ArrayList<>();
	public Set(){
	}
	
	static class Pair
	{
		private ArrayList<Integer> arrayOfValues;
		public Pair (){
			 this.arrayOfValues=new ArrayList<>();
		}
		
		public ArrayList<Integer> getValues(){
			return arrayOfValues; 
	}
		public void addValuesToPair(ArrayList<Integer> values){
		for(int i:values){
			arrayOfValues.add(i);
		}
		}
		public int getPairSize(){
			return arrayOfValues.size();
			}
		public String toString(){		
			return arrayOfValues.toString();
		}
	
	}
	public int getSize(){
		return arrayOfValuesForSet.size();
	}
	
	
	public ArrayList<Integer> getElementAtIndex(int index){
		return arrayOfValuesForSet.get(index).getValues();
	}
	
	public static Set cartesianProductOfTwoSets(Set setA,Set setB){
		Set newSet=new Set();
		int i=0,j=0;
		while(i<setA.getSize()){
			while(j<setB.getSize()){
				Pair newPair=new Pair();
				newPair.addValuesToPair(setA.getElementAtIndex(i));
				newPair.addValuesToPair(setB.getElementAtIndex(j));
				newSet.addValueToSet(newPair);
				j++;
			}
				j=0;
				i++;
			
		}

		return newSet;
	}
	
	public void deleteValueFromSet(int index){
		arrayOfValuesForSet.remove(index);
		}
	public void addValueToSet(Pair pair){
		arrayOfValuesForSet.add(pair);
	}
	public String toString(){
		return arrayOfValuesForSet.toString();
	}
	}
