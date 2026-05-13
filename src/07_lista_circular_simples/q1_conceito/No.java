// src/07_lista_circular_simples/q1_conceito/No.java
package q1_conceito;

public class No {
    String musica;
    No proximo;

    public No(String musica) {
        this.musica = musica;
        this.proximo = null;
    }
}
