import java.util.Scanner;

class BankAccount{
    double balance;

    BankAccount(){
        balance = 0;
    }

    void deposit(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Deposit Amount: ");
        double amount = sc.nextDouble();
        balance = balance + amount;
        System.out.println("Deposited: "+ amount);
    }

    void withdraw(){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter withdrawal amount: ");
        double amount = sc.nextDouble();
        balance = balance - amount;
        System.out.println("Withdrawn: " + amount);
    }

    void displayBalance() {
        System.out.println("Balance: " + balance);
    }
}

class SavingsAccount extends BankAccount{
    void withdraw(){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter withdrawal amount: ");
        double amount = sc.nextDouble();
        
        if (balance - amount < 100) {
            System.out.println("Withdrawal Failed! Minimum balance of 100 required.");
        } else {
            balance -= amount;
            System.out.println("Withdrawn: " + amount);
        }
    }
}

public class BankAccountDemo{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        SavingsAccount s1 = new SavingsAccount();

        System.out.print("Enter initial balance: ");
        s1.balance = sc.nextDouble();

        System.out.println("\nChoose an option: ");
        System.out.println("1. Deposit");
        System.out.println("2. Withdraw");
        System.out.println("3. Display Balance");
        System.out.println("4. Exit");

        int choice;
        do{
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1: s1.deposit();
                        break;
                case 2: s1.withdraw();
                        break;
                case 3: s1.displayBalance();
                        break;
                case 4: System.out.println("Exiting program...");
                        break;           
                default: System.out.println("Invalid choice! Please try again."); 
            }
        } while(choice != 4);
    }
}