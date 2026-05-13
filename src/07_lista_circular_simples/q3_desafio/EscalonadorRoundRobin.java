// src/07_lista_circular_simples/q3_desafio/EscalonadorRoundRobin.java
package q3_desafio;

/**
 * Classe EscalonadorRoundRobin — Implementa o algoritmo de escalonamento cíclico.
 */
public class EscalonadorRoundRobin {
    private No tail;
    private int totalProcessos;
    private int quantum;

    public EscalonadorRoundRobin(int quantum) {
        this.tail = null;
        this.totalProcessos = 0;
        this.quantum = quantum;
    }

    public void adicionarProcesso(int id, String nome, int tempo) {
        Processo p = new Processo(id, nome, tempo);
        No novo = new No(p);
        if (tail == null) {
            novo.proximo = novo;
            tail = novo;
        } else {
            novo.proximo = tail.proximo;
            tail.proximo = novo;
            tail = novo;
        }
        totalProcessos++;
    }

    public void executar() {
        if (tail == null) {
            System.out.println("Nenhum processo para escalonar.");
            return;
        }

        System.out.println("Iniciando escalonamento (Quantum: " + quantum + "ms)...");
        No atual = tail.proximo;
        No anterior = tail;

        while (totalProcessos > 0) {
            Processo p = atual.processo;
            System.out.println("Executando " + p.nome + "...");
            
            if (p.tempoRestante > quantum) {
                p.tempoRestante -= quantum;
                anterior = atual;
                atual = atual.proximo;
            } else {
                System.out.println(" >> Processo " + p.nome + " CONCLUÍDO!");
                // Remover nó
                if (totalProcessos == 1) {
                    tail = null;
                    totalProcessos = 0;
                } else {
                    anterior.proximo = atual.proximo;
                    if (atual == tail) tail = anterior;
                    atual = atual.proximo;
                    totalProcessos--;
                }
            }
            exibirFila();
        }
        System.out.println("Todos os processos foram concluídos.");
    }

    private void exibirFila() {
        if (tail == null) {
            System.out.println("Fila de prontos: [Vazia]");
            return;
        }
        System.out.print("Fila de prontos: ");
        No aux = tail.proximo;
        for (int i = 0; i < totalProcessos; i++) {
            System.out.print(aux.processo + " ");
            aux = aux.proximo;
        }
        System.out.println();
    }
}
