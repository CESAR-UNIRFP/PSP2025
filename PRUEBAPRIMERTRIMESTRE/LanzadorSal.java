import java.io.File;
import java.io.IOException;

public class LanzadorSal {
    public static void main(String[] args) {
        // Obtiene el classpath automáticamente
        String classpath = System.getProperty("java.class.path");

        // Si HolaMundo está en un paquete, usa el nombre completo: "mipaquete.HolaMundo"
        ProcessBuilder proceso =
                new ProcessBuilder("java", "-cp", classpath, "HolaMan", "5");

        // Guardar salida estándar y errores
        proceso.redirectOutput(new File("salida.txt"));
        proceso.redirectError(new File("error.txt"));

        try {
            proceso.start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
