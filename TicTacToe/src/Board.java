
public class Board
{

	
	public void createBoard() 
	{
		int floor = 0;
		String[][] board = {{"0", "1", "2"}, 
								   {"3", "4", "5"}, 
								   {"6", "7", "8"}};
		for(int i = 0;  i<board.length; i++)
		{
			
			System.out.print("  "+board[0][i]+" |");
			System.out.print("  "+board[1][i]+" |");
			System.out.print("  "+board[2][i]+"");
			System.out.println();
			if(floor<2)
			{
				System.out.print("______________");
				
			}
			floor++;
			System.out.println();
		}
	}
	
	
	public void eraseBoard() 
	{
		System.out.println("BOARD IS BEING ERASED ....");
	}
	
	
	
}
