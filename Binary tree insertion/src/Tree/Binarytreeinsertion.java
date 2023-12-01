package Tree;
import java.util.Scanner;
public class Binarytreeinsertion 
{
	static Scanner sc=null;
	public static void main(String args[])
	{
		sc=new Scanner(System.in);
		Node root=createTree();
		System.out.println("Print Pre-order");
		printpreorder(root);
		System.out.println("Print post-order");
		postorder(root);
		System.out.println("Print in-order");
		inorder(root);
		
	}
	static Node createTree()
	{
		Node root=null;
		System.out.println("Enter data : ");
		int data=sc.nextInt();
		if(data==-1)
			return null;
		root=new Node(data);
		System.out.println("Enter left for " +data);
		root.left=createTree();
		System.out.println("Entre right for " +data);
		root.right=createTree();
		return root;
		
	}
	static void printpreorder(Node node)
	{
		if(node==null)
			return;
		System.out.print(node.data+" ");
		printpreorder(node.left);
		printpreorder(node.right);
	}
	static void postorder(Node root)
	{
		if(root==null)
			return;
		postorder(root.left);
		postorder(root.right);
		System.out.print(root.data+" ");
	}
	static void inorder(Node root)
	{
		if(root==null)
			return;
		inorder(root.left);
		System.out.print(root.data);
		inorder(root.right);
	}
}

