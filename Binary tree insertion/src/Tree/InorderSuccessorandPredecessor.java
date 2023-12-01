package Tree;
import java.util.*;
public class InorderSuccessorandPredecessor {
	static Scanner sc=null;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		sc=new Scanner(System.in);
		Node root=createTree();
		System.out.println("Enter successor root's data");
		int data=sc.nextInt();
		System.out.println(successor(root,data));
		System.out.println(predecessor(root,data));
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
	static int successor(Node root,int val)
	{
		int successor=0;
		while(root!=null)
		{
			if(root.data>val)
			{
				successor=root.data;
				root=root.left;
			}
			else
			{
				root=root.right;
			}
		}
		return successor;
	}
	static int predecessor(Node root,int val)
	{
		int pred=0;
		while(root!=null)
		{
			if(root.data>=val)
			{
				root=root.left;
			}
			else
			{
				pred=root.data;
				root=root.right;
			}
		}
		return pred;
	}
}
