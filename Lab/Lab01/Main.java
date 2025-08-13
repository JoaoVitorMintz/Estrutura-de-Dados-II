import java.util.Scanner;

public class Main
{
	public static void main(String[] args) {
	    
	    Funcionario[] funcList;
	    funcList = new Funcionario[10];
		Funcionario func = new Funcionario();
		Scanner sc = new Scanner(System.in);
		
		for(int i = 0; i < funcList.length; i++) {
		    funcList[i] = func;
		}
		
// 		System.out.print("----------------------------\n");
// 		System.out.print("Digite o nome: ");
// 		String nome = sc.nextLine();
// 		System.out.print("Digite o ID: ");
// 		int ID = sc.nextInt();
// 		System.out.print("Digite o salário: ");
// 		double salario = sc.nextDouble();
// 		System.out.print("----------------------------\n");
		
// 		func.setNome(nome);
// 		func.setId(ID);
// 		func.setSalario(salario);
		
// 		System.out.print("----------------------------\n");
// 		System.out.print("Nome do viado: " + func.getNome());
// 		System.out.print("\nID do bostão: " + func.getId());
// 		System.out.print("\nSalário do duro: " + func.getSalario());
// 		System.out.print("\n----------------------------\n");
		
		for(int i = 0; i < funcList.length; i++) {
		    System.out.print(funcList[i]);
		    System.out.print("\n\n");
		}
		
	}
}