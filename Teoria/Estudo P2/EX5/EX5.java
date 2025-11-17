import java.util.*;

public class EX5 {
    
    // Sondagem Linear
    public static int[] sondagemLinear(int[] chaves, int tamanho) {
        int[] tabela = new int[tamanho];
        Arrays.fill(tabela, -1); // -1 indica posição vazia
        int colisoes = 0;
        
        for (int chave : chaves) {
            int posicao = chave % tamanho;
            int k = 0;
            
            while (tabela[(posicao + k) % tamanho] != -1) {
                colisoes++;
                k++;
            }
            
            tabela[(posicao + k) % tamanho] = chave;
        }
        
        System.out.println("Colisões (Linear): " + colisoes);
        return tabela;
    }
    
    // Sondagem Quadrática
    public static int[] sondagemQuadratica(int[] chaves, int tamanho) {
        int[] tabela = new int[tamanho];
        Arrays.fill(tabela, -1);
        int colisoes = 0;
        
        for (int chave : chaves) {
            int posicao = chave % tamanho;
            int k = 0;
            boolean inserido = false;
            
            while (k < tamanho && !inserido) {
                int novaPosicao = (posicao + k + 3 * k * k) % tamanho;
                if (novaPosicao < 0) novaPosicao += tamanho;
                
                if (tabela[novaPosicao] == -1) {
                    tabela[novaPosicao] = chave;
                    inserido = true;
                } else {
                    colisoes++;
                    k++;
                }
            }
        }
        
        System.out.println("Colisões (Quadrática): " + colisoes);
        return tabela;
    }
    
    public static void exibirTabela(int[] tabela, String metodo) {
        System.out.println("\nTabela " + metodo + ":");
        for (int i = 0; i < tabela.length; i++) {
            System.out.println("Posição " + i + ": " + 
                (tabela[i] == -1 ? "Vazia" : tabela[i]));
        }
    }
    
    public static void main(String[] args) {
        int[] chaves = {77, 18, 50, 39, 26, 5, 64, 91};
        int tamanho = 13;
        
        // (a) Sondagem Linear
        int[] tabelaLinear = sondagemLinear(chaves, tamanho);
        exibirTabela(tabelaLinear, "Sondagem Linear");
        
        // (b) Sondagem Quadrática
        int[] tabelaQuadratica = sondagemQuadratica(chaves, tamanho);
        exibirTabela(tabelaQuadratica, "Sondagem Quadrática");
        
        // (c) e (d) Análise
        System.out.println("\n=== ANÁLISE ===");
        System.out.println("A sondagem quadrática geralmente distribui melhor as chaves,");
        System.out.println("mas pode sofrer com agrupamento secundário.");
        System.out.println("Risco: pode não encontrar posições vazias mesmo havendo espaço.");
    }
}
