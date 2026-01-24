import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class ClienteAlarmaAfin {

    public static void main(String[] args) {
        try (Socket s = new Socket("127.0.0.1", 5000);
             PrintWriter out = new PrintWriter(s.getOutputStream(), true);
             BufferedReader in = new BufferedReader(new InputStreamReader(s.getInputStream()));
             Scanner sc = new Scanner(System.in)) {

            System.out.print("Texto de alarma: ");
            String texto = sc.nextLine();

            String mensajePlano = "ALARMA: " + texto;
            String mensajeCifrado = CifradoAfin.cifrar(mensajePlano);

            System.out.println("Enviado (cifrado): " + mensajeCifrado);
            out.println(mensajeCifrado);

            String respCifrada = in.readLine();
            String respPlana = CifradoAfin.descifrar(respCifrada);

            System.out.println("Servidor responde: " + respPlana);

        } catch (Exception e) {
            System.out.println("Error cliente: " + e.getMessage());
        }
    }
}
