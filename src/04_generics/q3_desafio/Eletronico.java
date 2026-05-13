// src/04_generics/q3_desafio/Eletronico.java
package q3_desafio;

/**
 * Subclasse concreta de Produto — representa produtos eletrônicos.
 * Adiciona o atributo garantiaMeses, específico desta categoria.
 */
public class Eletronico extends Produto {

    private int garantiaMeses;

    /**
     * @param nome           Nome do eletrônico.
     * @param preco          Preço em reais.
     * @param garantiaMeses  Duração da garantia em meses.
     */
    public Eletronico(String nome, double preco, int garantiaMeses) {
        super(nome, preco);
        this.garantiaMeses = garantiaMeses;
    }

    public int getGarantiaMeses() {
        return garantiaMeses;
    }

    @Override
    public String descricaoDetalhada() {
        return String.format("[ELETRÔNICO] %s | R$ %.2f | Garantia: %d meses",
                nome, preco, garantiaMeses);
    }
}
