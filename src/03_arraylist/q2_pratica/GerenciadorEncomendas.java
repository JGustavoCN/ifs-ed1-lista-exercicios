// src/03_arraylist/q2_pratica/GerenciadorEncomendas.java
package q2_pratica;

import java.util.ArrayList;

/**
 * Questão 8 — Gerenciador de Encomendas de Transportadora (Prática)
 *
 * Encapsula um ArrayList<String> para gerenciar códigos de rastreio de
 * encomendas, demonstrando os principais métodos da API Collections:
 * add(), add(index, element), get(), indexOf(), contains(), remove(Object) e size().
 *
 * O tratamento de exceções (IndexOutOfBoundsException) segue o padrão
 * recomendado por Goodrich & Tamassia para operações de acesso por índice.
 *
 * Referência: Goodrich & Tamassia — Cap. 7.2 (Array Lists)
 */
public class GerenciadorEncomendas {

    private ArrayList<String> encomendas;

    /**
     * Inicializa o gerenciador com uma lista vazia de encomendas.
     */
    public GerenciadorEncomendas() {
        this.encomendas = new ArrayList<>();
    }

    /**
     * Registra uma nova encomenda ao final da lista.
     * Rejeita códigos duplicados verificando com contains() — custo O(n).
     *
     * @param codigoRastreio Código único de rastreio da encomenda.
     */
    public void registrar(String codigoRastreio) {
        if (encomendas.contains(codigoRastreio)) {
            System.out.println("[REJEITADO] Código \"" + codigoRastreio + "\" já existe na lista. Duplicatas não são permitidas.");
            return;
        }

        encomendas.add(codigoRastreio);
        System.out.println("[REGISTRADO] Encomenda \"" + codigoRastreio + "\" adicionada na posição " + (encomendas.size() - 1) + ".");
    }

    /**
     * Insere uma encomenda prioritária em uma posição específica.
     * Internamente, o ArrayList usa System.arraycopy() para deslocar
     * todos os elementos subsequentes uma posição para a direita — custo O(n).
     *
     * @param posicao        Índice onde a encomenda será inserida.
     * @param codigoRastreio Código de rastreio da encomenda urgente.
     */
    public void inserirUrgente(int posicao, String codigoRastreio) {
        if (encomendas.contains(codigoRastreio)) {
            System.out.println("[REJEITADO] Código \"" + codigoRastreio + "\" já existe na lista.");
            return;
        }

        try {
            encomendas.add(posicao, codigoRastreio);
            System.out.println("[URGENTE] Encomenda \"" + codigoRastreio + "\" inserida na posição " + posicao + ".");
        } catch (IndexOutOfBoundsException e) {
            System.out.println("[ERRO] Posição " + posicao + " inválida! Intervalo válido: 0 a " + encomendas.size() + ". (" + e.getMessage() + ")");
        }
    }

    /**
     * Consulta o código de rastreio na posição indicada.
     * Trata IndexOutOfBoundsException para posições fora do intervalo.
     *
     * @param posicao Índice da encomenda a ser consultada.
     * @return O código de rastreio, ou null se a posição for inválida.
     */
    public String consultar(int posicao) {
        try {
            String codigo = encomendas.get(posicao);
            System.out.println("[CONSULTA] Posição " + posicao + ": \"" + codigo + "\".");
            return codigo;
        } catch (IndexOutOfBoundsException e) {
            System.out.println("[ERRO] Posição " + posicao + " inválida! Intervalo válido: 0 a " + (encomendas.size() - 1) + ". (" + e.getMessage() + ")");
            return null;
        }
    }

    /**
     * Localiza a posição (índice) de uma encomenda pelo código de rastreio.
     * Usa indexOf() que percorre a lista sequencialmente — custo O(n).
     *
     * @param codigoRastreio Código de rastreio a ser localizado.
     * @return O índice da encomenda, ou -1 se não encontrada.
     */
    public int localizar(String codigoRastreio) {
        int indice = encomendas.indexOf(codigoRastreio);

        if (indice >= 0) {
            System.out.println("[LOCALIZADO] Encomenda \"" + codigoRastreio + "\" encontrada na posição " + indice + ".");
        } else {
            System.out.println("[NÃO ENCONTRADO] Encomenda \"" + codigoRastreio + "\" não está na lista.");
        }

        return indice;
    }

    /**
     * Remove (despacha) uma encomenda da lista pelo código de rastreio.
     * Usa remove(Object) que localiza e remove o elemento — custo O(n)
     * pois precisa buscar o objeto e depois deslocar os subsequentes.
     *
     * @param codigoRastreio Código de rastreio da encomenda a ser despachada.
     */
    public void despachar(String codigoRastreio) {
        boolean removido = encomendas.remove(codigoRastreio);

        if (removido) {
            System.out.println("[DESPACHADO] Encomenda \"" + codigoRastreio + "\" removida da lista. Restam " + encomendas.size() + " encomendas.");
        } else {
            System.out.println("[ERRO] Encomenda \"" + codigoRastreio + "\" não encontrada na lista.");
        }
    }

    /**
     * Exibe o painel completo de encomendas pendentes.
     */
    public void exibirPainel() {
        System.out.println("\n======== PAINEL DE ENCOMENDAS ========");
        System.out.println("Total pendente: " + encomendas.size() + " encomenda(s)");
        System.out.println("--------------------------------------");

        if (encomendas.isEmpty()) {
            System.out.println("  (nenhuma encomenda pendente)");
        } else {
            for (int i = 0; i < encomendas.size(); i++) {
                System.out.println("  [" + i + "] " + encomendas.get(i));
            }
        }

        System.out.println("======================================\n");
    }

    public int getQuantidade() {
        return encomendas.size();
    }
}
