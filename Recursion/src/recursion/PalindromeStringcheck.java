package recursion;
import java.util.*;
public class PalindromeStringcheck {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter string");
		String s=sc.nextLine();
		System.out.println(check(0,s));
		sc.close();
	}
	static boolean check(int i,String s)
	{
		if(i>=(s.length()/2))
			return true;
		if(s.charAt(i)!=s.charAt(s.length()-i-1))
			return false;
		return check(i+1,s);			
	}
}
//for void functions no return type needed
//for other datatype functions return type of that type is needed.