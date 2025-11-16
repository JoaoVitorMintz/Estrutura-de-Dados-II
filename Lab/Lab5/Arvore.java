/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author USER
 */
public class Arvore {
    public No raiz;
    
    public void excluirArvore() {
        this.raiz = null;
    }
    
    public void inserir(int elemento) {
        No novoNo = new No();
        novoNo.valor = elemento;
        if(this.raiz == null) // árvore está vazia
            raiz = novoNo;
        else {
             No atual = raiz;
             No pai;
             while(true) {
              pai = atual;
                if(elemento <= atual.valor) {
                    atual = atual.esquerda;
                     if(atual == null) {
                        pai.esquerda = novoNo;
                        return;
                       }
                }
                else {
                     atual = atual.direita;
                     if (atual == null) {       
                       pai.direita = novoNo;
                       return;
                    }
                }
            }   
        }
    }
}
