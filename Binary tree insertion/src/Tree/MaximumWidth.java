package Tree;
import java.util.*;
public class MaximumWidth {
	static Scanner sc=null;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		sc=new Scanner(System.in);
		Node root=createTree();
		Maxwidth(root);
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
	static void Maxwidth(Node root)
	{
		Queue<Pair> q=new LinkedList<>();
		int ans=0;
		q.add(new Pair(0,root));
		while(!q.isEmpty())
		{
			int size=q.size();
			int minn=q.peek().num;
			int first=0;int last=0;
			for(int i=0;i<size;i++)
			{
				int cur_id=q.peek().num-minn;
				Pair temp=q.poll();
				if(i==0)
					first=cur_id;
				if(i==size-1)
					last=cur_id;
				if(temp.node.left!=null)
					q.add(new Pair(cur_id*2+1,temp.node.left));
				if(temp.node.right!=null)
					q.add(new Pair(cur_id*2+2,temp.node.right));
			}
			ans=Math.max(ans,(last-first)+1);
		}
		System.out.println("Maximum width is "+ans);
	}
}
