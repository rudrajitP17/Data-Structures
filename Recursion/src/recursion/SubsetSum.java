package recursion;
import java.util.*;
public class SubsetSum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter N");
		int n=sc.nextInt();
		System.out.println("Enter array");
		int ar[]=new int[n];
		for(int i=0;i<n;i++)
			ar[i]=sc.nextInt();
		subsetsum(0,0,ar);
		Collections.sort(arr);
		System.out.println(arr);
		sc.close();
	}
	static ArrayList<Integer> arr=new ArrayList<Integer>();
	static void subsetsum(int i,int sum,int ar[])
	{
		if(i==ar.length)
		{
			arr.add(sum);
			return;
		}
		subsetsum(i+1,sum+ar[i],ar);
		subsetsum(i+1,sum,ar);
	}
}
//You are told to store the sum in a sorted order that's why priorityqueue or else you can use arraylist and the sort it'