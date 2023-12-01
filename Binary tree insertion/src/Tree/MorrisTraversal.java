package Tree;
import java.util.*;
public class MorrisTraversal {
	static Scanner sc=null;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		sc=new Scanner(System.in);
		Node root=createTree();
		morrisinorder(root);
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
	static void morrisinorder(Node root)
	{
		ArrayList<Integer> ar=new ArrayList<>();
		Node curr=root;
		while(curr!=null)
		{
			if(curr.left==null)
			{
				ar.add(curr.data);
				curr=curr.right;
			}
			else
			{
				Node prev=curr.left;
				while(prev.right!=null && prev.right!=curr)
					prev=prev.right;
				if(prev.right==null)
				{
					prev.right=curr;
					curr=curr.left;
				}
				else
				{
					prev.right=null;
					ar.add(curr.data);
					curr=curr.right;
				}
			}
		}
		System.out.println(ar);
	}
}
