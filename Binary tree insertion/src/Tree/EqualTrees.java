package Tree;
import java.util.*;

public class EqualTrees 
{
	static Scanner sc=null;
	public static void main(String args[])
	{
		sc=new Scanner(System.in);
		System.out.println("Entre 1st tree");
		Node root1=createTree();
		System.out.println("Entre 2nd tree");
		Node root2=createTree();
		System.out.println(equalornot(root1, root2));
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
	static boolean equalornot(Node root1, Node root2)
	{
		if(root1==null || root2==null)
			return(root1==root2);
		if(root1!=null && root2!=null)
		{
			if(root1.data==root2.data && equalornot(root1.left,root2.left) && equalornot(root1.right,root2.right));
			return (root1.data==root2.data);
		}
		return false;
	}

}
