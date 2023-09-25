
public class InputValidation {
	public void isAmountValid(double amount) throws InvalidAmountException {
		if(amount < 0 || amount > 1000) {
			throw new InvalidAmountException("Invalid Amount. Please enter amount between 0 and 1000");
		}
	}
	public void isCategoryValid(String category) throws InvalidCategoryException {
		String[] validCategories = {"food", "travel", "bills", "entertainment", "other"};
        for (String validCategory : validCategories) {
            if (validCategory.equals(category.toLowerCase())) {
                return;
            }  	
        		
        }
        throw new InvalidCategoryException("Invalid Category");
	}

}

	