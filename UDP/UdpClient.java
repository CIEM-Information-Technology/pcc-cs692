import java.io.*;
import java.net.*;
class UdpClient
{
    public static void main(String args[]) throws IOException
    {
        InetAddress ipaddress = InetAddress.getByName("localhost");
        byte[] senddata=new byte[1024];
        byte[] receivedata=new byte[1024];
        System.out.println("Enter a message :");
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String sentence = br.readLine();
        DatagramSocket ds = new DatagramSocket();
        senddata = sentence.getBytes();
        DatagramPacket dp = new DatagramPacket(senddata, senddata.length,ipaddress,8080);
        ds.send(dp);
        DatagramPacket dp1 = new DatagramPacket(receivedata,receivedata.length);
        ds.receive(dp1);
        String msg=new String(dp1.getData());
        System.out.println("Receive from Server : "+msg);
        ds.close();
    }
}