package day6;

class MessagePrinter implements Runnable 
{
    private String message;
    public MessagePrinter(String message) 
    {
        this.message = message;
    }
    public void run() {
        for (int i = 1; i <= 5; i++)
        {
            System.out.println(Thread.currentThread().getName() + ": " + message + " (" + i + ")");
            try {
                Thread.sleep(500); 
            } catch (InterruptedException e)
            {
                System.out.println("Thread interrupted.");
            }
        }
    }
}
public class task2 
{
    public static void main(String[] args) 
    {
        Thread t1 = new Thread(new MessagePrinter("Hello from Thread 1"));
        Thread t2 = new Thread(new MessagePrinter("Hello from Thread 2"));
        Thread t3 = new Thread(new MessagePrinter("Hello from Thread 3"));
        t1.start();
        t2.start();
        t3.start();
    }
}
