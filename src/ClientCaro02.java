import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class ClientCaro02 {
    public static void main(String args[]) throws IOException {
        Socket socketOfClient = new Socket("42.119.121.119",13049);
        BufferedReader is = null;
        BufferedWriter os = null;
        os = new BufferedWriter(new OutputStreamWriter(socketOfClient.getOutputStream())); //gui du lieu den server
        is = new BufferedReader(new InputStreamReader(socketOfClient.getInputStream())); // nhan du lieu tu server
        //ghi du lieu ve server
        int value = 1;
        while(value!=0) {
            int n;
            System.out.print("nhap mot so nguyen: ");
            Scanner sc = new Scanner(System.in);
            n = sc.nextInt();
            os.write(n);
            os.flush();
            System.out.println("day di");


            //doc du lieu tu server
            value = is.read();
            System.out.println(value);
            if (value == 0) break;

        }
        os.close();
        is.close();
        socketOfClient.close();

    }
}
