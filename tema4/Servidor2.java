import java.io.InputStream;
import java.io.OutputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class Servidor2 {

    public static void main(String[] args) {
        int puerto = 5000;

        try {
            // Crear la dirección IP y puerto con InetSocketAddress
            InetAddress direccionLocal = InetAddress.getLocalHost();
            InetSocketAddress socketDireccion = new InetSocketAddress(direccionLocal, puerto);

            // Crear el ServerSocket y asociarlo a esa dirección
            ServerSocket servidor = new ServerSocket();
            servidor.bind(socketDireccion);

            System.out.println("Servidor escuchando en: " + socketDireccion);

            // Esperar conexión de un cliente
            Socket socket = servidor.accept();
            System.out.println("Cliente conectado desde: " + socket.getInetAddress().getHostAddress());

            // Flujos de datos
            InputStream entrada = socket.getInputStream();
            OutputStream salida = socket.getOutputStream();

            // Leer mensaje enviado por el cliente (máx. 1024 bytes)
            byte[] buffer = new byte[1024];
            int bytesLeidos = entrada.read(buffer);
            String mensaje = new String(buffer, 0, bytesLeidos);
            System.out.println("Mensaje recibido: " + mensaje);

            // Enviar respuesta al cliente
            String respuesta = "El mensaje tiene " + mensaje.length() + " caracteres.";
            salida.write(respuesta.getBytes());

            // Cerrar todo
            socket.close();
            servidor.close();
            System.out.println("Servidor finalizado.");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
