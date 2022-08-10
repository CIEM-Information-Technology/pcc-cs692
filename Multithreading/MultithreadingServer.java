import java.io.*;
import java.net.*;
public class MultithreadingServer 
{
    public static void main(String args[]) throws Exception
    {
        try
        {
            ServerSocket ss=new ServerSocket(4000);
            int counter=0;
            while(true)
            {
                counter++;
                Socket s=ss.accept();
                System.out.println("Client "+counter+" :Connected");
                ServerClientThread sct=new ServerClientThread(s,counter);
                sct.start();
            }
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
    }
}
