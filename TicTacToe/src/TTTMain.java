import java.util.ArrayList;
import java.util.Scanner;

public class TTTMain
{
	
	static Board board; 
	static boolean playing = true; 
	static boolean winning = false;
	static int floor = 0;
	static String[][] gameboard = {{"0", "3", "6"}, 
							   {"1", "4", "7"}, 
							   {"2", "5", "8"}};
	public static void main(String[] args)
	{
		board = new Board(); 
		while(playing)
		{
			
			for(int i = 0;  i<gameboard.length; i++)
			{
				
				System.out.print("  "+gameboard[0][i]+" |");
				System.out.print("  "+gameboard[1][i]+" |");
				System.out.print("  "+gameboard[2][i]+"");
				System.out.println();
				if(floor<2)
				{
					System.out.print("______________");
					
				}
				floor++;
				System.out.println();
			}
			ArrayList<Integer> numList = new ArrayList<Integer>(); 
			numList.add(0);
			numList.add(1);
			numList.add(2);
			numList.add(3);
			numList.add(4);
			numList.add(5);
			numList.add(6);
			numList.add(7);
			numList.add(8);
			
			while(!winning)
			{
				if(numList.isEmpty())
				{
					System.out.println("TIE");
					break;
				}
				Scanner scanner1 = new Scanner(System.in);
				Scanner scanner2 = new Scanner(System.in);
				System.out.println("First player enter your move:");
				int firstPlayer = Integer.parseInt(scanner1.nextLine());
				// checks if the space is taken or not
				while(!numList.contains(firstPlayer)) 
				{
					Scanner newInput = new Scanner(System.in);
					System.out.println("That spot was already taken; Enter Another:");
					firstPlayer=Integer.parseInt(newInput.nextLine());
				}
				//removes its spot from the list to track the places
				for(int y = 0; y<numList.size(); y++)
				{
					if(numList.get(y) == firstPlayer) 
					{
						numList.remove(y);
					}
				}
				if(numList.isEmpty())
				{
					if(checkWin().equals("X WON"))
					{
						System.out.println(checkWin());
						break;
					}else if(checkWin().equals("O WON "))
					{
						System.out.println(checkWin());
						break; 
					}else
					{
						System.out.println("TIE ");
						break; 
					}
						
				}
				System.out.println("Second player enter your move:");
				int secondPlayer = Integer.parseInt(scanner2.nextLine());
				// checks if the space is taken or not
				while(!numList.contains(secondPlayer)) 
				{
					Scanner newInput = new Scanner(System.in);
					System.out.println("That spot was already taken; Enter Another:");
					secondPlayer =Integer.parseInt(newInput.nextLine());
				}
				//removes its spot from the list to track the places
				for(int y = 0; y<numList.size(); y++)
				{
					if(numList.get(y) == secondPlayer) 
					{
						numList.remove(y);
					}
				}
				
				
				// updates board 
				updateBoard(firstPlayer, secondPlayer);
				//Checks win
				if(checkWin().equals("X WON")||checkWin().equals("O WON")) 
				{
					System.out.println(checkWin());
					break;
				}
					
				
			}
			// If they want to continue playing or not
			System.out.println("Would you like to continue playing? (yes/no)");
			Scanner scanner3 = new Scanner(System.in); 
			if(scanner3.nextLine().equals("no"))
			{
				playing=false;
			}
			board.eraseBoard();
			System.out.println("Restart program if you would like to play again");
			playing =false; 
		}
		System.out.println("Thanks For Playing");
		

	}
	public static void updateBoard(int x, int o) 
	{
		switch(x)
		{
			case 0:
				gameboard[0][0] = "X"; 
				break;
			case 1:
				gameboard[1][0] = "X"; 
				break; 
			case 2:
				gameboard[2][0] = "X"; 
				break; 
			case 3:
				gameboard[0][1] = "X"; 
				break; 
			case 4:
				gameboard[1][1] = "X"; 
				break; 
			case 5:
				gameboard[2][1] = "X"; 
				break; 
			case 6:
				gameboard[0][2] = "X"; 
				break; 
			case 7:
				gameboard[1][2] = "X"; 
				break; 
			case 8:
				gameboard[2][2] = "X"; 
				break; 
		}
		
		switch(o)
		{
			case 0:
				gameboard[0][0] = "O"; 
				break; 
			case 1:
				gameboard[1][0] = "O";
				break; 
			case 2:
				gameboard[2][0] = "O"; 
				break; 
			case 3:
				gameboard[0][1] = "O"; 
				break; 
			case 4:
				gameboard[1][1] = "O"; 
				break; 
			case 5:
				gameboard[2][1] = "O"; 
				break; 
			case 6:
				gameboard[0][2] = "O"; 
				break; 
			case 7:
				gameboard[1][2] = "O"; 
				break; 
			case 8:
				gameboard[2][2] = "O"; 
				break; 
		}
		
		for(int i = 0;  i<gameboard.length; i++)
		{
			floor=1;
			System.out.print("  "+gameboard[0][i]+" |");
			System.out.print("  "+gameboard[1][i]+" |");
			System.out.print("  "+gameboard[2][i]+"");
			System.out.println();
			if(floor<2)
			{
				System.out.print("______________");
				
			}
			floor++;
			System.out.println();
		}
	}
	public static String checkWin() 
	{
		if(gameboard[0][0] == "X" && gameboard[0][1] == "X" && gameboard[0][2] == "X") 
		{
			return "X WON";
		}else if(gameboard[0][0] == "X" && gameboard[1][0] == "X" && gameboard[2][0] == "X") 
		{
			return "X WON";
		}else if(gameboard[0][0] == "X" && gameboard[1][1] == "X" && gameboard[2][2] == "X") 
		{
			return "X WON";
		}else if(gameboard[0][1] == "X" && gameboard[1][1] == "X" && gameboard[2][1] == "X") 
		{
			return "X WON";
		}else if(gameboard[0][2] == "X" && gameboard[1][1] == "X" && gameboard[2][0] == "X") 
		{
			return "X WON";
		}else if(gameboard[0][2] == "X" && gameboard[1][2] == "X" && gameboard[2][2] == "X") 
		{
			return "X WON";
		}else if(gameboard[1][0] == "X" && gameboard[1][1] == "X" && gameboard[1][2] == "X") 
		{
			return "X WON";
		}else if(gameboard[2][0] == "X" && gameboard[2][1] == "X" && gameboard[2][2] == "X") 
		{
			return "X WON";
		}else if(gameboard[0][0] == "O" && gameboard[0][1] == "O" && gameboard[0][2] == "O") 
		{
			return "O WON";
		}else if(gameboard[0][0] == "O" && gameboard[1][0] == "O" && gameboard[2][0] == "O") 
		{
			return "O WON";
		}else if(gameboard[0][0] == "O" && gameboard[1][1] == "O" && gameboard[2][2] == "O") 
		{
			return "O WON";
		}else if(gameboard[0][1] == "O" && gameboard[1][1] == "O" && gameboard[2][1] == "O") 
		{
			return "O WON";
		}else if(gameboard[0][2] == "O" && gameboard[1][1] == "O" && gameboard[2][0] == "O") 
		{
			return "O WON";
		}else if(gameboard[0][2] == "O" && gameboard[1][2] == "O" && gameboard[2][2] == "O") 
		{
			return "O WON";
		}else if(gameboard[1][0] == "O" && gameboard[1][1] == "O" && gameboard[1][2] == "O") 
		{
			return "O WON";
		}else if(gameboard[2][0] == "O" && gameboard[2][1] == "O" && gameboard[2][2] == "O") 
		{
			return "O WON";
		}else
		{
			return "";
		}
	}
	public void eraseBoard() 
	{
		System.out.println("BOARD IS BEING ERASED ....");
		
	}

}
