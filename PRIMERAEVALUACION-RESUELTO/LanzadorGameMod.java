import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;

public class LanzadorGameMod {
    public static void main(String[] args) {
        try {
            String opcion = Files.readString(Path.of("entrada.txt")).trim();
            String cp = System.getProperty("java.class.path");

            Process p = new ProcessBuilder("java", "-cp", cp, "GameLauncher", opcion)
                    .redirectOutput(new File("salida.txt"))
                    .redirectError(new File("error.txt"))
                    .start();

            p.waitFor();
        } catch (Exception e) {
            // Si falla el propio lanzador, no hay obligación de redirigir esto
            System.out.println("Error al lanzar el proceso: " + e.getMessage());
        }
    }
}
