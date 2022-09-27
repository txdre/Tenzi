import java.util.Random;
import java.util.Scanner;

public class Tenzi_6_AS
{
	static Scanner input;
	static Random random;

	public static void main( String[ ] args )
	{
		String newGame; // This determines if there will be another game played
		int playerOneWins; // The number of times Player One has won the game in this session
		int playerTwoWins; // The number of times Player Two has won the game in this session
		int totalDraws; // The number of draws in this session
		int totalPlayerOneMatches; // The number of cumulative matches that Player One has in this session
		int totalPlayerTwoMatches; // The number of cumulative matches that Player Two has in this session

		playerOneWins = 0;
		playerTwoWins = 0;
		totalDraws = 0;
		totalPlayerOneMatches = 0;
		totalPlayerTwoMatches = 0;

		do
		{

			int playerOneGuess; // The number that the first player enters
			int playerTwoGuess; // The number that the second player enters
			int compNum; // Randomly Generated Dice Number
			int turn; // The loop count to keep track of the dice roll
			int playerOneMatches; // Number of times that the computer number matched the first player's number
			int playerTwoMatches; // Number of times that the computer number matched the second player's number

			playerOneMatches = 0;
			playerTwoMatches = 0;
			turn = 0;
			newGame = ( "yes" );

			input = new Scanner ( System.in );
			random = new Random ( );

			System.out.println ( "Player One: Enter a number between 1 and 6" );
			playerOneGuess = input.nextInt ( );
			System.out.println ( "Player Two: Enter a number between 1 and 6" );
			playerTwoGuess = input.nextInt ( );
			System.out.println ( "The computer will now pick 10 numbers." );

			System.out.println ( "Here is the number Player One entered: " + playerOneGuess );
			System.out.println ( "Here is the number Player Two entered: " + playerTwoGuess );

			while ( turn < 10 )
			{
				compNum = random.nextInt ( 6 ) + 1;
				turn++;
				System.out.println ( "The Computer rolled: " + compNum );
				
				if ( playerOneGuess == compNum )
				{
					playerOneMatches++;
					totalPlayerOneMatches++;
				}
				else if ( playerTwoGuess == compNum )
				{
					playerTwoMatches++;
					totalPlayerTwoMatches++;
				}
			}
			
			System.out.println ( "Player One's Number matched the computer's number " + playerOneMatches + " times! " );
			System.out.println ( "Player Two's Number matched the computer's number " + playerTwoMatches + " times! " );

			if ( playerOneMatches > playerTwoMatches )
			{
				System.out.println ( "Player One has won the game!" );
				playerOneWins++;
			}
			else if ( playerOneMatches < playerTwoMatches )
			{
				System.out.println ( "Player Two has won the game!" );
				playerTwoWins++;
			}
			else if ( playerOneMatches == playerTwoMatches )
			{
				System.out.println ( "The game is a draw!" );
				totalDraws++;
			}
			
			System.out.println ( "Would you like to play again? (Yes or No?)" );
			newGame = input.next ( );
			newGame = newGame.toLowerCase ( );
		} 
		while ( newGame.equals ( "yes" ) );
		 
		System.out.println ( "Final Score:" );
		System.out.println ( "Player One matched the Computer's Roll " + totalPlayerOneMatches + " times overall!" );
		System.out.println ( "Player One has won " + playerOneWins + " times!" );
		System.out.println ( "Player Two matched the Computer's Roll " + totalPlayerTwoMatches + " times overall!" );
		System.out.println ( "Player Two has won " + playerTwoWins + " times!" );
		System.out.println ( "There were " + totalDraws + " draws!" );

		input.close ( );
	}
}