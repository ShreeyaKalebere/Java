import java.util.Scanner;

class LowBalanceException extends Exception {
    LowBalanceException(String message) {
        System.out.println("LowBalanceException: " + message);
    }
}

class NegativeNumberException extends Exception {
    NegativeNumberException(String message) {
        System.out.println("NegativeNumberException: " + message);
    }
}

class BankAccount {
    double balance;

    BankAccount(double initialBalance) {
        balance = initialBalance;
    }

    void balanceEnquiry() {
        System.out.println("Current Balance: Rs." + balance);
    }

    void deposit(double amount) throws NegativeNumberException {
        if (amount < 0) {
            throw new NegativeNumberException("Cannot deposit a negative amount.");
        }
        balance += amount;
        System.out.println("Rs." + amount + " deposited successfully.");
    }

    void withdraw(double amount) throws LowBalanceException, NegativeNumberException {
        if (amount < 0) {
            throw new NegativeNumberException("Cannot withdraw a negative amount.");
        }
        if (amount > balance) {
            throw new LowBalanceException("Insufficient balance.");
        }
        balance -= amount;
        System.out.println("Rs." + amount + " withdrawn successfully.");
    }
}

public class BankApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BankAccount account = new BankAccount(5000);

        while (true) {
            System.out.println("\n------ Bank Menu ------");
            System.out.println("1. Balance Enquiry");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    account.balanceEnquiry();
                    break;
                case 2:
                    System.out.print("Enter amount to deposit: ");
                    double depositAmount = scanner.nextDouble();
                    try {
                        account.deposit(depositAmount);
                    } catch (NegativeNumberException e) {
                        System.out.println("Deposit failed.");
                    }
                    break;
                case 3:
                    System.out.print("Enter amount to withdraw: ");
                    double withdrawAmount = scanner.nextDouble();
                    try {
                        account.withdraw(withdrawAmount);
                    } catch (LowBalanceException | NegativeNumberException e) {
                        System.out.println("Withdrawal failed.");
                    }
                    break;
                case 4:
                    System.out.println("Thank you for using the Bank App.");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
