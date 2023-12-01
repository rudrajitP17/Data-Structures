package Tree;
import java.util.*;
public class BinarySearchTree {
	static Scanner sc=null;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		sc=new Scanner(System.in);
		Node root=createSearchTree();
		//System.out.println("Enter node to be searched");
		//int val=sc.nextInt();
		//System.out.println(search(root,val).data);
		//System.out.println("Enter Key");
		//int key=sc.nextInt();
		//System.out.println(ceil(root,key));
		//System.out.println("Entre key");
		//int key=sc.nextInt();
		//System.out.println(floor(root,key));
		//System.out.println("Enter value to be inserted");
		//int val=sc.nextInt();
		//root=insert(root,val);
		//printlevel2(root);
		System.out.println("Enter the node's data to be deleted");
		int val=sc.nextInt();
		root=deletenode(root,val);
		printlevel2(root);
	}
	static Node createSearchTree()
	{
		System.out.println("Enter data");
		int data=sc.nextInt();
		if(data==-1)
			return null;
		Node node=new Node(data);
		System.out.println("Enter left for "+data);
		node.left=createSearchTree();
		System.out.println("Enter right for "+data);
		node.right=createSearchTree();
		return node;
	}
	static Node search(Node root,int val)
	{
		while(root!=null && root.data!=val)
		{
			root=root.data<val?root.right:root.left;
		}
		return root;
	}
	static int ceil(Node root,int key)
	{
		int ceil=-1;
		while(root!=null)
		{
			if(key==root.data)
			{
				ceil=root.data;
				return ceil;
			}
			if(key>root.data)
			{
				root=root.right;
			}
			else
			{
				ceil=root.data;
				root=root.left;
			}
		}
		return ceil;
	}
	static int floor(Node root,int key)
	{
		int floor=-1;
		while(root!=null)
		{
			if(key==root.data)
			{
				floor=root.data;
				return floor;
			}
			if(key<root.data)
			{
				root=root.left;
			}
			else
			{
				floor=root.data;
				root=root.right;
			}
		}
		return floor;
	}
	static Node insert(Node root,int val)
	{
		Node curr=root;
		while(curr!=null)
		{
			if(curr.data<val)
			{
				if(curr.right!=null)
					curr=curr.right;
				else
				{
					curr.right=new Node(val);
					break;
				}
			}
			else
			{
				if(curr.left!=null)
					curr=curr.left;
				else
				{
					curr.left=new Node(val);
					break;
				}
			}
		}
		return root;
	}
	static void printlevel2(Node root)
	{
		Queue<Node> q=new LinkedList<>();
		q.add(root);
		while(!q.isEmpty())
		{
			Node curr=q.poll();
			System.out.print(curr.data+" ");
			if(curr.left!=null)
				q.add(curr.left);
			if(curr.right!=null)
				q.add(curr.right);
		}
		
	}
	static Node deletenode(Node root,int val)
	{
		if(root.data==val)
			return helper(root);
		Node curr=root;
		while(curr!=null)
		{
			if(root.data>val)
			{
				if(root!=null && root.left.data==val)
				{
					root.left=helper(root.left);
					break;
				}
				else
					root=root.left;
			}
			else
			{
				if(root!=null && root.right.data==val)
				{
					root.right=helper(root.right);
					break;
				}
				else
					root=root.right;
			}
		}
		return curr;
	}
	static Node helper(Node root)
	{
		if(root.left==null)
			return root.right;
		if(root.right==null)
			return root.left;
		Node rightchild=root.right;
		Node leftchild=root.left;
		while(leftchild.right!=null)
			leftchild=leftchild.right;
		leftchild.right=rightchild;
		return root.left;
	}
	
}
