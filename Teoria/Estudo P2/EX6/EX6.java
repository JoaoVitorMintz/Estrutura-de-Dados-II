import java.util.*;

public class EX6 {
    
    public static void dispersaoDupla(int[] chaves, int tamanho) {
        int[] tabela = new int[tamanho];
        Arrays.fill(tabela, -1);
        
        System.out.println("=== DISPERSÃO DUPLA ===");
        
        for (int chave : chaves) {
            int h1 = chave % tamanho;
            int h2 = 7 - (chave % 7);
            int k = 0;
            int posicao = (h1 + k * h2) % tamanho;
            
            while (tabela[posicao] != -1) {
                k++;
                posicao = (h1 + k * h2) % tamanho;
                if (posicao < 0) posicao += tamanho;
            }
            
            tabela[posicao] = chave;
            System.out.println("Chave " + chave + " -> Posição: " + posicao + 
                             " (h1=" + h1 + ", h2=" + h2 + ", k=" + k + ")");
        }
        
        // Exibir tabela final
        System.out.println("\nTabela Final:");
        for (int i = 0; i < tamanho; i++) {
            System.out.println("Posição " + i + ": " + 
                (tabela[i] == -1 ? "Vazia" : tabela[i]));
        }
    }
    
    public static void main(String[] args) {
        int[] chaves = {371, 121, 173, 203, 11, 24, 16, 97};
        int tamanho = 13; // Tamanho primo próximo do número de chaves
        
        dispersaoDupla(chaves, tamanho);
    }
}