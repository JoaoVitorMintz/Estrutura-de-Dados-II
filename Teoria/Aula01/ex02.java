// Exercicio da Diagonal Secundária na matriz:
import java.util.Scanner;

public class ex02 {
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        int[][] matriz = new int[4][4];

        // Inserir valores via console:
        for (int linha = 0; linha < 4; linha++) {
            for (int coluna = 0; coluna < 4; coluna++) {
                System.out.print("Indique o valor na posiçao [" + (linha + 1) + "]" + "[" + (coluna + 1) + "]: ");
                matriz[linha][coluna] = sc.nextInt();
            }
        }

        imprimirDS(matriz);

        sc.close();
    }


    private static void imprimirDS(int[][] matriz) {
        int n = matriz.length;
        // Print matriz em si:
        System.out.print("Matriz:\n");
        for (int k = 0; k < n; k++) {
            for (int p = 0; p < n; p++) {
                System.out.print(matriz[k][p] + " ");
            }
            System.out.print("\n");
        }

        // Print da diagonal principal:
        System.out.print("\nDiagonal Secundária: [ ");
        for (int i = 0; i < n; i++) {
            System.out.print("[" + matriz[i][n-1-i] + "]");
        }
        System.out.print(" ]");
    }

}