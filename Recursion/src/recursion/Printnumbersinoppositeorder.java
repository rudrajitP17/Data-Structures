package recursion;
import java.util.*;
public class Printnumbersinoppositeorder {
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
		System.out.println(i);
		f(i-1);
	}
}
