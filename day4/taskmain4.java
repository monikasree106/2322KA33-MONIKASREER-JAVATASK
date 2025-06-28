package day4;
import java.io.*;
import java.util.*;
public class taskmain4 
{  
public static void main(String[] args) 
{
        String inputFile = "marks.txt";
        String outputFile = "results.txt";
        try
        (
            BufferedReader reader = new BufferedReader(new FileReader(inputFile));
            BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile))
        )
        {
            String line;
            while ((line = reader.readLine()) != null) 
            {
                String[] parts = line.split("\\s+"); 
                String name = parts[0];
                int total = 0;
                for (int i = 1; i < parts.length; i++)
                {
                    total += Integer.parseInt(parts[i]);
                }
                double average = total / (parts.length - 1.0);
                writer.write(name + " Total: " + total + ", Average: " + String.format("%.2f", average));
                writer.newLine();
            }
            System.out.println("Result file written successfully.");
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
