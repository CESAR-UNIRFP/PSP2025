import java.net.Socket;
import java.net.InetSocketAddress;

public class InetSocketA {
    public static void main(String[] args) {
        try {
            // Crear la dirección IP y puerto
            InetSocketAddress direccion = new InetSocketAddress("192.168.1.68", 5000);

            // Crear el socket sin conectar
            Socket socket = new Socket();

            // Conectar el socket a la dirección especificada
            socket.connect(direccion);

            System.out.println("Socket conectado a " +
                               direccion.getAddress().getHostAddress() +
                               " en el puerto " + direccion.getPort());

            // Cerrar el socket
            socket.close();
            System.out.println("Socket cerrado.");

        } catch (Exception e) {
            System.out.println("Error al crear o conectar el socket: " + e.getMessage());
        }
    }
}