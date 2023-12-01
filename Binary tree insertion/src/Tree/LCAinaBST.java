package Tree;
import java.util.*;
public class LCAinaBST {
	static Scanner sc=null;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		sc=new Scanner(System.in);
		Node root=createTree();
		System.out.println("Enter data of the nodes for LCA");
		int p=sc.nextInt();
		int q=sc.nextInt();
		System.out.println(LCAinBST(root,p,q).data);
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
	static Node LCAinBST(Node root,int p,int q)
	{
		if(root.data>p && root.data>q)
			return LCAinBST(root.left,p,q);
		if(root.data<p && root.data<q)
			return LCAinBST(root.right,p,q);
		return root;
	}
}
