// src/08_lista_circular_dupla/q1_conceito/CarrosselCircular.java
package q1_conceito;

/**
 * Classe CarrosselCircular — Implementa uma Lista Circular Duplamente Encadeada.
 * Foco na conexão head-tail e tail-head sem uso de null.
 */
public class CarrosselCircular {
    private NoDuplo head;
    private int total;

    public CarrosselCircular() {
        head = null;
        total = 0;
    }

    /**
     * Adiciona uma imagem ao carrossel.
     * Se for a primeira, aponta para si mesma.
     * Se não, insere no final ajustando 4 ponteiros.
     */
    public void adicionarImagem(String nome) {
        NoDuplo novo = new NoDuplo(nome);
        if (head == null) {
            head = novo;
            novo.proximo = novo;
            novo.anterior = novo;
        } else {
            NoDuplo tail = head.anterior; // Em uma lista circular dupla, head.prev é o tail
            
            // Liga novo nó entre o tail atual e o head
            novo.proximo = head;
            novo.anterior = tail;
            
            tail.proximo = novo;
            head.anterior = novo;
        }
        total++;
        System.out.println("[ADD] Imagem: " + nome);
    }

    /**
     * Exibe o carrossel no sentido horário.
     */
    public void exibirHorario() {
        if (head == null) {
            System.out.println("Carrossel vazio.");
            return;
        }
        System.out.print("Carrossel (Horário): ");
        NoDuplo aux = head;
        for (int i = 0; i < total; i++) {
            System.out.print(aux.nomeImagem + (i < total - 1 ? " <-> " : ""));
            aux = aux.proximo;
        }
        System.out.println(" (volta ao início)");
    }

    /**
     * Exibe o carrossel no sentido anti-horário.
     */
    public void exibirAntiHorario() {
        if (head == null) return;
        System.out.print("Carrossel (Anti-Horário): ");
        NoDuplo aux = head.anterior; // Começa pelo fim (tail)
        for (int i = 0; i < total; i++) {
            System.out.print(aux.nomeImagem + (i < total - 1 ? " <-> " : ""));
            aux = aux.anterior;
        }
        System.out.println(" (volta ao fim)");
    }
}
