public class Node {
    int[] keys;          // vetor de chaves
    Node[] children;     // vetor de ponteiros para filhos
    int numKeys;         // número atual de chaves no nó
    boolean isLeaf;      // indica se é folha
    int grau;            // grau da B-árvore (M)

    public Node(int grau, boolean isLeaf) {
        this.grau = grau;
        this.isLeaf = isLeaf;
        this.keys = new int[grau - 1];
        this.children = new Node[grau];
        this.numKeys = 0;
    }

    public void print(String prefix) {
        System.out.print(prefix + "[ ");
        for (int i = 0; i < numKeys; i++) {
            System.out.print(keys[i] + " ");
        }
        System.out.println("]");
        if (!isLeaf) {
            for (int i = 0; i <= numKeys; i++) {
                if (children[i] != null) children[i].print(prefix + "   ");
            }
        }
    }
}
