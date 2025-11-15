public class HolaMan {
    public static void main(String[] args) {
        // Verifica si se pasó un argumento
        if (args.length > 0) {
            try {
                int repeticiones = Integer.parseInt(args[0]); // Convierte el argumento a un número
                for (int i = 0; i < repeticiones; i++) {
                    System.out.println("Hola Man");
                }
            } catch (NumberFormatException e) {
                System.out.println("Por favor, introduce un número válido como argumento.");
            }
        } else {
            System.out.println("Por favor, introduce un argumento indicando cuántas veces imprimir 'Hola Mundo'.");
        }
    }
}
