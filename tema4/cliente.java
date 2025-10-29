import java.io.InputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;

public class cliente {
    public static void main(String[] args) {
        int puerto = 5000;

        try {
            // Crear dirección del servidor
        	var IPserver= "192.168.1.68";
            InetSocketAddress direccionSocket = new InetSocketAddress(IPserver, puerto);

            // Crear socket y conectar al servidor
            Socket socket = new Socket();
            socket.connect(direccionSocket);
            System.out.println("Conectado al servidor en " + direccionSocket);

            // Recibir mensaje del servidor
            InputStream entrada = socket.getInputStream();
            byte[] buffer = new byte[1024];
            int bytesLeidos = entrada.read(buffer);
            String mensaje = new String(buffer, 0, bytesLeidos);

            System.out.println("Mensaje del servidor: " + mensaje);

            // Cerrar conexión
            socket.close();
            System.out.println("Cliente finalizado.");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
