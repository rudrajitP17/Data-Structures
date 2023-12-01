package Tree;
import java.util.*;
public class Levelbyleveltraversal 
{
	static Scanner sc=null;
	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		sc=new Scanner(System.in);
		Node root=createTree();
		System.out.println();
		//printlevel(root);//If you use this method, complexity will be n^2
		//use the below queue method, complexity will be O(N)
		printlevel2(root);
	}
	static Node createTree()
	{
		Node root=null;
		System.out.println("Enter data");
		int data=sc.nextInt();
		if(data==-1) 
			return null;
		root=new Node(data);
		System.out.println("Enter left for "+data);
		root.left=createTree();
		System.out.println("Enter right for "+data);
		root.right=createTree();
		return root;
	}
	static void printlevel(Node root)
	{
		int level=height(root);
		for(int i=1;i<=level;i++)
			printcurrentlevel(root,i);
	}
	static int height(Node root)
	{
		if(root==null)
			return 0;
		int lheight=height(root.left);
		int rheight=height(root.right);
		if (lheight>rheight)
			return(lheight+1);
		else
			return(rheight+1);
	}
	static void printcurrentlevel(Node root, int level)
	{
		if(root==null)
			return;
		if(level==1)
			System.out.print(root.data+" ");
		else if(level>1)
		{
			printcurrentlevel(root.left,level-1);
			printcurrentlevel(root.right,level-1);
		}
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
	
}
