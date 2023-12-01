//In this one no repeated combinations are allowed and one element can be used once
package recursion;
import java.util.*;
public class CombinationSumII {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter n");
		int n=sc.nextInt();
		System.out.println("Enter array");
		int ar[]=new int[n];
		for(int i=0;i<n;i++)
			ar[i]=sc.nextInt();
		Arrays.sort(ar);
		System.out.println("Enter target");
		int target=sc.nextInt();
		ArrayList<Integer> arr=new ArrayList<>();
		combinationsumtwo(0,ar,target,arr);
		sc.close();
	}
	static void combinationsumtwo(int ind,int ar[],int target,ArrayList<Integer> arr)
	{
		if(target==0)
		{
			System.out.println(arr);
			return;
		}
		for(int i=ind;i<ar.length;i++)
		{
			if(i>ind && ar[i]==ar[i-1])
				continue;
			if(ar[i]>target)
				break;
			arr.add(ar[i]);
			combinationsumtwo(i+1,ar,target-ar[i],arr);
			arr.remove(arr.size()-1);
		}
	}
}
