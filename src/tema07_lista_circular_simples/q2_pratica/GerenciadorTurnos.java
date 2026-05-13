// src/tema07_lista_circular_simples/q2_pratica/GerenciadorTurnos.java
package tema07_lista_circular_simples.q2_pratica;

/**
 * Classe GerenciadorTurnos — Lista Circular que gerencia turnos de jogadores.
 */
public class GerenciadorTurnos {
    private No tail;
    private No cursor; // Aponta para o jogador da vez
    private int totalJogadores;

    public GerenciadorTurnos() {
        tail = null;
        cursor = null;
        totalJogadores = 0;
    }

    public void adicionarJogador(String nome) {
        Jogador j = new Jogador(nome);
        No novo = new No(j);
        if (tail == null) {
            novo.proximo = novo;
            tail = novo;
            cursor = novo;
        } else {
            novo.proximo = tail.proximo;
            tail.proximo = novo;
            tail = novo;
        }
        totalJogadores++;
    }

    /**
     * Passa para o próximo jogador.
     */
    public Jogador proximoTurno() {
        if (cursor == null) return null;
        Jogador daVez = cursor.jogador;
        cursor = cursor.proximo; // Move para o próximo na rodada
        return daVez;
    }

    /**
     * Elimina um jogador pelo nome e ajusta a circularidade.
     */
    public void eliminarJogador(String nome) {
        if (tail == null) return;

        No atual = tail.proximo;
        No anterior = tail;
        boolean encontrado = false;

        // Procura o jogador
        for (int i = 0; i < totalJogadores; i++) {
            if (atual.jogador.nome.equals(nome)) {
                encontrado = true;
                break;
            }
            anterior = atual;
            atual = atual.proximo;
        }

        if (encontrado) {
            if (totalJogadores == 1) {
                tail = null;
                cursor = null;
            } else {
                anterior.proximo = atual.proximo;
                if (atual == tail) tail = anterior;
                if (atual == cursor) cursor = atual.proximo;
            }
            totalJogadores--;
            System.out.println("[ELIMINADO] " + nome);
        }
    }

    public void exibirJogadores() {
        if (tail == null) {
            System.out.println("Nenhum jogador na partida.");
            return;
        }
        No aux = tail.proximo;
        System.out.print("Jogadores ativos: ");
        for (int i = 0; i < totalJogadores; i++) {
            System.out.print("[" + aux.jogador.nome + "] ");
            aux = aux.proximo;
        }
        System.out.println();
    }

    public int getTotalJogadores() {
        return totalJogadores;
    }
}
