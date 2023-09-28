import org.junit.Before;
import org.junit.Test;

import javax.swing.table.DefaultTableModel;

import static org.junit.Assert.assertEquals;

public class ExpenseTrackerTest {

    private ExpenseTrackerView view;
    private ExpenseTrackerApp app;

    @Before
    public void setup() {
        DefaultTableModel tableModel = new DefaultTableModel();
        tableModel.addColumn("Serial");
        tableModel.addColumn("Amount");
        tableModel.addColumn("Category");
        tableModel.addColumn("Date");
        view = new ExpenseTrackerView(tableModel);
        app = new ExpenseTrackerApp();
    }

    @Test
    public void testAddTransaction() {
        // Create a new transaction
        double amount = 100.0;
        String category = "Food";
        Transaction transaction = new Transaction(amount, category);

        // Add the transaction to the view
        view.addTransaction(transaction);

        // Get the transactions from the view
        java.util.List<Transaction> transactions = view.getTransactions();

        // Verify that the transaction was added
        assertEquals(1, transactions.size());
        assertEquals(amount, transactions.get(0).getAmount(), 0.001);
        assertEquals(category, transactions.get(0).getCategory());
    }

    @Test(expected = InvalidAmountException.class)
    public void testValidateTransactionAmount() throws InvalidAmountException, InvalidCategoryException {
        InputValidation inputValidation = new InputValidation();
        String amount = "100.0ab0";
        String category = "school";
        inputValidation.isAmountValid(amount);
        inputValidation.isCategoryValid(category);
    }

    @Test(expected = InvalidAmountException.class)
    public void testValidateTransactionCategory() throws InvalidAmountException, InvalidCategoryException {
        InputValidation inputValidation = new InputValidation();
        String amount = "99999";
        String category = "travel";
        inputValidation.isAmountValid(amount);
        inputValidation.isCategoryValid(category);
    }

    @Test(expected = InvalidCategoryException.class)
    public void testValidateTransactionExceedAmount() throws InvalidAmountException, InvalidCategoryException {
        InputValidation inputValidation = new InputValidation();
        String amount = "789";
        String category = "Dance";
        inputValidation.isAmountValid(amount);
        inputValidation.isCategoryValid(category);
    }

}
