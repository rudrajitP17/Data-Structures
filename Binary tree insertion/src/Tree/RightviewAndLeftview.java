package Tree;
import java.util.*;
public class RightviewAndLeftview 
{
	static Scanner sc=null;
	public static void main(String args[])
	{
		sc=new Scanner(System.in);
		Node root=createTree();
		System.out.print("Left view : ");
		leftview(root,0);
		while(st.size()!=0)
			System.out.print(st.pop()+" ");
		System.out.print("\nRight view : ");
		rightview(root,0);
		while(st.size()!=0)
			System.out.print(st.pop()+" ");
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
	static Stack<Integer>st=new Stack<>();
	static void rightview(Node root,int level)
	{
		if(root==null)
			return;
		if(level==st.size())
			st.add(root.data);
		if(root.right!=null)
			rightview(root.right,level+1);
		if(root.left!=null)
			rightview(root.left,level+1);
	}
	static void leftview(Node root,int level)
	{
		if(root==null)
			return;
		if(level==st.size())
			st.add(root.data);
		if(root.left!=null)
			leftview(root.left,level+1);
		if(root.right!=null)
			leftview(root.right,level+1);
	}
}
