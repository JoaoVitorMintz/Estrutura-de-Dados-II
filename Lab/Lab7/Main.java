public class Main {
    public static void main(String[] args) {
        int grau = 4; // M = 4 (como no exemplo da aula)
        Arvore btree = new Arvore(grau);

        int[] chaves = {10, 20, 30, 40, 50, 60, 70, 80, 90, 100};

        for (int chave : chaves) {
            System.out.println("Inserindo " + chave + "...");
            btree.inserir(chave);
            btree.print();
            System.out.println("----------------------------");
        }
    }
}