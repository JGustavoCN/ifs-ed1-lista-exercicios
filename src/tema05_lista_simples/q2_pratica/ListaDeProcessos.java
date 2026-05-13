// src/tema05_lista_simples/q2_pratica/ListaDeProcessos.java
package tema05_lista_simples.q2_pratica;

/**
 * Classe ListaDeProcessos — Gerencia processos do S.O. usando
 * uma Lista Simplesmente Encadeada.
 *
 * Operações:
 *   - iniciarProcesso():       inserção no início — O(1)
 *   - iniciarProcessoNoFim():  inserção no final  — O(n)
 *   - finalizarPrimeiro():     remoção da cabeça   — O(1)
 *
 * Referência: Goodrich & Tamassia — Cap. 3.2 (Singly Linked Lists)
 *             Cormen — Seção 10.2 (Linked Lists)
 */
public class ListaDeProcessos {

    No cabeca;       // Ponteiro para o primeiro processo da lista
    int tamanho;     // Quantidade de processos ativos

    /**
     * Construtor: inicializa a lista de processos vazia.
     */
    public ListaDeProcessos() {
        this.cabeca = null;
        this.tamanho = 0;
    }

    /**
     * Insere um processo no INÍCIO da lista.
     * Simula a priorização do processo mais recente.
     *
     * Complexidade: O(1) — apenas manipulação de ponteiros.
     *
     * @param p o processo a ser iniciado
     */
    public void iniciarProcesso(Processo p) {
        No novoNo = new No(p);
        novoNo.proximo = this.cabeca;
        this.cabeca = novoNo;
        this.tamanho++;

        System.out.println("[INIT] Processo iniciado (início): " + p);
    }

    /**
     * Insere um processo no FINAL da lista.
     * Requer travessia completa para encontrar o último nó.
     *
     * Complexidade: O(n) — percorre todos os nós existentes.
     *
     * @param p o processo a ser iniciado no final
     */
    public void iniciarProcessoNoFim(Processo p) {
        No novoNo = new No(p);

        if (this.cabeca == null) {
            this.cabeca = novoNo;
        } else {
            No atual = this.cabeca;
            while (atual.proximo != null) {
                atual = atual.proximo;
            }
            atual.proximo = novoNo;
        }
        this.tamanho++;

        System.out.println("[INIT] Processo iniciado (final):  " + p);
    }

    /**
     * Finaliza (remove) o processo na cabeça da lista.
     *
     * Mecanismo:
     * 1. Guarda referência ao processo da cabeça.
     * 2. Avança a cabeça para o próximo nó.
     * 3. O nó antigo fica sem referência → Garbage Collector recolhe.
     *
     * Complexidade: O(1) — apenas redireciona o ponteiro.
     *
     * @return o processo finalizado, ou null se a lista estiver vazia
     */
    public Processo finalizarPrimeiro() {
        if (this.cabeca == null) {
            System.out.println("[AVISO] Nenhum processo ativo para finalizar!");
            return null;
        }

        Processo processoFinalizado = this.cabeca.dado;
        this.cabeca = this.cabeca.proximo; // Avança a cabeça
        this.tamanho--;

        System.out.println("[KILL] Processo finalizado: " + processoFinalizado);
        return processoFinalizado;
    }

    /**
     * Exibe todos os processos ativos em formato encadeado.
     */
    public void exibirProcessos() {
        System.out.print("   Processos: ");

        if (this.cabeca == null) {
            System.out.println("(nenhum processo ativo)");
            return;
        }

        No atual = this.cabeca;
        while (atual != null) {
            System.out.print("[" + atual.dado + "]");
            if (atual.proximo != null) {
                System.out.print(" -> ");
            }
            atual = atual.proximo;
        }
        System.out.println(" -> null");
    }

    /**
     * Retorna a quantidade de processos ativos.
     *
     * @return tamanho da lista
     */
    public int contarProcessos() {
        return this.tamanho;
    }
}
