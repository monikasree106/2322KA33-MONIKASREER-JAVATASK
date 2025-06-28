package day5;
import java.util.HashSet;
import java.util.Iterator;
public class task2
{
    public static void main(String[] args) 
    {
        HashSet<String> emailSet = new HashSet<>();
        emailSet.add("alice@example.com");
        emailSet.add("bob@example.com");
        emailSet.add("charlie@example.com");
        emailSet.add("alice@example.com");
        emailSet.add("dave@example.com");
        System.out.println("Unique Email Addresses:");
        Iterator<String> iterator = emailSet.iterator();
        while (iterator.hasNext()) 
        {
            System.out.println(iterator.next());
        }
    }
}
