// src/tema08_lista_circular_dupla/q2_pratica/PlayerPremium.java
package tema08_lista_circular_dupla.q2_pratica;

/**
 * Classe PlayerPremium — Navegação cíclica bidirecional.
 */
public class PlayerPremium {
    private NoDuplo head;
    private NoDuplo musicaAtual;
    private int total;

    public PlayerPremium() {
        head = null;
        musicaAtual = null;
        total = 0;
    }

    public void adicionar(Musica m) {
        NoDuplo novo = new NoDuplo(m);
        if (head == null) {
            head = novo;
            novo.proximo = novo;
            novo.anterior = novo;
            musicaAtual = novo;
        } else {
            NoDuplo tail = head.anterior;
            novo.proximo = head;
            novo.anterior = tail;
            tail.proximo = novo;
            head.anterior = novo;
        }
        total++;
    }

    public void proxima() {
        if (musicaAtual != null) {
            musicaAtual = musicaAtual.proximo;
            System.out.println("Tocando: " + musicaAtual.dado);
        }
    }

    public void anterior() {
        if (musicaAtual != null) {
            musicaAtual = musicaAtual.anterior;
            System.out.println("Tocando: " + musicaAtual.dado);
        }
    }

    public Musica getTocando() {
        return musicaAtual != null ? musicaAtual.dado : null;
    }

    public int getQuantidade() {
        return total;
    }
}
