package recursion;
import java.util.*;
public class Subsequenceofanarray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		ArrayList<Integer> ar1=new ArrayList<>();
		int ar[]= {3,1,2};
		printsub(0,ar,ar1);
	    sc.close();
	}
	static void printsub(int i,int ar[],ArrayList<Integer>ar1)
	{
		if(i==ar.length)
		{
			System.out.println(ar1);
			return;
		}
		ar1.add(ar[i]);
		printsub(i+1,ar,ar1);
		ar1.remove(ar1.size()-1);
		printsub(i+1,ar,ar1);
	}
}
