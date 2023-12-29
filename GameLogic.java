
import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class GameLogic {
    public static void main(String args[]) {

        List<Integer> winDistribution = new ArrayList<>();
        Scanner input = new Scanner(System.in);
        GameBoard b = new GameBoard();

        int playerOnePosition, playerTwoPosition;
        String positionMovedByPlayer1, positionMovedByPlayer2;
        boolean isPlayer1MoveOccupied = false, isPlayer2MoveOccupied = false, result = false;
        boolean loopForPlayer1 = true, loopForPlayer2 = true;
        System.out.println("Welcome to the Tic-Tac-Toe Game.\n");
        b.printBoard();

        int numberOfWinsByPlayer1 = 0, numberOfWinsByPlayer2 = 0;

        while (!result && !b.isFull()) {

            /*
             * loop below enables player 1 to play, he is reprompted to enter a valid input
             * within 1 and 25 inclusive incase he gives the wrong input.
             */

            while (loopForPlayer1 && !b.isFull()) {
                System.out.print("Player 1 (O) ---- Enter a position to play: ");
                playerOnePosition = getInt(input);
                positionMovedByPlayer2 = String.format("%d", playerOnePosition);
                isPlayer1MoveOccupied = b.checkSpace(positionMovedByPlayer2);

                if (isPlayer1MoveOccupied) {
                    System.out.println("The position is already occupied");
                    System.out.println("Choose a different postion");
                    loopForPlayer1 = true;

                } else {
                    b.changePosition(positionMovedByPlayer2, "O");
                    System.out.println();
                    b.printBoard();
                    System.out.println();
                    loopForPlayer1 = false;

                }

            }

            /*
             * checks to see if there is a win so far. If there is, ther program ends
             * otherwise, it continues.
             */
            result = b.checkWin("O");
            if (result) {
                System.out.println("Player 1 (O) wins");
                numberOfWinsByPlayer1++;

                System.exit(0);

            }

            /*
             * loop below enables player 1 to play, he is reprompted to enter a valid input
             * within 1 and 25 inclusive incase he gives the wrong input.
             */
            while (loopForPlayer2 && !b.isFull()) {
                System.out.print("Player 2 (X)---- Enter a position to play: ");
                playerTwoPosition = getInt(input);
                positionMovedByPlayer1 = String.format("%d", playerTwoPosition);
                isPlayer2MoveOccupied = b.checkSpace(positionMovedByPlayer1);

                if (isPlayer2MoveOccupied) {
                    System.out.println("The position is already occupied");
                    System.out.println("Choose a new position");
                    loopForPlayer2 = true;

                } else {
                    b.changePosition(positionMovedByPlayer1, "X");
                    System.out.println();
                    b.printBoard();
                    System.out.println();
                    loopForPlayer2 = false;

                }

            }

            /*
             * checks to see if there is a win so far. If there is, ther program ends
             * otherwise, it continues.
             */
            result = b.checkWin("X");
            if (result) {
                System.out.println("Player 2 (X) wins");
                numberOfWinsByPlayer2++;
                System.exit(0);

            }
            loopForPlayer1 = true;
            loopForPlayer2 = true;
        }

        System.out.println("Draw");

    }

    /**
     * Description: It validates the input of the user; re-prompts the user to enter
     * a valid input incase it gives anything not between 1 and 9 inclusive.
     * 
     * @param input takes in a Scanner input.
     * @return an integer between 1 and 9 inclusive
     */
    public static int getInt(Scanner input) {

        do {

            try {
                int userInput = Integer.parseInt(input.nextLine());
                if (userInput < 1 || userInput > 25)
                    throw new ValueOutOfBoundsException("Board position out of bounds for position " + userInput);
                return userInput;
            } catch (NumberFormatException e) {
                System.out.println("Not an Integer");
                System.out.println("Enter an accurate position");
            } catch (ValueOutOfBoundsException e) {
                System.out.println(e.getMessage());
                System.out.println("Enter an accurate position");
            }

        } while (true);

    }

}
