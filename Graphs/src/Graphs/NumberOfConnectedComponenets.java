package Graphs;
import java.util.*;
public class NumberOfConnectedComponenets {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int grid[][] = new int[5][5];
		NumberOfConnectedComponenets ob=new NumberOfConnectedComponenets();
		grid[0][1]=1;
		grid[0][2]=1;
		grid[1][1]=1;
		grid[1][2]=1;
		grid[2][2]=1;
		grid[4][0]=1;
		grid[4][1]=1;
		grid[4][4]=1;
		grid[2][4]=1;
		System.out.println(ob.numberofcomponenets(grid));
	}
	public int numberofcomponenets(int grid[][]) {
		int n=grid.length;
		int m=grid[0].length;
		int vis[][]=new int[n][m];
		int cnt=0;
		for(int i=0;i<n;i++)
		{
			for(int j=0;j<m;j++)
			{
				if(vis[i][j]==0 && grid[i][j]==1)
				{
					cnt++;
					bfs(grid,vis,i,j);
				}
			}
		}
		return cnt;
	}
	void bfs(int grid[][],int vis[][],int i, int j)
	{
		Queue<Pair> q=new LinkedList<>();
		q.add(new Pair(i,j));
		vis[i][j]=1;
		int n=grid.length;
		int m=grid[0].length;
		while(!q.isEmpty())
		{
			int row=q.peek().first;
			int col=q.peek().second;
			q.remove();
			for(int derow=-1;derow<=1;derow++)
			{
				for(int decol=-1;decol<=1;decol++)
				{
					int nr=derow+row;
					int nc=decol+col;
					if(nr>=0 && nr<n && nc>=0 && nc<m && grid[nr][nc]==1 && vis[nr][nc]==0)
					{
						q.add(new Pair(nr,nc));
						vis[nr][nc]=1;
					}
				}
			}
		}
	}
}
