public class granja {
    public static void main(String[] args) {
        Gallina g1 = new Gallina("Gallina Pepa");
        Gallina g2 = new Gallina("Gallina Lola");

        g1.start(); // empieza el hilo de Pepa
        g2.start(); // empieza el hilo de Lola
    }
}

// Clase que representa el hilo
class Gallina extends Thread {
    private String nombre;

    public Gallina(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public void run() {
        for (int i = 1; i <= 5; i++) {
            System.out.println(nombre + " pone huevo #" + i);
            try {
                Thread.sleep(500); // descansa medio segundo
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(nombre + " se va a dormir... ");
    }
}