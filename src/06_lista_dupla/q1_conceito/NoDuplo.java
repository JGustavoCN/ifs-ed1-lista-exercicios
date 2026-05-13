// src/06_lista_dupla/q1_conceito/NoDuplo.java
package q1_conceito;

/**
 * Classe NoDuplo — Representa um nó em uma lista duplamente encadeada.
 * Possui referências para o nó anterior e para o próximo.
 */
public class NoDuplo {
    String url;
    NoDuplo anterior;
    NoDuplo proximo;

    public NoDuplo(String url, NoDuplo anterior, NoDuplo proximo) {
        this.url = url;
        this.anterior = anterior;
        this.proximo = proximo;
    }
}
