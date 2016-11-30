
public class Problem1 {

	
	public static void main(String...args){
		int[] test1=new int[]{1,2,3,4,5,6,7};
		int[]test2=new int[]{8,10,12,15,19,30};
		int[]test3=new int[]{-2,5,6,10,20};
		System.out.println(modifiedBinarySearch(test1,0,1,0,test1.length-1));
		System.out.println(modifiedBinarySearch(test2,6,15,0,test1.length-1));
		System.out.println(modifiedBinarySearch(test3,-2,3,0,test1.length-1));
		
	}
	
	
	public static String modifiedBinarySearch(int[] arrayList,int low,int high,int beginIndex,int endIndex){
		int mid=arrayList[(beginIndex+endIndex)/2];
		if(mid >low && mid<high){
			return "Fund a value between "+ low+ " and "+ high+" and it is "+ mid;
		}
		else if(beginIndex==endIndex || endIndex-1==beginIndex){
			return "Not Found";
		}
		else{
		     if(mid>=high){
				return modifiedBinarySearch(arrayList,low,high,beginIndex,(beginIndex+endIndex)/2);
			}
			else if(mid<=low){
				return modifiedBinarySearch(arrayList,low,high,(beginIndex+endIndex)/2,endIndex);
			}
		}
	return null;	
	}
}
