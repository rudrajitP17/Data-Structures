package Tree;
import java.util.*;
public class Diameterofatree 
{
	static Scanner sc=null;
	public static void main(String args[])
	{
		sc=new Scanner(System.in);
		Node root=createTree();
		diameter(root);
		System.out.println("Dimater is "+maxdia);
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
		System.out.println("Entre right for "+data);
		node.right=createTree();
		return node;
	}
	static int maxdia=0;
	static int diameter(Node root)
	{
		if(root == null)
			return 0;
		int lh=diameter(root.left);
		int rh=diameter(root.right);
		maxdia=Math.max(maxdia,lh+rh+1);
		return Math.max(lh, rh)+1;
	}
}
