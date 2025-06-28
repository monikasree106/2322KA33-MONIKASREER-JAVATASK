package day3;
import java.util.ArrayList;
import java.util.Scanner;
class Book 
{
    String title;
    boolean isIssued;
    Book(String title)
    {
        this.title = title;
        this.isIssued = false;
    }
    void issue()
    {
        if (!isIssued)
        {
            isIssued = true;
            System.out.println("Book '" + title + "' has been issued.");
        } 
        else 
        {
            System.out.println("Book '" + title + "' is already issued.");
        }
    }
    void returnBook() 
    {
        isIssued = false;
    }
   public String toString() 
   {
        return title + (isIssued ? " (Issued)" : " (Available)");
   }
}
public class taskpost5
{
    static ArrayList<Book> library = new ArrayList<>();
    static void addBook(String title) 
    {
        library.add(new Book(title));
        System.out.println("Book '" + title + "' added to library.");
    }
    static void removeBook(String title)
    {
        for (int i = 0; i < library.size(); i++) 
        {
            if (library.get(i).title.equalsIgnoreCase(title)) 
            {
                library.remove(i);
                System.out.println("Book '" + title + "' removed from library.");
                return;
            }
        }
        System.out.println("Book '" + title + "' not found in library.");
    }
    static void issueBook(String title)
    {
        for (Book book : library) 
        {
            if (book.title.equalsIgnoreCase(title))
            {
                book.issue();
                return;
            }
        }
        System.out.println("Book '" + title + "' not found in library.");
    }
    static void displayBooks() 
    {
        System.out.println("\nBooks in Library:");
        if (library.isEmpty()) 
        {
            System.out.println("No books available.");
        }
        else
        {
            for (Book book : library)
            {
                System.out.println(book);
            }
        }
        System.out.println();
    }
    public static void main(String[] args) 
    {
        Scanner sc = new Scanner(System.in);
        int choice;
        do 
        {
            System.out.println("Library System Menu:");
            System.out.println("1. Add Book");
            System.out.println("2. Remove Book");
            System.out.println("3. Issue Book");
            System.out.println("4. Display Books");
            System.out.println("5. Exit");
            System.out.print("Enter choice: ");
            choice = sc.nextInt();
            sc.nextLine();  
            switch (choice)
            {
                case 1:
                    System.out.print("Enter book title to add: ");
                    String addTitle = sc.nextLine();
                    addBook(addTitle);
                    break;
                case 2:
                    System.out.print("Enter book title to remove: ");
                    String removeTitle = sc.nextLine();
                    removeBook(removeTitle);
                    break;
                case 3:
                    System.out.print("Enter book title to issue: ");
                    String issueTitle = sc.nextLine();
                    issueBook(issueTitle);
                    break;
                case 4:
                    displayBooks();
                    break;
                case 5:
                    System.out.println("Exiting Library System.");
                    break;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        } 
        while (choice != 5);
        sc.close();
    }
}

