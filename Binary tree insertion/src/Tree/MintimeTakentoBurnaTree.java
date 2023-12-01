package Tree;
import java.util.*;
public class MintimeTakentoBurnaTree {
	static Scanner sc=null;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		sc=new Scanner(System.in);
		Node root=createTree();
		System.out.println("Enter target");
		int target=sc.nextInt();
		System.out.println(mintime(root,target));
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
	static int mintime(Node root,int target)
	{
		Depth depth=new Depth(-1);
		Burntree(root,target,depth);
		return ans;
	}
	static int ans=-1;
	static int Burntree(Node root,int target,Depth depth)
	{
		if(root==null)
			return 0;
		if(root.data==target)
		{
			depth.d=1;
			return 1;
		}
		Depth ld=new Depth(-1);
		Depth rd=new Depth(-1);
		
		int lh=Burntree(root.left,target,ld);
		int rh=Burntree(root.right,target,rd);
		
		if(ld.d != -1)
		{
			ans=Math.max(ans, ld.d+1+rh);
			depth.d=ld.d+1;
		}
		if(rd.d != -1)
		{
			ans=Math.max(ans,rd.d+1+lh);
			depth.d=rd.d+1;
		}
				return Math.max(lh, rh)+1;
	}
}
class Depth
{
	int d;
	Depth(int d)
	{
		this.d=d;
	}
}