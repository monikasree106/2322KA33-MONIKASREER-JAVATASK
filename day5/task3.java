package day5;
import java.util.HashMap;
import java.util.Map;
public class task3 {
    public static void main(String[] args) 
    {
        HashMap<String, Integer> studentMarks = new HashMap<>();
        studentMarks.put("Alice", 85);
        studentMarks.put("Bob", 78);
        studentMarks.put("Charlie", 92);
        studentMarks.put("David", 88);
        System.out.println("Student Marks:");
        for (Map.Entry<String, Integer> entry : studentMarks.entrySet())
        {
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }
        int sum = 0;
        for (int mark : studentMarks.values())
        {
            sum += mark;
        }
        double average = (double) sum / studentMarks.size();
        System.out.println("\nAverage Marks: " + average);
    }
}