package Tree;
import java.util.*;
public class Boundarytraversal {
	static Scanner sc=null;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		sc=new Scanner(System.in);
		Node root=createTree();
		boundrytraversal(root);
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
	static Boolean isLeaf(Node root) {
        return (root.left == null) && (root.right == null);
    }
	static void boundryleft(Node root)
	{
		Node curr=root;
		while(curr!=null)
		{
			if(isLeaf(curr)==false)
				ar.add(curr.data);
			if(curr.left!=null)
				curr=curr.left;
			else
				curr=curr.right;
		}
	}
	static void addleafs(Node root)
	{
		if(isLeaf(root))
		{
			ar.add(root.data);
			return;
		}
		if(root.left!=null)
			addleafs(root.left);
		if(root.right!=null)
			addleafs(root.right);
	}
	static void boundryRight(Node root)
	{
		Node curr=root;
		while(curr!=null)
		{
			if(isLeaf(curr)==false)
				st.add(curr.data);
			if(curr.right!=null)
				curr=curr.right;
			else
				curr=curr.left;
		}
	}
	static Stack<Integer> st=new Stack<>();
	static Queue<Integer> ar=new LinkedList<>();
	static void boundrytraversal(Node root)
	{
		boundryleft(root);
		addleafs(root);
		boundryRight(root.right);
		while(!ar.isEmpty())
			System.out.print(ar.remove()+" ");
		while(!st.isEmpty())
			System.out.print(st.pop()+" ");
	}
	
}
