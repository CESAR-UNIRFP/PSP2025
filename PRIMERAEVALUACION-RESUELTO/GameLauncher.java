public class GameLauncher {

    public static void main(String[] args) {

        if (args.length == 0) {
            System.out.println("Debes introducir un número para lanzar un objeto.");
            return;
        }

        try {
            int opcion = Integer.parseInt(args[0]);

            switch (opcion) {
                case 1:
                    System.out.println("Has lanzado una Pokéball!");
                    break;

                case 2:
                    System.out.println("Has lanzado un Caparazón Verde!");
                    break;

                case 3:
                    System.out.println("Has lanzado una Granada de Fortnite!");
                    break;

                case 4:
                    System.out.println("Has lanzado una Bomba de Bomberman!");
                    break;

                default:
                    System.out.println("No conozco ese objeto…");
                    break;
            }

        } catch (NumberFormatException e) {
            System.out.println("El argumento debe ser un número válido.");
        }
    }
}
