import java.util.*;

public class EX9 {
    
    public static class CadastroClientes {
        private TreeMap<Integer, String> clientes;
        
        public CadastroClientes() {
            clientes = new TreeMap<>();
        }
        
        public void adicionarCliente(int id, String nome) {
            clientes.put(id, nome);
        }
        
        public void exibirClientes() {
            System.out.println("\n=== CLIENTES EM ORDEM ===");
            for (Map.Entry<Integer, String> cliente : clientes.entrySet()) {
                System.out.println("ID: " + cliente.getKey() + " - Nome: " + cliente.getValue());
            }
        }
        
        public void consultarFaixa(int inicio, int fim) {
            System.out.println("\n=== CLIENTES ENTRE ID " + inicio + " E " + fim + " ===");
            SortedMap<Integer, String> faixa = clientes.subMap(inicio, fim + 1);
            for (Map.Entry<Integer, String> cliente : faixa.entrySet()) {
                System.out.println("ID: " + cliente.getKey() + " - Nome: " + cliente.getValue());
            }
        }
        
        public void vizinhos(int id) {
            Integer anterior = clientes.lowerKey(id);
            Integer posterior = clientes.higherKey(id);
            
            System.out.println("\n=== VIZINHOS DO ID " + id + " ===");
            System.out.println("Anterior: " + 
                (anterior != null ? "ID " + anterior + " - " + clientes.get(anterior) : "Nenhum"));
            System.out.println("Posterior: " + 
                (posterior != null ? "ID " + posterior + " - " + clientes.get(posterior) : "Nenhum"));
        }
    }
    
    public static void main(String[] args) {
        CadastroClientes cadastro = new CadastroClientes();
        
        // Adicionar clientes de exemplo
        cadastro.adicionarCliente(101, "Ana Silva");
        cadastro.adicionarCliente(105, "Carlos Santos");
        cadastro.adicionarCliente(103, "Beatriz Oliveira");
        cadastro.adicionarCliente(107, "Daniel Costa");
        cadastro.adicionarCliente(102, "Eduardo Lima");
        cadastro.adicionarCliente(109, "Fernanda Rocha");
        
        // Operações
        cadastro.exibirClientes();
        cadastro.consultarFaixa(102, 107);
        cadastro.vizinhos(105);
        
        // Adicionar mais um cliente
        cadastro.adicionarCliente(104, "Gabriela Souza");
        cadastro.exibirClientes();
        
        // Respostas
        System.out.println("\n=== RESPOSTAS ===");
        System.out.println("(a) TreeMap é apropriado porque mantém ordenação automática por ID.");
        System.out.println("(b) HashMap não mantém ordem, LinkedInshMap mantém ordem de inserção");
        System.out.println("    (não natural).");
        System.out.println("(c) Cenários: sistemas de folha de pagamento, relatórios ordenados,");
        System.out.println("    consultas por faixas de valores.");
    }
}