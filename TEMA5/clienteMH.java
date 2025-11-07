import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;

public class clienteMH {
    public static void main(String[] args) {
        String host = "192.168.0.124";  // la IP de tu servidor
        int puerto = 2000;              // el puerto de tu servidor

        try (Socket socket = new Socket(host, puerto);
             InputStream entrada = socket.getInputStream();
             OutputStream salida = socket.getOutputStream();
             Scanner teclado = new Scanner(System.in)) {

            while (true) {
                System.out.print("Mensaje (FIN para salir): ");
                String texto = teclado.nextLine();

                // el servidor lee siempre 100 bytes, así que enviamos 100
                byte[] aEnviar = new byte[100];
                byte[] datos = texto.getBytes();
                System.arraycopy(datos, 0, aEnviar, 0, Math.min(datos.length, 100));
                salida.write(aEnviar);

                // leemos la respuesta del servidor
                byte[] buffer = new byte[200];
                int leidos = entrada.read(buffer);
                String respuesta = new String(buffer, 0, leidos);
                System.out.println("Servidor: " + respuesta);

                if (texto.trim().equals("FIN")) {
                    break;
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
