import java.net.ServerSocket;
import java.net.Socket;
import java.net.InetSocketAddress;
import java.io.InputStream;
import java.io.OutputStream;

public class Servidor {
    public static void main(String[] args) {
        final int PUERTO = 6665;
        final int KILOS_NARANJAS = 1250;
        final int KILOS_MANZANAS = 890;

        // Dirección donde se va a quedar escuchando el servidor
        InetSocketAddress direccion = new InetSocketAddress(PUERTO);

        try (ServerSocket serverSocket = new ServerSocket()) {
            // Asociamos el ServerSocket a esa dirección/puerto
            serverSocket.bind(direccion);
            System.out.println("Servidor escuchando en el puerto " + PUERTO + "...");

            // Esperar a que un cliente se conecte
            try (Socket clientSocket = serverSocket.accept()) {
                System.out.println("Cliente conectado.");

                // Recibir mensaje del cliente
                InputStream inputStream = clientSocket.getInputStream();
                byte[] buffer = new byte[1024];
                int bytesRead = inputStream.read(buffer);

                if (bytesRead == -1) {
                    System.out.println("No se ha recibido ningún dato del cliente.");
                    return; // termina el main
                }

                String mensajeCliente = new String(buffer, 0, bytesRead).trim();
                System.out.println("Mensaje recibido del cliente: " + mensajeCliente);

                // Preparar respuesta
                String mensajeServidor;

                if ("1".equals(mensajeCliente)) {
                    mensajeServidor = "Kilos de naranjas disponibles: " + KILOS_NARANJAS;
                } else if ("2".equals(mensajeCliente)) {
                    mensajeServidor = "Kilos de manzanas disponibles: " + KILOS_MANZANAS;
                } else {
                    mensajeServidor = "No se encuentra disponible esa opción en el menú.";
                }

                // Enviar respuesta al cliente
                OutputStream outputStream = clientSocket.getOutputStream();
                outputStream.write(mensajeServidor.getBytes());
                outputStream.flush();

                System.out.println("Mensaje enviado al cliente: " + mensajeServidor);
                System.out.println("Conexión con el cliente cerrada.");
            }

            System.out.println("Servidor cerrado (fin del programa).");
        } catch (Exception e) {
            System.out.println("Error en el servidor: " + e.getMessage());
        }
    }
}

