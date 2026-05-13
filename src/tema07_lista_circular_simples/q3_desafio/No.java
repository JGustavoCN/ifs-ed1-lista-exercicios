// src/tema07_lista_circular_simples/q3_desafio/No.java
package tema07_lista_circular_simples.q3_desafio;

public class No {
    Processo processo;
    No proximo;

    public No(Processo processo) {
        this.processo = processo;
        this.proximo = null;
    }
}
