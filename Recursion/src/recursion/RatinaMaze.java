package recursion;
import java.util.*;
public class RatinaMaze {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		int n = 4;
	    int[][] ar = {{1,0,0,0},{1,1,0,1},{1,1,0,0},{0,1,1,1}};
	    String move[]= {"D","L","R","U"};
	    int [][] vis=new int[n][n];
	    for(int i=0;i<ar.length;i++)
	    	for(int j=0;j<ar.length;j++)
	    		vis[i][j]=0;
	    int di[]= {+1,+0,+0,-1};
	    int dj[]= {+0,-1,+1,+0};
	    if(ar[0][0]==1)
	    	mazeroute(ar,vis,arr,"",move,0,0,di,dj);
	    System.out.println(arr);
		sc.close();
	}
	static ArrayList<String> arr=new ArrayList<>();
	static void mazeroute(int ar[][],int vis[][],ArrayList<String> arr,String ans,String move[],int i,int j,int di[],int dj[])
	{
		if(i==ar.length-1 && j==ar.length-1)
		{
			arr.add(ans);
			return;
		}
		for(int ind=0;ind<ar.length;ind++)
		{
			int nexti=i+di[ind];
			int nextj=j+dj[ind];
			if(nexti>=0 && nextj>=0 && nexti<ar.length && nextj<ar.length && ar[nexti][nextj]==1 && vis[nexti][nextj]!=1)
			{
				vis[nexti][nextj]=1;
				mazeroute(ar,vis,arr,ans+move[ind],move,nexti,nextj,di,dj);
				vis[nexti][nextj]=0;
			}
		}
	}
}
