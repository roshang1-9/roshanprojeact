/**
 * Simple ATM class that manages a user's balance with PIN verification.
 *
 * Features:
 * - PIN verification with lockout after 3 failed attempts
 * - deposit, withdraw, getBalance operations requiring PIN
 * - change PIN (requires current PIN)
 */
public class ATM {
    private String pin;
    private double balance;
    private int failedAttempts;
    private boolean locked;

    private static final int MAX_FAILED_ATTEMPTS = 3;

    public ATM(String initialPin, double initialBalance) {
        if (initialPin == null || initialPin.isEmpty()) throw new IllegalArgumentException("PIN cannot be empty");
        if (initialBalance < 0) throw new IllegalArgumentException("Initial balance cannot be negative");
        this.pin = initialPin;
        this.balance = initialBalance;
        this.failedAttempts = 0;
        this.locked = false;
    }

    /**
     * Verifies the provided PIN. Resets failedAttempts on success.
     * Locks the account after MAX_FAILED_ATTEMPTS incorrect tries.
     */
    public boolean verifyPin(String inputPin) {
        if (locked) return false;
        if (this.pin.equals(inputPin)) {
            failedAttempts = 0;
            return true;
        } else {
            failedAttempts++;
            if (failedAttempts >= MAX_FAILED_ATTEMPTS) {
                locked = true;
            }
            return false;
        }
    }

    private void ensureUnlocked() {
        if (locked) throw new SecurityException("ATM account locked due to multiple invalid PIN entries");
    }

    private void checkPinOrThrow(String inputPin) {
        ensureUnlocked();
        if (!verifyPin(inputPin)) {
            throw new SecurityException("Invalid PIN");
        }
    }

    public void deposit(double amount, String inputPin) {
        checkPinOrThrow(inputPin);
        if (amount <= 0) throw new IllegalArgumentException("Deposit amount must be positive");
        balance += amount;
    }

    public void withdraw(double amount, String inputPin) throws InsufficientFundsException {
        checkPinOrThrow(inputPin);
        if (amount <= 0) throw new IllegalArgumentException("Withdraw amount must be positive");
        if (amount > balance) throw new InsufficientFundsException("Insufficient funds: requested " + amount + ", available " + balance);
        balance -= amount;
    }

    public double getBalance(String inputPin) {
        checkPinOrThrow(inputPin);
        return balance;
    }

    public void changePin(String currentPin, String newPin) {
        checkPinOrThrow(currentPin);
        if (newPin == null || newPin.isEmpty()) throw new IllegalArgumentException("New PIN cannot be empty");
        this.pin = newPin;
    }

    public boolean isLocked() {
        return locked;
    }

    @Override
    public String toString() {
        return String.format("ATM[balance=%.2f, locked=%b]", balance, locked);
    }

    // Custom checked exception for insufficient funds
    public static class InsufficientFundsException extends Exception {
        public InsufficientFundsException(String message) { super(message); }
    }
}
