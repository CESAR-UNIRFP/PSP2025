import java.io.IOException;

public class LanzadorTriangulos {
    public static void main(String[] args) {
        // Definir los tres números de filas para los triángulos
        int[] filas = {5, 7, 9};

        // Lanzar tres procesos simultáneamente
        for (int numero : filas) {
            try {
                String classpath = System.getProperty("java.class.path");
            	ProcessBuilder pb = new ProcessBuilder("java", "-cp", classpath, "Triangulo", String.valueOf(numero));

            	//ProcessBuilder pb = new ProcessBuilder("java", "Triangulo", String.valueOf(numero));
                
                pb.redirectOutput(new java.io.File("triangulo" + numero + ".txt")); // Redirigir la salida a un archivo
                pb.redirectErrorStream(true); // Redirigir cualquier error también al archivo
                pb.start();
                // Iniciar el proceso

                System.out.println("Iniciado el proceso para el triángulo de " + numero + " filas.");

            } catch (IOException e) {
                System.out.println("Error al iniciar el proceso para el triángulo de " + numero + ": " + e.getMessage());
            }
        }
    }
}

/*
import java.io.IOException;
import java.time.LocalDateTime;

public class LanzadorTriangulos {
    public static void main(String[] args) {
        // Definir los tres números de filas para los triángulos
        int[] filas = {5, 7, 9};

        // Obtener el classpath actual para que los procesos puedan encontrar la clase Triangulo
        String classpath = System.getProperty("java.class.path");

        // Lanzar tres procesos simultáneamente
        for (int numero : filas) {
            try {
                // Crear el proceso usando ProcessBuilder, especificando el classpath
                ProcessBuilder pb = new ProcessBuilder("java", "-cp", classpath, "Triangulo", String.valueOf(numero));

                // Redirigir la salida del proceso a un archivo de texto
                pb.redirectOutput(new java.io.File("triangulo" + numero + ".txt"));
                pb.redirectErrorStream(true);

                // Registrar la fecha y hora de inicio
                System.out.println("Fecha de inicio del proceso para " + numero + " filas: " + LocalDateTime.now());

                // Iniciar el proceso
                Process p = pb.start();
                p.waitFor(); // Esperar a que el proceso termine

                // Registrar la fecha y hora de finalización
                System.out.println("Fecha de finalización del proceso para " + numero + " filas: " + LocalDateTime.now());

                System.out.println("Proceso para el triángulo de " + numero + " filas terminado.");

            } catch (IOException | InterruptedException e) {
                System.out.println("Error al iniciar o gestionar el proceso para el triángulo de " + numero + ": " + e.getMessage());
            }
        }
    }
}
 */

/*
        // Obtener el classpath actual para que los procesos puedan encontrar la clase Triangulo
        String classpath = System.getProperty("java.class.path");


                // Crear el proceso usando ProcessBuilder, especificando el classpath
                ProcessBuilder pb = new ProcessBuilder("java", "-cp", classpath, "Triangulo", String.valueOf(numero));

*/

/*
import java.io.IOException;

public class LanzadorTriangulos {
    public static void main(String[] args) {
        // Definir los tres números de filas para los triángulos
        int[] filas = {5, 7, 9};

        // Obtener el classpath actual para que los procesos puedan encontrar la clase Triangulo
        String classpath = System.getProperty("java.class.path");

        // Lanzar tres procesos simultáneamente
        for (int numero : filas) {
            try {
                // Crear el proceso usando ProcessBuilder, especificando el classpath
                ProcessBuilder pb = new ProcessBuilder("java", "-cp", classpath, "Triangulo", String.valueOf(numero));

                // Iniciar el proceso
                Process p = pb.start();
                p.waitFor(); // Esperar a que el proceso termine

                System.out.println("Proceso para el triángulo de " + numero + " filas terminado.");

            } catch (IOException | InterruptedException e) {
                System.out.println("Error al iniciar o gestionar el proceso para el triángulo de " + numero + ": " + e.getMessage());
            }
        }
    }
}


 */

/*
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;

public class LanzadorTriangulos {
    public static void main(String[] args) {
        // Definir los tres números de filas para los triángulos
        int[] filas = {5, 7, 9};

        // Obtener el classpath actual para que los procesos puedan encontrar la clase Triangulo
        String classpath = System.getProperty("java.class.path");

        // Lanzar tres procesos simultáneamente
        for (int numero : filas) {
            String fileName = "triangulo" + numero + ".txt";

            try (FileWriter writer = new FileWriter(fileName, true)) {
                // Escribir la fecha y hora de inicio en el archivo
                LocalDateTime inicio = LocalDateTime.now();
                writer.write("Fecha de inicio del proceso: " + inicio + "\n");

                // Crear el proceso usando ProcessBuilder, especificando el classpath
                ProcessBuilder pb = new ProcessBuilder("java", "-cp", classpath, "Triangulo", String.valueOf(numero));
                pb.redirectOutput(new java.io.File(fileName)); // Redirigir la salida a un archivo
                pb.redirectErrorStream(true); // Redirigir cualquier error también al archivo

                // Iniciar el proceso
                Process p = pb.start();
                p.waitFor(); // Esperar a que el proceso termine

                // Escribir la fecha y hora de finalización en el archivo
                LocalDateTime fin = LocalDateTime.now();
                writer.write("Fecha de finalización del proceso: " + fin + "\n");

                System.out.println("Proceso para el triángulo de " + numero + " filas terminado.");

            } catch (IOException | InterruptedException e) {
                System.out.println("Error al iniciar o gestionar el proceso para el triángulo de " + numero + ": " + e.getMessage());
            }
        }
    }
}

*/


//Process p = pb.start();