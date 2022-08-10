import java.io.*;
import java.net.*;
public class Multicasting_Server 
{
    public static void main(String args[]) throws Exception
    {
        InetAddress IP=InetAddress.getByName("226.0.0.3");
        DatagramSocket ds=new DatagramSocket();
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

        System.out.println("Enter");
        String sentence=br.readLine();
        DatagramPacket dp=new DatagramPacket(sentence.getBytes(),sentence.getBytes().length,IP,8080);
        ds.send(dp);
    }
}
