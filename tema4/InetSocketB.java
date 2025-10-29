import java.net.ServerSocket;
import java.net.Socket;

public class InetSocketB {
    public static void main(String[] args) {
        try {
            // Crear un servidor que escuche en el puerto 5000
            ServerSocket servidor = new ServerSocket(5000);   //SOCKET NACE Y ENLAZA
            System.out.println("Servidor esperando conexión en el puerto 5000...");

            // Esperar a que un cliente se conecte
            Socket socket = servidor.accept();
            System.out.println("Cliente conectado desde: " + socket.getInetAddress());

            // Cerrar conexión
            socket.close();
            servidor.close();
            System.out.println("Conexión cerrada. Servidor finalizado.");
        } catch (Exception e) {
            System.out.println("Error en el servidor: " + e.getMessage());
        }
    }
}
