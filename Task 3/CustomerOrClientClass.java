package atm;

import java.util.Scanner;

public class CustomerOrClientClass {
	static AtmOperationsClass atm = new AtmOperationsClass();
	static Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub		
		int id = 987654;
		int pin = 7863;
		int cusId, cusPin;
		
		for (int i = 0; i < 27; i++) {
			System.out.print("-");
		}
		System.out.print(" Welcome to the Oasis ATM ");
		
		for (int i = 0; i < 27; i++) {
			System.out.print("-");
		}
		System.out.println();
		for (int i = 0; i < 28; i++) {
			System.out.print("-");
		}
		System.out.print(" Press 0 for ID to Exit ");
		
		for (int i = 0; i < 28; i++) {
			System.out.print("-");
		}
		
		System.out.println();
		
		while (true) {
			System.out.print("\nCustomer/User ID: ");
			cusId = sc.nextInt();
			
			if (cusId == 0) {
				System.exit(0);
			}
			
			System.out.print("Four digit ATM pin: ");
			cusPin = sc.nextInt();
			
			if (cusId != id || cusPin != pin) {
				System.out.println("\nCustomer/User Id or Pin is incorrect!!");
			} else {
				break;
			}
		}
		
		while(true) {
			System.out.println();
			menu();
			
			System.out.print("Select your choice [1 - 6]: ");
			int choice = sc.nextInt();
			
			System.out.println();
			if (choice == 1) {
				balanceEnquiry();
			} else if (choice == 2) {
				withdraw();
			} else if (choice == 3) {
				deposit();
			} else if (choice == 4) {
				transfer();
			} else if (choice == 5) {
				transactionHistory();
			} else if (choice == 6) {
				exit();
				System.exit(0);
			} else {
				System.out.println("Kindly select the correct choice [1 - 6].");
			}
			
		}
		
	}
	
	public static void menu() {
		for (int i = 0; i < 80; i++) {
			System.out.print("-");
		}
		
		System.out.println();
		System.out.println();
		System.out.println("1. Balance Enquiry\n2. Withdraw\n3. Deposit\n4. Transfer\n5. Transactions History\n6. Exit");
	}
	
    public static void balanceEnquiry() {
		atm.viewBalance();
	}
    
    public static void withdraw() {
    	System.out.print("Enter the amount to withdraw: ");
    	atm.debitAmount(sc.nextDouble());
    	balanceEnquiry();
    }
    
    public static void deposit() {
    	System.out.print("Enter the amount to deposit: ");
    	atm.creditAmount(sc.nextDouble());
        balanceEnquiry();
    }
    
    public static void transfer() {
    	System.out.print("Enter the account number: ");
    	int accNo = sc.nextInt();
    	
    	System.out.print("Enter the amount: ");
    	double amnt = sc.nextDouble();
    	
    	atm.transferAmount(accNo, amnt);
    }
    
    public static void transactionHistory() {
    	balanceEnquiry();
    	atm.transactionHistory();
    }
	
	public static void exit() {
		System.out.println("\n-------------------------------- Take Your Card --------------------------------");
		System.out.println("------------------------ Thank You For Choosing Oasis ATM ------------------------");
		System.out.println("-------------------------------- Have A Nice Day ---------------------------------");
		System.out.println("------------------------- Represented By Mohammad Salman -------------------------");
	}

}
