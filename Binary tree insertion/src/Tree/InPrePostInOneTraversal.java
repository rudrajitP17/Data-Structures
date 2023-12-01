package Tree;
import java.util.*;
public class InPrePostInOneTraversal 
{
	static Scanner sc=null;
	public static void main(String args[])
	{
		sc=new Scanner(System.in);
		Node root=createTree();
		InprePost(root);
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
	static void InprePost(Node root)
	{
		Stack<Pair> st=new Stack<>();
		ArrayList<Integer> pre=new ArrayList<>();
		ArrayList<Integer> in=new ArrayList<>();
		ArrayList<Integer> post=new ArrayList<>();
		st.push(new Pair(1,root));
		while(!st.isEmpty())
		{
			Pair curr=st.pop();
			if(curr.num==1)
			{
				pre.add(curr.node.data);
				curr.num++;
				st.push(curr);
				if(curr.node.left!=null)
					st.push(new Pair(1,curr.node.left));
			}
			else if(curr.num==2)
			{
				in.add(curr.node.data);
				curr.num++;
				st.push(curr);
				if(curr.node.right!=null)
					st.push(new Pair(1,curr.node.right));
			}
			else
				post.add(curr.node.data);
		}
		System.out.println("Pre-order "+pre);
		System.out.println("In-order "+in);
		System.out.println("Post-order "+post);
	}
}