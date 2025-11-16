public class Arvore {
    private Node raiz;

    

    // Inserir elemento:
    public void inserir(int elemento) {
        Node novoNo = new Node();
        novoNo.value = elemento;

        if (this.raiz == null) {
            raiz = novoNo;
        } else {
            Node atual = raiz;
            Node pai;
            while(true) {
                pai = atual;
                if (elemento <= atual.value) {
                    atual = atual.esquerda;
                    if (atual == null) {
                        pai.esquerda = novoNo;
                        return;
                    }
                } else {
                    atual = atual.direita;
                    if (atual == null) {
                        pai.direita = novoNo;
                        return;
                    }
                }
            }
        }
    }

    // Buscar elemento:
    public Node busca(int elemento) {
        Node atual = raiz;
        boolean achou = false;
        while (atual != null) {
            if(atual.value == elemento) {
                return atual;
            } 
            if (atual.value < elemento) {
                atual = atual.direita;
            } else {
                atual = atual.esquerda;
            }
        }
        return null;
    }

    // Exibir em ordem:
    public void emOrdem() {
        visitarEmOrdem(raiz);
    }

    private void visitarEmOrdem(Node no) {
        if (no != null) {
            visitarEmOrdem(no.esquerda);
            System.out.print(no.value + " ");
            visitarEmOrdem(no.direita);
        }
    }

    // Exercicio 1 da lista de revisão:
    // a)
    public int numNos(Node atual) {
        if (atual == null) return 0;

        return 1 + numNos(atual.esquerda) + numNos(atual.direita);
    }

    // b) 
    public int numFolhas(Node atual) {
        if (atual == null) return 0;
        if (atual.esquerda == null && atual.direita == null) return 1;
        return numFolhas(atual.esquerda) + numFolhas(atual.direita);
    }

    // c)
    public int nivelNo(Node atual, int chave, int nivel) {
        if (atual == null) return -1;
        if (atual.value == chave) return nivel;

        int esq = nivelNo(atual.esquerda, chave, nivel + 1);
        if (esq != 1) return esq;

        return nivelNo(atual.direita, chave, nivel + 1);
    }

    // d)
    public boolean ehBST(Node atual, Integer min, Integer max) {
        if (atual == null) return true;

        if ((min != null && atual.value <= min) || (max != null && atual.value >= max)) {
            return false;
        }

        return ehBST(atual.esquerda, min, atual.value) && ehBST(atual.direita, atual.value, max);
    }
}
