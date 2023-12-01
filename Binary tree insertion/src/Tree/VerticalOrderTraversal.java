package Tree;
import java.util.*;
public class VerticalOrderTraversal 
{
	static Scanner sc=null;
	public static void main(String args[])
	{
		sc=new Scanner(System.in);
		Node root=createTree();
		Map<Integer,ArrayList<Integer>> map=new TreeMap<>();
		Queue<Pair> q=new LinkedList<>();
		q.add(new Pair(0,root));
		while(!q.isEmpty())
		{
			Pair curr=q.poll();
			if(map.containsKey(curr.num))
				map.get(curr.num).add(curr.node.data);
			else
			{
				ArrayList<Integer> temp=new ArrayList<>();
				temp.add(curr.node.data);
				map.put(curr.num, temp);
			}
			if(curr.node.left!=null)
				q.add(new Pair(curr.num-1,curr.node.left));
			if(curr.node.right!=null)
				q.add(new Pair(curr.num+1,curr.node.right));
		}
		ArrayList<ArrayList<Integer>> list=new ArrayList<>();
		for(Map.Entry<Integer,ArrayList<Integer>> m : map.entrySet())
			list.add(m.getValue());
		System.out.println(list);
	}
	static Node createTree()
	{
		System.out.println("Enter data");
		int data=sc.nextInt();
		if(data==-1)
			return null;
		Node node=new Node(data);
		System.out.println("Enter left for "+data);
		node.left=createTree();
		System.out.println("Enter right for "+data);
		node.right=createTree();
		return node;
	}
}
