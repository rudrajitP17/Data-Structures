package recursion;
import java.util.ArrayList;
import java.util.Scanner;
public class SubsetSumII {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter N");
		int n=sc.nextInt();
		int ar[]=new int[n];
		System.out.println("Enter array");
		for(int i=0;i<n;i++)
			ar[i]=sc.nextInt();
		ArrayList<Integer> arr=new ArrayList<Integer>();
		subsetsumII(0,ar,arr,arr1);
		System.out.println(arr1);
		sc.close();
	}
	static ArrayList<ArrayList<Integer>> arr1=new ArrayList<>();
	static void subsetsumII(int ind,int ar[],ArrayList<Integer> arr,ArrayList<ArrayList<Integer>> arr1)
	{
		arr1.add(new ArrayList<>(arr));
		for(int i=ind;i<ar.length;i++)
		{
			if(i>ind && ar[i]==ar[i-1])
				continue;
			arr.add(ar[i]);
			subsetsumII(i+1,ar,arr,arr1);
			arr.remove(arr.size()-1);
		}
	}
}
//here duplicates are allowed in case of combinations