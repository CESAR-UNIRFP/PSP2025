import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class ServidorKart {

    private static int kilosPlatanos = 300;
    private static int kilosCaparazones = 150;

    public static void main(String[] args) {
        try (ServerSocket server = new ServerSocket(666)) {
            while (true) {
                try (Socket s = server.accept();
                     BufferedReader in = new BufferedReader(new InputStreamReader(s.getInputStream()));
                     PrintWriter out = new PrintWriter(s.getOutputStream(), true)) {

                    int op = Integer.parseInt(in.readLine().trim());
                    out.println(respuesta(op));
                } catch (Exception e) {
                    // Si llega algo raro, cerramos esa conexión sin complicarnos
                }
            }
        } catch (Exception e) {
            System.out.println("Error en el servidor: " + e.getMessage());
        }
    }

    private static String respuesta(int op) {
        switch (op) {
            case 1:
                return "Kilos de plátanos disponibles: " + kilosPlatanos;
            case 2:
                return "Kilos de caparazones disponibles: " + kilosCaparazones;
            case 3:
                kilosPlatanos++;
                return "Se ha recogido 1 kg de plátanos. Te quedan " + kilosPlatanos + " kg.";
            case 4:
                kilosPlatanos--;
                return "Se ha usado 1 kg de plátanos. Te quedan " + kilosPlatanos + " kg.";
            case 5:
                kilosCaparazones++;
                return "Se ha recogido 1 kg de caparazones. Te quedan " + kilosCaparazones + " kg.";
            case 6:
                kilosCaparazones--;
                return "Se ha usado 1 kg de caparazones. Te quedan " + kilosCaparazones + " kg.";
            default:
                return "Opción inválida en el menú.";
        }
    }
}
