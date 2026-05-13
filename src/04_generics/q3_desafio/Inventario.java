// src/04_generics/q3_desafio/Inventario.java
package q3_desafio;

import java.util.ArrayList;

/**
 * Questão 12 — Inventário de Loja Virtual com Limites de Tipo (Desafio)
 *
 * Classe genérica com BOUNDED TYPE: <T extends Produto>.
 * Isso garante que apenas subtipos de Produto podem ser usados como T.
 * Tentar criar Inventario<String> ou Inventario<Integer> gera erro de compilação.
 *
 * Após o Type Erasure, T é substituído por Produto (o bound), permitindo
 * que o bytecode acesse métodos como getNome() e getPreco() diretamente,
 * sem necessidade de casting.
 *
 * Referência: Goodrich & Tamassia — Cap. 2.5.2 (Bounded Generics)
 *             Oracle Docs — "Bounded Type Parameters"
 */
public class Inventario<T extends Produto> {

    private ArrayList<T> estoque;

    /**
     * Inicializa o inventário com um estoque vazio.
     */
    public Inventario() {
        this.estoque = new ArrayList<>();
    }

    /**
     * Adiciona um produto ao estoque.
     * Como T extends Produto, o compilador garante que apenas
     * subtipos válidos de Produto são aceitos.
     *
     * @param produto O produto a ser adicionado (tipo T).
     */
    public void adicionar(T produto) {
        estoque.add(produto);
        System.out.println("[INVENTÁRIO] Adicionado: " + produto);
    }

    /**
     * Busca um produto pelo nome (case-insensitive).
     * Como T extends Produto, podemos chamar getNome() diretamente
     * — após o Type Erasure, o bytecode sabe que T é pelo menos Produto.
     *
     * @param nome Nome do produto a ser buscado.
     * @return O primeiro produto com nome correspondente, ou null.
     */
    public T buscarPorNome(String nome) {
        for (T produto : estoque) {
            // T extends Produto → getNome() é acessível sem casting
            if (produto.getNome().equalsIgnoreCase(nome)) {
                System.out.println("[BUSCA] Encontrado: " + produto.descricaoDetalhada());
                return produto;
            }
        }
        System.out.println("[BUSCA] Produto \"" + nome + "\" não encontrado no estoque.");
        return null;
    }

    /**
     * Exibe todos os produtos no estoque com sua descrição detalhada.
     */
    public void listar() {
        System.out.println("\n┌──────────────────────────────────────────┐");
        System.out.println("│  INVENTÁRIO — " + estoque.size() + " produto(s) em estoque");
        System.out.println("├──────────────────────────────────────────┤");

        if (estoque.isEmpty()) {
            System.out.println("│  (estoque vazio)");
        } else {
            for (int i = 0; i < estoque.size(); i++) {
                System.out.println("│  [" + i + "] " + estoque.get(i).descricaoDetalhada());
            }
        }

        System.out.println("└──────────────────────────────────────────┘\n");
    }

    /**
     * Retorna a quantidade total de produtos no estoque.
     *
     * @return Número de produtos armazenados.
     */
    public int quantidade() {
        return estoque.size();
    }

    /**
     * Retorna a lista interna de estoque.
     * Usado pelo RelatorioUtil para calcular o valor total via Wildcard.
     *
     * @return A ArrayList interna de produtos.
     */
    public ArrayList<T> getEstoque() {
        return estoque;
    }
}
