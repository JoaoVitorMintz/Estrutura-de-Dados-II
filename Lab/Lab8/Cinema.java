public class Cinema {

    private final HashMap<Integer, Seat> mapa;
    private final Seat[] ordenados; // manter ordem natural dos assentos

    public Cinema(int totalAssentos) {
        this.mapa = new HashMap<>(totalAssentos * 2);
        this.ordenados = new Seat[totalAssentos];

        for (int i = 1; i <= totalAssentos; i++) {
            Seat s = new Seat(i);
            mapa.put(i, s);
            ordenados[i - 1] = s;
        }
    }

    public boolean reservarAssento(int numero) {
        Seat s = mapa.get(numero);
        if (s == null) return false;
        return s.reservar();
    }

    public void listarAssentos() {
        for (Seat s : ordenados) {
            System.out.println("Assento " + s.getNumero() +
                               " - " + (s.isReservado() ? "Reservado" : "Livre"));
        }
    }
}
