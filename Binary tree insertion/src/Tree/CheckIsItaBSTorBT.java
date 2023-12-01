package Tree;
import java.util.*;
public class CheckIsItaBSTorBT {
	static Scanner sc=null;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		sc=new Scanner(System.in);
		Node root=createTree();
		ArrayList<Integer> ar=new ArrayList<Integer>();
		inorder(root,ar);
		if(checksorting(ar))
			System.out.println("It is a BST");
		else
			System.out.println("It is a BT");
	}
	static boolean checksorting(ArrayList<Integer> ar)
	{
		for(int i=1;i<ar.size();i++)
		{
			if(ar.get(i-1).compareTo(ar.get(i))>0)
			{
				return false;
			}
		}
		return true;
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
	static void inorder(Node root,ArrayList<Integer> ar)
	{
		if(root==null)
			return;
		inorder(root.left,ar);
		ar.add(root.data);	
		inorder(root.right,ar);
		
	}
}
