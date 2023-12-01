package Tree;
import java.util.*;
public class CreateTreewithPostandInorder {
	static Scanner sc=null;
	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		sc=new Scanner(System.in);
		System.out.println("Enter the no of nodes in the tree");
		int n=sc.nextInt();int in[]=new int[n];int post[]=new int[n];
		System.out.println("Enter In-order");
		for(int i=0;i<n;i++)
			in[i]=sc.nextInt();
		System.out.println("Enter Post-order");
		for(int i=0;i<n;i++)
			post[i]=sc.nextInt();
		Map<Integer,Integer> map=new HashMap<>();
		for(int i=0;i<n;i++)
			map.put(in[i], i);
		Node root=buildtree(in,0,n-1,post,0,n-1,map);
		Queue<Node> q=new LinkedList<>();
		q.offer(root);
		while(!q.isEmpty())
		{
			Node temp=q.poll();
			System.out.print(temp.data+" ");
			if(temp.left!=null)
				q.offer(temp.left);
			if(temp.right!=null)
				q.offer(temp.right);
		}
	}
	static Node buildtree(int[] in,int instart,int inend,int[] post,int poststart,int postend,Map<Integer,Integer>map)
	{
		if(instart>inend || poststart>postend)
			return null;
		Node root=new Node(post[postend]);
		int inroot=map.get(post[postend]);
		int numsleft=inroot-instart;
		root.left=buildtree(in,instart,inroot-1,post,poststart,poststart+numsleft-1,map);
		root.right=buildtree(in,inroot+1,inend,post,numsleft+poststart,postend-1,map);
		return root;
	}
}
