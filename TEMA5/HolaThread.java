/*class HelloThread implements Runnable {

    Thread t;
    HelloThread () {
        t = new Thread(this, "Nuevo Thread");
        System.out.println("Creado hilo: " + t);
        t.start(); // Arranca el nuevo hilo de ejecución. Ejecuta run
    }

    public void run() {
        System.out.println("Hola desde el hilo creado");
        System.out.println("Hilo finalizando.");
    }
}

*/


class HelloThread implements Runnable {

	Thread t;

	HelloThread() {
		t = new Thread(this, "Nuevo Thread");
		System.out.println("Creado hilo: " + t);
		t.start(); // arranca el hilo, ejecuta run()
	}

@Override
	public void run() {
    // contamos 10 segundos
    	for (int i = 1; i <= 10; i++) {
    		System.out.println("(HILO " + t.getName() + " SEGUNDO: " + i + ")");
    			try {
    				Thread.sleep(1000); // 1 segundo
    			} 
    			catch (InterruptedException e) {
            // si lo interrumpen, salimos antes
    				System.out.println("Hilo interrumpido.");
    				return;
    			}
    	}
    	System.out.println("Hola desde el hilo creado");
    	System.out.println("Hilo finalizando.");
	}
}