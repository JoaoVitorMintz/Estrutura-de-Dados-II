// Exercicio do produto de matrizes:
import java.util.Scanner;

public class ex04 {
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        double[][] matrizM = new double[2][4];
        double[][] matrizN = new double[4][2];
        double[][] matrizR = new double[2][2];

        // Inserir valores via console:
        for (int linha = 0; linha < 2; linha++) {
            for (int coluna = 0; coluna < 4; coluna++) {
                System.out.print("Indique o valor na posiçao [" + (linha + 1) + "]" + "[" + (coluna + 1) + "]: ");
                matrizM[linha][coluna] = sc.nextDouble();
            }
        }

        System.out.print("-------------------------------------------\n");
        // Inserir valores via console:
        for (int linha = 0; linha < 4; linha++) {
            for (int coluna = 0; coluna < 2; coluna++) {
                System.out.print("Indique o valor na posiçao [" + (linha + 1) + "]" + "[" + (coluna + 1) + "]: ");
                matrizN[linha][coluna] = sc.nextDouble();
            }
        }

        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                matrizR[i][j] = 0;
                for (int k = 0; k < 4; k++) {
                    matrizR[i][j] += matrizM[i][k] * matrizN[k][j];
                }
            }
        }



        imprimirMatriz("Matriz m:", matrizM);
        imprimirMatriz("Matriz n:", matrizN);
        imprimirMatriz("Matriz Resultante:", matrizR);

        sc.close();
    }


    private static void imprimirMatriz(String nome, double[][] matriz) {
        System.out.println(nome);
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                System.out.print(matriz[i][j] + "\t");
            }
            System.out.println();
        }
        System.out.println("-------------------------------------------");
    }

}