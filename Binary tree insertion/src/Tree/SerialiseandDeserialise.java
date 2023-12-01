package Tree;
import java.util.*;
public class SerialiseandDeserialise {
	static Scanner sc=null;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		sc=new Scanner(System.in);
		Node root=createTree();
		String data=serialise(root);
		System.out.println(data);
		root=deserSTRING(data);
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
	static String serialise(Node root)
	{
		if(root==null)
			return "x";
		String serL=serialise(root.left);
		String serR=serialise(root.right);
		return root.data+","+serL+","+serR;
	}
	static Node deserSTRING(String data)
	{
		String arr[]=data.split(",");
		Queue<String> q=new LinkedList<>();
		for(int i=0;i<arr.length;i++)
			q.offer(arr[i]);
		Node root=deserliase(q);
		return root;
	}
	static Node deserliase(Queue<String> q) 
	{
		String temp=q.poll();
		if(temp.equals("x"))
			return null;
		Node node=new Node(Integer.parseInt(temp));
		node.left=deserliase(q);
		node.right=deserliase(q);
		return node;
	}
}
