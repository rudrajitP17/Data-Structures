package Tree;
import java.util.*;
public class TwosumBSTProblem {
	static Scanner sc=null;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		sc=new Scanner(System.in);
		Node root=createTree();
		System.out.println("Enter the Sum value");
		int k=sc.nextInt();
		inorder(root,in);
		int i=0;int s=in.size()-1;
		int sum=0;
		while(true)
		{
			sum=in.get(i)+in.get(s);
			if(sum>k)
				s--;
			if(sum<k)
				i++;
			if(sum==k)
				break;
		}
		System.out.println("Two nodes are "+in.get(i)+" "+in.get(s));
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
	static ArrayList<Integer> in=new ArrayList<>();
	static void inorder(Node root,ArrayList<Integer> in)
	{
		if(root==null)
			return;
		inorder(root.left,in);
		in.add(root.data);
		inorder(root.right,in);
	}
}
