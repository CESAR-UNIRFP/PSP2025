import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class ClienteAlarmaMHCesar {
    public static void main(String[] args) {
        try (Socket s = new Socket("127.0.0.1", 5000);
             PrintWriter out = new PrintWriter(s.getOutputStream(), true);
             BufferedReader in = new BufferedReader(new InputStreamReader(s.getInputStream()));
             Scanner sc = new Scanner(System.in)) {

            System.out.print("Texto de alarma: ");
            String texto = sc.nextLine().trim();

            // 1) Ciframos lo que va por la red
            String mensajePlano = "ALARMA: " + texto;
            String mensajeCifrado = CifradoCesar.cifrar(mensajePlano);

            out.println(mensajeCifrado);

            // 2) Leemos respuesta (cifrada) y la desciframos
            String respCifrada = in.readLine();
            String respPlana = CifradoCesar.descifrar(respCifrada);

            System.out.println("Servidor dice: " + respPlana);

        } catch (Exception e) {
            System.out.println("Error cliente: " + e.getMessage());
        }
    }
}
