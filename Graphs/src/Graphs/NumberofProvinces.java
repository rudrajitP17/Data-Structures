package Graphs;
import java.util.*;
public class NumberofProvinces {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int isConnected[][]=new int [4][4];
		isConnected[0][0]=1;
		isConnected[0][1]=1;
		isConnected[1][0]=1;
		isConnected[1][1]=1;
		isConnected[2][2]=1;
		isConnected[3][3]=1;
		NumberofProvinces ob=new NumberofProvinces();
		System.out.println(ob.findProvince(isConnected));
	}
	public int findProvince(int[][] isConnected) {
	   int n=isConnected.length;
	     ArrayList<ArrayList<Integer>> adj=new ArrayList<>();
	        for(int i=0;i<n;i++)
	            adj.add(new ArrayList<Integer>());
	        for(int i=0;i<n;i++)
	        {
	            for(int j=0;j<n;j++)
	            {
	                if(isConnected[i][j]==1 && i!=j)
	                {
	                    adj.get(i).add(j);
	                    adj.get(j).add(i);
	                }
	            }
	        }
	        int vis[]=new int[n];
	        int cnt=0;
	        for(int i=0;i<n;i++)
	        {
	            if(vis[i]==0)
	            {
	                cnt++;
	                dfs(i,adj,vis);
	            }
	        }
	        return cnt;
	    }
	    void dfs(int node, ArrayList<ArrayList<Integer>> adj, int vis[])
	    {
	        vis[node]=1;
	        for(int i=0;i<adj.get(node).size();i++)
	        {
	            int f=adj.get(node).get(i);
	            if(vis[f]==0)
	                dfs(f,adj,vis);
        }
    }
}
