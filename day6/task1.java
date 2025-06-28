package day6;
class NumberPrinter extends Thread {
    public void run() {
        for (int i = 1; i <= 10; i++) {
            System.out.println("Number: " + i);
            try {
                Thread.sleep(500); 
            } catch (InterruptedException e)
            {
                System.out.println("Thread interrupted.");
            }
        }
    }
}
public class task1 {
    public static void main(String[] args)
    {
        NumberPrinter np = new NumberPrinter();
        np.start(); // Start the thread
    }
}

