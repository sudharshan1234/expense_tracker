import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


/**
 * The ExpenseTrackerApp class allows users to add/remove daily transactions.
 */
public class ExpenseTrackerApp {

  public static void main(String[] args) {
    
    // Create MVC components
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
      double amount = view.getAmountField(); 
      		
      String category = view.getCategoryField();
      try {
		inputValidation.isAmountValid(amount);
		inputValidation.isCategoryValid(category);
	      // Create transaction object
	    Transaction t = new Transaction(amount, category);
	
	      // Call controller to add transaction
	    view.addTransaction(t);
	    

	} 
      catch (InvalidAmountException e2) {
		JOptionPane.showMessageDialog(null, "Invalid Amount !");
		e2.printStackTrace();
	}
      catch (InvalidCategoryException e1) {
  		JOptionPane.showMessageDialog(null, "Invalid Category!");
  		e1.printStackTrace();
  	}



    });

  }

}