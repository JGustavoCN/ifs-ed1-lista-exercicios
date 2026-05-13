// src/04_generics/q3_desafio/Produto.java
package q3_desafio;

/**
 * Questão 12 — Inventário de Loja Virtual com Limites de Tipo (Desafio)
 *
 * Classe abstrata que serve como "limite superior" (upper bound) para
 * a classe genérica Inventario<T extends Produto>.
 *
 * Quando o compilador aplica Type Erasure em <T extends Produto>,
 * T é substituído por Produto (e NÃO por Object), pois o bound
 * fornece informação suficiente para o bytecode.
 *
 * Referência: Goodrich & Tamassia — Cap. 2.5.2 (Bounded Generics)
 *             Oracle Docs — "Bounded Type Parameters"
 */
public abstract class Produto {

    protected String nome;
    protected double preco;

    /**
     * Construtor parametrizado — todo produto deve ter nome e preço.
     *
     * @param nome  Nome do produto.
     * @param preco Preço do produto em reais.
     */
    public Produto(String nome, double preco) {
        this.nome = nome;
        this.preco = preco;
    }

    public String getNome() {
        return nome;
    }

    public double getPreco() {
        return preco;
    }

    /**
     * Método abstrato que cada subcategoria deve implementar
     * com seus detalhes específicos.
     *
     * @return Descrição detalhada do produto.
     */
    public abstract String descricaoDetalhada();

    @Override
    public String toString() {
        return String.format("%s — R$ %.2f", nome, preco);
    }
}
