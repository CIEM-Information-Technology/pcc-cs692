import java.io.*;
import java.net.*;

public class Crc_server {
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
        System.out.println("Waiting for connection\n ");
        ServerSocket ss = new ServerSocket(8000);

        while (true) {
            Socket s = ss.accept();
            BufferedReader br = new BufferedReader(new InputStreamReader(s.getInputStream()));
            String Clientsent = br.readLine();
            System.out.println("Message from Client=> "+Clientsent);
            String str3 = "";
            if (checksum(Clientsent).equalsIgnoreCase("000"))
                str3 = "No Error";
            else
                str3 = "Error";
            System.out.println("CRC=> "+checksum(Clientsent));
            DataOutputStream ds = new DataOutputStream(s.getOutputStream());
            ds.writeBytes(str3 + "\n");
            s.close();

        }

    }

}