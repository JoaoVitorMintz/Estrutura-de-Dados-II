// Exercicio da soma de matrizes:
import java.util.Scanner;

public class ex03 {
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        double[][] matrizM = new double[2][4];
        double[][] matrizN = new double[2][4];
        double[][] matrizR = new double[2][4];

        // Inserir valores via console:
        for (int linha = 0; linha < 2; linha++) {
            for (int coluna = 0; coluna < 4; coluna++) {
                System.out.print("Indique o valor na posiçao [" + (linha + 1) + "]" + "[" + (coluna + 1) + "]: ");
                matrizM[linha][coluna] = sc.nextDouble();
            }
        }

        System.out.print("-------------------------------------------\n");
        // Inserir valores via console:
        for (int linha = 0; linha < 2; linha++) {
            for (int coluna = 0; coluna < 4; coluna++) {
                System.out.print("Indique o valor na posiçao [" + (linha + 1) + "]" + "[" + (coluna + 1) + "]: ");
                matrizN[linha][coluna] = sc.nextDouble();
            }
        }

        for (int linha = 0; linha < 2; linha++) {
            for (int coluna = 0; coluna < 4; coluna++) {
                matrizR[linha][coluna] = matrizN[linha][coluna] + matrizM[linha][coluna];
            }
        }



        imprimirSomaMatrizes(matrizM, matrizN, matrizR);

        sc.close();
    }


    private static void imprimirSomaMatrizes(double[][] matrizM, double[][] matrizN, double[][] matrizR) {
        int n = matrizM.length;
        // Print matriz m em si:
        System.out.print("Matriz m:\n");
        for (int k = 0; k < n; k++) {
            for (int p = 0; p < n; p++) {
                System.out.print(matrizM[k][p] + " ");
            }
            System.out.print("\n");
        }
        System.out.print("-------------------------------------------\n");

        // Print matriz n em si:
        System.out.print("Matriz n:\n");
        for (int k = 0; k < n; k++) {
            for (int p = 0; p < n; p++) {
                System.out.print(matrizN[k][p] + " ");
            }
            System.out.print("\n");
        }
        System.out.print("-------------------------------------------\n");

        // Print matriz R:
        System.out.print("Matriz Resultante:\n");
        for (int k = 0; k < n; k++) {
            for (int p = 0; p < n; p++) {
                System.out.print(matrizR[k][p] + " ");
            }
            System.out.print("\n");
        }

    }

}