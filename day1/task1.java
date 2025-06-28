package day1;
public class task1 
{
    public static void main(String[] args)
    {
        int i;
        System.out.println("Even Numbers");
        for(i = 1; i <= 100; i++) 
        {
            if(i % 2 == 0)
            {
                System.out.println(i);
            }
        }
        System.out.println("Final value of i : " + i);
    }
}
