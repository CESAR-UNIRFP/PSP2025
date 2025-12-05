import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class HiloCliente implements Runnable {

    private final Socket socket;

    public HiloCliente(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try (Socket s = socket;
             BufferedReader in = new BufferedReader(new InputStreamReader(s.getInputStream()));
             PrintWriter out = new PrintWriter(s.getOutputStream(), true)) {

            int op = Integer.parseInt(in.readLine().trim());
            out.println(respuesta(op));

        } catch (Exception e) {
            // Simplificado al máximo
        }
    }

    private String respuesta(int op) {
        switch (op) {
            case 1:
                return "Kilos de plátanos disponibles: " + ServidorKartMH.kilosPlatanos;
            case 2:
                return "Kilos de caparazones disponibles: " + ServidorKartMH.kilosCaparazones;
            case 3:
                ServidorKartMH.kilosPlatanos++;
                return "Se ha recogido 1 kg de plátanos. Te quedan " + ServidorKartMH.kilosPlatanos + " kg.";
            case 4:
                ServidorKartMH.kilosPlatanos--;
                return "Se ha usado 1 kg de plátanos. Te quedan " + ServidorKartMH.kilosPlatanos + " kg.";
            case 5:
                ServidorKartMH.kilosCaparazones++;
                return "Se ha recogido 1 kg de caparazones. Te quedan " + ServidorKartMH.kilosCaparazones + " kg.";
            case 6:
                ServidorKartMH.kilosCaparazones--;
                return "Se ha usado 1 kg de caparazones. Te quedan " + ServidorKartMH.kilosCaparazones + " kg.";
            default:
                return "Opción inválida en el menú.";
        }
    }
}
