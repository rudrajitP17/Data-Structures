package recursion;
import java.util.*;
public class Subsequencesonthebasisofgivensum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		int ar[]= {1,2,1};
		int sum=2;
		ArrayList<Integer> arr=new ArrayList<>();
		//printsubsequences(ar,0,arr,sum,0);
		//printonlyonesequence(ar,0,arr,sum,0);
		System.out.println(printthenumberofsequences(ar,0,arr,sum,0));
		sc.close();
	}
	static void printsubsequences(int ar[],int i,ArrayList<Integer> arr,int sum,int k)
	{
		if(i==ar.length)
		{
			if(sum==k)
				System.out.println(arr);
			return;
		}
		arr.add(ar[i]);
		k=k+ar[i];
		printsubsequences(ar,i+1,arr,sum,k);
		k=k-arr.get(arr.size()-1);
		arr.remove(arr.size()-1);
		printsubsequences(ar,i+1,arr,sum,k);
	}
	static boolean printonlyonesequence(int ar[],int i,ArrayList<Integer> arr,int sum,int k)
	{
		if(i==ar.length)
		{
			if(sum==k)
			{
				System.out.println(arr);
				return true;
			}
			else
				return false;
		}
		arr.add(ar[i]);
		k=k+ar[i];
		if(printonlyonesequence(ar,i+1,arr,sum,k)==true)
			return true;
		k=k-arr.get(arr.size()-1);
		arr.remove(arr.size()-1);
		if(printonlyonesequence(ar,i+1,arr,sum,k)==true)
			return true;
		return false;
	}
	static int printthenumberofsequences(int ar[],int i,ArrayList<Integer> arr,int sum,int k)
	{
		if(i==ar.length)
		{
			if(sum==k)
				return 1;
			else
				return 0;
		}
		arr.add(ar[i]);
		k=k+ar[i];
		int l=printthenumberofsequences(ar,i+1,arr,sum,k);
		k=k-arr.get(arr.size()-1);
		arr.remove(arr.size()-1);
		int r=printthenumberofsequences(ar,i+1,arr,sum,k);
		return r+l;
	}
}
