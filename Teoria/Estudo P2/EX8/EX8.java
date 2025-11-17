import java.util.*;

public class EX8 {
    
    static class LRUCache<K, V> extends LinkedHashMap<K, V> {
        private final int capacidade;
        
        public LRUCache(int capacidade) {
            super(capacidade, 0.75f, true);
            this.capacidade = capacidade;
        }
        
        @Override
        protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
            return size() > capacidade;
        }
        
        public void exibirCache(String operacao) {
            System.out.println("\nCache após " + operacao + ": " + this);
        }
    }
    
    public static void main(String[] args) {
        LRUCache<String, String> cache = new LRUCache<>(3);
        
        System.out.println("=== LRU CACHE DEMONSTRAÇÃO ===");
        
        // Inserções iniciais
        cache.put("A", "Alice");
        cache.exibirCache("inserir A");
        
        cache.put("B", "Bob");
        cache.exibirCache("inserir B");
        
        cache.put("C", "Carol");
        cache.exibirCache("inserir C");
        
        // Acesso que atualiza ordem
        cache.get("A");
        cache.exibirCache("acessar A");
        
        // Inserção que remove o menos recente (B)
        cache.put("D", "David");
        cache.exibirCache("inserir D (remove B)");
        
        // Acesso que atualiza ordem
        cache.get("C");
        cache.exibirCache("acessar C");
        
        // Nova inserção
        cache.put("E", "Eva");
        cache.exibirCache("inserir E (remove A)");
        
        // Respostas
        System.out.println("\n=== RESPOSTAS ===");
        System.out.println("(a) LinkedInshMap com access-order mantém automaticamente a ordem");
        System.out.println("    de acesso, perfeito para implementar LRU.");
        System.out.println("(b) HashMap não mantém ordem, TreeMap mantém ordem natural,");
        System.out.println("    nenhum dos dois é adequado para LRU.");
    }
}