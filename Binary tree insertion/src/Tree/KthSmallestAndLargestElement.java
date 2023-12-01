package Tree;
import java.util.*;
public class KthSmallestAndLargestElement {
	static Scanner sc=null;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		sc=new Scanner(System.in);
		Node root=createTree();
		System.out.println("Enter K");
		int k=sc.nextInt();
		System.out.println(kthSmallest(root,k));
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
	static int kthSmallest(Node root,int k)
	{
		Stack<Node> st=new Stack<>();
		int c=0;
		while(true)
		{
			if(root!=null)
			{
				st.push(root);
				root=root.left;
			}
			else
			{
				if(st.isEmpty())
					break;
				else
					root=st.pop();
				c++;
				if(c==k)
					return root.data;
				root=root.right;
			}
		}
		return -1;
	}
}
