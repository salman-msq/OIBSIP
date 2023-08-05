package atm;

public class AutomatedTellerMachine {
	private double creditBalance;
	private double debitBalance;
	private double totalBalance;
	
	public AutomatedTellerMachine() {
		totalBalance = 20000.00;
	}
	
	public double getCreditBalance() {
		return creditBalance;
	}
	
	public void setCreditBalance(double creditBalance) {
		this.creditBalance = creditBalance;
	}
	
	public double getDebitBalance() {
		return debitBalance;
	}
	
	public void setDebitBalance(double debitBalance) {
		this.debitBalance = debitBalance;
	}
	
	public double getTotalBalance() {
		return totalBalance;
	}
	
	public void setTotalBalance(double totalBalance) {
		this.totalBalance = totalBalance;
	}
	
}
