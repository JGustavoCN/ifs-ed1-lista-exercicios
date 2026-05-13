// src/tema05_lista_simples/q3_desafio/No.java
package tema05_lista_simples.q3_desafio;

/**
 * Classe No — Nó da lista encadeada da central de ocorrências.
 * 
 * Armazena um objeto BoletimOcorrencia e a referência para o próximo nó.
 */
public class No {
    BoletimOcorrencia dado;
    No proximo;

    /**
     * Construtor do nó.
     * 
     * @param dado o boletim de ocorrência a ser armazenado
     */
    public No(BoletimOcorrencia dado) {
        this.dado = dado;
        this.proximo = null;
    }
}
