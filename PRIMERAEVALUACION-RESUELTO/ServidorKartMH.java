import java.net.ServerSocket;
import java.net.Socket;

public class ServidorKartMH {

    static int kilosPlatanos = 300;
    static int kilosCaparazones = 150;

    public static void main(String[] args) {
        try (ServerSocket server = new ServerSocket(666)) {
            while (true) {
                Socket s = server.accept();
                new Thread(new HiloCliente(s)).start();
            }
        } catch (Exception e) {
            System.out.println("Error en el servidor: " + e.getMessage());
        }
    }
}
