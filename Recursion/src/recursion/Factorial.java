package recursion;
import java.util.*;
public class Factorial {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter N");
		int n=sc.nextInt();
		parameterised(1,n);
		System.out.println(functional(n));
		sc.close();
	}
	static void parameterised(int f,int n)
	{
		if(n==1)
		{
			System.out.println(f);
			return;
		}
		parameterised(f*n,n-1);
	}
	static int functional(int n)
	{
		if(n==1)
			return 1;
		return n*functional(n-1); 
	}
}
