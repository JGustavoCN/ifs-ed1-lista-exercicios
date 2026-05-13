// src/04_generics/q3_desafio/Main.java
package q3_desafio;

import java.util.ArrayList;

/**
 * Questão 12 — Inventário de Loja Virtual com Limites de Tipo (Desafio)
 *
 * Demonstra:
 * 1. Bounded Type Parameters: Inventario<T extends Produto>
 * 2. Wildcards: RelatorioUtil.calcularValorTotal(ArrayList<? extends Produto>)
 * 3. Invariância de tipos genéricos (ArrayList<Eletronico> ≠ ArrayList<Produto>)
 *
 * Referência: Goodrich & Tamassia — Cap. 2.5 (Generics)
 *             Oracle Docs — "Bounded Type Parameters" e "Wildcards"
 */
public class Main {

    public static void main(String[] args) {

        System.out.println("==============================================");
        System.out.println("  QUESTÃO 12 — INVENTÁRIO COM LIMITES DE TIPO");
        System.out.println("==============================================\n");

        // ============================================================
        // INVENTÁRIO DE ELETRÔNICOS
        // ============================================================
        System.out.println("--- INVENTÁRIO DE ELETRÔNICOS ---\n");

        Inventario<Eletronico> invEletronicos = new Inventario<>();
        invEletronicos.adicionar(new Eletronico("Notebook Gamer", 5499.90, 24));
        invEletronicos.adicionar(new Eletronico("Fone Bluetooth", 349.00, 12));
        invEletronicos.adicionar(new Eletronico("Monitor 4K", 2199.00, 36));

        invEletronicos.listar();

        // ============================================================
        // INVENTÁRIO DE LIVROS
        // ============================================================
        System.out.println("--- INVENTÁRIO DE LIVROS ---\n");

        Inventario<Livro> invLivros = new Inventario<>();
        invLivros.adicionar(new Livro("Estruturas de Dados em Java", 189.90, "Goodrich & Tamassia"));
        invLivros.adicionar(new Livro("Algoritmos: Teoria e Prática", 249.00, "Thomas Cormen"));
        invLivros.adicionar(new Livro("Java Efetivo", 159.90, "Joshua Bloch"));

        invLivros.listar();

        // ============================================================
        // INVENTÁRIO DE ROUPAS
        // ============================================================
        System.out.println("--- INVENTÁRIO DE ROUPAS ---\n");

        Inventario<Roupa> invRoupas = new Inventario<>();
        invRoupas.adicionar(new Roupa("Camiseta Polo", 89.90, "M"));
        invRoupas.adicionar(new Roupa("Jaqueta Corta-Vento", 199.90, "G"));

        invRoupas.listar();

        // ============================================================
        // BUSCA POR NOME (demonstra que getNome() funciona via bound)
        // ============================================================
        System.out.println("--- BUSCA POR NOME ---\n");
        invEletronicos.buscarPorNome("monitor 4k");      // Encontra (case-insensitive)
        invLivros.buscarPorNome("java efetivo");          // Encontra
        invRoupas.buscarPorNome("Tênis Esportivo");       // Não encontra

        System.out.println();

        // ============================================================
        // RELATÓRIO COM WILDCARDS (? extends Produto)
        // ============================================================
        System.out.println("=".repeat(50));
        System.out.println("--- RELATÓRIO DE VALOR TOTAL (Wildcards) ---\n");

        // O método aceita ArrayList<Eletronico>, ArrayList<Livro> e
        // ArrayList<Roupa> — todos são subtipos de "? extends Produto".
        // Sem o Wildcard, ArrayList<Eletronico> NÃO seria subtipo de
        // ArrayList<Produto> (invariância de tipos genéricos).

        double totalEletronicos = RelatorioUtil.calcularValorTotal(invEletronicos.getEstoque());
        System.out.printf("  Valor total (Eletrônicos): R$ %.2f%n", totalEletronicos);

        double totalLivros = RelatorioUtil.calcularValorTotal(invLivros.getEstoque());
        System.out.printf("  Valor total (Livros):      R$ %.2f%n", totalLivros);

        double totalRoupas = RelatorioUtil.calcularValorTotal(invRoupas.getEstoque());
        System.out.printf("  Valor total (Roupas):      R$ %.2f%n", totalRoupas);

        double totalGeral = totalEletronicos + totalLivros + totalRoupas;
        System.out.printf("%n  VALOR TOTAL GERAL:         R$ %.2f%n", totalGeral);

        // ============================================================
        // DEMONSTRAÇÃO: Inventario<String> é PROIBIDO pelo compilador
        // ============================================================
        //
        // A linha abaixo, se descomentada, gera ERRO DE COMPILAÇÃO:
        //
        // Inventario<String> invTextos = new Inventario<>();
        //
        // Erro: "type argument String is not within bounds of type-variable T"
        //
        // >> Isso acontece porque String NÃO estende Produto.
        //    O bound <T extends Produto> restringe T a apenas subtipos
        //    de Produto. Qualquer outro tipo é rejeitado em COMPILAÇÃO.

        System.out.println("\n" + "=".repeat(50));
        System.out.println("[CONCLUSÃO]");
        System.out.println("  1. <T extends Produto> restringe T a subtipos de Produto.");
        System.out.println("  2. <? extends Produto> permite que métodos aceitem qualquer");
        System.out.println("     ArrayList de subtipos, resolvendo a invariância de Generics.");
        System.out.println("  3. Após Type Erasure, T é substituído por PRODUTO (o bound),");
        System.out.println("     e não por Object. Isso permite chamar getNome()/getPreco()");
        System.out.println("     diretamente no bytecode sem casting.");
    }
}
