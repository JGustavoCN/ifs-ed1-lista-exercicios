// src/tema06_lista_dupla/q3_desafio/NoDuplo.java
package tema06_lista_dupla.q3_desafio;

public class NoDuplo {
    String musica;
    NoDuplo anterior;
    NoDuplo proximo;

    public NoDuplo(String musica, NoDuplo anterior, NoDuplo proximo) {
        this.musica = musica;
        this.anterior = anterior;
        this.proximo = proximo;
    }
}
