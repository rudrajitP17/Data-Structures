package Graphs;
import java.util.*;
public class DFS {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<ArrayList<Integer>> adj=new ArrayList<>();
		for(int i=0;i<=8;i++)
			adj.add(new ArrayList<Integer> ());
		adj.get(1).add(2);
		adj.get(2).add(1);
		adj.get(1).add(3);
		adj.get(3).add(1);
		adj.get(2).add(5);
		adj.get(5).add(2);
		adj.get(2).add(6);
		adj.get(6).add(2);
		adj.get(3).add(4);
		adj.get(4).add(3);
		adj.get(3).add(7);
		adj.get(7).add(3);
		adj.get(4).add(8);
		adj.get(7).add(8);
		adj.get(8).add(4);
		adj.get(8).add(7);
		
		DFS ob=new DFS();
		ArrayList<Integer> dfs=ob.dfstraversal(8,adj);
		for(int i=0;i<dfs.size();i++)
			System.out.print(dfs.get(i)+" ");
	}
	public ArrayList<Integer> dfstraversal(int v,ArrayList<ArrayList<Integer>> adj)
	{
		boolean vis[]=new boolean[v+1];
		vis[1]=true;
		ArrayList<Integer> dfs1=new ArrayList<>();
		dfslist(1,vis,adj,dfs1);
		return dfs1;
	}
	void dfslist(int node,boolean vis[],ArrayList<ArrayList<Integer>> adj, ArrayList<Integer> dfs1)
	{
		vis[node]=true;
		dfs1.add(node);
		for(int i=0;i<adj.get(node).size();i++)
		{
			int f=adj.get(node).get(i);
			if(vis[f]==false)
				dfslist(f,vis,adj,dfs1);
		}
	}
}
