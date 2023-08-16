package TicTacToe;

import java.util.Scanner;

public class GameLogic {
    public static void main(String args[]) {

        Scanner input = new Scanner(System.in);
        GameBoard b = new GameBoard();

        int position1;
        int position2;
        String numPosition2;
        String numPosition1;
        boolean isOccupied1 = false;
        boolean isOccupied2 = false;
        boolean loop1 = true;
        boolean loop2 = true;
        boolean result = false;
        System.out.println("Welcome to the Tic-Tac-Toe Game.\n");
        b.printBoard();

        while (result == false && b.isFull() == false) {

            /*
             * loop below enables player 1 to play, he is reprompted to enter a valid input
             * within 1 and 25 inclusive incase he gives the wrong input.
             */

            while (loop1 == true && b.isFull() == false) {
                System.out.print("Player 1 (O) ---- Enter a position to play: ");
                position1 = getInt(input);
                numPosition1 = String.format("%d", position1);
                isOccupied1 = b.checkSpace(numPosition1);

                if (isOccupied1 == true) {
                    System.out.println("The position is already occupied");
                    System.out.println("Choose a different postion");
                    loop1 = true;

                } else {
                    b.changePosition(numPosition1, "O");
                    System.out.println();
                    b.printBoard();
                    System.out.println();
                    loop1 = false;

                }

            }

            /*
             * checks to see if there is a win so far. If there is, ther program ends
             * otherwise, it continues.
             */
            result = b.checkWin();
            if (result) {
                System.out.println("Player 1 (O) wins");
                System.exit(0);

            }

            /*
             * loop below enables player 1 to play, he is reprompted to enter a valid input
             * within 1 and 25 inclusive incase he gives the wrong input.
             */
            while (loop2 && !b.isFull()) {
                System.out.print("Player 2 (X)---- Enter a position to play: ");
                position2 = getInt(input);
                numPosition2 = String.format("%d", position2);
                isOccupied2 = b.checkSpace(numPosition2);

                if (isOccupied2 == true) {
                    System.out.println("The position is already occupied");
                    System.out.println("Choose a new position");
                    loop2 = true;

                } else {
                    b.changePosition(numPosition2, "X");
                    System.out.println();
                    b.printBoard();
                    System.out.println();
                    loop2 = false;

                }

            }

            /*
             * checks to see if there is a win so far. If there is, ther program ends
             * otherwise, it continues.
             */
            result = b.checkWin();
            if (result) {
                System.out.println("Player 2 (X) wins");
                System.exit(0);

            }
            loop1 = true;
            loop2 = true;
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
        boolean loop = true;
        int num = 0;
        while (loop) {
            if (input.hasNextInt()) {
                num = input.nextInt();
                if (num < 1 || num > 25) {
                    input.nextLine();
                    System.out.println(
                            "Number out of range; enter an accurate position number as displayed on the board");

                } else {
                    loop = false;
                }

            } else {
                input.nextLine();
                System.out.println(
                        "You did not enter a correct postion; enter an accurate position number as displayed on the board");

            }
        }

        return num;
    }

}
