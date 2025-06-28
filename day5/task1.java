package day5;
import java.util.ArrayList;
import java.util.Iterator;
class Student {
    String name;
    int rollNo;
    int age;
    Student(String name, int rollNo, int age) 
    {
        this.name = name;
        this.rollNo = rollNo;
        this.age = age;
    }
    public String toString() 
    {
        return "Name: " + name + ", Roll No: " + rollNo + ", Age: " + age;
    }
}
public class task1 
{
    public static void main(String[] args) 
    {
        ArrayList<Student> students = new ArrayList<>();
        students.add(new Student("Alice", 1, 20));
        students.add(new Student("Bob", 2, 21));
        students.add(new Student("Charlie", 3, 22));

        Iterator<Student> iterator = students.iterator();
        System.out.println("Student List:");
        while (iterator.hasNext()) 
        {
            Student s = iterator.next();
            System.out.println(s); 
        }
    }
}