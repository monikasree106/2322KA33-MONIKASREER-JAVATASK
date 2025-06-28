package day3;
import java.util.Scanner;
class BankAccount
{
    private String accountNumber;
    private String accountHolderName;
    private double balance;
    public BankAccount(String accNumber, String accHolderName, double initialBalance)
    {
        accountNumber = accNumber;
        accountHolderName = accHolderName;
        balance = initialBalance;
    }
    public void deposit(double amount) 
    {
        if(amount > 0)
        
        {
            balance += amount;
            System.out.println("Deposited: ₹" + amount);
        } 
        else
        {
            System.out.println("Invalid deposit amount.");
        }
    }
    public void withdraw(double amount)
    {
        if(amount > 0 && amount <= balance) 
        {
            balance -= amount;
            System.out.println("Withdrawn: ₹" + amount);
        }
        else
        {
            System.out.println("Invalid or insufficient balance for withdrawal.");
        }
    }
    public void displayBalance() 
    {
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Account Holder: " + accountHolderName);
        System.out.println("Current Balance: ₹" + balance);
    }
}
public class task1
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Account Number: ");
        String accNumber = sc.nextLine();
        System.out.print("Enter Account Holder Name: ");
        String accHolderName = sc.nextLine();
        System.out.print("Enter Initial Balance: ₹");
        double initialBalance = sc.nextDouble();
        BankAccount account = new BankAccount(accNumber, accHolderName, initialBalance);
        while(true)
        {
            System.out.println("\n--- Bank Menu ---");
            System.out.println("1. Deposit");
            System.out.println("2. Withdraw");
            System.out.println("3. Display Balance");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");
            int choice = sc.nextInt();
            switch(choice) 
            {
                case 1:
                    System.out.print("Enter amount to deposit: ₹");
                    double depositAmount = sc.nextDouble();
                    account.deposit(depositAmount);
                    break;
                case 2:
                    System.out.print("Enter amount to withdraw: ₹");
                    double withdrawAmount = sc.nextDouble();
                    account.withdraw(withdrawAmount);
                    break;
                case 3:
                    account.displayBalance();
                    break;
                case 4:
                    System.out.println("Thank you for using the Bank App.");
                    sc.close();
                    System.exit(0);
                default:
                    System.out.println("Invalid choice.");
            }
        }
    }
}
