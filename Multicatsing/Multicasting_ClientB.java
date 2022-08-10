import java.io.*;
import java.net.*;
public class Multicasting_ClientB
{
    public static void main(String args[]) throws Exception
    {
        InetAddress IP=InetAddress.getByName("226.0.0.3");
        byte receiveData[]=new byte[1024];
        MulticastSocket ms=new MulticastSocket(8080);
        ms.joinGroup(IP);
        while(true)
        {
            DatagramPacket dp=new DatagramPacket(receiveData,receiveData.length);
            ms.receive(dp);
            String msg=new String(dp.getData());
            System.out.println("Client 2 receives this message => "+msg);
        }
    }
}
