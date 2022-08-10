import java.io.*;
import java.net.*;
class UdpServer
{
    public static void main(String args[])throws IOException 
    {
        byte[] senddata=new byte[1024];
        byte[] receivedata=new byte[1024];
        System.out.println("Waiting for Connection...");
        while(true)
        {
            DatagramSocket ds = new DatagramSocket(8080);
            DatagramPacket dp = new DatagramPacket(receivedata,receivedata.length);
            ds.receive(dp);
            String sentence = new String(dp.getData());
            System.out.println("Received from Client : "+sentence);
            InetAddress ipaddress = dp.getAddress();
            int port=dp.getPort();
            String caps = sentence.toUpperCase()+'\n';
            DatagramPacket dp1 = new DatagramPacket(caps.getBytes(),caps.getBytes().length,ipaddress,port);
            ds.send(dp1);
            ds.close();
        }
    }
}