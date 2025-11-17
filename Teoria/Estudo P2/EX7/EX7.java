import java.util.*;

public class EX7 {
    
    public static class SistemaVendas {
        private HashMap<String, Integer> vendas;
        
        public SistemaVendas() {
            vendas = new HashMap<>();
        }
        
        public void registrarVenda(String produto) {
            vendas.put(produto, vendas.getOrDefault(produto, 0) + 1);
        }
        
        public void exibirVendas() {
            System.out.println("\n=== RELATÓRIO DE VENDAS ===");
            for (Map.Entry<String, Integer> entry : vendas.entrySet()) {
                System.out.println(entry.getKey() + ": " + entry.getValue() + " vendas");
            }
        }
        
        public void identificarExtremos() {
            String maisVendido = null;
            String menosVendido = null;
            int max = Integer.MIN_VALUE;
            int min = Integer.MAX_VALUE;
            
            for (Map.Entry<String, Integer> entry : vendas.entrySet()) {
                if (entry.getValue() > max) {
                    max = entry.getValue();
                    maisVendido = entry.getKey();
                }
                if (entry.getValue() < min) {
                    min = entry.getValue();
                    menosVendido = entry.getKey();
                }
            }
            
            System.out.println("\nProduto mais vendido: " + maisVendido + " (" + max + " vendas)");
            System.out.println("Produto menos vendido: " + menosVendido + " (" + min + " vendas)");
        }
        
        public int totalVendas() {
            int total = 0;
            for (int quantidade : vendas.values()) {
                total += quantidade;
            }
            return total;
        }
        
        public int consultarVendas(String produto) {
            return vendas.getOrDefault(produto, 0);
        }
    }
    
    public static void main(String[] args) {
        SistemaVendas sistema = new SistemaVendas();
        
        // Simular vendas
        String[] produtosVendidos = {
            "Notebook", "Mouse", "Teclado", "Monitor", "Notebook",
            "Mouse", "Notebook", "Teclado", "Monitor", "Mouse",
            "Webcam", "Headset", "Notebook", "Mouse", "Teclado"
        };
        
        for (String produto : produtosVendidos) {
            sistema.registrarVenda(produto);
        }
        
        // Exibir resultados
        sistema.exibirVendas();
        sistema.identificarExtremos();
        System.out.println("\nTotal de vendas: " + sistema.totalVendas());
        System.out.println("Vendas de Notebook: " + sistema.consultarVendas("Notebook"));
        
        // Respostas das questões
        System.out.println("\n=== RESPOSTAS ===");
        System.out.println("(a) HashMap é apropriado porque oferece O(1) para inserção e busca,");
        System.out.println("    sendo eficiente para atualizar contagens rapidamente.");
        System.out.println("(b) LinkedInshMap manteria ordem de inserção (desnecessário aqui),");
        System.out.println("    TreeMap manteria ordenado (também desnecessário) com O(log n).");
    }
}