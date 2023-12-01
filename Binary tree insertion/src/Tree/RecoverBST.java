package Tree;
import java.util.*;
public class RecoverBST {
	static Scanner sc=null;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		sc=new Scanner(System.in);
		Node root=createTree();
		prev=new Node(Integer.MIN_VALUE);
		inorder(root);
		if(first!=null && last!=null)
		{
			Node temp=first;
			first=last;
			last=temp;
		}
		else if(first!=null && middle!=null)
		{
			Node temp=first;
			first=middle;
			middle=temp;
		}
		printinorder(root);
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
	static Node first,middle,last,prev;
	static void inorder(Node root)
	{
		if(root==null)
			return;
		inorder(root.left);
		if(prev!=null && root.data<prev.data)
		{
			if(first==null)
			{
				first=prev;
				middle=root;
			}
			else
				last=root;
		}
		prev=root;
		inorder(root.right);
	}
	static void printinorder(Node root)
	{
		if(root==null)
			return;
		printinorder(root.left);
		System.out.print(root.data+" ");
		printinorder(root.right);
	}
}
