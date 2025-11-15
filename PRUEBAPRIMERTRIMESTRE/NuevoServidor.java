import java.net.ServerSocket;
import java.net.Socket;

public class NuevoServidor {
    public static void main(String[] args) {
        final int PUERTO = 6665;

        try {
            ServerSocket serverSocket = new ServerSocket(PUERTO);
            System.out.println("Servidor escuchando en el puerto " + PUERTO);

            // Bucle infinito: atiende muchos clientes, cada uno en un hilo
            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("Cliente conectado.");

                // Crear un manejador y lanzarlo en un hilo
                ManejadorCliente manejador = new ManejadorCliente(socket);
                Thread hilo = new Thread(manejador);
                hilo.start();
            }

        } catch (Exception e) {
            System.out.println("Error en el servidor: " + e.getMessage());
        }
    }
}
