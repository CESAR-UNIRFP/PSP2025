public class Triangulo
{
    public static void main(String[] args)
    {
        if (args.length == 0)
        {
            System.out.println("Se requiere un argumento");
            return;
        }
        int filas = Integer.parseInt(args[0]);
        for (int i=filas; i>=1; i--)
        {
            for (int n=1; n<=i; n++)
            {
                System.out.print(n);
            }
            System.out.println();
        }
    }
}


/*
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;

public class Triangulo {
    public static void main(String[] args) {
        if (args.length == 0) {
            System.out.println("Se requiere un argumento");
            return;
        }

        int filas = Integer.parseInt(args[0]);

        // Nombre del archivo de salida
        String fileName = "triangulo" + filas + ".txt";

        try (FileWriter writer = new FileWriter(fileName, true)) {
            // Escribir la fecha y hora de inicio
            LocalDateTime inicio = LocalDateTime.now();
            writer.write("Fecha de inicio del proceso: " + inicio + "\n");

            // Generar el triángulo
            for (int i = filas; i >= 1; i--) {
                for (int n = 1; n <= i; n++) {
                    writer.write(n + " ");
                }
                writer.write("\n");
            }

            // Escribir la fecha y hora de finalización
            LocalDateTime fin = LocalDateTime.now();
            writer.write("Fecha de finalización del proceso: " + fin + "\n");

            System.out.println("Triángulo de " + filas + " filas guardado en " + fileName);

        } catch (IOException e) {
            System.out.println("Error al escribir en el archivo: " + e.getMessage());
        }
    }
}
*/
