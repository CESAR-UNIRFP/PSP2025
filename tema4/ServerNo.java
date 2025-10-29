import java.net.InetSocketAddress;
import java.net.Socket; 
public class ServerNo
{
	public static void main(String[] args) 
	{
		
        String IPserver = "192.168.1.68"; // o "127.0.0.1"
        int puerto = 1234;

        try (Socket socket = new Socket()) {
            InetSocketAddress direccionSocket = new InetSocketAddress(IPserver, puerto);
            socket.connect(direccionSocket, 3000); // timeout opcional de 3s		
	        System.out.println("Socket creado y conectado a 127.0.0.1 en el puerto 8080"); 
	       // Cerrar el socket 
                   socket.close(); 
                   System.out.println("Socket cerrado."); 
                    } 
         catch (Exception e) 
                   {
	     System.out.println("Error al crear o conectar el socket: " + e.getMessage()); 
                    }
         }
 }
