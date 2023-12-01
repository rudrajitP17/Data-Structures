package Graphs;
import java.util.*;
public class BFS {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList < ArrayList < Integer >> adj = new ArrayList < > ();
        for (int i = 0; i < 5; i++) {
            adj.add(new ArrayList < > ());
        }
        adj.get(0).add(1);
        adj.get(1).add(0);
        adj.get(0).add(4);
        adj.get(4).add(0);
        adj.get(1).add(2);
        adj.get(2).add(1);
        adj.get(1).add(3);
        adj.get(3).add(1);
        
        BFS sl = new BFS(); 
        ArrayList < Integer > ans = sl.bfsOfGraph(5, adj);
        int n = ans.size(); 
        for(int i = 0;i<n;i++) {
            System.out.print(ans.get(i)+" "); 
        }
	}
	public ArrayList<Integer> bfsOfGraph(int V, 
		    ArrayList<ArrayList<Integer>> adj) {
		        
		        ArrayList < Integer > bfs = new ArrayList < > ();
		        boolean vis[] = new boolean[V];
		        Queue < Integer > q = new LinkedList < > ();

		        q.add(0);
		        vis[0] = true;

		        while (!q.isEmpty()) {
		            Integer node = q.poll();
		            bfs.add(node);

		            for(int i=0;i<adj.get(node).size();i++)
		            {
		            	int f=adj.get(node).get(i);
		            	if(vis[f]==false)
		            	{
		            		vis[f]=true;
		            		q.add(f);
		            	}
		            }
		        }

		        return bfs;
		    }
}
