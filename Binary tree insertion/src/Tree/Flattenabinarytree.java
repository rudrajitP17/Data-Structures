package Tree;
import java.util.*;
public class Flattenabinarytree {
	static Scanner sc=null;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		sc=new Scanner(System.in);
		Node root=createTree();
		Node curr=flattenapproach2(root);
		printtree(curr);
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
	static Node flattenapproach1(Node root)
	{
		Stack<Node>st=new Stack<>();
		st.push(root);Node curr=null;
		while(!st.isEmpty())
		{
		    curr=st.pop();
			if(curr.right!=null)
				st.push(curr.right);
			if(curr.left!=null)
				st.push(curr.left);
			if(!st.isEmpty())
				curr.right=st.peek();
			curr.left=null;
		}
		return root;
	}
	static Node flattenapproach2(Node root)
	{
		Node curr=root;
		while(curr!=null)
		{
			if(curr.left!=null)
			{
				Node prev=curr.left;
				while(prev.right!=null)
					prev=prev.right;
				prev.right=curr.right;
				curr.right=curr.left;
			}
			curr=curr.right;
		}
		return root;
	}
	static void printtree(Node root)
	{
		Queue<Node>q=new LinkedList<>();
		q.offer(root);
		while(!q.isEmpty())
		{
			Node temp=q.poll();
			System.out.print(temp.data+" ");
			if(temp.right!=null)
				q.add(temp.right);
		}
	}
}
