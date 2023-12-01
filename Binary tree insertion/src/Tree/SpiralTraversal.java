package Tree;
import java.util.*;
public class SpiralTraversal {
	static Scanner sc=null;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		sc=new Scanner(System.in);
		Node root=CreateTree();
		Spiral(root);
	}
	static Node CreateTree()
	{
		System.out.println("Enter data");
		int data=sc.nextInt();
		if(data==-1)
			return null;
		Node node=new Node(data);
		System.out.println("Enter left for "+data);
		node.left=CreateTree();
		System.out.println("Enter right for "+data);
		node.right=CreateTree();
		return node;
	}
	static void Spiral(Node root)
	{
		Stack<Node> st=new Stack<>();
		Stack<Node>	st1=new Stack<>();
		st.add(root);
		while(!st.isEmpty() || !st1.isEmpty())
		{
			while(!st.isEmpty())
			{
				Node curr=st.pop();
				System.out.print(curr.data+" ");
				if(curr.left!=null)
					st1.push(curr.left);
				if(curr.right!=null)
					st1.add(curr.right);
			}
			while(!st1.isEmpty())
			{
				Node curr=st1.pop();
				System.out.print(curr.data+" ");
				if(curr.right!=null)
					st.push(curr.right);
				if(curr.left!=null)
					st.push(curr.left);
			}
		}
	}	
}

