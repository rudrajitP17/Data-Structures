package recursion;
import java.util.*;
public class CombinationSum {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		int ar[]= {2,3,4,7};int target=7;
		ArrayList<Integer> arr=new ArrayList<>();
		combinationsumelements(0,ar,arr,target);
		sc.close();
	}
	static void combinationsumelements(int i,int ar[],ArrayList<Integer> arr,int target)
	{
		if(i==ar.length)
		{
			if(target==0)
				System.out.println(arr);
			return;
		}
		if(ar[i]<=target)
		{
			arr.add(ar[i]);
			combinationsumelements(i,ar,arr,target-ar[i]);
			arr.remove(arr.size()-1);
		}
		combinationsumelements(i+1, ar, arr, target);
	}
}
