package Tree;
import java.util.*;
public class CreateTreewithPreandInorder 
{
static Scanner sc=null;
	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		sc=new Scanner(System.in);
		System.out.println("Enter number of nodes of a tree");
		int n=sc.nextInt();int in[]=new int[n];int pre[]=new int[n];
		System.out.println("Enter the inorder traversal");
		for(int i=0;i<n;i++)
			in[i]=sc.nextInt();
		System.out.println("Enter the preorder traversal");
		for(int i=0;i<n;i++)
			pre[i]=sc.nextInt();
		Map<Integer,Integer> map=new HashMap<>();
		for(int i=0;i<n;i++)
			map.put(in[i], i);
		Node root=buildtree(pre,0,n-1,in,0,n-1,map);
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
	static Node buildtree(int pre[],int prestart,int preend,int in[],int instart,int inend, Map<Integer,Integer>map )
	{
		if(prestart>preend || instart>inend)
			return null;
		Node root=new Node(pre[prestart]);
		int inroot=map.get(root.data);
		int numsleft=inroot-instart;
		root.left=buildtree(pre,prestart+1,prestart+numsleft,in,instart,inroot-1,map);
		root.right=buildtree(pre,prestart+numsleft+1,preend,in,inroot+1,inend,map);
		return root;
	}
}
