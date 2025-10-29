import java.io.InputStream;
import java.io.OutputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;

public class Cliente2 {

    public static void main(String[] args) {
        int puerto = 5000;

        try {
            // Crear dirección del servidor usando InetSocketAddress
        	var IPserver= "192.168.1.68";
            InetSocketAddress direccionSocket = new InetSocketAddress(IPserver, puerto);

            // Crear el socket y conectarlo al servidor
            Socket socket = new Socket();
            socket.connect(direccionSocket);
            System.out.println("Conectado al servidor en: " + direccionSocket);
            
            // Flujos de datos
            OutputStream salida = socket.getOutputStream();
            InputStream entrada = socket.getInputStream();

            // Enviar un mensaje simple
            String mensaje = "Hola Servidor desde el Cliente";
            salida.write(mensaje.getBytes());
            System.out.println("Enviado: " + mensaje);

            // Recibir respuesta del servidor
            byte[] buffer = new byte[1024];
            int bytesLeidos = entrada.read(buffer);
            String respuesta = new String(buffer, 0, bytesLeidos);
            System.out.println("Servidor responde: " + respuesta);

            // Cerrar conexión
            socket.close();
            System.out.println("Cliente finalizado.");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
