package day1;
import java.util.Scanner;
public class taskpost5
{
	    public static int calculateTotal(int[] marks)
	    {
	        int total = 0;
	        for(int mark : marks)
	        {
	            total += mark;
	        }
	        return total;
	    }
	    public static double calculateAverage(int total, int subjects) 
	    {
	        return (double) total / subjects;
	    }
	    public static double calculatePercentage(int total, int maxMarks) 
	    {
	        return ((double) total / maxMarks) * 100;
	    }
	    public static String determineGrade(double percentage)
	    {
	        if(percentage >= 90) {
	            return "A+";
	        } else if(percentage >= 80) {
	            return "A";
	        } else if(percentage >= 70) {
	            return "B";
	        } else if(percentage >= 60) {
	            return "C";
	        } else if(percentage >= 50) {
	            return "D";
	        } else {
	            return "Fail";
	        }
	    }
	    public static void main(String[] args) 
	    {
	        Scanner sc = new Scanner(System.in);
	        int subjects = 5;
	        int[] marks = new int[subjects];
	        int maxMarksPerSubject = 100;
	        System.out.println("Enter marks for " + subjects + " subjects (out of 100):");
	        for(int i = 0; i < subjects; i++)
	        {
	            System.out.print("Subject " + (i+1) + ": ");
	            marks[i] = sc.nextInt();
	        }
	        int total = calculateTotal(marks);
	        double average = calculateAverage(total, subjects);
	        double percentage = calculatePercentage(total, subjects * maxMarksPerSubject);
	        String grade = determineGrade(percentage);
	        System.out.println("\n--- Student Result ---");
	        System.out.println("Total Marks: " + total);
	        System.out.println("Average Marks: " + average);
	        System.out.println("Percentage: " + percentage + "%");
	        System.out.println("Grade: " + grade);
	        sc.close();
	        }
}
