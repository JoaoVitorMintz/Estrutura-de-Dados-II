
public class Hash {
    int[] tabela;
    int m;
    int colisoes;
    
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
        this.colisoes = 0;
    }

    public int funcaoHash(int chave) {
        return chave % m;
    }

    public void inserirLinear(int chave) {
        int index = funcaoHash(chave);
        int i = 0;

        while (tabela[(index + i) % m] != -1) {
            colisoes++;
            i++;
            if (i == m) return;
        }
        tabela[(index + i) % m] = chave;
    }

    public void inserirQuadratica(int chave) {
        int index = funcaoHash(chave);
        int i = 0;
        
        while (tabela[(index + i * i) % m] != -1) {
            colisoes++;
            i++;
            if (i == m) return;
        }
        
        tabela[(index + i * i) % m] = chave;
    }

    public void limpar() {
        for (int i = 0; i < m; i++) tabela[i] = -1;
        colisoes = 0;
    }

}
