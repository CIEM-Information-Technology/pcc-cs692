import java.io.*;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;

import javax.xml.namespace.QName;

public class MultithreadingClientTwo 
{
    public static void main(String args[]) throws Exception
    {
        try
        {
            Socket s=new Socket("localhost",4000);
            BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
            DataOutputStream out=new DataOutputStream(s.getOutputStream());
            DataInputStream in=new DataInputStream(s.getInputStream());
            String message=" ";
            String severmessage=" ";

            while(!message.equals("bye"))
            {
                System.out.println("Enter a Number: ");
                message=br.readLine();
                out.writeUTF(message);
                out.flush();
                severmessage=in.readUTF();
                System.out.println(severmessage);
            }
            s.close();
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
    }
}
