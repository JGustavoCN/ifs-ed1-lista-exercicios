// src/07_lista_circular_simples/q1_conceito/PlayerCircular.java
package q1_conceito;

/**
 * Classe PlayerCircular — Implementa uma Lista Circular Simplesmente Encadeada
 * mantendo apenas o ponteiro para o 'tail' (último nó).
 * 
 * Referência: Goodrich & Tamassia — Cap. 3.4 (Circularly Linked Lists)
 */
public class PlayerCircular {
    private No tail; // Ponteiro para o último nó. tail.proximo é a cabeça.
    private int tamanho;

    public PlayerCircular() {
        tail = null;
        tamanho = 0;
    }

    /**
     * Adiciona uma música ao final da lista.
     */
    public void adicionarMusica(String nome) {
        No novo = new No(nome);
        if (tail == null) {
            novo.proximo = novo; // Primeiro nó aponta para si mesmo
            tail = novo;
        } else {
            novo.proximo = tail.proximo; // Novo nó aponta para a cabeça
            tail.proximo = novo;         // Antigo tail aponta para o novo
            tail = novo;                 // Novo nó se torna o tail
        }
        tamanho++;
        System.out.println("[ADD] " + nome);
    }

    /**
     * Exibe a playlist. Usa uma condição de parada especial para evitar loops.
     */
    public void exibirPlaylist() {
        if (tail == null) {
            System.out.println("Playlist vazia.");
            return;
        }

        System.out.print("Playlist Circular: ");
        No cabeca = tail.proximo;
        No atual = cabeca;

        do {
            System.out.print("[" + atual.musica + "] -> ");
            atual = atual.proximo;
        } while (atual != cabeca); // Condição de paragem: voltou ao início

        System.out.println("(REPETIR)");
    }

    public int getTamanho() {
        return tamanho;
    }
}
