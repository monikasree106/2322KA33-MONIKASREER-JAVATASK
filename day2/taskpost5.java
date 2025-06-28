package day2;
import java.util.Scanner;
public class taskpost5
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        String[] names = new String[5];
        String[] phones = new String[5];
        String[] addresses = new String[5];
        int count = 0; 
        while(true) 
        {
            System.out.println("\n--- Mini Address Book ---");
            System.out.println("1. Add Contact");
            System.out.println("2. Display Contacts");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();
            sc.nextLine();
            switch(choice) 
            {
                case 1:
                    if(count < 5) 
                    {
                        System.out.print("Enter Name: ");
                        names[count] = sc.nextLine();
                        System.out.print("Enter Phone Number: ");
                        phones[count] = sc.nextLine();
                        System.out.print("Enter Address: ");
                        addresses[count] = sc.nextLine();
                        count++;
                        System.out.println("Contact Added Successfully!");
                    } 
                    else 
                    {
                        System.out.println("Address Book Full! Cannot add more contacts.");
                    }
                    break;
                case 2:
                    System.out.println("\n--- Contact List ---");
                    if(count == 0) 
                    {
                        System.out.println("No contacts to display.");
                    }
                    else
                    {
                        for(int i = 0; i < count; i++)
                        {
                            System.out.println("Contact " + (i+1) + ":");
                            System.out.println("Name    : " + names[i]);
                            System.out.println("Phone   : " + phones[i]);
                            System.out.println("Address : " + addresses[i]);
                            System.out.println("----------------------");
                        }
                    }
                    break;
                case 3:
                    System.out.println("Exiting Address Book.");
                    sc.close();
                    System.exit(0);
                default:
                    System.out.println("Invalid choice! Please try again.");
            }
        }
    }
}
