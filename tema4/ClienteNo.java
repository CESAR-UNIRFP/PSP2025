import java.net.InetSocketAddress;
import java.net.Socket;
public class ClienteNo
{
    public static void main(String[] args)
    {
    	
        String IPserver = "192.168.1.68"; // o "127.0.0.1"
        int puerto = 1234;

        try (Socket socket = new Socket()) {
            InetSocketAddress direccionSocket = new InetSocketAddress(IPserver, puerto);
            socket.connect(direccionSocket, 3000); // timeout opcional de 3s
            System.out.println("Conectado al servidor en 127.0.0.1:8080");
            // Cerrar el socket
            socket.close();
            System.out.println("Conexión cerrada.");
        } catch (Exception e)
        {
            System.out.println("No se pudo conectar al servidor: " + e.getMessage());
        }
    }
}

