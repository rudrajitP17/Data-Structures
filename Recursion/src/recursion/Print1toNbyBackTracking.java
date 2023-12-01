package recursion;
import java.util.*;
public class Print1toNbyBackTracking {
	public static void main(String args[])
	{
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter n");
		int n=sc.nextInt();
		f(n);
		sc.close();
	}
	static void f(int i)
	{
		if(i<1)
			return;
		f(i-1);
		System.out.println(i);
	}
}
