import java.io.*;
import java.net.*;
public class TCPServer 
{
    public static void main(String args[]) 
    {
        try
        {
            System.out.println("Waiting for Message");
            ServerSocket ss=new ServerSocket(8082);
            while(true)
            {
                Socket s=ss.accept();
                BufferedReader br=new BufferedReader(new InputStreamReader(s.getInputStream()));
                String received=br.readLine();
                System.out.println("Received this Message=> "+received);
                String n="Received this Message '"+received+"'\n";
                DataOutputStream dos=new DataOutputStream(s.getOutputStream());
                dos.writeBytes(n);
                System.out.println("Message sent back");
                s.close();
            }
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
    }
}
