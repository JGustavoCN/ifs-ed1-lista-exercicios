// src/tema05_lista_simples/q3_desafio/CentralOcorrencias.java
package tema05_lista_simples.q3_desafio;

/**
 * Classe CentralOcorrencias — Gerencia boletins de ocorrência usando uma Lista Simplesmente Encadeada.
 * 
 * Implementa operações de busca e remoção no meio da lista com tratamento de NullPointerException.
 * 
 * Referência: Goodrich & Tamassia — Cap. 3.2 (Singly Linked Lists)
 *             Cormen — Seção 10.2 (Linked Lists)
 */
public class CentralOcorrencias {
    private No cabeca;
    private int tamanho;

    public CentralOcorrencias() {
        this.cabeca = null;
        this.tamanho = 0;
    }

    /**
     * Registra um novo B.O. no final da lista.
     * 
     * @param bo o boletim de ocorrência a ser registrado
     */
    public void registrar(BoletimOcorrencia bo) {
        No novoNo = new No(bo);
        if (cabeca == null) {
            cabeca = novoNo;
        } else {
            No atual = cabeca;
            while (atual.proximo != null) {
                atual = atual.proximo;
            }
            atual.proximo = novoNo;
        }
        tamanho++;
        System.out.println("[REGISTRO] B.O. #" + bo.numero + " adicionado com sucesso.");
    }

    /**
     * Busca um B.O. pelo seu número identificador.
     * 
     * @param numero o número do boletim procurado
     * @return o BoletimOcorrencia encontrado ou null se não existir
     */
    public BoletimOcorrencia buscarPorNumero(int numero) {
        No atual = cabeca;
        while (atual != null) {
            // Verificação de segurança contra NullPointerException já implícita no loop (atual != null)
            if (atual.dado.numero == numero) {
                return atual.dado;
            }
            atual = atual.proximo;
        }
        return null;
    }

    /**
     * Remove um B.O. da lista pelo seu número.
     * Implementa a técnica do ponteiro anterior para permitir remoção no meio.
     * 
     * @param numero o número do boletim a ser removido
     * @return true se removido com sucesso, false caso contrário
     */
    public boolean removerPorNumero(int numero) {
        if (cabeca == null) {
            System.out.println("[ERRO] Lista vazia. Impossível remover.");
            return false;
        }

        // Caso especial: remoção da cabeça
        if (cabeca.dado.numero == numero) {
            System.out.println("[REMOÇÃO] B.O. #" + numero + " removido da CABEÇA.");
            cabeca = cabeca.proximo;
            tamanho--;
            return true;
        }

        // Busca com ponteiro anterior
        No anterior = cabeca;
        No atual = cabeca.proximo;

        while (atual != null) {
            if (atual.dado.numero == numero) {
                anterior.proximo = atual.proximo; // "Pula" o nó atual
                tamanho--;
                System.out.println("[REMOÇÃO] B.O. #" + numero + " removido.");
                return true;
            }
            anterior = atual;
            atual = atual.proximo;
        }

        System.out.println("[AVISO] B.O. #" + numero + " não encontrado para remoção.");
        return false;
    }

    /**
     * Exibe todos os B.O.s registrados na central.
     */
    public void listarOcorrencias() {
        System.out.println("\n--- LISTAGEM DE OCORRÊNCIAS ---");
        if (cabeca == null) {
            System.out.println("Nenhum B.O. registrado.");
            return;
        }
        No atual = cabeca;
        while (atual != null) {
            System.out.println(atual.dado);
            atual = atual.proximo;
        }
        System.out.println("-------------------------------\n");
    }

    public int totalOcorrencias() {
        return tamanho;
    }
}
