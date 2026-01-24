import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class HiloAlarmaCesar implements Runnable {

    private final Socket socket;

    public HiloAlarmaCesar(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try (Socket s = socket;
             BufferedReader in = new BufferedReader(new InputStreamReader(s.getInputStream()));
             PrintWriter out = new PrintWriter(s.getOutputStream(), true)) {

            // 1) Llega cifrado desde el cliente
            String msgCifrado = in.readLine();

            // 2) Desciframos para procesar/mostrar
            String msgPlano = CifradoCesar.descifrar(msgCifrado);

            System.out.println("ALERTA (descifrada): " + msgPlano);
            System.out.println("ALERTA (cifrada):    " + msgCifrado);

            // 3) Respondemos cifrado también (para que el ejemplo sea completo)
            out.println(CifradoCesar.cifrar("alarma recibida"));

        } catch (Exception ignored) {}
    }
}
