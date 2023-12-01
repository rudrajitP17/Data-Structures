package Tree;
import java.util.*;
public class PrintallNodesatDistK {
	static Scanner sc=null;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		sc=new Scanner(System.in);
		Node root=CreateTree();
		System.out.println("Enter distance");
		int k=sc.nextInt();
		System.out.println("Enter target's node data");
		int target=sc.nextInt();
		printatdistK(root,target,k);
	}
	static Node CreateTree()
	{
		System.out.println("Enter data");
		int data=sc.nextInt();
		if(data==-1)
			return null;
		Node node=new Node(data);
		System.out.println("Enter left for "+data);
		node.left=CreateTree();
		System.out.println("Enter right for "+data);
		node.right=CreateTree();
		return node;
	}
	static void printatdistK(Node root,int target, int k)
	{
		roottoleaf(root,target);
		for(int i=0;i<ar.size();i++)
		{
			printdown(ar.get(i),k-i,i==0?null:ar.get(i-1));
		}
	}
	static void printdown(Node node, int k,Node blocker )
	{
		if(node==null || k<0 || node==blocker)
			return;
		if(k==0)
			System.out.print(node.data+" ");
		printdown(node.left,k-1,blocker);
		printdown(node.right,k-1,blocker);
	}
	static ArrayList<Node> ar=new ArrayList<>();
	static boolean roottoleaf(Node root,int leaf)
	{
		if(root==null)
			return false;
		if(root.data==leaf) {
			ar.add(root);
			return true;
		}
		boolean f=roottoleaf(root.left,leaf);
		if(f) {
			ar.add(root);
			return true;
		}
		f=roottoleaf(root.right,leaf);
		if(f) {
			ar.add(root);
			return true;
		}
		return false;
	}
}
