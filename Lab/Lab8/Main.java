public class Main {
    public static void main(String[] args) {

        Cinema cinema = new Cinema(10);

        // Duas threads tentando reservar ao mesmo tempo
        Thread t1 = new Thread(() -> {
            if (cinema.reservarAssento(5))
                System.out.println("Thread 1 reservou o assento 5");
            else
                System.out.println("Thread 1 falhou ao reservar");
        });

        Thread t2 = new Thread(() -> {
            if (cinema.reservarAssento(5))
                System.out.println("Thread 2 reservou o assento 5");
            else
                System.out.println("Thread 2 falhou ao reservar");
        });

        t1.start();
        t2.start();

        try { t1.join(); t2.join(); } catch (Exception e) {}

        System.out.println("\nSituação final:");
        cinema.listarAssentos();
    }
}
