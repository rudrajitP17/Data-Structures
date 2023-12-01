package Tree;
import java.util.*;
public class ChildrenSumProperty {
	static Scanner sc=null;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		sc=new Scanner(System.in);
		Node root=createTree();
		levelorder(root);
		ChildSumParent(root);
		System.out.println();
		levelorder(root);
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
	static void levelorder(Node root)
	{
		Queue<Node> q=new LinkedList<>();
		q.add(root);
		while(!q.isEmpty())
		{
			Node temp=q.poll();
			System.out.print(temp.data+" ");
			if(temp.left!=null)
				q.add(temp.left);
			if(temp.right!=null)
				q.add(temp.right);
		}
	}
	static void ChildSumParent(Node root)
	{
		if(root==null)
			return;
		int child=0;
		if(root.left!=null)
			child=child+root.left.data;
		if(root.right!=null)
			child=child+root.right.data;
		if(child>root.data)
			root.data=child;
		else
		{
			if(root.left!=null)
				root.left.data=root.data;
			if(root.right!=null)
				root.right.data=root.data;
		}
		
		ChildSumParent(root.left);
		ChildSumParent(root.right);
		
		int tot=0;
		if(root.left!=null)
			tot=tot+root.left.data;
		if(root.right!=null)
			tot=tot+root.right.data;
		if(root.left!=null || root.right!=null)
			root.data=tot;
	}
}
