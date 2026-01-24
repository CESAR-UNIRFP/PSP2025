import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class ClienteAlarmaMH {
    public static void main(String[] args) {
        try (Socket s = new Socket("127.0.0.1", 5000);
             PrintWriter out = new PrintWriter(s.getOutputStream(), true);
             BufferedReader in = new BufferedReader(new InputStreamReader(s.getInputStream()));
             Scanner sc = new Scanner(System.in)) {

            System.out.print("Texto de alarma: ");
            out.println("ALARMA: " + sc.nextLine().trim());

            System.out.println(in.readLine());

        } catch (Exception e) {
            System.out.println("Error cliente: " + e.getMessage());
        }
    }
}
