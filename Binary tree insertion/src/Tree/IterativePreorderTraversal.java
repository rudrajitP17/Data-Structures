package Tree;
import java.util.*;
public class IterativePreorderTraversal 
{
	static Scanner sc=null;
	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		sc=new Scanner(System.in);
		Node root=createTree();
		printitpreorder(root);
		System.out.println();
		printinorder(root);
		System.out.println();
		printpostorder1(root);//postorder using 2 stacks
		System.out.println();
		printpostorder2(root);//postorder using 1 stack
	}
	static Node createTree()
	{
		System.out.println("Enter data");
		int data=sc.nextInt();
		if(data==-1)
			return null;
		Node node=null;
		node=new Node(data);
		System.out.println("Enter left for "+data);
		node.left=createTree();
		System.out.println("Enter right for "+data);
		node.right=createTree();
		return node;
	}
	static void printitpreorder(Node root)
	{
		Stack<Node> s=new Stack<>();
		s.add(root);
		while(!s.isEmpty())
		{
			Node temp=s.pop();
			System.out.print(temp.data+" ");
			if(temp.right!=null)
				s.add(temp.right);
			if(temp.left!=null)
				s.add(temp.left);
		}
	}
	static void printinorder(Node root)
	{
		Stack<Node> s = new Stack<Node>();
        Node curr = root;
        while (curr != null || s.size() > 0)
        {
           while (curr !=  null)
            {
                s.push(curr);
                curr = curr.left;
            }
            curr = s.pop();
            System.out.print(curr.data + " ");
            curr = curr.right;
        }
    }
	static void printpostorder1(Node root)
	{
		Stack <Node>s1=new Stack<>();
		Stack <Node>s2=new Stack<>();
		s1.add(root);
		while(!s1.isEmpty())
		{
			Node temp=s1.pop();
			s2.add(temp);
			if(temp.left!=null)
				s1.add(temp.left);
			if(temp.right!=null)
				s1.add(temp.right);
		}
		while(!s2.isEmpty())
		{
			Node temp=s2.pop();
			System.out.print(temp.data+" ");
		}
	}
	static void printpostorder2(Node root)
	{
		Node curr=root;
		Stack<Node> s=new Stack<>();
		while(curr!=null || !s.isEmpty())
		{
			if(curr!=null)
			{
				s.push(curr);
				curr=curr.left;
			}
			else
			{
				Node temp=s.peek().right;
				if(temp==null)
				{
					temp=s.pop();
					System.out.print(temp.data+" ");
					while(!s.isEmpty() && temp==s.peek().right)
					{
						temp=s.pop();
						System.out.print(temp.data+" ");
					}
				}
				else
					curr=temp;
			}
		}
	}
}


