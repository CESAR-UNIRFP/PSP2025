import java.net.Socket;
import java.net.InetSocketAddress;

public class ClienteBase {
    public static void main(String[] args) {
        try {
            String IPserver = "192.168.1.68";
            int puerto = 8080;

            InetSocketAddress direccionSocket = new InetSocketAddress(IPserver, puerto);
            System.out.println("Conectando a " + IPserver + ":" + puerto + "...");

            Socket socket = new Socket();
            socket.connect(direccionSocket, 3000); // opcional: timeout 3s

            System.out.println("Conectado al servidor.");
            socket.close();
            System.out.println("Conexión cerrada.");
        } catch (Exception e) {
            System.out.println("Error en el cliente: " + e.getMessage());
        }
    }
}
