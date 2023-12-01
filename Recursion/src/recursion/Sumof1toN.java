package recursion;
import java.util.*;
public class Sumof1toN {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter N");
		int n=sc.nextInt();
		parameterised(0,n);
		System.out.println(functional(n));
		sc.close();
	}
	static void parameterised(int sum,int n)
	{
		if(n<1)
		{
			System.out.println(sum);
			return;
		}
		parameterised(sum+n,n-1);
	}
	static int functional(int n)
	{
		if(n==0)
			return 0;
		return n+functional(n-1);
	}
}
