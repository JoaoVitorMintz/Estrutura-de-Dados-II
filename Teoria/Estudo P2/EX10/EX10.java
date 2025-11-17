import java.util.*;

public class EX10 {
    
    public static void testarDesempenho() {
        final int QUANTIDADE = 30000;
        Random random = new Random();
        
        // HashMap
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        
        long inicioInsercaoHashMap = System.currentTimeMillis();
        for (int i = 0; i < QUANTIDADE; i++) {
            int numero = random.nextInt(100000);
            hashMap.put(numero, numero);
        }
        long fimInsercaoHashMap = System.currentTimeMillis();
        
        long inicioBuscaHashMap = System.currentTimeMillis();
        for (int i = 0; i < QUANTIDADE; i++) {
            int numero = random.nextInt(100000);
            hashMap.containsKey(numero);
        }
        long fimBuscaHashMap = System.currentTimeMillis();
        
        // TreeMap
        TreeMap<Integer, Integer> treeMap = new TreeMap<>();
        
        long inicioInsercaoTreeMap = System.currentTimeMillis();
        for (int i = 0; i < QUANTIDADE; i++) {
            int numero = random.nextInt(100000);
            treeMap.put(numero, numero);
        }
        long fimInsercaoTreeMap = System.currentTimeMillis();
        
        long inicioBuscaTreeMap = System.currentTimeMillis();
        for (int i = 0; i < QUANTIDADE; i++) {
            int numero = random.nextInt(100000);
            treeMap.containsKey(numero);
        }
        long fimBuscaTreeMap = System.currentTimeMillis();
        
        // Resultados
        System.out.println("=== COMPARAÇÃO DE DESEMPENHO ===");
        System.out.println("\nHASHMAP:");
        System.out.println("Inserção: " + (fimInsercaoHashMap - inicioInsercaoHashMap) + "ms");
        System.out.println("Busca: " + (fimBuscaHashMap - inicioBuscaHashMap) + "ms");
        
        System.out.println("\nTREEMAP:");
        System.out.println("Inserção: " + (fimInsercaoTreeMap - inicioInsercaoTreeMap) + "ms");
        System.out.println("Busca: " + (fimBuscaTreeMap - inicioBuscaTreeMap) + "ms");
        
        // Análise
        System.out.println("\n=== ANÁLISE ===");
        System.out.println("(a) Em ambas estruturas, as inserções geralmente são mais lentas");
        System.out.println("    devido à necessidade de reorganização/balanceamento.");
        System.out.println("(b) HashMap é mais rápido (O(1) vs O(log n)) devido à hashing,");
        System.out.println("    enquanto TreeMap precisa manter ordenação (árvore rubro-negra).");
    }
    
    public static void main(String[] args) {
        testarDesempenho();
    }
}