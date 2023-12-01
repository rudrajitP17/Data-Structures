package recursion;
import java.util.*;
public class PalindromePartioninng {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter String");
		String s=sc.nextLine();
		ArrayList<ArrayList<String>> arr=new ArrayList<>();
		ArrayList<String> ar=new ArrayList<>();
		partition(0,s,ar,arr);
		System.out.println(arr);
		sc.close();
	}
	static void partition(int index,String s,ArrayList<String> ar,ArrayList<ArrayList<String>> arr)
	{
		if(index==s.length())
		{
			arr.add(new ArrayList<>(ar));
			return;
		}
		for(int i=index;i<s.length();i++)
		{
			if(palindrome(s,index,i))
			{
				ar.add(s.substring(index,i+1));
				partition(i+1,s,ar,arr);
				ar.remove(ar.size()-1);
			}
		}
	}
	static boolean palindrome(String s,int first,int last)
	{
		while(first<=last)
		{
			if(s.charAt(first)!=s.charAt(last))
				return false;
			first++;last--;
		}
		return true;
	}
}
