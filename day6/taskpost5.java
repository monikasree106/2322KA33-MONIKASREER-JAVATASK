package day6;
class BankAccount 
{
    private int balance = 1000;
    public synchronized void withdraw(String user, int amount) 
    {
        System.out.println(user + " is attempting to withdraw ₹" + amount);
        if (amount <= balance) 
        {
            System.out.println(user + " withdrawal in process...");
            try
            {
                Thread.sleep(1000);
            }
            catch (InterruptedException e) 
            {
                System.out.println("Transaction interrupted for " + user);
            }
            balance -= amount;
            System.out.println(user + " successfully withdrew ₹" + amount + ". Remaining balance: ₹" + balance);
        } 
        else 
        {
            System.out.println("❌ " + user + " - Insufficient balance. Current balance: ₹" + balance);
        }
    }
    public int getBalance()
    {
        return balance;
    }
}
class UserTransaction extends Thread 
{
    private String userName;
    private BankAccount account;
    private int amount;

    public UserTransaction(String userName, BankAccount account, int amount) {
        this.userName = userName;
        this.account = account;
        this.amount = amount;
        this.setName(userName);
    }
    public void run()
    {
        account.withdraw(getName(), amount);
    }
}
public class taskpost5 
{
    public static void main(String[] args)
    {
        BankAccount sharedAccount = new BankAccount();
        UserTransaction user1 = new UserTransaction("User-1", sharedAccount, 400);
        UserTransaction user2 = new UserTransaction("User-2", sharedAccount, 300);
        UserTransaction user3 = new UserTransaction("User-3", sharedAccount, 500);
        UserTransaction user4 = new UserTransaction("User-4", sharedAccount, 200);
        user1.start();
        user2.start();
        user3.start();
        user4.start();
    }
}

