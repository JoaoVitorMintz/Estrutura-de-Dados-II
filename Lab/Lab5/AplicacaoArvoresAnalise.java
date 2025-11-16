/*
 * NOME: João Vitor Garcia Aguiar Mintz
 * RA: 10440421
 */

import java.util.Random;

public class AplicacaoArvoresAnalise {

    public static void main(String[] args) {
        final int AMPLITUDE_SORTEIOS = 1_000_000;

        // Tamanhos e sementes conforme o enunciado
        int[] tamanhos = {100, 500, 1000, 10_000, 100_000, 500_000};
        int[][] sementes = {
            {7, 8, 9},
            {10, 11, 12},
            {13, 14, 15},
            {16, 17, 18},
            {19, 20, 21},
            {22, 23, 24}
        };

        for (int i = 0; i < tamanhos.length; i++) {
            int n = tamanhos[i];
            System.out.println("\n----------------------------------------------------------");
            System.out.println("Quantidade de elementos (n) = " + n);

            // ======================================================
            // BST sem sementes (3 execuções aleatórias)
            // ======================================================
            long[] temposBSTsemSeed = new long[3];
            for (int j = 0; j < 3; j++) {
                Arvore bst = new Arvore();
                Random r = new Random(); // sem seed fixa
                long inicio = System.currentTimeMillis();
                for (int k = 0; k < n; k++) {
                    bst.inserir(r.nextInt(AMPLITUDE_SORTEIOS));
                }
                long fim = System.currentTimeMillis();
                temposBSTsemSeed[j] = fim - inicio;
            }
            double mediaBSTsemSeed = (temposBSTsemSeed[0] + temposBSTsemSeed[1] + temposBSTsemSeed[2]) / 3.0;

            System.out.println("\n[1] BST sem semente:");
            for (int j = 0; j < 3; j++) {
                System.out.println("  Execução " + (j + 1) + ": " + temposBSTsemSeed[j] + " ms");
            }
            System.out.printf("  Média: %.2f ms\n", mediaBSTsemSeed);

            // ======================================================
            // BST com sementes (1 execução por semente)
            // ======================================================
            long[] temposBSTcomSeed = new long[3];
            for (int j = 0; j < 3; j++) {
                Arvore bst = new Arvore();
                Random r = new Random(sementes[i][j]);
                long inicio = System.currentTimeMillis();
                for (int k = 0; k < n; k++) {
                    bst.inserir(r.nextInt(AMPLITUDE_SORTEIOS));
                }
                long fim = System.currentTimeMillis();
                temposBSTcomSeed[j] = fim - inicio;
            }
            double mediaBSTcomSeed = (temposBSTcomSeed[0] + temposBSTcomSeed[1] + temposBSTcomSeed[2]) / 3.0;

            System.out.println("\n[2] BST com semente (" + sementes[i][0] + ", " + sementes[i][1] + ", " + sementes[i][2] + "):");
            for (int j = 0; j < 3; j++) {
                System.out.println("  Execução semente " + sementes[i][j] + ": " + temposBSTcomSeed[j] + " ms");
            }
            System.out.printf("  Média: %.2f ms\n", mediaBSTcomSeed);

            // ======================================================
            // AVL com sementes (1 execução por semente)
            // ======================================================
            long[] temposAVL = new long[3];
            for (int j = 0; j < 3; j++) {
                ArvoreAVL avl = new ArvoreAVL();
                Random r = new Random(sementes[i][j]);
                long inicio = System.currentTimeMillis();
                for (int k = 0; k < n; k++) {
                    avl.inserir(r.nextInt(AMPLITUDE_SORTEIOS));
                }
                long fim = System.currentTimeMillis();
                temposAVL[j] = fim - inicio;
            }
            double mediaAVL = (temposAVL[0] + temposAVL[1] + temposAVL[2]) / 3.0;

            System.out.println("\n[3] AVL com semente (" + sementes[i][0] + ", " + sementes[i][1] + ", " + sementes[i][2] + "):");
            for (int j = 0; j < 3; j++) {
                System.out.println("  Execução semente " + sementes[i][j] + ": " + temposAVL[j] + " ms");
            }
            System.out.printf("  Média: %.2f ms\n", mediaAVL);

            // ======================================================
            // Resumo final para este n
            // ======================================================
            System.out.println("\nResumo (n = " + n + "):");
            System.out.printf("  BST (sem semente): %.2f ms\n", mediaBSTsemSeed);
            System.out.printf("  BST (com semente): %.2f ms\n", mediaBSTcomSeed);
            System.out.printf("  AVL (com semente): %.2f ms\n", mediaAVL);
            System.out.println("----------------------------------------------------------\n");
        }

        System.out.println("Experimento concluído com sucesso!");
    }
}
