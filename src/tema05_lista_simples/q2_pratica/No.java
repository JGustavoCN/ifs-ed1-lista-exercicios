// src/tema05_lista_simples/q2_pratica/No.java
package tema05_lista_simples.q2_pratica;

/**
 * Classe No — Nó da lista encadeada de processos.
 *
 * Armazena um objeto Processo e uma referência para o próximo nó.
 * Diferente da Q13 (onde o dado era String), aqui o nó encapsula
 * um objeto de domínio completo.
 *
 * Referência: Goodrich & Tamassia — Cap. 3.2 (Singly Linked Lists)
 */
public class No {

    Processo dado;   // Processo armazenado neste nó
    No proximo;      // Referência para o próximo nó

    /**
     * Construtor: cria um nó com o processo informado.
     *
     * @param dado o processo a ser armazenado
     */
    public No(Processo dado) {
        this.dado = dado;
        this.proximo = null;
    }
}
