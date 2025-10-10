public class GranjaRunnable {
    public static void main(String[] args) {
        System.out.println("🌞 ¡Empieza la mañana en la granja!\n");

        GallinaRunnable g1 = new GallinaRunnable("Gallina Pepa");
        GallinaRunnable g2 = new GallinaRunnable("Gallina Lola");
        GallinaRunnable g3 = new GallinaRunnable("Gallina Josefa");

        Thread t1 = new Thread(g1);
        Thread t2 = new Thread(g2);
        Thread t3 = new Thread(g3);

        t1.start();
        t2.start();
        t3.start();
    }
}

class Ave {
    public void cantar(String nombre) {
        System.out.println(nombre + " canta:  Pío pío pío");
    }
}

class GallinaRunnable extends Ave implements Runnable {
    private String nombre;

    public GallinaRunnable(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public void run() {
        for (int i = 1; i <= 5; i++) {
            // La gallina pone un huevo
            System.out.println(nombre + " pone huevo #" + i );

            // De vez en cuando canta
            if (i % 2 == 0) {
                cantar(nombre);
            }

            try {
                Thread.sleep(500); // descansa medio segundo
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(nombre + " termina su jornada y se va al gallinero... \n");
    }
}
