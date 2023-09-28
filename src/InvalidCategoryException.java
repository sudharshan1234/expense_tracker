/**
 * The InvalidCategoryException class is a custom exception that extends the
 * Exception class.
 * It is thrown when an invalid category is encountered, providing a specific
 * error message.
 */
public class InvalidCategoryException extends Exception {

	/**
	 * Constructs a new InvalidCategoryException with the specified error message.
	 *
	 * @param message The error message associated with the exception.
	 */
	public InvalidCategoryException(String message) {

		super(message);
	}

}
