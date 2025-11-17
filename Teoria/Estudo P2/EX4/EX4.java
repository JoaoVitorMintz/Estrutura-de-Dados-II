
public class EX4 {
    
    public static int hashDobra(int chave, int tamanhoTabela) {
        // Converte a chave para string para manipular dígitos
        String chaveStr = String.valueOf(chave);
        
        while (chave > tamanhoTabela) {
            // Converte para array de caracteres
            char[] digitos = chaveStr.toCharArray();
            
            // Se número de dígitos for ímpar, adiciona zero no início
            if (digitos.length % 2 != 0) {
                chaveStr = "0" + chaveStr;
                digitos = chaveStr.toCharArray();
            }
            
            // Aplica a dobra
            StringBuilder novaChave = new StringBuilder();
            for (int i = 0; i < digitos.length / 2; i++) {
                int esquerda = Character.getNumericValue(digitos[i]);
                int direita = Character.getNumericValue(digitos[digitos.length - 1 - i]);
                int soma = (esquerda + direita) % 10; // Desconsidera o "vai-um"
                novaChave.append(soma);
            }
            
            chaveStr = novaChave.toString();
            chave = Integer.parseInt(chaveStr);
        }
        
        return chave;
    }
    
    public static void main(String[] args) {
        // Teste do método da dobra
        int[] chaves = {123456, 789012, 456789, 123, 987654};
        int tamanhoTabela = 100;
        
        System.out.println("=== MÉTODO DA DOBRA ===");
        for (int chave : chaves) {
            int hash = hashDobra(chave, tamanhoTabela);
            System.out.println("Chave: " + chave + " -> Hash: " + hash);
        }
    }
}