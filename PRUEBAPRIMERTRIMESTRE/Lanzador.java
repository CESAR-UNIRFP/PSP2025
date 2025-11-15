import java.io.IOException;

public class Lanzador {
    public static void main(String[] args) {
        // Obtiene el classpath automáticamente
        String classpath = System.getProperty("java.class.path");

        // OJO: si HolaMundo tiene package, pon "mi.paquete.HolaMundo"
        ProcessBuilder proceso =
                new ProcessBuilder("java", "-cp", classpath, "HolaMan", "5");

        // Muy importante: que use la misma consola que el programa actual
        proceso.inheritIO();

        try {
            // Lanza el proceso
            Process p = proceso.start();
            // Esperar a que termine (opcional, pero suele ser buena idea)
            p.waitFor();
            System.out.println("Proceso lanzado con éxito");
        } catch (IOException | InterruptedException e) {
            System.out.println("Error al lanzar el proceso: " + e.getMessage());
        }
    }
}

