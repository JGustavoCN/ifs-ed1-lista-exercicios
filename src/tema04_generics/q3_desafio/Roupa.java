// src/tema04_generics/q3_desafio/Roupa.java
package tema04_generics.q3_desafio;

/**
 * Subclasse concreta de Produto — representa roupas.
 * Adiciona o atributo tamanho, específico desta categoria.
 */
public class Roupa extends Produto {

    private String tamanho;

    /**
     * @param nome    Nome da peça de roupa.
     * @param preco   Preço em reais.
     * @param tamanho Tamanho da peça (P, M, G, GG, etc.).
     */
    public Roupa(String nome, double preco, String tamanho) {
        super(nome, preco);
        this.tamanho = tamanho;
    }

    public String getTamanho() {
        return tamanho;
    }

    @Override
    public String descricaoDetalhada() {
        return String.format("[ROUPA] %s | R$ %.2f | Tamanho: %s",
                nome, preco, tamanho);
    }
}
