/**
 * Demo for the ATM class. Shows PIN verification, deposit, withdraw, balance check and lockout.
 */
public class ATMDemo {
    public static void main(String[] args) {
        ATM atm = new ATM("1234", 1000.0);
        System.out.println("Created ATM: " + atm);

        // Wrong PIN attempt
        try {
            System.out.println("Attempting to get balance with wrong PIN '0000'");
            double b = atm.getBalance("0000");
            System.out.println("Balance: " + b);
        } catch (SecurityException se) {
            System.out.println("SecurityException: " + se.getMessage());
        }

        // Correct PIN: deposit
        try {
            System.out.println("Depositing 500 with correct PIN '1234'");
            atm.deposit(500, "1234");
            System.out.println("Balance after deposit: " + atm.getBalance("1234"));
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }

        // Withdraw with insufficient funds
        try {
            System.out.println("Attempting to withdraw 2000 with PIN '1234'");
            atm.withdraw(2000, "1234");
        } catch (ATM.InsufficientFundsException ife) {
            System.out.println("InsufficientFundsException: " + ife.getMessage());
        } catch (SecurityException se) {
            System.out.println("SecurityException: " + se.getMessage());
        }

        // Trigger lockout by entering wrong PIN 3 times
        System.out.println("Triggering lockout by entering wrong PIN 3 times...");
        for (int i = 1; i <= 3; i++) {
            try {
                atm.getBalance("0000");
            } catch (SecurityException se) {
                System.out.println("Attempt " + i + ": " + se.getMessage());
            }
        }

        // Now account should be locked; any attempt should throw
        try {
            System.out.println("Trying to access after lockout with correct PIN '1234'");
            System.out.println("Balance: " + atm.getBalance("1234"));
        } catch (SecurityException se) {
            System.out.println("SecurityException: " + se.getMessage());
        }

        System.out.println("Final ATM state: " + atm);
    }
}
