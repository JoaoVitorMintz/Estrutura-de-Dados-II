public class No {
    int[] chaves;
    No[] filhos;
    int numChaves;
    boolean ehFolha;
    int grau;

    public No(int grau, boolean ehFolha) {
        this.grau = grau;
        this.ehFolha = ehFolha;
        this.chaves = new int[grau - 1];
        this.filhos = new No[grau];
        this.numChaves = 0;
    }

    public void print(String prefix) {
        System.out.print(prefix + "[ ");
        for (int i = 0; i < numChaves; i++) {
            System.out.print(chaves[i] + " ");
        }
        System.out.println("]");
        if (!ehFolha) {
            for (int i = 0; i <= numChaves; i++) {
                if (filhos[i] != null) filhos[i].print(prefix + "   ");
            }
        }
    }
}
