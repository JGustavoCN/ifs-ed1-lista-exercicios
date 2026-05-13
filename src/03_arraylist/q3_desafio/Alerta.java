// src/03_arraylist/q3_desafio/Alerta.java
package q3_desafio;

/**
 * Questão 9 — Classe Alerta
 *
 * Representa um alerta gerado por um sensor IoT em uma fábrica.
 * Cada alerta possui a identificação do sensor, o nível de severidade
 * (INFO, WARNING ou CRITICAL) e uma mensagem descritiva.
 */
public class Alerta {

    private String sensor;
    private String nivel;
    private String mensagem;

    /**
     * Cria um novo alerta.
     *
     * @param sensor   Identificação do sensor (ex: "Sensor-T01").
     * @param nivel    Nível de severidade: "INFO", "WARNING" ou "CRITICAL".
     * @param mensagem Descrição do alerta.
     */
    public Alerta(String sensor, String nivel, String mensagem) {
        this.sensor = sensor;
        this.nivel = nivel;
        this.mensagem = mensagem;
    }

    public String getSensor() {
        return sensor;
    }

    public String getNivel() {
        return nivel;
    }

    public String getMensagem() {
        return mensagem;
    }

    @Override
    public String toString() {
        return "[" + nivel + "] " + sensor + " — " + mensagem;
    }
}
