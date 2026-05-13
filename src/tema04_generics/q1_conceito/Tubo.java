// src/tema04_generics/q1_conceito/Tubo.java
package tema04_generics.q1_conceito;

/**
 * Questão 10 — Laboratório de Análises Clínicas (Conceito)
 * Parte B: Classe genérica que garante segurança de tipos em tempo de compilação.
 *
 * Antes dos Generics (Java < 5), coleções armazenavam Object e exigiam castings
 * manuais, arriscando ClassCastException em tempo de execução. Com Generics,
 * o compilador rejeita tipos incompatíveis ANTES da execução.
 *
 * Internamente, o Java aplica Type Erasure: T é substituído por Object no bytecode,
 * mas o compilador insere checkcast automáticos para garantir a segurança.
 *
 * Referência: Goodrich & Tamassia — Cap. 2.5 (Generics)
 *             Oracle Docs — "Why Use Generics?"
 */
public class Tubo<T> {

    private T amostra;

    /**
     * Insere uma amostra tipada no tubo.
     * Graças ao parâmetro genérico T, o compilador garante que apenas objetos
     * do tipo declarado na instanciação podem ser inseridos.
     *
     * @param amostra A amostra biológica a ser armazenada.
     */
    public void inserir(T amostra) {
        this.amostra = amostra;
        System.out.println("[TUBO] Amostra inserida: " + amostra);
    }

    /**
     * Retira a amostra do tubo.
     * O retorno é do tipo T — nenhum casting é necessário no código cliente.
     * Após o Type Erasure, o bytecode retorna Object, mas o compilador insere
     * um checkcast invisível para o tipo correto.
     *
     * @return A amostra armazenada, já tipada.
     */
    public T retirar() {
        return this.amostra;
    }
}
