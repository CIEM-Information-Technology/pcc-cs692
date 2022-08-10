import java.io.*;
import java.net.*;
public class TCPClient
{
    public static void main(String args[])
    {
        try
        {
            BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
            System.out.println("Enter the Message\n");
            String sentence=br.readLine();
            Socket s=new Socket("LocalHost",8082);
            DataOutputStream dos=new DataOutputStream(s.getOutputStream());
            dos.writeBytes(sentence+"\n");
            System.out.println("Sending this Message=> "+sentence);
            BufferedReader br1=new BufferedReader(new InputStreamReader(s.getInputStream()));
            String received=br1.readLine();
            System.out.println("Received Message=> "+received);
            s.close();
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
    }
}