public class ArvoreB {
    No raiz;
    int grau;

    public ArvoreB(int grau) {
        this.grau = grau;
        this.raiz = new No(grau, true);
    }


    public void inserir(int chave) {
        No r = raiz;
        if (r.numChaves == grau-1) { // Se for raiz e tiver cheia:
            No s = new No(grau, false);
            s.filhos[0] = r;
            dividirFilho(s, 0, r);
            raiz = s;
            inserirNaoCheio(s, chave);
        } else { // Se não for raiz e não tiver cheia:
            inserirNaoCheio(r, chave);
        }
    }

    private void inserirNaoCheio(No no, int chave) { // chave == value
        int i = no.numChaves-1;

        if (no.ehFolha) { // Se não for raiz:
            while (i >= 0 && chave < no.chaves[i]) {
                no.chaves[i+1] = no.chaves[i];
                i--;
            }
            no.chaves[i+1] = chave;
            no.numChaves++;
        } else { // Se for raiz:
            while (i >=0 && chave < no.chaves[i]) i--;
            i++;
            if (no.filhos[i].numChaves == grau-1) {
                dividirFilho(no, i, no.filhos[i]);
                if (chave > no.chaves[i]) i++;
            }
            inserirNaoCheio(no.filhos[i], chave);
        }
    }

    private void dividirFilho(No pai, int i, No cheio) {
        No novo = new No(grau, cheio.ehFolha);
        novo.numChaves = grau / 2 - 1;

        for (int j = 0; j< grau/2-1; j++) {
            novo.chaves[j] = cheio.chaves[j + grau/2];
        }

        if (!cheio.ehFolha) {
            for (int j = 0; j < grau/2; j++) {
                novo.filhos[j] = cheio.filhos[j+grau/2];
            }
        }

        cheio.numChaves = grau / 2 - 1;

        for (int j = pai.numChaves; j >= i + 1; j--) {
            pai.filhos[j+1] = pai.filhos[j];
        }
        pai.filhos[i + 1] = novo;

        for (int j = pai.numChaves-1; j >= i; j--) {
            pai.chaves[j+1] = pai.chaves[j];
        }

        pai.chaves[i] = cheio.chaves[grau/2-1];
        pai.numChaves++;
    }

    public void print() {
        if (raiz != null) raiz.print("");
    }
}
