// src/07_lista_circular_simples/q2_pratica/No.java
package q2_pratica;

public class No {
    Jogador jogador;
    No proximo;

    public No(Jogador jogador) {
        this.jogador = jogador;
        this.proximo = null;
    }
}
