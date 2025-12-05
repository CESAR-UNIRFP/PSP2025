import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class ClienteAlarma {

    public static void main(String[] args) {
        final String HOST = "127.0.0.1";
        final int PUERTO = 5000;

        try (Socket s = new Socket(HOST, PUERTO);
             PrintWriter out = new PrintWriter(s.getOutputStream(), true);
             BufferedReader in = new BufferedReader(new InputStreamReader(s.getInputStream()));
             Scanner sc = new Scanner(System.in)) {

            System.out.print("Introduce texto de alarma: ");
            String texto = sc.nextLine().trim();

            out.println("ALARMA: " + texto);

            System.out.println("Respuesta del servidor: " + in.readLine());

        } catch (Exception e) {
            System.out.println("Error cliente: " + e.getMessage());
        }
    }
}
