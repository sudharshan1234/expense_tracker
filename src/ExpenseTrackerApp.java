import java.util.logging.ConsoleHandler;
import java.util.logging.Level;
import java.util.logging.LogManager;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 * The ExpenseTrackerApp class allows users to add/remove daily transactions.
 */
public class ExpenseTrackerApp {
  private static final Logger logger = Logger.getLogger(ExpenseTrackerView.class.getName());

  // Set up logging properties

  public static void main(String[] args) {

    // Create MVC components
    // Set up logging properties
    LogManager.getLogManager().reset(); // Clear any default configurations
    logger.setLevel(Level.ALL); // Log all messages

    ConsoleHandler consoleHandler = new ConsoleHandler();
    consoleHandler.setLevel(Level.ALL); // Log all messages

    SimpleFormatter formatter = new SimpleFormatter();
    consoleHandler.setFormatter(formatter);

    logger.addHandler(consoleHandler);

    logger.info("ExpenseTrackerView initialized."); // Example log statement

    InputValidation inputValidation = new InputValidation();
    DefaultTableModel tableModel = new DefaultTableModel();
    tableModel.addColumn("Serial");
    tableModel.addColumn("Amount");
    tableModel.addColumn("Category");
    tableModel.addColumn("Date");

    ExpenseTrackerView view = new ExpenseTrackerView(tableModel);

    // Initialize view
    view.setVisible(true);

    // Handle add transaction button clicks
    view.getAddTransactionBtn().addActionListener(e -> {

      // Get transaction data from view
      String amount = view.getAmountField();

      String category = view.getCategoryField();
      try {

        inputValidation.isAmountValid(amount);
        inputValidation.isCategoryValid(category);
        logger.info("User Entered: " + amount + " - " + category);
        double amountNum = Double.parseDouble(amount);
        // Create transaction object
        Transaction t = new Transaction(amountNum, category);

        // Call controller to add transaction
        view.addTransaction(t);
        logger.info("Transaction added: " + t.getAmount() + " - " + t.getCategory());

      } catch (InvalidAmountException e2) {
        JOptionPane.showMessageDialog(null, "Invalid Amount !");
        logger.log(Level.SEVERE, "Error adding transaction: (Invalid Category) " + e2.getMessage(), e2);
        e2.printStackTrace();
      } catch (InvalidCategoryException e1) {
        JOptionPane.showMessageDialog(null, "Invalid Category!");
        logger.log(Level.SEVERE, "Error adding transaction: (Invalid Category) " + e1.getMessage(), e1);
        e1.printStackTrace();
      }

    });

  }

}