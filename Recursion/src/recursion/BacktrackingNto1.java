package recursion;
import java.util.*;
public class BacktrackingNto1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter n");
		int n=sc.nextInt();
		f(1,n);
		sc.close();
	}
	static void f(int i,int n)
	{
		if(n<i)
			return;
		f(i+1,n);
		System.out.println(i);
	}
}
