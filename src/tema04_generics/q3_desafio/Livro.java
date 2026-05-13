// src/tema04_generics/q3_desafio/Livro.java
package tema04_generics.q3_desafio;

/**
 * Subclasse concreta de Produto — representa livros.
 * Adiciona o atributo autor, específico desta categoria.
 */
public class Livro extends Produto {

    private String autor;

    /**
     * @param nome  Título do livro.
     * @param preco Preço em reais.
     * @param autor Nome do autor.
     */
    public Livro(String nome, double preco, String autor) {
        super(nome, preco);
        this.autor = autor;
    }

    public String getAutor() {
        return autor;
    }

    @Override
    public String descricaoDetalhada() {
        return String.format("[LIVRO] %s | R$ %.2f | Autor: %s",
                nome, preco, autor);
    }
}
