package day6;
class TicketCounter 
{
    private int availableSeats = 5;
    public void bookTicket(String user, int seatsRequested)
    {
        synchronized (this)
        {
            System.out.println(user + " is trying to book " + seatsRequested + " seat(s)...");
            if (seatsRequested <= availableSeats)
            {
                System.out.println("Seats available. Booking in progress for " + user + "...");
                try 
                {
                    Thread.sleep(1000); // Simulate processing delay
                }
                catch (InterruptedException e)
                {
                    System.out.println("Booking interrupted for " + user);
                }
                availableSeats -= seatsRequested;
                System.out.println("Booking successful for " + user + ". Seats left: " + availableSeats);
            }
            else 
            {
                System.out.println("Booking failed for " + user + ". Not enough seats available.");
            }
        }
    }
}
class User extends Thread 
{
    private String userName;
    private int seats;
    private TicketCounter counter;
    public User(String userName, int seats, TicketCounter counter) 
    {
        this.userName = userName;
        this.seats = seats;
        this.counter = counter;
    }
    public void run() 
    {
        counter.bookTicket(userName, seats);
    }
}

public class taskmain4
{
    public static void main(String[] args) 
    {
        TicketCounter counter = new TicketCounter();
        User user1 = new User("User-A", 2, counter);
        User user2 = new User("User-B", 1, counter);
        User user3 = new User("User-C", 3, counter);
        User user4 = new User("User-D", 1, counter);
        user1.start();
        user2.start();
        user3.start();
        user4.start();
    }
}
