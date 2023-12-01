package recursion;
import java.util.*;
public class Reverseanarray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter n");
		int n=sc.nextInt();
		int a[]=new int[n];
		System.out.println("Enter array");
		for(int i=0;i<n;i++)
			a[i]=sc.nextInt();
		firststmethod(a,0,n-1);
		//secondmethod(a,0,n);
		for(int i=0;i<n;i++)
			System.out.print(a[i]+" ");
		
		sc.close();
	}
	static void firststmethod(int a[],int l,int r)
	{
		if(l>r)
			return;
		int temp=a[l];
		a[l]=a[r];
		a[r]=temp;
		firststmethod(a,l+1,r-1);
	}
	static void secondmethod(int a[],int i,int n)
	{
		if(i>=n/2)
			return;
		int temp=a[i];
		a[i]=a[n-i-1];
		a[n-i-1]=temp;
		secondmethod(a,i+1,n);
	}
}
