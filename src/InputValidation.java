/**
 * The InputValidation class provides methods to validate user input for the
 * Expense Tracker application.
 */
public class InputValidation {

	/**
	 * Validates if the provided amount is within the valid range of 0 to 1000.
	 *
	 * @param amountField The input representing the amount.
	 * @throws InvalidAmountException If the input is not a valid amount (outside
	 *                                the range 0 to 1000).
	 */
	public void isAmountValid(String amountField) throws InvalidAmountException {
		try {
			double amount = Double.parseDouble(amountField);
			if (amount < 0 || amount > 1000) {
				throw new InvalidAmountException("Invalid Amount. Please enter amount between 0 and 1000");
			}
		} catch (Exception e) {
			// TODO: handle exception
			throw new InvalidAmountException("Invalid Amount. Please enter amount between 0 and 1000");

		}

	}

	/**
	 * Validates if the provided category is one of the predefined valid categories.
	 *
	 * @param category The input representing the category.
	 * @throws InvalidCategoryException If the input is not a valid category.
	 */
	public void isCategoryValid(String category) throws InvalidCategoryException {
		String[] validCategories = { "food", "travel", "bills", "entertainment", "other" };
		for (String validCategory : validCategories) {
			if (validCategory.equals(category.toLowerCase())) {
				return;
			}

		}
		throw new InvalidCategoryException("Invalid Category");
	}

}
