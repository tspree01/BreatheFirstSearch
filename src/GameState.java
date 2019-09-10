import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.*;

class GameState
{

	GameState prev;
	//Array of x and y positions for each piece
	byte[] positionOfPieces;

	//constuctor
	GameState()
	{
		positionOfPieces = new byte[22];
	}

	//copy constructor
	GameState(GameState _prev)
	{
		this.prev = _prev;
		this.positionOfPieces = new byte[22];
		System.arraycopy(_prev.positionOfPieces, 0, this.positionOfPieces, 0, _prev.positionOfPieces.length);
	}

	//Checks to see if the state is at the goal state
	boolean CheckForGoalState(GameState currentState)
	{
		return currentState.positionOfPieces[0] == 4 && currentState.positionOfPieces[1] == - 2;
	}
}

class StateComparator implements Comparator<GameState>
{
	public int compare(GameState a, GameState b)
	{
		for (int i = 0; i < 22; i++)
		{
			if (a.positionOfPieces[i] < b.positionOfPieces[i]) { return - 1; }
			else if (a.positionOfPieces[i] > b.positionOfPieces[i]) { return 1; }
		}
		return 0;
	}
}

class Main
{
	static boolean[][] board = new boolean[10][10];
	static Shape piece0, piece1, piece2, piece3, piece4, piece5, piece6, piece7, piece8, piece9, piece10;
	static ArrayList<Shape> gamePieces = new ArrayList<>();
	private static File file = new File("Results.txt");
	static PrintWriter printWriter;

	static
	{
		try
		{
			printWriter = new PrintWriter(file);
		} catch (FileNotFoundException e)
		{
			e.printStackTrace();
		}
	}


	public static void main(String args[])
	{
		GameState start = new GameState();
		GameState goal = new GameState();

		//Make the pieces
		piece0 = new Shape(1, 3, 2, 3, 1, 4, 2, 4);
		piece1 = new Shape(1, 5, 1, 6, 2, 6);
		piece2 = new Shape(2, 5, 3, 5, 3, 6);
		piece3 = new Shape(3, 7, 3, 8, 4, 8);
		piece4 = new Shape(4, 7, 5, 7, 5, 8);
		piece5 = new Shape(6, 7, 7, 7, 6, 8);
		piece6 = new Shape(5, 4, 5, 5, 5, 6, 4, 5);
		piece7 = new Shape(6, 4, 6, 5, 6, 6, 7, 5);
		piece8 = new Shape(8, 5, 8, 6, 7, 6);
		piece9 = new Shape(6, 2, 6, 3, 5, 3);
		piece10 = new Shape(5, 1, 6, 1, 5, 2);

		//add the shpes to the arraylist of gamePieces
		gamePieces.add(piece0);
		gamePieces.add(piece1);
		gamePieces.add(piece2);
		gamePieces.add(piece3);
		gamePieces.add(piece4);
		gamePieces.add(piece5);
		gamePieces.add(piece6);
		gamePieces.add(piece7);
		gamePieces.add(piece8);
		gamePieces.add(piece9);
		gamePieces.add(piece10);

		//set the board with the 11 pieces
		SetBlock(piece0.numberOfBlocksInPiece.get(0).x, piece0.numberOfBlocksInPiece.get(0).y);
		SetBlock(piece0.numberOfBlocksInPiece.get(1).x, piece0.numberOfBlocksInPiece.get(1).y);
		SetBlock(piece0.numberOfBlocksInPiece.get(2).x, piece0.numberOfBlocksInPiece.get(2).y);
		SetBlock(piece0.numberOfBlocksInPiece.get(3).x, piece0.numberOfBlocksInPiece.get(3).y);

		SetBlock(piece1.numberOfBlocksInPiece.get(0).x, piece1.numberOfBlocksInPiece.get(0).y);
		SetBlock(piece1.numberOfBlocksInPiece.get(1).x, piece1.numberOfBlocksInPiece.get(1).y);
		SetBlock(piece1.numberOfBlocksInPiece.get(2).x, piece1.numberOfBlocksInPiece.get(2).y);

		SetBlock(piece2.numberOfBlocksInPiece.get(0).x, piece2.numberOfBlocksInPiece.get(0).y);
		SetBlock(piece2.numberOfBlocksInPiece.get(1).x, piece2.numberOfBlocksInPiece.get(1).y);
		SetBlock(piece2.numberOfBlocksInPiece.get(2).x, piece2.numberOfBlocksInPiece.get(2).y);

		SetBlock(piece3.numberOfBlocksInPiece.get(0).x, piece3.numberOfBlocksInPiece.get(0).y);
		SetBlock(piece3.numberOfBlocksInPiece.get(1).x, piece3.numberOfBlocksInPiece.get(1).y);
		SetBlock(piece3.numberOfBlocksInPiece.get(2).x, piece3.numberOfBlocksInPiece.get(2).y);

		SetBlock(piece4.numberOfBlocksInPiece.get(0).x, piece4.numberOfBlocksInPiece.get(0).y);
		SetBlock(piece4.numberOfBlocksInPiece.get(1).x, piece4.numberOfBlocksInPiece.get(1).y);
		SetBlock(piece4.numberOfBlocksInPiece.get(2).x, piece4.numberOfBlocksInPiece.get(2).y);

		SetBlock(piece5.numberOfBlocksInPiece.get(0).x, piece5.numberOfBlocksInPiece.get(0).y);
		SetBlock(piece5.numberOfBlocksInPiece.get(1).x, piece5.numberOfBlocksInPiece.get(1).y);
		SetBlock(piece5.numberOfBlocksInPiece.get(2).x, piece5.numberOfBlocksInPiece.get(2).y);

		SetBlock(piece6.numberOfBlocksInPiece.get(0).x, piece6.numberOfBlocksInPiece.get(0).y);
		SetBlock(piece6.numberOfBlocksInPiece.get(1).x, piece6.numberOfBlocksInPiece.get(1).y);
		SetBlock(piece6.numberOfBlocksInPiece.get(2).x, piece6.numberOfBlocksInPiece.get(2).y);
		SetBlock(piece6.numberOfBlocksInPiece.get(3).x, piece6.numberOfBlocksInPiece.get(3).y);

		SetBlock(piece7.numberOfBlocksInPiece.get(0).x, piece7.numberOfBlocksInPiece.get(0).y);
		SetBlock(piece7.numberOfBlocksInPiece.get(1).x, piece7.numberOfBlocksInPiece.get(1).y);
		SetBlock(piece7.numberOfBlocksInPiece.get(2).x, piece7.numberOfBlocksInPiece.get(2).y);
		SetBlock(piece7.numberOfBlocksInPiece.get(3).x, piece7.numberOfBlocksInPiece.get(3).y);

		SetBlock(piece8.numberOfBlocksInPiece.get(0).x, piece8.numberOfBlocksInPiece.get(0).y);
		SetBlock(piece8.numberOfBlocksInPiece.get(1).x, piece8.numberOfBlocksInPiece.get(1).y);
		SetBlock(piece8.numberOfBlocksInPiece.get(2).x, piece8.numberOfBlocksInPiece.get(2).y);

		SetBlock(piece9.numberOfBlocksInPiece.get(0).x, piece9.numberOfBlocksInPiece.get(0).y);
		SetBlock(piece9.numberOfBlocksInPiece.get(1).x, piece9.numberOfBlocksInPiece.get(1).y);
		SetBlock(piece9.numberOfBlocksInPiece.get(2).x, piece9.numberOfBlocksInPiece.get(2).y);

		SetBlock(piece10.numberOfBlocksInPiece.get(0).x, piece10.numberOfBlocksInPiece.get(0).y);
		SetBlock(piece10.numberOfBlocksInPiece.get(1).x, piece10.numberOfBlocksInPiece.get(1).y);
		SetBlock(piece10.numberOfBlocksInPiece.get(2).x, piece10.numberOfBlocksInPiece.get(2).y);

		goal = BreadthFirstSearch(start);
		CreatePathToGoal(goal);
	}

	// sets the board where pieces are and where the black squares are (board is a 10x10 array of booleans)
	private static void SetBlock(int x, int y)
	{
		board[x][y] = true;

	}

	private static void DrawBlackBlocks()
	{
		// make the black squares
		for (int i = 0; i < 10; i++)
		{
			//top row of black squares
			SetBlock(i, 0);
			//bottom row of black squares
			SetBlock(i, 9);
		}
		for (int i = 1; i < 9; i++)
		{
			//left side of black squares
			SetBlock(0, i);
			//right side of black squares
			SetBlock(9, i);
		}
		//top left corner of black squares
		SetBlock(1, 1);
		SetBlock(1, 2);
		SetBlock(2, 1);
		//top right corner of black squares
		SetBlock(7, 1);
		SetBlock(8, 1);
		SetBlock(8, 2);
		//bottom left corner of black squares
		SetBlock(1, 7);
		SetBlock(1, 8);
		SetBlock(2, 8);
		//bottom right corner of black squares
		SetBlock(8, 7);
		SetBlock(7, 8);
		SetBlock(8, 8);
		// middle black squares
		SetBlock(3, 4);
		SetBlock(4, 4);
		SetBlock(4, 3);
	}

	private static void ResetBoard()
	{
		for (int i = 0; i < board.length; i++)
		{
			for (int j = 0; j < board.length; j++)
			{
				board[i][j] = false;
			}

		}
	}

	private static boolean ValidateState(ArrayList<Shape> _gamePieces, GameState tempState)
	{
		boolean validMove = false;
		//reset the board and "draw" all the pieces again
		ResetBoard();
		DrawBlackBlocks();

		for (int i = 0; i < _gamePieces.size(); i++)
		{

			for (int j = 0; j < _gamePieces.get(i).numberOfBlocksInPiece.size(); j++)
			{

				if (board[_gamePieces.get(i).numberOfBlocksInPiece.get(j).x + tempState.positionOfPieces[2 * i]]
						[_gamePieces.get(i).numberOfBlocksInPiece.get(j).y + tempState.positionOfPieces[2 * i + 1]])
				{
					//validMove = true;
					_gamePieces.get(i).numberOfBlocksInPiece.get(j).validMove = false;
				}
				// if the spot the square is moved to is false set it to true
				else if (! board[_gamePieces.get(i).numberOfBlocksInPiece.get(j).x + tempState.positionOfPieces[2 * i]]
						[_gamePieces.get(i).numberOfBlocksInPiece.get(j).y + tempState.positionOfPieces[2 * i + 1]])
				{

					board[_gamePieces.get(i).numberOfBlocksInPiece.get(j).x + tempState.positionOfPieces[2 * i]]
							[_gamePieces.get(i).numberOfBlocksInPiece.get(j).y + tempState.positionOfPieces[2 * i + 1]] = true;
					//validMove = false;
					_gamePieces.get(i).numberOfBlocksInPiece.get(j).validMove = true;
				}
			}
		}
		//Checks every square to see if the move was valid then if all squares inside the piece are valid set the piece's validMove to true
		for (Shape _gamePiece : _gamePieces)
		{
			if (_gamePiece.numberOfBlocksInPiece.size() == 3)
			{
				if (! _gamePiece.numberOfBlocksInPiece.get(0).validMove && ! _gamePiece.numberOfBlocksInPiece.get(1).validMove && ! _gamePiece.numberOfBlocksInPiece.get(2).validMove)
				{
					_gamePiece.validMove = false;
				}
				else
				{
					_gamePiece.validMove = _gamePiece.numberOfBlocksInPiece.get(0).validMove && _gamePiece.numberOfBlocksInPiece.get(1).validMove && _gamePiece.numberOfBlocksInPiece.get(2).validMove;
				}
			}
			else if (_gamePiece.numberOfBlocksInPiece.size() == 4)
			{
				if (! _gamePiece.numberOfBlocksInPiece.get(0).validMove && ! _gamePiece.numberOfBlocksInPiece.get(1).validMove && ! _gamePiece.numberOfBlocksInPiece.get(2).validMove && ! _gamePiece.numberOfBlocksInPiece.get(3).validMove)
				{
					_gamePiece.validMove = false;
				}
				else
				{
					_gamePiece.validMove = _gamePiece.numberOfBlocksInPiece.get(0).validMove && _gamePiece.numberOfBlocksInPiece.get(1).validMove && _gamePiece.numberOfBlocksInPiece.get(2).validMove && _gamePiece.numberOfBlocksInPiece.get(3).validMove;
				}
			}
		}
		//Checks every piece to see if its a valid move
		validMove = _gamePieces.get(0).validMove && _gamePieces.get(1).validMove && _gamePieces.get(2).validMove && _gamePieces.get(3).validMove && _gamePieces.get(4).validMove && _gamePieces.get(5).validMove && _gamePieces.get(6).validMove && _gamePieces.get(7).validMove && _gamePieces.get(8).validMove && _gamePieces.get(9).validMove && _gamePieces.get(10).validMove;
		return validMove;

	}

	static String stateToString(byte[] b)
	{
		StringBuilder sb = new StringBuilder();
		sb.append(Byte.toString(b[0]));
		for (int i = 1; i < b.length; i++)
		{
			sb.append(",");
			sb.append(Byte.toString(b[i]));
		}
		return sb.toString();
	}

	private static void CreatePathToGoal(GameState goal)
	{
		LinkedList<GameState> flipResult = new LinkedList<>();
		GameState temp = goal;
		flipResult.push(temp);
		while (temp.prev != null)
		{
			temp = temp.prev;
			flipResult.push(temp);
		}
		while (! flipResult.isEmpty())
		{
			System.out.println(stateToString(flipResult.poll().positionOfPieces));
		}
	}

	private static GameState BreadthFirstSearch(GameState startState)
	{
		//A queue for the things that still need to be processed
		Queue<GameState> todo = new LinkedList<GameState>();
		//TreeSet to store the GameStates you have already visited
		StateComparator comp = new StateComparator();
		TreeSet<GameState> seenIt = new TreeSet<GameState>(comp);
		TreeSet<GameState> processedIt = new TreeSet<GameState>(comp);
		//HashMap<GameState, GameState> pathToGoal = new HashMap<>();
		GameState goal = new GameState();

		//Add the start state to the queue and the seen it set
		todo.add(startState);

		// For each node on the current level expand and process, if no children
		//(leaf) then unwind
		while (! todo.isEmpty())
		{
			//pop a games state off the queue
			GameState currentState = todo.poll();
			//Check to see if its the goal
			if (currentState.CheckForGoalState(currentState))
			{
				goal = currentState;
				return currentState;
			}
			//make the neighbors
			for (int i = 0; i < 22; i++)
			{
				//make a copy of the current game state
				GameState tempState = new GameState(currentState);

				tempState.positionOfPieces[i] += 1;

				//if valid and hasn't been seen add the game state to the queue
				if (ValidateState(gamePieces, tempState) && ! seenIt.contains(tempState) && ! processedIt.contains(tempState))
				{
					todo.add(tempState);
					//add it to the seen it set so we don't get duplicates
					seenIt.add(tempState);
				}

				//make a new game state for moving the pieces positive
				tempState = new GameState(currentState);

				tempState.positionOfPieces[i] -= 1;

				//if valid and hasn't been seen yet add the game state to the queue
				if (ValidateState(gamePieces, tempState) && ! seenIt.contains(tempState) && ! processedIt.contains(tempState))
				{
					todo.add(tempState);
					//add it to the seen it set so we dont get duplicates
					seenIt.add(tempState);
				}
			}
			//add the current state to the seen it set
			processedIt.add(currentState);
		}
		return goal;
	}
}