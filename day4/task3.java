package day4;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
public class task3 
{
    public static void main(String[] args) 
    {
        String[] lines = 
        {
            "First line",
            "Second line",
            "Third line"
        };
        String filename = "output.txt";
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) 
        {
            for (String line : lines) 
            {
                writer.write(line);
                writer.newLine();
            }
            System.out.println("Lines written to file successfully.");
        }
        catch (IOException e)
        {
            System.out.println("An error occurred: " + e.getMessage());
        }
    }
}
