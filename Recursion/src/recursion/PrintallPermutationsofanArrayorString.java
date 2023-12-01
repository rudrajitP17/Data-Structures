package recursion;
import java.util.*;
public class PrintallPermutationsofanArrayorString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter N");
		int n=sc.nextInt();
		System.out.println("Enter array");
		int ar[]=new int[n];
		for(int i=0;i<n;i++)
			ar[i]=sc.nextInt();
		//boolean fre[]=new boolean[n];
		ArrayList<Integer> arr=new ArrayList<>();
		//permutations(ar,arr,arr1,fre);
		permutations2(0,ar,arr);//This method uses less space.
		//System.out.println(arr1);
		sc.close();
	}
	static ArrayList<ArrayList<Integer>> arr1=new ArrayList<>();
	static void permutations(int ar[],ArrayList<Integer> arr,ArrayList<ArrayList<Integer>> arr1,boolean freq[])
	{
		if(arr.size()==ar.length)
		{
			arr1.add(new ArrayList<>(arr));
			return;
		}
		for(int i=0;i<ar.length;i++)
		{
			if(!freq[i])
			{
				arr.add(ar[i]);
				freq[i]=true;
				permutations(ar,arr,arr1,freq);
				arr.remove(arr.size()-1);
				freq[i]=false;
			}
		}
	}
	static void permutations2(int ind,int ar[],ArrayList<Integer> arr)
	{
		if(ind==ar.length)
		{
			for(int i=0;i<ar.length;i++)
				arr.add(ar[i]);
			System.out.println(arr);
			arr.clear();
		}
		for(int i=ind;i<ar.length;i++)
		{
			swap(i,ind,ar);
			permutations2(ind+1,ar,arr);
			swap(i,ind,ar);
		}
	}
	static void swap(int i,int n,int ar[])
	{
		int temp=ar[i];
		ar[i]=ar[n];
		ar[n]=temp;
	}
}
