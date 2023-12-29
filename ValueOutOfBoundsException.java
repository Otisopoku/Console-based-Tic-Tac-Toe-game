/**
 * Exception class to handle when the user gives a position outside the
 * avaliable position within the board game
 */

public class ValueOutOfBoundsException extends Exception {

    /**
     * Default constructer that invokes the parent class
     */
    public ValueOutOfBoundsException() {
        super();
    }

    /**
     * 
     * @param message message to output to the user
     */
    public ValueOutOfBoundsException(String message) {
        super(message);
    }

}
