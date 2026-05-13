// src/tema05_lista_simples/q3_desafio/BoletimOcorrencia.java
package tema05_lista_simples.q3_desafio;

/**
 * Classe BoletimOcorrencia — Representa um registro de ocorrência policial.
 * 
 * Cada boletim possui um número único, um tipo e uma descrição.
 */
public class BoletimOcorrencia {
    int numero;
    String tipo;
    String descricao;

    /**
     * Construtor parametrizado.
     * 
     * @param numero    número do boletim (único)
     * @param tipo      tipo da ocorrência (ex: "Furto", "Acidente")
     * @param descricao breve relato da ocorrência
     */
    public BoletimOcorrencia(int numero, String tipo, String descricao) {
        this.numero = numero;
        this.tipo = tipo;
        this.descricao = descricao;
    }

    @Override
    public String toString() {
        return "B.O. #" + numero + " [" + tipo + "]: " + descricao;
    }
}
