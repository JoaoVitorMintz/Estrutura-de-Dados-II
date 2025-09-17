/*
 * NOME: João Vitor Garcia Aguiar Mintz
 * RA: 10440421
 */

import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

public class Tree {

    private Node raiz;

    public void excluirArvore() {
        this.raiz = null;
    }

    public void inserir(int elemento) {
        Node novoNo = new Node();
        novoNo.valor = elemento;

        if (raiz == null) {
            raiz = novoNo;
            return;
        }

        Node atual = raiz;
        Node pai;
        while (true) { 
            pai = atual;
            if (elemento <= atual.valor) {
                atual = atual.esq;
                if ( atual == null) {
                    pai.esq = novoNo;
                    return;
                }
            } else {
                atual = atual.dir;
                if (atual == null) {
                    pai.dir = novoNo;
                    return;
                }
            }
        }

    }

    public void remover(int elemento) {
        raiz = removerValor(raiz, elemento);
    }

    private Node removerValor(Node no, int elemento) {
        if (no == null) return null;

        if (elemento < no.valor) {
            no.esq = removerValor(no.esq, elemento);
        } else if (elemento > no.valor) {
            no.dir = removerValor(no.dir, elemento);
        } else {
            if (no.esq == null && no.dir == null) {
                return null;
            } else if (no.esq == null) {
                return no.dir;
            } else if (no.dir == null) {
                return no.esq;
            }

        }
        return no;
    }

    public void removerSeq(int n) {
    int maxValor =  maiorValor();
    Random rand = new Random();
    for (int i = 0; i < n; i++) {
        int valor = rand.nextInt(maxValor + 1);
        remover(valor); 
        }
    }

    public int maiorValor() {
        Node atual = raiz;

        while (atual.dir != null) {
            atual = atual.dir;
        }
        return atual.valor;
    }

    public Node buscar(int elemento) {
        Node atual = raiz;

        while (atual != null) {
            if (atual.valor == elemento) return atual;
            if (atual.valor < elemento) atual = atual.dir;
            else atual = atual.esq;
        }
        return null;
    }

    public void exibirArvore() {
        exibirArvore(this.raiz, 0);
    }

    private void exibirArvore(Node no, int nivel) {
        if (no != null) {
            exibirArvore(no.dir, nivel + 1);
            for (int i = 1; i <= nivel; i++) {
                System.out.print(" - ");
            }
            System.out.println(no.valor);
            exibirArvore(no.esq, nivel + 1);
        }
    }

    public void emOrdem() {
        emOrdem(raiz);
    }

    private void emOrdem(Node no) {
        if (no != null) {
            emOrdem(no.esq);
            System.out.print(no.valor + " ");
            emOrdem(no.dir);
        }
    }

    public void preOrdem() {
        preOrdem(raiz);
    }

    private void preOrdem(Node no) {
        if (no != null) {
            System.out.print(no.valor + " ");
            preOrdem(no.esq);
            preOrdem(no.dir);
        }
    }

    public void posOrdem() {
        posOrdem(raiz);
    }

    private void posOrdem(Node no) {
        if (no != null) {
            posOrdem(no.esq);
            posOrdem(no.dir);
            System.out.print(no.valor + " ");
        }
    }

    public void porLargura() {
        porLarguraPriv();
    }

    private void porLarguraPriv() {
        if (raiz == null) return;

        Queue<Node> fila = new LinkedList<>();
        fila.add(raiz);
        while (!fila.isEmpty()) {
            Node atual = fila.poll();
            System.out.print(atual.valor + " ");
            if (atual.esq != null) fila.add(atual.esq);
            if (atual.dir != null) fila.add(atual.dir);
        }
        System.out.println();
    
    }

    public int sucessor(int elemento) {
        Node atual = raiz;
        Node suc = null;
        while (atual != null) {
            if (elemento < atual.valor) {
                suc = atual;
                atual = atual.esq;
            } else {
                atual = atual.dir;
            }
        }
        return (suc != null) ? suc.valor : null;
    }

    public Integer antecessor(int elemento) {
        Node atual = raiz;
        Node ant = null;
        while (atual != null) {
            if (elemento > atual.valor) {
                ant = atual;
                atual = atual.dir;
            } else {
                atual = atual.esq;
            }
        }
        return (ant != null) ? ant.valor : null;
    }

    public void ancestrais(int elemento) {
        Node atual = raiz;
        while (atual != null && atual.valor != elemento) {
            System.out.print(atual.valor + " ");
            if (elemento < atual.valor) atual = atual.esq;
            else atual = atual.dir;
        }
        System.out.println();
    }
}
