package classobjectassignment;

import java.util.Scanner;

public class bankwithdrawlstory {
	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in)) {
			BankAccount account = new BankAccount();

			System.out.print("Enter account holder name: ");
			String name = sc.nextLine().trim();
			account.setAccountHolder(name);

			double balance = -1.0;
			while (balance < 0) {
				System.out.print("Enter current balance (non-negative number): ");
				if (sc.hasNextDouble()) {
					balance = sc.nextDouble();
					if (balance < 0) {
						System.out.println("Balance cannot be negative. Please try again.");
					}
				} else {
					System.out.println("Invalid input. Please enter a numeric value.");
					sc.next();
				}
			}
			account.setBalance(balance);

			double withdraw = -1.0;
			while (withdraw < 0) {
				System.out.print("Enter withdraw amount (non-negative number): ");
				if (sc.hasNextDouble()) {
					withdraw = sc.nextDouble();
					if (withdraw < 0) {
						System.out.println("Withdraw amount cannot be negative. Please try again.");
					}
				} else {
					System.out.println("Invalid input. Please enter a numeric value.");
					sc.next();
				}
			}
			account.setWithdrawAmount(withdraw);

			// Perform the withdrawal logic via getter-like method and display result
			double remaining = account.getRemainingBalance();
			System.out.println();
			System.out.println("Account Holder: " + account.getAccountHolder());
			System.out.printf("Remaining Balance: %.2f%n", remaining);
		}
	}
}

class BankAccount {
	private String accountHolder;
	private double balance;
	private double withdrawAmount;

	// Setters
	public void setAccountHolder(String accountHolder) {
		this.accountHolder = accountHolder;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public void setWithdrawAmount(double withdrawAmount) {
		this.withdrawAmount = withdrawAmount;
	}

	// Getters
	public String getAccountHolder() {
		return accountHolder;
	}

	public double getBalance() {
		return balance;
	}

	public double getWithdrawAmount() {
		return withdrawAmount;
	}

	// Getter-like method that applies withdrawal logic and returns remaining balance.
	// If withdrawAmount <= balance, subtract it; otherwise print "Insufficient balance" and leave balance unchanged.
	public double getRemainingBalance() {
		if (withdrawAmount <= balance) {
			balance = balance - withdrawAmount;
		} else {
			System.out.println("Insufficient balance");
		}
		return balance;
	}
}
