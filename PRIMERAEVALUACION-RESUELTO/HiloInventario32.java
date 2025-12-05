import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class HiloInventario32 implements Runnable {

    private final Socket socket;
    private final Inventario inv = new Inventario(); // inventario propio del cliente

    public HiloInventario32(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try (Socket s = socket;
             BufferedReader in = new BufferedReader(new InputStreamReader(s.getInputStream()));
             PrintWriter out = new PrintWriter(s.getOutputStream(), true)) {

            int op = Integer.parseInt(in.readLine().trim());
            out.println(respuesta(op));

        } catch (Exception ignored) {}
    }

    private String respuesta(int op) {
        switch (op) {
            case 1: return "Kilos de plátanos disponibles: " + inv.platanos;
            case 2: return "Kilos de caparazones disponibles: " + inv.caparazones;
            case 3: inv.platanos++; return "Se ha recogido 1 kg de plátanos. Te quedan " + inv.platanos + " kg.";
            case 4: inv.platanos--; return "Se ha usado 1 kg de plátanos. Te quedan " + inv.platanos + " kg.";
            case 5: inv.caparazones++; return "Se ha recogido 1 kg de caparazones. Te quedan " + inv.caparazones + " kg.";
            case 6: inv.caparazones--; return "Se ha usado 1 kg de caparazones. Te quedan " + inv.caparazones + " kg.";
            default: return "Opción inválida en el menú.";
        }
    }
}
