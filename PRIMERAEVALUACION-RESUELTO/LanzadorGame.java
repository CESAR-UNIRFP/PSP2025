import java.nio.file.Files;
import java.nio.file.Path;

public class LanzadorGame {
    public static void main(String[] args) {
        try {
            String opcion = Files.readString(Path.of("entrada.txt")).trim();
            String cp = System.getProperty("java.class.path");

            Process p = new ProcessBuilder("java", "-cp", cp, "GameLauncher", opcion)
                    .inheritIO()
                    .start();

            p.waitFor();
            System.out.println("El proceso se ha ejecutado correctamente.");
        } catch (Exception e) {
            System.out.println("Error al lanzar el proceso: " + e.getMessage());
        }
    }
}
