// src/tema02_array_primitivo/q2_pratica/Playlist.java
package tema02_array_primitivo.q2_pratica;

public class Playlist {

    private String[] musicas;
    private int tamanho;

    /**
     * Cria uma playlist com capacidade fixa de 7 músicas.
     */
    public Playlist() {
        this.musicas = new String[7];
        this.tamanho = 0;
    }

    /**
     * Adiciona uma música no final da playlist. Operação O(1).
     *
     * @param musica Nome da música a ser adicionada.
     * @return O número de shifts realizados (sempre 0 para inserção no final).
     */
    public int adicionarNoFim(String musica) {
        if (tamanho >= musicas.length) {
            System.out.println("[ERRO] Playlist cheia! Capacidade máxima: " + musicas.length + ". Não é possível adicionar \"" + musica + "\".");
            return 0;
        }

        musicas[tamanho] = musica;
        tamanho++;
        System.out.println("[OK] \"" + musica + "\" adicionada no final (posição " + (tamanho - 1) + "). Shifts: 0");
        return 0;
    }

    /**
     * Insere uma música em uma posição específica, deslocando (shift) os
     * elementos subsequentes para a direita. Operação O(n) no pior caso.
     *
     * @param posicao Índice onde a música será inserida (0 a tamanho).
     * @param musica  Nome da música a ser inserida.
     * @return O número de shifts realizados.
     */
    public int inserirNaPosicao(int posicao, String musica) {
        if (tamanho >= musicas.length) {
            System.out.println("[ERRO] Playlist cheia! Não é possível inserir \"" + musica + "\".");
            return 0;
        }

        if (posicao < 0 || posicao > tamanho) {
            System.out.println("[ERRO] Posição " + posicao + " inválida! Intervalo válido: 0 a " + tamanho + ".");
            return 0;
        }

        int shifts = 0;

        // Desloca todos os elementos a partir de 'posicao' uma casa para a direita
        // Começa do final para não sobrescrever dados
        for (int i = tamanho - 1; i >= posicao; i--) {
            musicas[i + 1] = musicas[i];
            shifts++;
        }

        musicas[posicao] = musica;
        tamanho++;
        System.out.println("[OK] \"" + musica + "\" inserida na posição " + posicao + ". Shifts para a direita: " + shifts);
        return shifts;
    }

    /**
     * Remove a música na posição indicada, deslocando (shift) os elementos
     * subsequentes para a esquerda para preencher o buraco. Operação O(n) no pior caso.
     *
     * @param posicao Índice da música a ser removida (0 a tamanho-1).
     * @return O número de shifts realizados.
     */
    public int removerDaPosicao(int posicao) {
        if (posicao < 0 || posicao >= tamanho) {
            System.out.println("[ERRO] Posição " + posicao + " inválida! Intervalo válido: 0 a " + (tamanho - 1) + ".");
            return 0;
        }

        String removida = musicas[posicao];
        int shifts = 0;

        // Desloca todos os elementos após 'posicao' uma casa para a esquerda
        for (int i = posicao; i < tamanho - 1; i++) {
            musicas[i] = musicas[i + 1];
            shifts++;
        }

        // Limpa a última posição que agora é lixo (duplicata do penúltimo)
        musicas[tamanho - 1] = null;
        tamanho--;

        System.out.println("[OK] \"" + removida + "\" removida da posição " + posicao + ". Shifts para a esquerda: " + shifts);
        return shifts;
    }

    /**
     * Exibe apenas as músicas válidas (do índice 0 até tamanho-1).
     */
    public void exibir() {
        System.out.println("\n♫ Playlist (" + tamanho + "/" + musicas.length + " músicas):");
        if (tamanho == 0) {
            System.out.println("  (vazia)");
        } else {
            for (int i = 0; i < tamanho; i++) {
                System.out.println("  [" + i + "] " + musicas[i]);
            }
        }
        System.out.println();
    }

    public int getTamanho() {
        return tamanho;
    }

    public int getCapacidade() {
        return musicas.length;
    }
}
