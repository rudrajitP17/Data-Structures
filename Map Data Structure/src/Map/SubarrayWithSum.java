package Map;
import java.util.*;
public class SubarrayWithSum 
{
	public static void main(String args[])
	{
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter Sum");
		int sum=sc.nextInt();
		System.out.println("Enter the length of the array");
		int n=sc.nextInt();
		int ar[]=new int[n];
		System.out.println("Enter the array");
		for(int i=0;i<n;i++)
			ar[i]=sc.nextInt();
		HashMap<Integer,Integer> map=new HashMap<>();
		int curr=0,start=0,end=-1;
		for(int i=0;i<n;i++)
		{
			curr=curr+ar[i];
			if(curr==sum)
			{
				start=0;
				end=i;
				break;
			}
			if(map.containsKey(curr-sum))
			{
				start=map.get(curr-sum)+1;
				end=i;
				break;
			}
			map.put(curr, i);
		}
		if(end==-1)
			System.out.println("value not found");
		else
			System.out.println(start+" "+end);
	}
}
