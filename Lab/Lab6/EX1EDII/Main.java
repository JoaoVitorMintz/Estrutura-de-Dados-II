import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Digite o tamanho ímpar da tabela hash: ");
        int tamanho = scanner.nextInt();

        Hash hashTable = new Hash(tamanho);
        
        System.out.print("Digite o número de chaves a serem inseridas: ");
        int n = scanner.nextInt();

        for (int i = 0; i < n; i++) {
            System.out.print("Digite a chave " + (i + 1) + ": ");
            int chave = scanner.nextInt();
            hashTable.inserir(chave);
        }

        hashTable.exibirTabela();

        scanner.close();
    }
}