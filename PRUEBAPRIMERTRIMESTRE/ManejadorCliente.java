import java.net.Socket;
import java.io.InputStream;
import java.io.OutputStream;

public class ManejadorCliente implements Runnable {

    private Socket socket;

    // Datos del almacén (iguales para todos los clientes)
    private static final int KILOS_NARANJAS = 1250;
    private static final int KILOS_MANZANAS = 890;

    public ManejadorCliente(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            InputStream inputStream = socket.getInputStream();
            OutputStream outputStream = socket.getOutputStream();

            // Leer la opción enviada por el cliente
            byte[] buffer = new byte[1024];
            int bytesRead = inputStream.read(buffer);

            if (bytesRead != -1) {
                String mensajeCliente = new String(buffer, 0, bytesRead).trim();
                System.out.println("Mensaje del cliente: " + mensajeCliente);

                String respuesta;

                if ("1".equals(mensajeCliente)) {
                    respuesta = "Kilos de naranjas disponibles: " + KILOS_NARANJAS;
                } else if ("2".equals(mensajeCliente)) {
                    respuesta = "Kilos de manzanas disponibles: " + KILOS_MANZANAS;
                } else {
                    respuesta = "No se encuentra disponible esa opción en el menú.";
                }

                // Enviar respuesta al cliente
                outputStream.write(respuesta.getBytes());
                outputStream.flush();
            }

            // Cerrar conexión con este cliente
            socket.close();
            System.out.println("Conexión con el cliente cerrada.");

        } catch (Exception e) {
            System.out.println("Error al atender a un cliente: " + e.getMessage());
        }
    }
}
