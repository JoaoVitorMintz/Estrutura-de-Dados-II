/*
 * NOME: João Vitor Garcia Aguiar Mintz
 * RA: 10440421
 */

import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Tree ar = new Tree();
        Scanner sc = new Scanner(System.in);
        Random r = new Random();
        int nQtd = 0;

        final int AMPLITUDE_SORTEIOS = 900;
        boolean continua = true;
        int opcao, valor, qtd_sorteio;

        do { 
            System.out.print("\n1 - insira um elemento\n");
            System.out.print("2 - insira uma sequencia aleatória de n elementos\n");
            System.out.print("3 - remova um elemento\n");
            System.out.print("4 - remova sequencia aleatória de n elementos\n");
            System.out.print("5 - busque um valor\n");
            System.out.print("6 - percorra a árvore em ordem\n");
            System.out.print("7 - percorra a árvore pré ordem\n");
            System.out.print("8 - percorra a árvore pós ordem\n");
            System.out.print("9 - percorra a árvore em largura\n");
            System.out.print("10 - sucessor de um elemento\n");
            System.out.print("11 - antecessor de um elemento\n");
            System.out.print("12 - ancestrais de um elemento\n");
            System.out.print("13 - exibir árvore\n");
            System.out.print("14 - excluir árvore\n");
            System.out.print("15 - Sair\n: ");
            System.out.print("Digite sua opção: ");
            opcao = sc.nextInt();

            switch (opcao) {
                case 1:
                    System.out.print("Digite o valor a ser inserido na árvore: ");
                    valor = sc.nextInt();
                    ar.inserir(valor);
                    System.out.print("Árvore resultante: ");
                    ar.emOrdem();
                    nQtd += 1;
                    break;

                case 2:
                    System.out.print("Digite a quantidade de números a serem sorteados para a inserção: ");
                    qtd_sorteio = sc.nextInt();
                    for (int i = 0; i < qtd_sorteio; i++) ar.inserir(r.nextInt(AMPLITUDE_SORTEIOS));
                    System.out.print("Árvore resultante: ");
                    ar.emOrdem();
                    nQtd += qtd_sorteio;
                    break;

                case 3:
                    System.out.print("Digite o valor a ser removido: ");
                    valor = sc.nextInt();
                    if (ar.buscar(valor) != null) {
                        ar.remover(valor);
                        System.out.print("Valor removido!");
                        nQtd -= 1;
                        break;
                    }
                    System.out.print("Valor não presente na árvore");
                    break;

                case 4: 
                    System.out.print("Digite o número de remoções a serem realizadas: ");
                    int n = sc.nextInt();
                    if (n > nQtd) {
                        System.out.print("Você escolheu um número maior que a quantidade de nós, está certo? \n1 - sim\n2 - nao\n-> ");
                        valor = sc.nextInt();
                        if (valor == 1) {
                            ar.excluirArvore();
                            nQtd = 0;
                            System.out.print("Sequência removida por completo!");
                            break;
                        } else {
                            break;
                        }
                    }
                    ar.removerSeq(n);
                    System.out.print("Sequência removida por completo!");
                    break;

                case 5: 
                    Node noBusca;
                    System.out.print("Digite o valor a ser encontrado na árvore: ");
                    valor = sc.nextInt();
                    noBusca = ar.buscar(valor);
                    if (noBusca != null) System.out.println("Achou o valor " + noBusca.valor);
                    else System.out.println("Não achou o valor " + valor);
                    break;

                case 6:
                    System.out.print("Árvore em ordem: ");
                    ar.emOrdem();
                    break;

                case 7:
                    System.out.print("Árvore pré ordem: ");
                    ar.preOrdem();
                    break;

                case 8:
                    System.out.print("Árvore pós ordem: ");
                    ar.posOrdem();
                    break;

                case 9:
                    System.out.print("Árvore por Lárgura: ");
                    ar.porLargura();
                    break;

                case 10:
                    System.out.print("Digite o valor que terá seu sucessor apresentado: ");
                    valor = sc.nextInt();
                    System.out.print("\nSucessor: " + ar.sucessor(valor));
                    break;

                case 11:
                    System.out.print("Digite o valor que terá seu antecessor apresentado: ");
                    valor = sc.nextInt();
                    System.out.print("\nAntecessor: " + ar.antecessor(valor));
                    break;

                case 12:
                    System.out.print("Digite o valor que terá seus ancestrais apresentados: ");
                    valor = sc.nextInt();
                    System.out.print("\nAncestrais: " + ar.sucessor(valor));
                    break;

                case 13:
                    ar.exibirArvore();
                    break;

                case 14:
                    ar.excluirArvore();
                    break;

                case 15:
                    continua = false;
                    break;

                default:
                    System.out.println("Digite uma opção válida!\n");

            }
        } while (continua);
        sc.close();
    }
}
