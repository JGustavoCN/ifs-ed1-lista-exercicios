// src/tema05_lista_simples/q1_conceito/CorreiaTransportadora.java
package tema05_lista_simples.q1_conceito;

/**
 * Classe CorreiaTransportadora — Lista Simplesmente Encadeada de caixas.
 *
 * Mantém um ponteiro 'cabeca' para o primeiro nó e um contador 'tamanho'.
 * Demonstra inserção no início (O(1)) e no final (O(n)) sem capacidade fixa.
 *
 * Referência: Goodrich & Tamassia — Cap. 3.2 (Singly Linked Lists)
 *             Cormen — Seção 10.2 (Linked Lists)
 */
public class CorreiaTransportadora {

    No cabeca;       // Ponteiro para a primeira caixa da correia (null = vazia)
    int tamanho;     // Quantidade de caixas na correia

    /**
     * Construtor: inicializa a correia vazia.
     */
    public CorreiaTransportadora() {
        this.cabeca = null;
        this.tamanho = 0;
    }

    /**
     * Insere uma nova caixa no INÍCIO da correia.
     *
     * Mecanismo:
     * 1. Cria um novo nó com o código.
     * 2. O 'proximo' do novo nó aponta para a cabeça atual.
     * 3. A cabeça passa a ser o novo nó.
     *
     * Complexidade: O(1) — nenhuma travessia é necessária.
     *
     * @param codigo código de identificação da nova caixa
     */
    public void adicionarNoInicio(String codigo) {
        No novoNo = new No(codigo);
        novoNo.proximo = this.cabeca; // Novo nó aponta para a antiga cabeça
        this.cabeca = novoNo;         // Atualiza a cabeça para o novo nó
        this.tamanho++;

        System.out.println("[+] Caixa '" + codigo + "' adicionada no INÍCIO da correia.");
    }

    /**
     * Insere uma nova caixa no FINAL da correia.
     *
     * Mecanismo:
     * 1. Se a correia estiver vazia, o novo nó se torna a cabeça.
     * 2. Caso contrário, percorre do início ao fim até encontrar o último nó
     *    (aquele cujo 'proximo' é null) e conecta o novo nó ali.
     *
     * Complexidade: O(n) — precisa percorrer todos os nós existentes.
     *
     * @param codigo código de identificação da nova caixa
     */
    public void adicionarNoFim(String codigo) {
        No novoNo = new No(codigo);

        // Caso especial: correia vazia — o novo nó é a cabeça
        if (this.cabeca == null) {
            this.cabeca = novoNo;
        } else {
            // Percorre até encontrar o último nó
            No atual = this.cabeca;
            while (atual.proximo != null) {
                atual = atual.proximo;
            }
            // 'atual' agora é o último nó — engata a nova caixa
            atual.proximo = novoNo;
        }
        this.tamanho++;

        System.out.println("[+] Caixa '" + codigo + "' adicionada no FINAL da correia.");
    }

    /**
     * Exibe a correia transportadora no formato encadeado:
     * [CX-001] -> [CX-002] -> ... -> null
     *
     * Percorre a lista do primeiro ao último nó usando a referência 'proximo'.
     */
    public void exibirCorreia() {
        System.out.print("   Correia: ");

        if (this.cabeca == null) {
            System.out.println("(vazia) -> null");
            return;
        }

        No atual = this.cabeca;
        while (atual != null) {
            System.out.print("[" + atual.codigo + "]");
            if (atual.proximo != null) {
                System.out.print(" -> ");
            }
            atual = atual.proximo;
        }
        System.out.println(" -> null");
    }
}
