/*
The reason I don't have all of the comments is because this is the "extra"
version of the game, which is only getting peer-reviewed and is not worth real
marks. I only like writing comments occasionally. Feel free to write "0/10" for
Coding Practices
*/

import java.util.Scanner;
import java.util.Arrays;

public class MichaelSkybaPaperTennisFinal {
	static Scanner scan = new Scanner(System.in);

	// The minimum selection that is allowed for betting (negative)
	static int minimumSel = -150;

	// Used in a couple different functions so it's fine as a staic config
	static String[] bots = {
		"DeepTennis v1",
		"DeepTennis v2",
		"Lennis",
		"ChaDennis",
		"Rennis",
		"OpenTennis",
		"sans"
	};

	// Having these as global variables is generally bad practice but I'm not
	// sure how else to do it in Java without stacking 999 params for getSel
	// It's easy in non-meme langs like TypeScript and Python
	static int round = 0;
	static int ballPosition = 0;
	static int leftPoints = 0;
	static int leftLastPoints = 0;
	static int leftSel = 0;
	static int leftTotalSel = 0;
	static int rightPoints = 0;
	static int rightSel = 0;
	static int rightTotalSel = 0;

	public static int RNG(int min, int max) {
		return (int)(Math.random() * (max - min + 1)) + min;
	}

	public static String getName() {
		System.out.print("Before you start, enter your name.\n> ");
		String name = scan.nextLine();

		// Convert the array to a List, which has indexOf, first
		while (Arrays.asList(bots).indexOf(name) != -1) {
			System.out.println("You cannot take the name of an existing player.");
			System.out.print("Enter a new name.\n> ");
			name = scan.nextLine();
		}

		return name;
	}

	public static void displayBoard(int[][] board) {
		System.out.println();

		// Column number (ball position)
		System.out.println("   -2 -1  0  1  2");

		for (int i = 0; i < board.length; i++) {
			// Row number (turn)
			System.out.printf("%2d ", i+1);

			for (int j = 0; j < board[i].length; j++) {
				if (board[i][j] == 0)
					System.out.print("   ");
				else
					System.out.print(" ◍ ");

			}
			System.out.println();
		}

		System.out.println();
	}

	public static int getPlayerSel(int points) {
		// This default works as a number outside of the range, so the while
		// loop will continue
		int defaultSel = minimumSel - 1;
		int sel = defaultSel;

		while (sel < minimumSel || sel > points) {
			System.out.println("Select a number of points to use.");

			// The minimum selection will always be < 0 and points will always
			// be >= 0, so we don't have to worry about order
			System.out.printf("(%d to %d)\n> ", minimumSel, points);

			try {
				sel = Integer.parseInt(scan.nextLine());
			}
			catch (Exception error) {
				// Ensure that the while loop condition runs again
				sel = defaultSel;
			}
		}
		System.out.println();

		return sel;
	}

	// Get the selection of a competitor, including the actual player
	// Random from minimumSel to computer's num of points
	// --
	// Please do not try reading these to figure out how the opponents work so
	// that you can create a strategy to defeat them (especially sans). That
	// ruins the fun and the magic of the competition
	public static int getSel(String name, int points) {
		int rt;

		switch (name) {
			case "DeepTennis v1":
				return RNG(minimumSel, points);

			case "DeepTennis v2":
				rt = getSel("DeepTennis v1", points);
				if (rt <= 0)
					return minimumSel;

				if (points == leftPoints && rt > rightPoints)
					rt = rightPoints;
				else if (points == rightPoints && rt > leftPoints)
					rt = leftPoints;

				return rt;

			case "Lennis":
				int div = round - 2;

				if (div == 0)
					return getSel("DeepTennis v2", points);
				if (points == leftPoints)
					rt = (int)(rightTotalSel/div) + 2;
				else {
					// The left player has had an extra turn, so divide by an
					// extra number
					div++;
					rt = (int)(leftTotalSel/div) + 2;
				}

				if (rt > points)
					rt = (int)(minimumSel * 0.95);

				return rt;

			case "ChaDennis":
				if (RNG(1, 100)%2 == 0)
					return points;
				return minimumSel + 1;

			case "Rennis":
				if (round%2 == 0)
					return getSel("OpenTennis", points);
				else
					return getSel("DeepTennis v2", points);

			case "OpenTennis":
				int epoints = 0;
				boolean left = false;
				if (points == leftPoints) {
					epoints = rightPoints;
					left = true;
				}
				else
					epoints = leftLastPoints;

				boolean critical = (left && ballPosition == -2 ||
				                    !left && ballPosition == 2);

				rt = epoints + 1;
				if (rt < (int)(points * 0.2))
					return rt;

				int threshold = (int)(Math.abs(minimumSel) * 1.25);
				if (epoints > threshold && !critical)
					return minimumSel;

				rt = (int)(epoints * 0.95) - 20;
				if (rt > points) {
					if (critical)
						return points;
					else
						return minimumSel;
				}
				return rt;

			case "sans":
				// sans is always right, since he is index 7
				rt = leftSel + 1;
				if (rt > points)
					rt = minimumSel;
				return rt;

			// It didn't match any of the bot names, so it must be the player
			default:
				return getPlayerSel(points);
		}
	}

	// Shift every row (match) down (in terms of index; up in terms of
	// UI) to make room for another match result
	public static void shiftDown(int[][] board) {
		// We go one less than the length to avoid setting the last row, which
		// would have an index error
		for (int i = 0; i < board.length - 1; i++)
			board[i] = board[i+1];

		// Set the last row to an empty array to clear it
		board[board.length - 1] = new int[board[0].length];
	}

	public static String[] getInitialContestants(String player) {
		int length = 8;

		// Remaining bots to be randomly placed
		// We have to make this for loop because Java clones arrays by reference
		// by default
		// length - 1 to exclude player
		String[] remBots = new String[8];
		for (int i = 0; i < length-1; i++) {
			remBots[i] = bots[i];
		}

		String[] contestants = new String[8];

		// -1 (index) - 1 (not including the player) - 1 (don't include sans)
		int last = length - 3;
		int j;

		// The player has to be in the first half so that they win their half
		// and fight sans in the finals
		boolean placedPlayer = false;
		for (int i = 0; i < 4; i++) {
			if (!placedPlayer && RNG(1, 4-i) == 1) {
				contestants[i] = player;
				placedPlayer = true;
			} else {
				j = RNG(0, last);
				contestants[i] = remBots[j];

				// Ignore that bot now
				remBots[j] = remBots[last];
				last--;
			}
		}

		for (int i = 4; i < 7; i++) {
			j = RNG(0, last);
			contestants[i] = remBots[j];
			remBots[j] = remBots[last];
			last--;
		}
		contestants[7] = "sans";

		return contestants;
	}

	public static void displayContestants(String[] contestants, int number) {
		String description;

		for (int i = 0; i < number; i++) {
			String cont = contestants[i];
			switch(cont) {
				case "DeepTennis v1":
					description = "version 1 of DeepMind's Paper Tennis AI";
					break;

				case "DeepTennis v2":
					description = "version 2 of DeepMind's Paper Tennis AI";
					break;

				case "Lennis":
					description = "an amazing player that has never lost a game (but also never played a game before today)";
					break;

				case "ChaDennis":
					description = "not that good at Paper Tennis but really social";
					break;

				case "Rennis":
					description = "ChaDennis's gym coach; has heard of Paper Tennis once";
					break;

				case "OpenTennis":
					description = "The comma body's on-device Paper Tennis algorithm";
					break;

				case "sans":
					description = "some homeless dude we found in the attic";
					break;

				default:
					description = "a young Paper Tennis apprentice (apprenTennis)";
					break;
			}

			System.out.printf("%d. %s: %s\n", i+1, cont, description);
		}

	}

	public static boolean getWatch() {
		String input = "";
		while (!input.equals("y") && !input.equals("n")) {
			System.out.printf("Would you like to spectate for this game? (y/n)\n> ");
			input = scan.nextLine();
		}
		return input.equals("y");
	}

	public static String playGame(String leftName, String rightName, boolean display, boolean extraPause) {
		int[][] board = new int[10][5];
		board[0][2] = 1;

		round = 2;
		ballPosition = 0;

		leftPoints = 1000;
		leftLastPoints = leftPoints;
		leftTotalSel = 0;
		leftSel = 0;

		rightPoints = 1000;
		rightTotalSel = 0;
		rightSel = 0;

		String winner = "";
		String loser = "";

		if (display) {
			System.out.println("\nFor Round 1, the ball starts at position 0.");
			System.out.println("PL L: initialized points at 1000");
			System.out.println("PL R: initialized points at 1000");
		}

		while (true) {
			if (display) {
				System.out.println("\n=================================================");
				System.out.printf("Round #%d!\n", round);
				System.out.printf("%s (Left) vs %s (Right)\n", leftName, rightName);

				displayBoard(board);

				// round == 2 is the first round, for which we don't have any
				// scoring data yet. So, we should only display it on the second
				// round the user plays, which is == 3 and > 2
				if (round > 2) {
					System.out.println("Previous results:");
					System.out.printf("PL L: %4d used --> %4d rem\n", leftSel, leftPoints);
					System.out.printf("PL R: %4d used --> %4d rem\n", rightSel, rightPoints);
					System.out.println();
				}
			}

			leftSel = getSel(leftName, leftPoints);
			leftTotalSel += leftSel;
			leftLastPoints = leftPoints;
			leftPoints -= leftSel;

			rightSel = getSel(rightName, rightPoints);
			rightTotalSel += rightSel;
			rightPoints -= rightSel;

			if (rightSel > leftSel)
				ballPosition--;
			else if (rightSel < leftSel)
				ballPosition++;

			if (ballPosition >= 3) {
				winner = leftName;
				loser = rightName;
			}
			else if (ballPosition <= -3) {
				winner = rightName;
				loser = leftName;
			}
			if (ballPosition >= 3 || ballPosition <= -3) {
				if (display) {
					System.out.printf("The ball has reached position %d and thus has\nleft the field from %s's side.\n", ballPosition, loser);
					System.out.printf("%s wins!\n", winner);

					System.out.println("\nFinal match results:");
					System.out.printf("PL L: %4d used --> %4d rem\n", leftSel, leftPoints);
					System.out.printf("PL R: %4d used --> %4d rem\n", rightSel, rightPoints);
				}

				return winner;
			}

			// Calculate which row of the board 2D array should be modified
			int row = 0;

			// We only have a max of 10 rows but there could be more than 9
			// (length-1) rounds
			if (round >= board.length)
				row = 9;
			// round has to be -1 because the first round is 2 but the first index is 1
			else
				row = round - 1;

			// ballPosition has to be +2 because column 0 in the array is
			// position -2 in the board
			board[row][ballPosition + 2] = 1;

			round++;

			if (round - 1 >= board.length)
				shiftDown(board);

			if (extraPause) {
				System.out.println("Press Enter to go the next round of the game.");
				scan.nextLine();
			}
		}
	}

	// The return value is whether the tournament is over (player lost)
	public static boolean playTournamentGame(String[] contestants, int i1, int i2, String name, int cycle) {
		String c1 = contestants[i1];
		String c2 = contestants[i2];
		String winner;

		boolean display;
		boolean participating;

		participating = c1.equals(name) || c2.equals(name);

		System.out.printf("\nGame %d: %s vs %s\n", i1/2 + 1, c1, c2);

		if (cycle == 3) {
			System.out.println("\nBefore the match, sans walks up to you casually and stares into your eyes.");
			System.out.println("Without hesitation, he says");
			System.out.println("\"hey, did you hear the one about the skeleton who played tennis?\"");
			System.out.println("Shocked, you fail to come up with a reply, and simply stare back at him.");
			System.out.println("After what must only have been minutes, but what felt like hours,\nhe answers his own question...");
			System.out.println("\"they really 'racketed' up the score.\"");
			System.out.println("Completely dumbfounded, your mouth hangs open as you try to even begin\nto fathom what must have been going through his head to compel him to utter such a thing.");
			System.out.println("Before a semblance of articulation comes to mind, sans turns around and walks away.");
			System.out.println("Trying not to let it get to your head, you prepare yourself for the game.");
			System.out.println("This is it. If you win this one last game, you will become the champion.");
			System.out.printf("%s! Believe in yourself! You got this! You've been training so hard!\n", name);
		}

		if (participating)
			winner = playGame(c1, c2, true, false);
		else {
			display = getWatch();
			boolean sans = c1.equals("sans") || c2.equals("sans");

			if (display && sans) {
				System.out.println("We apologize, but sans has requested that no\nspectators be allowed to view his match.");
				display = false;
			}

			winner = playGame(c1, c2, display, display);

			if (!display)
				System.out.printf("\n%s wins!\n", winner);
		}

		if (cycle < 3) {
			// Reuse contesants for next round
			contestants[i1/2] = winner;

			String loser = c1;
			if (loser.equals(winner)) loser = c2;

			System.out.printf("\nSince %s won, they will advance to the next cycle.\n", winner);
			System.out.printf("Since %s lost, they will be eliminated from the tournament.\n", loser);

		} else {
			System.out.println("\nTherefore, sans is crowned the Champion of Paper Tennis!");
			System.out.println("Although you weren't the winner,\nyou should still be proud of how far you made it.");
			System.out.println("Perhaps, with a bit of corruption, you can win the next tournament!");
			return true;
		}

		if (participating && !winner.equals(name)) {
			System.out.println("Therefore, the tournament, for you, is over...");
			System.out.println("Train some more, and then try again.\nYou can become the Champion if you work hard enough!");
			return true;
		}
		return false;
	}

	public static void tournament(String player) {
		System.out.printf("\nAfter fifty episodes of training, %s finally musters up\nthe courage to participate in the Global™  Paper Tennis tournament!\n", player);
		System.out.println("The eight best players in the world (there are nine total\nplayers and one of them was busy) have come together to compete today.");
		System.out.println("It will surely be a kind of exciting display of talent!");

		System.out.println("\nAnd now, here are today's contestants:");

		String[] contestants = getInitialContestants(player);
		displayContestants(contestants, 8);

		System.out.println("\nThe tournament will have three cycles, where half of the\ncontestants will be eliminated each cycle.");
		System.out.println("The winner of the final cycle will be crowned the Champion of Paper Tennis!");
		System.out.println("My personal bet is that it will be Rennis, of course, but we will see how it goes.");

		System.out.println("\nPress enter to start the first round.");
		scan.nextLine();

		System.out.println("=================================================");
		System.out.println("Cycle 1: Opening");

		for (int i = 0; i < 8; i += 2) {
			if (playTournamentGame(contestants, i, i+1, player, 1))
				return;
		}

		System.out.println("\nPress enter to start the second round.");
		scan.nextLine();

		System.out.println("=================================================");
		System.out.println("Cycle 2: Semi-finals");

		System.out.println("\nRemaining contestants:");
		displayContestants(contestants, 4);

		for (int i = 0; i < 4; i += 2) {
			if (playTournamentGame(contestants, i, i+1, player, 2))
				return;
		}

		System.out.println("\nPress enter to start the third round.");
		scan.nextLine();

		System.out.println("=================================================");
		System.out.println("Cycle 3: Finals");

		System.out.println("\nRemaining contestants:");
		displayContestants(contestants, 2);

		playTournamentGame(contestants, 0, 1, player, 3);
	}

	public static void tutorial() {
		System.out.println("\nWelcome to Paper Tennis!");
		System.out.println("In paper tennis, there is a board that represents the tennis court.");
		System.out.println("Each row on the board represents one past turn where the ball traveled.");
		System.out.println("For example, look at the following board:");

		int[][] board = new int[4][5];
		board[0][2] = 1;
		board[1][1] = 1;
		board[2][1] = 1;
		board[3][0] = 1;
		displayBoard(board);

		System.out.println("The ball always starts at position 0, in the center, on round 1.");
		System.out.println("Then, players compete to push the ball towards their opponents.\n");

		System.out.println("As you can see, in round 2, the right player won the\nexchange and pushed the ball to the left, to position -1.");
		System.out.println("In round 3, the left and right players tied, so the ball was not pushed.");
		System.out.println("In round 4, the right player won the exchange again,\nso the ball was pushed to the left again, to position -2.\n");

		System.out.println("Press Enter to continue.");
		scan.nextLine();

		System.out.println("Now, if the right player wins one more time, the ball\nwill be pushed to -3, meaning that the right player would win the game.");
		System.out.println("For the left player to win, they have to push the ball\nall the way to the right, to position 3.\n");

		System.out.println("The movement of the ball is determined by the points that the players use.");
		System.out.println("Both players start with 1000 points, and on any turn\ncan use from -150 up to their current number of points.");
		System.out.println("The points used each round are lost (or gained, if you used a negative number).");
		System.out.println("Then, whichever player used more points in the current round wins the exchange.");
		System.out.println("You only see how many points the other player used after you\nhave chosen how many points that you want to use, so you have to predict\nwhat your opponent will do and prereact accordingly.\n");

		System.out.println("Press Enter to continue.");
		scan.nextLine();

		displayBoard(board);
		System.out.println("For example, this is one possible (out of many) sequence of point usage\nthat could lead to the above board:");
		System.out.println("Round 1");
		System.out.println("The left and right players both start with 1000 points.");
		System.out.println("Round 2");
		System.out.println("The right player used 500 and the left player used 100.");
		System.out.println("So, the right player has 1000-500=500 remaining,\nand the left player has 1000-100=900 remaining.");
		System.out.println("Round 3");
		System.out.println("The left player and right player both used -150 points.");
		System.out.println("So, the right player has 500-(-150)=650 remaining,\nand the left player has 900-(-150)=1050 remaining.");
		System.out.println("Round 4");
		System.out.println("The right player used 650 points and the left player used 500 points.");
		System.out.println("So, the right player has 650-650=0 remaining,\nand the left player has 1050-500=550 remaining.\n");

		System.out.println("You have finished reading the tutorial.");
		System.out.println("You should understand how the game works now.\n");

		System.out.println("Press Enter to return to the main menu.");
		scan.nextLine();
	}

	public static int mainMenu(String name) {
		// The default input should be outside of the while loop range (1-3)
		int defaultInput = 0;
		int input = defaultInput;

		System.out.println();
		System.out.println("=================================================");

		while (input < 1 || input > 4) {
			System.out.println();
			System.out.printf("Welcome to Paper Tennis, %s!\n", name);
			System.out.println("1. Tutorial");
			System.out.println("2. Practice (vs DeepTennis v1)");
			System.out.println("3. Enter Tournament");
			System.out.println("4. Exit");
			System.out.print("Please select an option.\n> ");

			try {
				input = Integer.parseInt(scan.nextLine());
			}
			catch (Exception error) {
				input = defaultInput;
			}
		}

		return input;
	}

	public static void main(String[] args) {
		int option = 0;

		String name = getName();

		// Keep displaying the main menu, getting and responding to input, until
		// the player decides to exit (option 3)
		while (option != 4) {
			option = mainMenu(name);

			if (option == 1) tutorial();
			if (option == 2) playGame(name, "DeepTennis v1", true, false);
			if (option == 3) tournament(name);
		}

		// The loop is over, meaning that the player exited
		System.out.printf("\nThanks for playing, %s!\n", name);
		System.out.printf("Make sure to purchase the companion game,\n\"Paper Tennis Graphical Version\", at https://is.gd/Q6GyIx.\n", name);
	}
}