package recursion;
import java.util.*;
public class Nqueens {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter N");
		int n=sc.nextInt();
		List<String> ar=new ArrayList<>();
		char board[][]=new char[n][n];
		helper(board,ar,0);
		System.out.println(arr);
		sc.close();
	}
	static List<List<String>> arr=new ArrayList<>();
	static void helper(char board[][],List<String> ar, int col)
	{
		if(col==board.length)
		{
			String row="";
			for(int i=0;i<board.length;i++)
			{
				row="";
				for(int j=0;j<board.length;j++)
				{
					if(board[i][j]=='Q')
						row=row+'Q';
					else
						row=row+'.';		
				}
				ar.add(row);
			}
			arr.add(new ArrayList<>(ar));
			ar.clear();
			return;
		}
		for(int row=0;row<board.length;row++)
		{
			if(isSafe(row,col,board))
			{
			board[row][col]='Q';
			helper(board,ar,col+1);
			board[row][col]='.';
			}
		}
	}
	static boolean isSafe(int row,int col,char board[][])
	{
		
		for(int c=0;c<board.length;c++)
			if(board[row][c]=='Q')
				return false;
		for(int r=0;r<board.length;r++)
			if(board[r][col]=='Q')
				return false;
		int r=row;
		for(int c=col;c>=0 && r>=0;r--,c--)
			if(board[r][c]=='Q')
				return false;
		r=row;
		for(int c=col;c<board.length && r>=0;r--,c++)
			if(board[r][c]=='Q')
				return false;
		r=row;
		for(int c=col;c>=0 && r<board.length;r++,c--)
			if(board[r][c]=='Q')
				return false;
		return true;
	}
}
