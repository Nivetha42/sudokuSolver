
public class SudokuSolver {

	public static void main(String[] args) {
	    /* 9 x 9 Matrix */
		/*int[][] board=new int[][] {
			{1,2,0,3,0,4,0,5,6},
			{7,0,0,0,0,6,0,0,1},
			{0,0,0,0,0,0,0,0,0},
			{0,8,0,4,0,9,0,2,0},
			{0,0,0,0,6,0,0,0,0},
			{0,3,0,5,0,1,0,8,0},
			{0,0,0,0,0,0,0,0,0},
			{9,0,0,2,0,0,0,0,8},
			{8,4,0,6,0,7,0,1,9}
		};*/
		/* 6 x 6 Matrix */
		/*int[][] board=new int[][] {
			{0,0,2,0,3,0},
			{4,0,0,6,0,0},
			{0,0,0,0,5,6},
			{1,6,0,0,0,0},
			{0,0,6,0,0,1},
			{0,4,0,5,0,0}
			};*/
		/* 4 x 4 Matrix */
		/*int[][] board=new int[][] {
			{0,1,0,0},
			{0,0,1,0},
			{0,2,0,0},
			{0,0,3,0} 
		};*/
		int[][] board=new int[][] {
			{0,0,3,0},
			{0,0,1,0},
			{0,0,0,1},
			{3,0,2,0}
			
		};
		if(solve(board))
		{
			display(board);
		}
		else
		{
			System.out.println("Cannot be solved");
		}
		
		
		
	}
	
	
	static boolean solve(int[][] board)
	{
		int n=board.length;
		int row=-1;
		int col=-1;
		boolean emptyLeft=true;
		for(int i=0;i<n;i++)
		{
			for(int j=0;j<n;j++)
			{
				if(board[i][j]==0)
				{
					row=i;
					col=j;
					emptyLeft=false;
					break;
				}
			}
			if(emptyLeft==false)
			{
				break;
			}
		}
		
		if(emptyLeft==true)
		{
			return true;
		}
		for(int number=1;number<=board.length;number++)
		{
			if(isSafe(board,row,col,number))
			{
				board[row][col]=number;
				if(solve(board))
				{
					return true;
				}else
				{
					board[row][col]=0;
				}
			}
		}
		return false;
	}
	
	static void display(int[][] board)
	{
		for(int[] row:board)
		{
			for(int num:row)
			{
				System.out.print(num+" ");
			}
			System.out.println("");
		}
	}
	
	
	static boolean isSafe(int[][] board,int row,int col,int num)
	{
		for(int i=0;i<board.length;i++)
		{
			if(board[row][i]==num)
			{
				return false;
			}
		}
		for(int[] nums:board)
		{
			if(nums[col]==num)
			{
				return false;
			}
		}
		int sqrt=(int)Math.sqrt(board.length);
		int rowStart=row-(row%sqrt);
		int colStart=col-(col%sqrt);
		for(int i=rowStart;i<rowStart+sqrt;i++)
		{
			for(int j=colStart;j<colStart+sqrt;j++)
			{
				if(board[i][j]==num)
				{
					return false;
				}
			}
		}
		return true;
	}
	
}
