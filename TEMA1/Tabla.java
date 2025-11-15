//import java.io.File;
//import java.io.FileNotFoundException;
import java.util.Scanner;

public class Tabla {
    public static void main(String[] args) {
        //try (Scanner lector = new Scanner(new File("entrada.txt"))) {
    	Scanner lector = new Scanner(System.in);
        System.out.println("Tabla del número: ");
        int n = lector.nextInt();
        System.out.println(n);
        for (int i=1; i<=10; i++) {
            System.out.println(n + " X " + i + " = " + (n*i));
        }
        lector.close();   //comentar

  //  } catch (FileNotFoundException e) {
    //    System.err.println("No se encontró el archivo entrada.txt");
  //  }
  
    }
}

