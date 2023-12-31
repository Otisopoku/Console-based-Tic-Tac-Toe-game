
import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class GameLogic {
    public static void main(String args[]) {

        List<Integer> winDistribution = new ArrayList<>(2); // arrayList to keep track of the number of wins and loses
                                                            // of each player
        winDistribution.add(0);
        winDistribution.add(0);
        Scanner input = new Scanner(System.in);
        GameBoard board = new GameBoard();

        int playerOnePosition, playerTwoPosition;
        String positionMovedByPlayer1, positionMovedByPlayer2;
        boolean isPlayer1MoveOccupied = false, isPlayer2MoveOccupied = false, result = false;
        boolean loopForPlayer1 = true, loopForPlayer2 = true;
        boolean replayLoop = false;
        System.out.println("Welcome to the Tic-Tac-Toe Game.\n");
        board.printBoard();

        int numberOfWinsByPlayer1 = 0, numberOfWinsByPlayer2 = 0;

        do {
            while (result == false && !board.isFull()) {

                /*
                 * loop below enables player 1 to play, he is reprompted to enter a valid input
                 * within 1 and 25 inclusive incase he gives the wrong input.
                 */

                while (loopForPlayer1 && !board.isFull()) {
                    System.out.print("Player 1 (O) ---- Enter a position to play: ");
                    playerOnePosition = getInt(input);
                    positionMovedByPlayer2 = String.format("%d", playerOnePosition);
                    isPlayer1MoveOccupied = board.checkSpace(positionMovedByPlayer2);

                    if (isPlayer1MoveOccupied) {
                        System.out.println("The position is already occupied");
                        System.out.println("Choose a different postion");
                        loopForPlayer1 = true;

                    } else {
                        board.changePosition(positionMovedByPlayer2, "O");
                        System.out.println();
                        board.printBoard();
                        System.out.println();
                        loopForPlayer1 = false;

                    }

                }

                /*
                 * checks to see if there is a win so far. If there is, ther program ends
                 * otherwise, it continues.
                 */
                result = board.checkWin("O");
                if (result) {
                    System.out.println("Player 1 (O) wins");
                    numberOfWinsByPlayer1++;
                    winDistribution.set(0, numberOfWinsByPlayer1);
                    loopForPlayer2 = false;
                    break;

                }

                /*
                 * loop below enables player 1 to play, he is reprompted to enter a valid input
                 * within 1 and 25 inclusive incase he gives the wrong input.
                 */
                while (loopForPlayer2 && !board.isFull()) {
                    System.out.print("Player 2 (X)---- Enter a position to play: ");
                    playerTwoPosition = getInt(input);
                    positionMovedByPlayer1 = String.format("%d", playerTwoPosition);
                    isPlayer2MoveOccupied = board.checkSpace(positionMovedByPlayer1);

                    if (isPlayer2MoveOccupied) {
                        System.out.println("The position is already occupied");
                        System.out.println("Choose a new position");
                        loopForPlayer2 = true;

                    } else {
                        board.changePosition(positionMovedByPlayer1, "X");
                        System.out.println();
                        board.printBoard();
                        System.out.println();
                        loopForPlayer2 = false;

                    }

                }

                /*
                 * checks to see if there is a win so far. If there is, ther program ends
                 * otherwise, it continues.
                 */
                result = board.checkWin("X");
                if (result) {
                    System.out.println("Player 2 (X) wins");
                    numberOfWinsByPlayer2++;
                    winDistribution.set(1, numberOfWinsByPlayer2);
                    loopForPlayer1 = false;
                    break;

                }

                if (board.isFull()) {
                    System.out.println("Draw");
                    result = true;
                } else {
                    loopForPlayer1 = true;
                    loopForPlayer2 = true;
                }

            }

            System.out.println("\nDo you want to play again? Enter Y to play again, anything else to quit the game");
            String rePlay = input.nextLine();

            switch (rePlay) {
                case "Y":
                    replayLoop = true;
                    result = false;
                    board.clearBoard();
                    System.out.println("\n");
                    board.printBoard();
                    break;
                default:
                    replayLoop = false;
                    result = false;
                    System.out.println("\n");
                    break;
            }

        } while (replayLoop);
        scoreDistribution(winDistribution);

    }

    /**
     * Description: It validates the input of the user; re-prompts the user to enter
     * a valid input incase it gives anything not between 1 and 9 inclusive.
     * 
     * @param input takes in a Scanner input.
     * @return an integer between 1 and 9 inclusive
     */
    public static int getInt(Scanner input) {
        int userInput = 0; // Initialize userInput
        while (true) {
            try {
                userInput = Integer.parseInt(input.nextLine());
                if (userInput < 1 || userInput > 25)
                    throw new ValueOutOfBoundsException("Board position out of bounds for position " + userInput);
                break; // Exit the loop if input is valid
            } catch (NumberFormatException e) {
                System.out.println("Not an Integer");
                System.out.println("Enter an accurate position");
            } catch (ValueOutOfBoundsException e) {
                System.out.println(e.getMessage());
                System.out.println("Enter an accurate position");
            }
        }

        return userInput;
    }

    public static void scoreDistribution(List<Integer> list) {
        System.out.println("\t------Scores Distribution------");
        System.out.printf("%n\t%-15s\t%-15s%n", "Number of wins", "Number of loses");
        System.out.printf("%-15s\t%d\t\t%d%n", "Player1", list.get(0), (list.get(0) + list.get(1)) - list.get(0));
        System.out.printf("%-15s\t%d\t\t%d%n", "Player2", list.get(1), (list.get(0) + list.get(1)) - list.get(1));
    }
}
