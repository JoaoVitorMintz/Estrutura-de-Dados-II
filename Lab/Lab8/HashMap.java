public class HashMap<K, V> {

    private static class Entry<K, V> {
        K key;
        V value;

        Entry(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }

    private Entry<K, V>[] tabela;
    private int m; 
    private int size;

    @SuppressWarnings("unchecked")
    public HashMap(int m) {
        // mantém a mesma lógica do seu código — evitar número par
        if (m % 2 == 0) {
            System.out.println("Tamanho deve ser ímpar. Usando " + (m + 1));
            m++;
        }
        this.m = m;
        this.tabela = new Entry[m];
        this.size = 0;
    }

    private int funcaoHash(K key) {
        return Math.abs(key.hashCode()) % m;
    }

    /** Rehash quando load factor > 0.75 */
    private void verificarResize() {
        double load = (double) size / m;
        if (load >= 0.75) {
            resize();
        }
    }

    @SuppressWarnings("unchecked")
    private void resize() {
        int novoM = m * 2 + 1; // mantém ímpar
        Entry<K, V>[] antigo = tabela;

        tabela = new Entry[novoM];
        m = novoM;
        size = 0;

        for (Entry<K, V> e : antigo) {
            if (e != null) {
                put(e.key, e.value); // reinsere tudo com novo mod
            }
        }
    }

    public void put(K key, V value) {
        verificarResize();

        int index = funcaoHash(key);

        while (tabela[index] != null) {
            if (tabela[index].key.equals(key)) {
                tabela[index].value = value; // substitui
                return;
            }
            index = (index + 1) % m; // linear probing
        }

        tabela[index] = new Entry<>(key, value);
        size++;
    }

    public V get(K key) {
        int index = funcaoHash(key);

        while (tabela[index] != null) {
            if (tabela[index].key.equals(key)) {
                return tabela[index].value;
            }
            index = (index + 1) % m;
        }

        return null;
    }

    public void exibirTabela() {
        System.out.println("Tabela Hash:");
        for (int i = 0; i < m; i++) {
            if (tabela[i] != null) {
                System.out.println("Índice " + i + ": " + tabela[i].key + " => " + tabela[i].value);
            } else {
                System.out.println("Índice " + i + ": Vazio");
            }
        }
    }
}
