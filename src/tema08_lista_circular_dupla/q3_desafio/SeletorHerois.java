// src/tema08_lista_circular_dupla/q3_desafio/SeletorHerois.java
package tema08_lista_circular_dupla.q3_desafio;

/**
 * Classe SeletorHerois — Lista Circular Dupla com remoção rigorosa.
 */
public class SeletorHerois {
    private NoDuplo head;
    private int total;

    public SeletorHerois() {
        head = null;
        total = 0;
    }

    public void adicionar(Heroi h) {
        NoDuplo novo = new NoDuplo(h);
        if (head == null) {
            head = novo;
            novo.proximo = novo;
            novo.anterior = novo;
        } else {
            NoDuplo tail = head.anterior;
            novo.proximo = head;
            novo.anterior = tail;
            tail.proximo = novo;
            head.anterior = novo;
        }
        total++;
    }

    public void remover(String nome) {
        if (head == null) return;

        NoDuplo atual = head;
        boolean encontrado = false;

        for (int i = 0; i < total; i++) {
            if (atual.dado.nome.equals(nome)) {
                encontrado = true;
                break;
            }
            atual = atual.proximo;
        }

        if (encontrado) {
            System.out.println("[REMOVER] Herói: " + nome);
            if (total == 1) {
                head = null;
            } else {
                // Religa vizinhos
                atual.anterior.proximo = atual.proximo;
                atual.proximo.anterior = atual.anterior;
                
                // Se o removido era a cabeça, atualiza head
                if (atual == head) {
                    head = atual.proximo;
                }
            }
            total--;
        } else {
            System.out.println("[AVISO] Herói '" + nome + "' não encontrado.");
        }
    }

    public void exibirOpcoes() {
        if (head == null) {
            System.out.println("Nenhum herói disponível.");
            return;
        }
        System.out.print("Seletor: ");
        NoDuplo aux = head;
        for (int i = 0; i < total; i++) {
            System.out.print("[" + aux.dado.nome + "] ");
            aux = aux.proximo;
        }
        System.out.println();
    }
}
