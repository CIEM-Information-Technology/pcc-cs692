import java.util.*;
class Soln
{
    void main_func(String ip)
    {
        int first_oct=Integer.parseInt(ip.substring(0,ip.indexOf('.')));
        if(first_oct>=0 && first_oct<=127)
        {
            String net=first_oct+".0.0.0";
            String bdc=first_oct+".255.255.255";
            System.out.println("Net Id "+net);
            System.out.println("Broadcast Id "+bdc);
        }
        else if(first_oct>=128 && first_oct<=191)
        {
            int c=0;
            int i;
            for(i=0;i<ip.length();i++)
            {
                if(ip.charAt(i)=='.')
                {
                    c++;
                }
                if(c==2)
                {
                    break;
                }
            }
            String octs=ip.substring(0,i)+".0.0";
            String bdc=ip.substring(0,i)+".255.255";
            System.out.println("Net Id "+octs);
            System.out.println("Broadcast Id "+bdc);
        }
        else if(first_oct>=192 && first_oct<=223)
        {
            int ind=ip.lastIndexOf('.');
            String oct=ip.substring(0,ind)+".0";
            String bdc=ip.substring(0,ind)+".255";
            System.out.println("Net Id "+oct);
            System.out.println("Broadcast Id "+bdc);
        }
    }
}
public class NetId_determiner
{
    public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);
        String ip=sc.nextLine();

        Soln obj=new Soln();
        obj.main_func(ip);
    }
}