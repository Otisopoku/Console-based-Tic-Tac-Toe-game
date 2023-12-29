/**
 * This class is for board game, and contains characteristics of a simple
 * board game and actions that carry out
 * specific functions to simulate the board game.
 * 
 * @author Otis Opoku.
 */

public class GameBoard {
    private final int boardSize = 5;
    String[][] board = new String[boardSize][boardSize];

    /**
     * A constructor that creates the board of the game.
     * The numbers represent the positions that the player can play.
     * They help the players to know where to play.
     */
    public GameBoard() {
        for (int i = 0; i < boardSize; i++) {
            for (int j = 0; i < boardSize; j++) {
                board[i][j] = String.valueOf(j + 1);
            }
        }

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
        // Check rows and columns
        for (int i = 0; i < boardSize; i++) {
            if ((board[i][0].equals(board[i][1]) && board[i][1].equals(board[i][2])
                    && board[i][2].equals(board[i][3]) && board[i][3].equals(board[i][4]))
                    || (board[0][i].equals(board[1][i]) && board[1][i].equals(board[2][i])
                            && board[2][i].equals(board[3][i]) && board[3][i].equals(board[4][i]))) {
                return true;
            }
        }

        // Check diagonals
        if ((board[0][0].equals(board[1][1]) && board[1][1].equals(board[2][2]) && board[2][2].equals(board[3][3])
                && board[3][3].equals(board[4][4]))
                || (board[0][4].equals(board[1][3]) && board[1][3].equals(board[2][2])
                        && board[2][2].equals(board[3][1])
                        && board[3][1].equals(board[4][0]))) {
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
