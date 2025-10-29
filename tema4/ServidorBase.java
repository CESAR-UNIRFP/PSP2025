import java.net.ServerSocket;
import java.net.Socket;
import java.net.InetSocketAddress;

public class ServidorBase {
    public static void main(String[] args) {
        
        int puerto = 8080;

        try (ServerSocket serverSocket = new ServerSocket()) {  //SOCKET NACE SIN ENLAZAR
            // Vincular el socket al IP/puerto concretos
            serverSocket.bind(new InetSocketAddress(puerto));
            System.out.println("Servidor escuchando en " + puerto + "...");

            // Esperar a que un cliente se conecte
            try (Socket clientSocket = serverSocket.accept()) {
                System.out.println("Cliente conectado desde " +
                        clientSocket.getInetAddress().getHostAddress() + ":" + clientSocket.getPort());
                // aquí podrías leer/escribir si quisieras
            }

            System.out.println("Conexión con el cliente cerrada.");
            System.out.println("Servidor cerrado.");
        } catch (Exception e) {
            System.out.println("Error en el servidor: " + e.getMessage());
        }
    }
}

