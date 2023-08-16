/**
 * This class is for a board game data, and contains characteristics of a simple
 * board game and actions that carries out
 * specific functions to simulated the board game.
 * 
 * @author Otis Opoku.
 */

package TicTacToe;

public class GameBoard {
    String[][] board = new String[5][5];

    /**
     * A constructor that creats the board of the game.
     * The numbers represent the positions that the player can play.
     * They help the players to know where to play.
     */
    public GameBoard() {
        board[0][0] = "1";
        board[0][1] = "2";
        board[0][2] = "3";
        board[0][3] = "4";
        board[0][4] = "5";
        board[1][0] = "6";
        board[1][1] = "7";
        board[1][2] = "8";
        board[1][3] = "9";
        board[1][4] = "10";
        board[2][0] = "11";
        board[2][1] = "12";
        board[2][2] = "13";
        board[2][3] = "14";
        board[2][4] = "15";
        board[3][0] = "16";
        board[3][1] = "17";
        board[3][2] = "18";
        board[3][3] = "19";
        board[3][4] = "20";
        board[4][0] = "21";
        board[4][1] = "22";
        board[4][2] = "23";
        board[4][3] = "24";
        board[4][4] = "25";

    }

    /**
     * Predescription: void
     * Postdescription: void
     * description: This method prints out the elements of the board.
     * 
     */
    public void printBoard() {
        int counter1 = 0;
        int counter2 = 0;

        for (String[] arrays : board) {

            for (String elements : arrays) {
                if (counter1 >= 0 && counter1 < 4) {
                    System.out.print(String.format("%5s%5s", elements, " | "));
                } else {
                    System.out.print(String.format("%5s", elements));
                }
                counter1++;

            }
            System.out.println();
            counter1 = 0;
            if (counter2 >= 0 && counter2 < 4) {
                System.out.println("-------------------------------------------------");
            } else {
                System.out.println();
            }
            counter2++;

        }

    }

    /**
     * Postdescription: void
     * Description: inserts the parameter "play" into the position of the parameter
     * "pos"
     * 
     * @param pos  this is the position the player wants to insert parameter "play"
     * @param play this is what the player plays with (eg."X" or "O")
     */

    public void changePosition(String pos, String play) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j].equals(pos)) {
                    board[i][j] = play;
                }
            }
        }
    }

    /**
     * Predescription: void
     * Description: finds to see if there is a win by checking the elements of the
     * array
     * 
     * @return boolean (true if there is a win; otherwise it returns false)
     */

    public boolean checkWin() {
        for (int i = 0; i < board.length; i++) {
            if (board[i][0].equals(board[i][1]) && board[i][1].equals(board[i][2]) && board[i][2].equals(board[i][3])
                    && board[i][3].equals(board[i][4])) {
                return true;
            }
        }

        if (board[0][0].equals(board[1][0]) && board[1][0].equals(board[2][0]) && board[2][0].equals(board[3][0])
                && board[3][0].equals(board[4][0])) {
            return true;
        }

        else if (board[0][1].equals(board[1][1]) && board[1][1].equals(board[2][1]) && board[2][1].equals(board[3][1])
                && board[3][1].equals(board[4][1])) {
            return true;
        }

        else if (board[0][2].equals(board[1][2]) && board[1][2].equals(board[2][2]) && board[2][2].equals(board[3][2])
                && board[3][2].equals(board[4][2])) {
            return true;
        } else if (board[0][3].equals(board[1][3]) && board[1][3].equals(board[2][3]) && board[2][3].equals(board[3][3])
                && board[3][3].equals(board[4][3])) {
            return true;
        } else if (board[0][4].equals(board[1][4]) && board[1][4].equals(board[2][4]) && board[2][4].equals(board[3][4])
                && board[3][4].equals(board[4][4])) {
            return true;
        }

        else if (board[0][0].equals(board[1][1]) && board[1][1].equals(board[2][2]) && board[2][2].equals(board[3][3])
                && board[3][3].equals(board[4][4])) {
            return true;
        }

        else if (board[0][4].equals(board[1][3]) && board[1][3].equals(board[2][2]) && board[2][2].equals(board[3][1])
                && board[3][1].equals(board[4][0])) {
            return true;
        }

        return false;

    }

    /**
     * Description: Checks to see if the specified space (pos) is occupied or not
     * 
     * @param pos this is the position the player wants to insert his "play"
     * @return boolean (true if the space the user wants to insert is not occupied;
     *         otherwise false)
     */

    public boolean checkSpace(String pos) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j].equals(pos)) {
                    return false;
                }

            }
        }

        return true;
    }

    /**
     * Predescription: void
     * Description: Checks to see whether the board is full or not
     * 
     * @return boolean (true if board is full, otherwise false)
     */

    public boolean isFull() {
        int count = 0;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j].equals("X") || board[i][j].equals("O")) {
                    count++;
                }
            }
        }

        if (count < 25) {
            return false;
        }
        return true;
    }

}
