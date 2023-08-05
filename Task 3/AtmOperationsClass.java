package atm;

import java.time.LocalDateTime;
import java.util.HashMap;

public class AtmOperationsClass implements AtmInterfaceOperations{
	AutomatedTellerMachine atm = new AutomatedTellerMachine();
	HashMap<Double, String> transHis = new HashMap<>();
	
	
	@Override
	public void viewBalance() {
		// TODO Auto-generated method stub
		System.out.println("Your current balance is " + atm.getTotalBalance());
	}

	@Override
	public void debitAmount(double debit) {
		// TODO Auto-generated method stub
		if (atm.getTotalBalance() < debit) {
		    System.out.println("You have insufficient balance in your account.");
		} else if (debit % 100 !=0) {
			System.out.println("Kindly enter the amount in the multiple of 100.");
		} else {
			transHis.put(debit, "Debited successfully on " + LocalDateTime.now());
			System.out.println("\n" + debit + " debited from your account.");
			System.out.println("Kindly collect your cash!");
			atm.setTotalBalance(atm.getTotalBalance() - debit);
		}
	}

	@Override
	public void creditAmount(double credit) {
		// TODO Auto-generated method stub
		if (credit % 100 == 0) {
			transHis.put(credit, "Credited successfully on " + LocalDateTime.now());
			System.out.println("\n" + credit + " credited successfully.");
			atm.setTotalBalance(atm.getTotalBalance() + credit);
		} else {
			System.out.println("Kindly enter the amount in the multiple of 100.");
		}
	}

	@Override
	public void transferAmount(int accountNo, double amount) {
		// TODO Auto-generated method stub
		if (atm.getTotalBalance() >= amount) {
			transHis.put(amount, "Transferred to account " + accountNo + " successfully on " + LocalDateTime.now());
			System.out.println("\n" + amount + " is transferred successfully to the account no. " + accountNo + ".");
			atm.setTotalBalance(atm.getTotalBalance() - amount);
		} else {
			System.out.println("Insufficient Balance!!");
			viewBalance();
		}
	}

	@Override
	public void transactionHistory() {
		// TODO Auto-generated method stub
		System.out.println("\nAmount\t|\tTransaction Type & Date");
		
		for (int i = 0; i < 80; i++) {
			System.out.print("-");
		}
		
		System.out.println();
		
		for (HashMap.Entry th : transHis.entrySet()) {
			System.out.println(th.getKey()+ "\t|\t" + th.getValue());
		}
	}
	
}
