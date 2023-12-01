package Tree;
import java.util.*;
public class BalanceBinarytree 
{
	static Scanner sc=null;
	public static void main(String args[])
	{
		sc=new Scanner(System.in);
		Node root=createTree();
		checkbalance(root);
		if(f==0)
			System.out.println("Tree is not balance");
		else
			System.out.println("Tree is balanced");
	}
	static Node createTree()
	{
		System.out.println("Enter data");
		int data=sc.nextInt();
		if(data==-1)
			return null;
		Node root=new Node(data);
		System.out.println("Enter left for "+data);
		root.left=createTree();
		System.out.println("Entre right for "+data);
		root.right=createTree();
		return root;
	}
	static int f=1;
	static int checkbalance(Node root)
	{
		if(root==null)
			return 0;
		int lh=checkbalance(root.left);
		int rh=checkbalance(root.right);
		if(Math.abs(lh-rh)>1)
			f=0;
		return (Math.max(lh,rh)+1);
	}
}
