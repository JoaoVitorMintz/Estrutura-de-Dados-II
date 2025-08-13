public class Funcionario {
    
    private String nome;
    private int id;
    private double salario;
    
    public Funcionario(String nome, int id, double salario) {
        this.nome = nome;
        this.id = id;
        this.salario = salario;
    }
    
    public Funcionario() {
        this("none", 0000, 0.0);
    }
    
    
    // Getters
    
    public String getNome() {
        return nome;
    }
    
    public int getId() {
        return id;
    }
    
    public double getSalario() {
        return salario;
    }
    
    // Setters
    
    public void setNome(String nome) {
        this.nome = nome;
    }
    
    public void setId(int id) {
        this.id = id;
    }
    
    public void setSalario(double salario) {
        this.salario = salario;
    }
    
    public String toString() {
        String dados = "Funcionario: " + this.nome + "\nID: " + this.id + "\nSalário: " + this.salario;
        return dados;
    }
    
    
}