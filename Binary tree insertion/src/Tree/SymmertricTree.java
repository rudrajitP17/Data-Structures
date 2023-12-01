package Tree;
import java.util.*;
public class SymmertricTree 
{
	static Scanner sc=null;
	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		sc=new Scanner(System.in);
		Node root=createTree();
		System.out.println(symmetrycheck(root.left,root.right));
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
	static boolean symmetrycheck(Node root1, Node root2)
	{
		if(root1==null || root2==null)
			return root1==root2;
		if(root1.data!=root2.data)
			return false;
		return symmetrycheck(root1.left,root2.right)&&symmetrycheck(root1.right,root2.left);
	}
}
