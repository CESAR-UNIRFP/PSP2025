import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Cliente {

    private static final int PUERTO_SERVIDOR = 5000; // puerto real del servidor
    private static final int PUERTO_LOCAL_TUNEL = 6000; // puerto local cuando usamos SSH -L

    public static void main(String[] args) {
        boolean usarSsh = args.length > 0 && args[0].equalsIgnoreCase("--ssh");

        String host;
        int puerto;

        if (usarSsh) {
            // Cuando hay túnel SSH, el cliente SIEMPRE conecta a localhost:PUERTO_LOCAL_TUNEL
            host = "127.0.0.1";
            puerto = PUERTO_LOCAL_TUNEL;
            System.out.println("Modo SSH: conectando a " + host + ":" + puerto);
        } else {
            // Modo normal: conecta directo al servidor
            host = "127.0.0.1"; // cambia esto por la IP del servidor si están en distintas máquinas
            puerto = PUERTO_SERVIDOR;
            System.out.println("Modo normal: conectando a " + host + ":" + puerto);
        }

        try (Socket s = new Socket(host, puerto);
             PrintWriter out = new PrintWriter(s.getOutputStream(), true);
             BufferedReader in = new BufferedReader(new InputStreamReader(s.getInputStream()));
             Scanner sc = new Scanner(System.in)) {

            System.out.print("Texto de alarma: ");
            out.println("ALARMA: " + sc.nextLine().trim());

            System.out.println(in.readLine());

        } catch (Exception e) {
            System.out.println("Error cliente: " + e.getMessage());

            if (usarSsh) {
                System.out.println("\nTe falta el túnel SSH. Ejemplo:");
                System.out.println("ssh -L " + PUERTO_LOCAL_TUNEL + ":127.0.0.1:" + PUERTO_SERVIDOR + " usuario@IP_SERVIDOR");
                System.out.println("Luego ejecuta: java ClienteAlarmaMH --ssh");
            }
        }
    }
}
