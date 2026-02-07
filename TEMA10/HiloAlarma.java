import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class HiloAlarma implements Runnable {

    private final Socket socket;

    public HiloAlarma(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try (Socket s = socket;
             BufferedReader in = new BufferedReader(new InputStreamReader(s.getInputStream()));
             PrintWriter out = new PrintWriter(s.getOutputStream(), true)) {

            String msg = in.readLine();
            System.out.println("ALERTA: " + msg);

            out.println("alarma recibida");

        } catch (Exception ignored) {}
    }
}