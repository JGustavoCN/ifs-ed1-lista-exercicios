// src/06_lista_dupla/q3_desafio/PlaylistDupla.java
package q3_desafio;

/**
 * Classe PlaylistDupla — Lista Duplamente Encadeada com sentinelas.
 * Foco em inserção e remoção no meio da lista (manipulação quádrupla de ponteiros).
 */
public class PlaylistDupla {
    private NoDuplo header;
    private NoDuplo trailer;
    private int tamanho;

    public PlaylistDupla() {
        header = new NoDuplo(null, null, null);
        trailer = new NoDuplo(null, header, null);
        header.proximo = trailer;
        tamanho = 0;
    }

    /**
     * Adiciona no final (antes do trailer).
     */
    public void adicionar(String musica) {
        NoDuplo novo = new NoDuplo(musica, trailer.anterior, trailer);
        trailer.anterior.proximo = novo;
        trailer.anterior = novo;
        tamanho++;
    }

    /**
     * Insere uma música entre dois nós já existentes.
     * @param nova nome da nova música
     * @param anterior nome da música que deve vir ANTES
     * @param proximo nome da música que deve vir DEPOIS
     */
    public void inserirEntre(String nova, String anterior, String proximo) {
        NoDuplo noA = buscarNo(anterior);
        NoDuplo noB = buscarNo(proximo);

        if (noA != null && noB != null && noA.proximo == noB) {
            // AMARRAÇÃO QUÁDRUPLA
            NoDuplo novoNo = new NoDuplo(nova, noA, noB); // 1 e 2: novo aponta para A e B
            noA.proximo = novoNo;                        // 3: A aponta para novo
            noB.anterior = novoNo;                       // 4: B aponta para novo
            
            tamanho++;
            System.out.println("[REORDENAR] '" + nova + "' inserida entre '" + anterior + "' e '" + proximo + "'.");
        } else {
            System.out.println("[ERRO] Não foi possível inserir. Verifique se '" + anterior + "' e '" + proximo + "' são adjacentes.");
        }
    }

    /**
     * Remove uma música da lista.
     */
    public void remover(String musica) {
        NoDuplo alvo = buscarNo(musica);
        if (alvo != null) {
            // Religa os vizinhos
            alvo.anterior.proximo = alvo.proximo;
            alvo.proximo.anterior = alvo.anterior;
            
            // Ajuda o GC
            alvo.anterior = null;
            alvo.proximo = null;
            
            tamanho--;
            System.out.println("[REMOVER] '" + musica + "' removida da playlist.");
        }
    }

    private NoDuplo buscarNo(String nome) {
        NoDuplo aux = header.proximo;
        while (aux != trailer) {
            if (aux.musica.equals(nome)) return aux;
            aux = aux.proximo;
        }
        return null;
    }

    public void exibir() {
        System.out.print("Playlist: ");
        NoDuplo aux = header.proximo;
        while (aux != trailer) {
            System.out.print("[" + aux.musica + "] ");
            aux = aux.proximo;
        }
        System.out.println("(Total: " + tamanho + ")");
    }
}
