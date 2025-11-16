import java.util.concurrent.atomic.AtomicBoolean; // Thread-safe

public class Seat {
    private final int numero;
    private final AtomicBoolean reservado;

    public Seat(int numero) {
        this.numero = numero;
        this.reservado = new AtomicBoolean(false);
    }

    public int getNumero() {
        return numero;
    }

    public boolean reservar() {
        return reservado.compareAndSet(false, true);
    }

    public boolean isReservado() {
        return reservado.get();
    }
}
