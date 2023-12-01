package Tree;
import java.util.*;
public class RoottoLeaf {
	static Scanner sc=null;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		sc=new Scanner(System.in);
		Node root=createTree();
		System.out.println("Enter leaf");
		int leaf=sc.nextInt();
		roottoleaf(root,leaf);
		System.out.println("Path "+ar);
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
	static ArrayList<Integer> ar=new ArrayList<>();
	static boolean roottoleaf(Node root,int leaf)
	{
		if(root==null)
			return false;
		if(root.data==leaf) {
			ar.add(root.data);
			return true;
		}
		boolean f=roottoleaf(root.left,leaf);
		if(f) {
			ar.add(root.data);
			return true;
		}
		f=roottoleaf(root.right,leaf);
		if(f) {
			ar.add(root.data);
			return true;
		}
		return false;
	}
}
