import java.util.Random;

public class Main {
    public static void main(String[] args) {
        int tamanho = 11; 
        int n = 8; 
        int limiteValor = 100; 

        Hash hash = new Hash(tamanho);
        Random random = new Random();
        int[] chaves = new int[n];


        for (int i = 0; i < n; i++) {
            chaves[i] = random.nextInt(limiteValor);
        }


        for (int chave : chaves) {
            hash.inserirQuadratica(chave);
        }
        int colisoesQuadratica = hash.colisoes;


        hash.limpar();
        for (int chave : chaves) {
            hash.inserirLinear(chave);
        }
        int colisoesLinear = hash.colisoes;


        System.out.println("Chaves inseridas: ");
        for (int c : chaves) System.out.print(c + " ");
        System.out.println("\n");

        System.out.println("Colisões (Sondagem Quadrática): " + colisoesQuadratica);
        System.out.println("Colisões (Sondagem Linear): " + colisoesLinear);


        System.out.println("\nComparação:");
        if (colisoesQuadratica < colisoesLinear)
            System.out.println("A sondagem quadrática apresentou menos colisões.");
        else if (colisoesQuadratica > colisoesLinear)
            System.out.println("A sondagem linear apresentou menos colisões.");
        else
            System.out.println("Ambos os métodos apresentaram a mesma quantidade de colisões.");
    }
}