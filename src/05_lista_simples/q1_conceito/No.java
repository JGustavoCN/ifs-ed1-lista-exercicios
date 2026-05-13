// src/05_lista_simples/q1_conceito/No.java
package q1_conceito;

/**
 * Classe No — Representa uma caixa na correia transportadora.
 *
 * Cada nó armazena um dado (código da caixa) e uma referência (ponteiro)
 * para o próximo nó da sequência. Essa é a unidade fundamental de uma
 * Lista Simplesmente Encadeada (Singly Linked List).
 *
 * Referência: Goodrich & Tamassia — Cap. 3.2 (Singly Linked Lists)
 *             Cormen — Seção 10.2 (Linked Lists)
 */
public class No {

    String codigo;   // Dado armazenado: código de identificação da caixa
    No proximo;      // Referência (ponteiro) para o próximo nó na lista

    /**
     * Construtor: cria um novo nó com o código informado.
     * O ponteiro 'proximo' é inicializado como null (nó isolado).
     *
     * @param codigo código de identificação da caixa
     */
    public No(String codigo) {
        this.codigo = codigo;
        this.proximo = null; // Ainda não está conectado a nenhum outro nó
    }
}
