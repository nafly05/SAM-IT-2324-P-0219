
import java.util.Scanner;


class BankAccount {
    private String accountNumber;
    private double balance;


    public BankAccount(String accountNumber) {
        this.accountNumber = accountNumber;
        this.balance = 0.0;
    }


    public void deposit(double amount) {
        if (amount <= 0) {
            System.out.println("Please enter a valid amount greater than zero.");
        } else {
            balance += amount;
            System.out.println("Deposit successful! Rs. " + amount + " added to your account.");
        }
    }


    public void withdraw(double amount) {
        if (amount <= 0) {
            System.out.println("Please enter a valid amount greater than zero");
        } else if (amount > balance) {
            System.out.println("Insufficient balance! Your current balance is Rs. " + balance);
        } else {
            balance -= amount;
            System.out.println(" Your Withdrawal successful! Rs. " + amount + " withdrawn from your account.");
        }
    }


    public double getBalance() {
        return balance;
    }

    
    public void showAccountInfo() {
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Current Balance: Rs. " + balance);
    }
}


public class BankApplication {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter your Account Number: ");
        String accNo = input.nextLine();

        BankAccount account = new BankAccount(accNo);

        int choice;
        do {
            System.out.println("\n==== Bank Menu ====");
            System.out.println("1. Deposit Money");
            System.out.println("2. Withdraw Money");
            System.out.println("3. Check Balance");
            System.out.println("4. Show Account Info");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            choice = input.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter amount to deposit: Rs. ");
                    double depositAmount = input.nextDouble();
                    account.deposit(depositAmount);
                    break;

                case 2:
                    System.out.print("Enter amount to withdraw: Rs. ");
                    double withdrawAmount = input.nextDouble();
                    account.withdraw(withdrawAmount);
                    break;

                case 3:
                    System.out.println("Your current balance is: Rs. " + account.getBalance());
                    break;

                case 4:
                    account.showAccountInfo();
                    break;

                case 5:
                    System.out.println("Thank you for using our banking service!");
                    break;

                default:
                    System.out.println("Invalid choice! Please try again.");
            }
        } while (choice != 5);

        input.close();
    }
}
