import java.io.OutputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class servidor {
    public static void main(String[] args) {
        int puerto = 5000;

        try {
            // Crear dirección y socket del servidor
            InetAddress direccionLocal = InetAddress.getLocalHost();
            InetSocketAddress direccionSocket = new InetSocketAddress(direccionLocal, puerto);

            ServerSocket servidor = new ServerSocket();  //SOCKET NACE SIN ENLAZAR
            servidor.bind(direccionSocket);  // ENLAZAMOS

            System.out.println("Servidor esperando conexión en " + direccionSocket);

            // Esperar a que un cliente se conecte
            Socket socket = servidor.accept();
            System.out.println("Cliente conectado.");

            // Enviar un mensaje simple al cliente
            OutputStream salida = socket.getOutputStream();
            String mensaje = "Hola cliente, conexión establecida correctamente.";
            salida.write(mensaje.getBytes());
            System.out.println("Mensaje enviado al cliente.");

            // Cerrar conexiones
            socket.close();
            servidor.close();
            System.out.println("Servidor finalizado.");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

