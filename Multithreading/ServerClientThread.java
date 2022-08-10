import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.*;
public class ServerClientThread extends Thread
{
    Socket s;
    int clientNo;
    int squarevalue;
    ServerClientThread(Socket src, int counter)
    {
        s=src;
        clientNo=counter;
    }
    public void run()
    {
        try
        {
            DataOutputStream out=new DataOutputStream(s.getOutputStream());
            DataInputStream in =new DataInputStream(s.getInputStream());
            String clientMessage=" ";
            String serverMessage=" ";
            while(!clientMessage.equals("bye"))
            {
                clientMessage=in.readUTF();
                System.out.println("From Client "+clientNo+", the square of "+clientMessage+" is "+squarevalue);
                out.writeUTF(serverMessage);
                out.flush();
            }
            s.close();
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
        finally
        {
            System.out.println("client "+clientNo+" : Exit");
        }
    }
}
