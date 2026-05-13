// src/04_generics/q2_pratica/Cofre.java
package q2_pratica;

import java.util.ArrayList;

/**
 * Questão 11 — Cofre Digital Parametrizado (Prática)
 *
 * Classe genérica que simula um cofre digital com segurança de tipos.
 * O parâmetro T define o tipo de item que o cofre aceita, garantindo
 * que um Cofre<String> jamais receba um Double acidentalmente.
 *
 * Após o Type Erasure, T é substituído por Object no bytecode, mas o
 * compilador insere checkcast automáticos. Apenas UMA classe Cofre
 * existe no bytecode — não há Cofre_String, Cofre_Double, etc.
 *
 * Referência: Goodrich & Tamassia — Cap. 2.5 (Generics)
 *             Oracle Docs — "Generic Types"
 */
public class Cofre<T> {

    private ArrayList<T> itens;
    private String dono;
    private int capacidadeMaxima;

    /**
     * Inicializa um cofre digital para o proprietário especificado.
     *
     * @param dono              Nome do proprietário do cofre.
     * @param capacidadeMaxima  Número máximo de itens que o cofre suporta.
     */
    public Cofre(String dono, int capacidadeMaxima) {
        this.dono = dono;
        this.capacidadeMaxima = capacidadeMaxima;
        this.itens = new ArrayList<>();
    }

    /**
     * Armazena um item no cofre.
     * Rejeita duplicatas (contains() usa equals() internamente) e
     * respeita o limite de capacidade.
     *
     * @param item O item a ser guardado (tipo T).
     * @return true se guardado com sucesso, false caso contrário.
     */
    public boolean guardar(T item) {
        if (itens.size() >= capacidadeMaxima) {
            System.out.println("[COFRE DE " + dono.toUpperCase() + "] Cofre lotado! " +
                    "Capacidade máxima de " + capacidadeMaxima + " itens atingida.");
            return false;
        }

        if (itens.contains(item)) {
            System.out.println("[COFRE DE " + dono.toUpperCase() + "] Item \"" + item +
                    "\" já existe no cofre. Duplicata rejeitada.");
            return false;
        }

        itens.add(item);
        System.out.println("[COFRE DE " + dono.toUpperCase() + "] Item \"" + item +
                "\" guardado com sucesso. (" + itens.size() + "/" + capacidadeMaxima + ")");
        return true;
    }

    /**
     * Recupera (sem remover) o item na posição indicada.
     * O retorno é do tipo T — nenhum casting é necessário.
     *
     * @param posicao Índice do item desejado.
     * @return O item na posição, ou null se a posição for inválida.
     */
    public T recuperar(int posicao) {
        try {
            T item = itens.get(posicao);
            System.out.println("[COFRE DE " + dono.toUpperCase() + "] Recuperado na posição " +
                    posicao + ": \"" + item + "\".");
            return item;
        } catch (IndexOutOfBoundsException e) {
            System.out.println("[COFRE DE " + dono.toUpperCase() + "] Posição " + posicao +
                    " inválida! Intervalo válido: 0 a " + (itens.size() - 1) +
                    ". (" + e.getMessage() + ")");
            return null;
        }
    }

    /**
     * Verifica se um item específico está armazenado no cofre.
     * Usa contains() que internamente percorre a lista com equals() — O(n).
     *
     * @param item O item a ser procurado.
     * @return true se o item estiver no cofre.
     */
    public boolean contem(T item) {
        boolean encontrado = itens.contains(item);
        if (encontrado) {
            System.out.println("[COFRE DE " + dono.toUpperCase() + "] Item \"" + item +
                    "\" encontrado no cofre.");
        } else {
            System.out.println("[COFRE DE " + dono.toUpperCase() + "] Item \"" + item +
                    "\" NÃO encontrado no cofre.");
        }
        return encontrado;
    }

    /**
     * Remove e retorna o item na posição indicada.
     * Após a remoção, os elementos subsequentes são deslocados (shift) para a esquerda.
     *
     * @param posicao Índice do item a ser removido.
     * @return O item removido, ou null se a posição for inválida.
     */
    public T remover(int posicao) {
        try {
            T item = itens.remove(posicao);
            System.out.println("[COFRE DE " + dono.toUpperCase() + "] Item \"" + item +
                    "\" removido da posição " + posicao + ". Restam " +
                    itens.size() + " item(ns).");
            return item;
        } catch (IndexOutOfBoundsException e) {
            System.out.println("[COFRE DE " + dono.toUpperCase() + "] Posição " + posicao +
                    " inválida para remoção! (" + e.getMessage() + ")");
            return null;
        }
    }

    /**
     * Exibe o conteúdo completo do cofre, incluindo o dono, os itens
     * armazenados e o espaço disponível.
     */
    public void listarConteudo() {
        System.out.println("\n╔══════════════════════════════════════════╗");
        System.out.println("║  COFRE DE: " + dono.toUpperCase());
        System.out.println("║  Itens: " + itens.size() + "/" + capacidadeMaxima +
                " | Disponível: " + (capacidadeMaxima - itens.size()));
        System.out.println("╠══════════════════════════════════════════╣");

        if (itens.isEmpty()) {
            System.out.println("║  (cofre vazio)");
        } else {
            for (int i = 0; i < itens.size(); i++) {
                System.out.println("║  [" + i + "] " + itens.get(i));
            }
        }

        System.out.println("╚══════════════════════════════════════════╝\n");
    }
}
