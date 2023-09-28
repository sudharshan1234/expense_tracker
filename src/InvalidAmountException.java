
/**
 * The InvalidAmountException class is a custom exception that extends the
 * Exception class.
 * It is thrown when an invalid amount is encountered, providing a specific
 * error message.
 */
public class InvalidAmountException extends Exception {

	/**
	 * Constructs a new InvalidAmountException with the specified error message.
	 *
	 * @param message The error message associated with the exception.
	 */
	public InvalidAmountException(String message) {
		super(message);
	}

}
