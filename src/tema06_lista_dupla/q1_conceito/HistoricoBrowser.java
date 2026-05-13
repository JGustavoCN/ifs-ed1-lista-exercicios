// src/tema06_lista_dupla/q1_conceito/HistoricoBrowser.java
package tema06_lista_dupla.q1_conceito;

/**
 * Classe HistoricoBrowser — Implementa uma Lista Duplamente Encadeada usando
 * sentinelas (header e trailer) para gerenciar o histórico de navegação.
 * 
 * Referência: Goodrich & Tamassia — Cap. 3.3 (Doubly Linked Lists)
 */
public class HistoricoBrowser {
    private NoDuplo header;  // Sentinela de início
    private NoDuplo trailer; // Sentinela de fim
    private int tamanho;

    public HistoricoBrowser() {
        // Inicializa as sentinelas
        header = new NoDuplo(null, null, null);
        trailer = new NoDuplo(null, header, null);
        header.proximo = trailer;
        tamanho = 0;
    }

    /**
     * Adiciona uma nova URL ao final do histórico (antes do trailer).
     * @param url endereço do site
     */
    public void visitar(String url) {
        NoDuplo novo = new NoDuplo(url, trailer.anterior, trailer);
        trailer.anterior.proximo = novo;
        trailer.anterior = novo;
        tamanho++;
        System.out.println("[VISITA] " + url);
    }

    /**
     * Exibe o histórico do mais antigo para o mais recente (header -> trailer).
     */
    public void exibirOrdemDireta() {
        System.out.print("Histórico (Antigo -> Novo): ");
        NoDuplo atual = header.proximo;
        while (atual != trailer) {
            System.out.print(atual.url + (atual.proximo != trailer ? " <-> " : ""));
            atual = atual.proximo;
        }
        System.out.println();
    }

    /**
     * Exibe o histórico do mais recente para o mais antigo (trailer -> header).
     * Demonstra a utilidade do ponteiro 'anterior'.
     */
    public void exibirOrdemReversa() {
        System.out.print("Histórico (Novo -> Antigo): ");
        NoDuplo atual = trailer.anterior;
        while (atual != header) {
            System.out.print(atual.url + (atual.anterior != header ? " <-> " : ""));
            atual = atual.anterior;
        }
        System.out.println();
    }

    public int getTamanho() {
        return tamanho;
    }
}
