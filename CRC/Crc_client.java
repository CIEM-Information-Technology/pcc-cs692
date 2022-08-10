import java.io.*;
import java.net.*;

public class Crc_client {
    public static String checksum(String str) {
        int a[] = new int[20];
        int n = str.length();
        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt("" + str.charAt(i));
        }

        for (int i = 0; i <= n - 4; i++) {
            if (a[i] == 1) {
                a[i] = (a[i] == 1) ? 0 : 1;
                a[i + 1] = (a[i + 1] == 1) ? 1 : 0;
                a[i + 2] = (a[i + 2] == 1) ? 0 : 1;
                a[i + 3] = (a[i + 3] == 1) ? 0 : 1;
            }
        }

        String r = "";
        for (int i = n - 3; i < n; i++) {
            r = r + ("" + a[i]);
        }
        return r;

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String msg = br.readLine();
        String crc = checksum(msg.concat("000"));
        System.out.println("CRC=> "+crc);
        String sendData = msg + crc;

        Socket s = new Socket("LocalHost", 8000);
        DataOutputStream ds = new DataOutputStream(s.getOutputStream());
        ds.writeBytes(sendData + "\n");
        BufferedReader br1 = new BufferedReader(new InputStreamReader(s.getInputStream()));
        String str2 = br1.readLine();
        System.out.println("Acknowledgement from Server=> " + str2);
        s.close();
    }
}