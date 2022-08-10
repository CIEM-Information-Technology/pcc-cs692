import java.util.*;
class Soln
{
    void func()
    {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the IP Address");
        String s=sc.nextLine();

        int x=Integer.parseInt(s.substring(0,s.indexOf('.')));
        if(x>=0 && x<=127)
        {
            System.out.println("Class A");
        }
        else if(x>=128 && x<=191)
        {
            System.out.println("Class B");
        }
        else if(x>=192 && x<=223)
        {
            System.out.println("Class C");
        }
        else if(x>=224 && x<=239)
        {
            System.out.println("Class D");
        }
        else
        {
            System.out.println("Class E");
        }
    }
}
public class Ip_class_det
{
    public static void main(String args[])
    {
        Soln obj=new Soln();
        obj.func();
    }
}