package atm;

public interface AtmInterfaceOperations {
	void viewBalance();
	void debitAmount(double debit);
	void creditAmount(double credit);
	void transferAmount(int accountNo, double amount);
	void transactionHistory();
}
