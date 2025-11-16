public class Arvore {
    private Node raiz;
    private int grau; // grau M

    public Arvore(int grau) {
        this.grau = grau;
        this.raiz = new Node(grau, true);
    }

    public void inserir(int chave) {
        Node r = raiz;
        if (r.numKeys == grau - 1) {
            Node s = new Node(grau, false);
            s.children[0] = r;
            dividirFilho(s, 0, r);
            raiz = s;
            inserirNaoCheio(s, chave);
        } else {
            inserirNaoCheio(r, chave);
        }
    }

    private void inserirNaoCheio(Node node, int chave) {
        int i = node.numKeys - 1;

        if (node.isLeaf) {
            while (i >= 0 && chave < node.keys[i]) {
                node.keys[i + 1] = node.keys[i];
                i--;
            }
            node.keys[i + 1] = chave;
            node.numKeys++;
        } else {
            while (i >= 0 && chave < node.keys[i]) i--;
            i++;
            if (node.children[i].numKeys == grau - 1) {
                dividirFilho(node, i, node.children[i]);
                if (chave > node.keys[i]) i++;
            }
            inserirNaoCheio(node.children[i], chave);
        }
    }

    private void dividirFilho(Node pai, int i, Node cheio) {
        Node novo = new Node(grau, cheio.isLeaf);
        novo.numKeys = grau / 2 - 1;

        // Copia metade das chaves para o novo nó
        for (int j = 0; j < grau / 2 - 1; j++) {
            novo.keys[j] = cheio.keys[j + grau / 2];
        }

        // Se não for folha, copia também os filhos
        if (!cheio.isLeaf) {
            for (int j = 0; j < grau / 2; j++) {
                novo.children[j] = cheio.children[j + grau / 2];
            }
        }

        cheio.numKeys = grau / 2 - 1;

        for (int j = pai.numKeys; j >= i + 1; j--) {
            pai.children[j + 1] = pai.children[j];
        }
        pai.children[i + 1] = novo;

        for (int j = pai.numKeys - 1; j >= i; j--) {
            pai.keys[j + 1] = pai.keys[j];
        }

        pai.keys[i] = cheio.keys[grau / 2 - 1];
        pai.numKeys++;
    }

    public void print() {
        if (raiz != null) raiz.print("");
    }
}