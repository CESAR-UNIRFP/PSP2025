import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class ClienteKart {
    public static void main(String[] args) {
        try (Socket s = new Socket("127.0.0.1", 666);
             PrintWriter out = new PrintWriter(s.getOutputStream(), true);
             BufferedReader in = new BufferedReader(new InputStreamReader(s.getInputStream()));
             Scanner sc = new Scanner(System.in)) {

            System.out.println("MENÚ MARIO KART");
            System.out.println("1) Ver kilos de plátanos");
            System.out.println("2) Ver kilos de caparazones");
            System.out.println("3) Recoger 1 kg de plátanos");
            System.out.println("4) Usar 1 kg de plátanos");
            System.out.println("5) Recoger 1 kg de caparazones");
            System.out.println("6) Usar 1 kg de caparazones");
            System.out.print("Opción: ");

            String op = sc.nextLine().trim();
            out.println(op);

            System.out.println(in.readLine());

        } catch (Exception e) {
            System.out.println("Error en el cliente: " + e.getMessage());
        }
    }
}
