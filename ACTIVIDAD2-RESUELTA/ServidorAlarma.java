import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class ServidorAlarma {

    public static void main(String[] args) {
        final int PUERTO = 5000;

        try (ServerSocket server = new ServerSocket(PUERTO)) {
            System.out.println("Servidor de alarma escuchando en puerto " + PUERTO);

            while (true) {
                Socket cliente = server.accept();

                new Thread(() -> atender(cliente)).start();
            }

        } catch (Exception e) {
            System.out.println("Error servidor: " + e.getMessage());
        }
    }

    private static void atender(Socket socket) {
        try (Socket s = socket;
             BufferedReader in = new BufferedReader(new InputStreamReader(s.getInputStream()));
             PrintWriter out = new PrintWriter(s.getOutputStream(), true)) {

            String mensaje = in.readLine(); // un mensaje simple por conexión
            System.out.println("ALERTA RECIBIDA: " + mensaje);

            out.println("alarma recibida");

        } catch (Exception ignored) {
        }
    }
}
