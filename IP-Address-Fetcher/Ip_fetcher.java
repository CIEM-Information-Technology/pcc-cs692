import java.net.*;
/*
Abir Bhattacharya Sem6
*/
public class Ip_fetcher
{
    public static void main(String args[]) throws Exception
    {
        InetAddress obj=InetAddress.getLocalHost();
        System.out.println("Local Host Name "+obj.getHostName());
        System.out.println("Local Host IP "+obj.getHostAddress());
    }
}