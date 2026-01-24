import java.net.ServerSocket;
import java.net.Socket;

public class ServidorAlarmaMH {
    public static void main(String[] args) {
        try (ServerSocket server = new ServerSocket(5000)) {
            System.out.println("Servidor alarma en 5000");

            while (true) {
                Socket s = server.accept();
                new Thread(new HiloAlarmaAfin(s)).start();
            }

        } catch (Exception e) {
            System.out.println("Error servidor: " + e.getMessage());
        }
    }
}
