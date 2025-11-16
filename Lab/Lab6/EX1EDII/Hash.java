public class Hash {
    int[] tabela;
    int m; 
    
    public Hash(int m) {
        if (m % 2 == 0) {
            System.out.println("O tamanho da tabela deve ser ímpar. Aumentando para o próximo valor ímpar.");
            m++;
        }
        this.m = m;
        this.tabela = new int[m];
        for (int i = 0; i < m; i++) {
            tabela[i] = -1;
        }
    }

    public int funcaoHash(int chave) {
        return chave % m;
    }

    public void inserir(int chave) {
        int index = funcaoHash(chave);
        
        while (tabela[index] != -1) {
            index = (index + 1) % m;
        }
        
        tabela[index] = chave;
    }

    public void exibirTabela() {
        System.out.println("Tabela Hash:");
        for (int i = 0; i < m; i++) {
            if (tabela[i] != -1) {
                System.out.println("Índice " + i + ": " + tabela[i]);
            } else {
                System.out.println("Índice " + i + ": Vazio");
            }
        }
    }

}
