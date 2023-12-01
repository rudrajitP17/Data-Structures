package Tree;
import java.util.*;
public class MaxLengthBetweenNodes 
{
	static Scanner sc=null;
	public static void main(String args[])
	{
		sc=new Scanner(System.in);
		Node root=createTree();
		Maxlen(root);
		System.out.println("Maximum length between 2 nodes = " +max);
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
		System.out.println("Enter right for "+data);
		root.right=createTree();
		return root;
	}
	static int max=0;
	static int Maxlen(Node root)
	{
		if(root==null)
			return 0;
		int lh=Math.max(0,Maxlen(root.left));
		int rh=Math.max(0,Maxlen(root.right));
		max=Math.max(max,lh+rh+root.data);
		return Math.max(lh,rh)+root.data;
	}

}
