package Graphs;
import java.util.*;
public class FloodFillAlgo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int image[][]= {{1,1,1},{1,1,0},{1,0,1}};
		FloodFillAlgo ob=new FloodFillAlgo();
		int ans[][]=ob.floodfill(image,1,1,2);
		for(int i=0;i<ans.length;i++)
		{
			for(int j=0;j<ans.length;j++)
			{
				System.out.print(ans[i][j]);
			}
			System.out.println();
		}
	}
	public int[][] floodfill(int image[][],int sr,int sc, int newcolor)
	{
		int incolor=image[sr][sc];
		int derow[] = {-1,0,+1,0};
		int decol[] = {0,+1,0,-1};
		int ans[][]=image;
		dfs(image,ans,sr,sc,newcolor,derow,decol,incolor);
		return ans;
	}
	void dfs(int image[][],int ans[][],int sr,int sc,int newcolor,int derow[],int decol[],int incolor)
	{
		ans[sr][sc]=newcolor;
		int n=image.length;
		int m=image[0].length;
		for(int i=0;i<4;i++)
		{
			int nr=derow[i]+sr;
			int nc=decol[i]+sc;
			if(nr>=0 && nr<n && nc>=0 && nc<m && image[nr][nc]==incolor && ans[nr][nc]!=newcolor)
				dfs(image,ans,nr,nc,newcolor,derow,decol,incolor);
		}
	}

}
