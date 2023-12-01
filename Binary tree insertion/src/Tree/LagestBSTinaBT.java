package Tree;
import java.util.*;
public class LagestBSTinaBT {
	static Scanner sc=null;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		sc=new Scanner(System.in);
		Node root=createTree();
		levelbylevel(root);int ans=0;
		for(int i=0;i<ar.size()-1;i++)
		{
			inorder(ar.get(i));boolean f=false;
			for(int j=1;j<ar1.size();j++)
			{
				if(ar1.get(j-1).compareTo(ar1.get(j))>0)
				{
					f=false;
					break;
				}
				else
				{
					f=true;
				}
			}
			if(f)
				ans=Math.max(ans,ar1.size());
			ar1.clear();
		}
		System.out.println(ans);
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
	static ArrayList<Node> ar=new ArrayList<>(); 
	static void levelbylevel(Node root)
	{
		Queue<Node> q=new LinkedList<>();
		q.add(root);
		while(!q.isEmpty())
		{
			Node temp=q.poll();
			ar.add(temp);
			if(temp.left!=null)
				q.add(temp.left);
			if(temp.right!=null)
				q.add(temp.right);
		}
	}
	static ArrayList<Integer> ar1=new ArrayList<>();
	static void inorder(Node root)
	{
		if(root==null)
			return;
		inorder(root.left);
		ar1.add(root.data);
		inorder(root.right);
	}
}