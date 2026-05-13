// src/04_generics/q3_desafio/RelatorioUtil.java
package q3_desafio;

import java.util.ArrayList;

/**
 * Questão 12 — Classe utilitária com método que usa Wildcards.
 *
 * O método calcularValorTotal aceita ArrayList<? extends Produto>, o que
 * permite receber ArrayList<Eletronico>, ArrayList<Livro>, ArrayList<Roupa>
 * ou qualquer outra lista de subtipos de Produto.
 *
 * Sem o Wildcard, seria necessário usar ArrayList<Produto>, e como Generics
 * em Java são INVARIANTES (ArrayList<Eletronico> NÃO é subtipo de
 * ArrayList<Produto>), o método não compilaria para listas específicas.
 *
 * Referência: Goodrich & Tamassia — Cap. 2.5.3 (Wildcards)
 *             Oracle Docs — "Wildcards" e "Upper Bounded Wildcards"
 */
public class RelatorioUtil {

    /**
     * Calcula o valor total de qualquer lista de subtipos de Produto.
     *
     * O Wildcard '? extends Produto' é a chave: ele diz ao compilador
     * "aceite qualquer ArrayList cujo tipo seja Produto ou um subtipo".
     *
     * Internamente, só podemos LEITURA dessa lista (princípio PECS:
     * Producer Extends, Consumer Super). Não podemos adicionar elementos
     * porque o compilador não sabe o tipo exato de '?'.
     *
     * @param produtos Lista de qualquer subtipo de Produto.
     * @return A soma dos preços de todos os produtos.
     */
    public static double calcularValorTotal(ArrayList<? extends Produto> produtos) {
        double total = 0.0;

        for (Produto p : produtos) {
            // O Wildcard garante que cada elemento é pelo menos um Produto,
            // então getPreco() está disponível sem casting.
            total += p.getPreco();
        }

        return total;
    }
}
