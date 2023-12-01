package recursion;
import java.util.*;
public class PrintyournameNtimes {

	public static void main(String[] args) 
	{
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter n");
		int n=sc.nextInt();
		f(1,n);
		sc.close();
	}
	static void f(int i,int n)
	{
		if(i>n)
		return;
		System.out.print("Rudrajit ");
		f(i+1,n);
	}
}
//i=i+1 and i++ means the same first implementation is done then i value is changed, but in case of recursion
//it does'nt happen like that, if you i+1, the value remains same and thus results in stack
//overflow, so instead use ++1 or i+1 pre-increment happens in this and the value is changed.