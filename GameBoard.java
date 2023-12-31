import java.util.HashMap;

/**
 * This class is for board game, and contains characteristics of a simple
 * board game and actions that carry out
 * specific functions to simulate the board game.
 * 
 * @author Otis Opoku.
 */

public class GameBoard {
    private final int boardSize = 5;
    HashMap<String, String> board = new HashMap<>(boardSize * boardSize); // hashMap to designate the board of the game.

    /**
     * A constructor that creates the board of the game.
     * The numbers represent the positions that the player can play.
     * They help the players to know where to play.
     */
    public GameBoard() {
        for (int i = 0; i < boardSize * boardSize; i++) {
            board.put(String.valueOf(i + 1), String.valueOf(i + 1));
        }

    }

    /**
     * prints the board game for the users to view the positions of their play
     */
    public void printBoard() {
        for (int i = 0; i < board.size(); i++) {
            if (i % 5 == 0) {
                if (i > 0) {
                    System.out.println(String.format("%n%s", "-------------------------------"));
                }
                System.out.print(String.format("| %-4s", board.get(String.valueOf(i + 1))));
            } else if (i % 5 == 4) {
                System.out.print(String.format("| %-4s|", board.get(String.valueOf(i + 1))));
            } else {
                System.out.print(String.format("| %-4s", board.get(String.valueOf(i + 1))));
            }
        }
        System.out.println("\n");
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
        board.put(pos, play);
    }

    /**
     * Predescription: void
     * Description: finds to see if there is a win by checking the elements of the
     * array
     * 
     * @return boolean (true if there is a win; otherwise it returns false)
     */
    public boolean checkWin(String player) {
        if (board.get("1").equals(player) && board.get("2").equals(player) && board.get("3").equals(player)
                && board.get("4").equals(player) && board.get("5").equals(player)
                || board.get("6").equals(player) && board.get("7").equals(player) && board.get("8").equals(player)
                        && board.get("9").equals(player) && board.get("10").equals(player)
                || board.get("11").equals(player) && board.get("12").equals(player) && board.get("13").equals(player)
                        && board.get("14").equals(player) && board.get("15").equals(player)
                || board.get("16").equals(player) && board.get("17").equals(player) && board.get("18").equals(player)
                        && board.get("19").equals(player) && board.get("20").equals(player)
                || board.get("21").equals(player) && board.get("22").equals(player) && board.get("23").equals(player)
                        && board.get("24").equals(player) && board.get("25").equals(player)) {
            return true;
        } else if (board.get("1").equals(player) && board.get("7").equals(player) && board.get("3").equals(player)
                && board.get("13").equals(player) && board.get("19").equals(player) && board.get("25").equals(player)
                || board.get("5").equals(player) && board.get("9").equals(player) && board.get("13").equals(player)
                        && board.get("17").equals(player) && board.get("21").equals(player)) {
            return true;
        } else if (board.get("1").equals(player) && board.get("6").equals(player) && board.get("11").equals(player)
                && board.get("16").equals(player) && board.get("21").equals(player)
                || board.get("2").equals(player) && board.get("7").equals(player) && board.get("12").equals(player)
                        && board.get("17").equals(player) && board.get("22").equals(player)
                || board.get("3").equals(player) && board.get("8").equals(player) && board.get("13").equals(player)
                        && board.get("18").equals(player) && board.get("23").equals(player)
                || board.get("4").equals(player) && board.get("9").equals(player) && board.get("14").equals(player)
                        && board.get("19").equals(player) && board.get("24").equals(player)
                || board.get("5").equals(player) && board.get("10").equals(player) && board.get("15").equals(player)
                        && board.get("20").equals(player) && board.get("25").equals(player)) {
            return true;
        } else {
            return false;
        }

    }

    /**
     * Description: Checks to see if the specified space (pos) is occupied or not
     * 
     * @param pos this is the position the player wants to insert his "play"
     * @return boolean (true if the space the user wants to insert is not occupied;
     *         otherwise false)
     */

    public boolean checkSpace(String pos) {
        if (board.get(pos).equals(pos)) {
            return false;
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
        for (String key : board.keySet()) {
            if (board.get(key).equals(key))
                return false;

        }
        return true;
    }

    public void clearBoard() {
        for (int i = 0; i < board.size(); i++) {
            board.put(String.valueOf(i + 1), String.valueOf(i + 1));
        }
    }

}
