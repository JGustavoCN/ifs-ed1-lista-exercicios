// src/tema06_lista_dupla/q2_pratica/NoDuplo.java
package tema06_lista_dupla.q2_pratica;

public class NoDuplo {
    String acao;
    NoDuplo anterior;
    NoDuplo proximo;

    public NoDuplo(String acao) {
        this.acao = acao;
        this.anterior = null;
        this.proximo = null;
    }
}
