package Tree;
import java.util.*;
public class BottomView {
	static Scanner sc=null;
	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		sc=new Scanner(System.in);
		Node root=createTree();
		bottomview(root);
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
	static void bottomview(Node root)
	{
		Queue<Pair> q=new LinkedList<>();
		Map<Integer,Integer> map=new TreeMap<>();
		q.add(new Pair(0,root));
		while(!q.isEmpty())
		{
			Pair curr=q.poll();
			if(map.containsKey(curr.num))
				map.replace(curr.num,curr.node.data);
			else
			{
				map.put(curr.num, curr.node.data);
			}
			if(curr.node.left!=null)
				q.add(new Pair(curr.num-1,curr.node.left));
			if(curr.node.right!=null)
				q.add(new Pair(curr.num+1,curr.node.right));
		}
		for(Map.Entry<Integer,Integer>m:map.entrySet())
			System.out.print(m.getValue()+" ");
	}
}
