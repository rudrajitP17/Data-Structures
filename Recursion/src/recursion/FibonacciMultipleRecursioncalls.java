package recursion;
import java.util.*;
public class FibonacciMultipleRecursioncalls {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the number");
		int n=sc.nextInt();
		System.out.println(fibonacci(n));
		sc.close();
	}
	static int fibonacci(int n)
	{
		if(n<=1)
			return n;
		return fibonacci(n-1)+fibonacci(n-2);
	}
}
