package day6;
class Worker extends Thread 
{
    private String taskName;
    public Worker(String taskName) 
    {
        this.taskName = taskName;
    }
    public void run() {
        System.out.println(taskName + " started.");
        for (int i = 1; i <= 3; i++) 
        {
            System.out.println(taskName + " - Step " + i);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) 
            {
                System.out.println(taskName + " interrupted.");
            }
        }
        System.out.println(taskName + " finished.");
    }
}
public class task3
{
    public static void main(String[] args)
    {
        Worker t1 = new Worker("Thread-A");
        Worker t2 = new Worker("Thread-B");
        System.out.println("Main thread starting Thread-A...");
        t1.start();

        try
        {
            t1.join();
        } 
        catch (InterruptedException e) 
        {
            System.out.println("Main thread interrupted while waiting.");
        }

        System.out.println("Main thread starting Thread-B after Thread-A completes...");
        t2.start();

        try
        {
            t2.join();
        } catch (InterruptedException e) 
        {
            System.out.println("Main thread interrupted while waiting.");
        }

        System.out.println("Main thread ends.");
    }
}

