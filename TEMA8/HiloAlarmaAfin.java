import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class HiloAlarmaAfin implements Runnable {

    private final Socket socket;

    public HiloAlarmaAfin(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try (Socket s = socket;
             BufferedReader in = new BufferedReader(new InputStreamReader(s.getInputStream()));
             PrintWriter out = new PrintWriter(s.getOutputStream(), true)) {

            String msgCifrado = in.readLine();
            String msgPlano = CifradoAfin.descifrar(msgCifrado);

            System.out.println("ALERTA (cifrada):    " + msgCifrado);
            System.out.println("ALERTA (descifrada): " + msgPlano);

            out.println(CifradoAfin.cifrar("alarma recibida"));

        } catch (Exception e) {
            System.out.println("Error hilo: " + e.getMessage());
        }
    }
}
