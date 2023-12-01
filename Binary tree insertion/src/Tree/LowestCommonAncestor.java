package Tree;
import java.util.*;
public class LowestCommonAncestor {
	static Scanner sc=null;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		sc=new Scanner(System.in);
		Node root=createTree();
		System.out.println("Enter the nodes for ancestors");
		int a=sc.nextInt();
		int b=sc.nextInt();
		Node value=LCA(root,a,b);
		System.out.println(value.data);
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
	static Node LCA(Node root,int p,int q)
	{
		if(root==null)
			return null;
		if(root.data==p || root.data==q)
			return root;
		
		Node left=LCA(root.left,p,q);
		Node right=LCA(root.right,p,q);
		
		if(left==null)
			return right;
		if(right==null)
			return left;
		
		return root;
	}
}
