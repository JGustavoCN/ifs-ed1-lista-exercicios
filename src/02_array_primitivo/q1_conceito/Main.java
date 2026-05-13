// src/02_array_primitivo/q1_conceito/Main.java
package q1_conceito;

public class Main {

    /**
     * Registra um veículo em uma vaga específica do estacionamento.
     * Não sobrescreve vagas já ocupadas.
     *
     * @param vagas   Array representando as vagas do estacionamento.
     * @param posicao Índice da vaga desejada (0 a N-1).
     * @param placa   Placa do veículo a ser estacionado.
     */
    public static void estacionar(String[] vagas, int posicao, String placa) {
        if (posicao < 0 || posicao >= vagas.length) {
            System.out.println("[ERRO] Posição " + posicao + " inválida! O estacionamento possui vagas de 0 a " + (vagas.length - 1) + ".");
            return;
        }

        if (vagas[posicao] != null) {
            System.out.println("[AVISO] Vaga " + posicao + " já está ocupada pelo veículo " + vagas[posicao] + ". Operação cancelada.");
            return;
        }

        vagas[posicao] = placa;
        System.out.println("[OK] Veículo " + placa + " estacionado na vaga " + posicao + ".");
    }

    /**
     * Libera uma vaga do estacionamento, atribuindo null à posição.
     *
     * @param vagas   Array representando as vagas do estacionamento.
     * @param posicao Índice da vaga a ser liberada.
     */
    public static void liberar(String[] vagas, int posicao) {
        if (posicao < 0 || posicao >= vagas.length) {
            System.out.println("[ERRO] Posição " + posicao + " inválida!");
            return;
        }

        if (vagas[posicao] == null) {
            System.out.println("[AVISO] Vaga " + posicao + " já está livre.");
            return;
        }

        String placaRemovida = vagas[posicao];
        vagas[posicao] = null;
        System.out.println("[OK] Veículo " + placaRemovida + " removido da vaga " + posicao + ". Vaga liberada.");
    }

    /**
     * Exibe o painel completo do estacionamento mostrando o estado de cada vaga.
     *
     * @param vagas Array representando as vagas do estacionamento.
     */
    public static void exibirPainel(String[] vagas) {
        System.out.println("\n========= PAINEL DO ESTACIONAMENTO =========");
        System.out.println("Capacidade total: " + vagas.length + " vagas");
        System.out.println("---------------------------------------------");

        int ocupadas = 0;
        for (int i = 0; i < vagas.length; i++) {
            if (vagas[i] != null) {
                System.out.println("  Vaga [" + i + "]: OCUPADA - " + vagas[i]);
                ocupadas++;
            } else {
                System.out.println("  Vaga [" + i + "]: LIVRE");
            }
        }

        System.out.println("---------------------------------------------");
        System.out.println("Ocupação: " + ocupadas + "/" + vagas.length);
        System.out.println("=============================================\n");
    }

    public static void main(String[] args) {
        // Array primitivo de tamanho fixo — 8 vagas
        String[] vagas = new String[8];

        System.out.println(">>> Controle de Vagas de Estacionamento <<<\n");

        // Estacionando 4 veículos em posições distintas
        estacionar(vagas, 0, "ABC-1234");
        estacionar(vagas, 3, "DEF-5678");
        estacionar(vagas, 5, "GHI-9012");
        estacionar(vagas, 7, "JKL-3456");

        System.out.println();

        // Tentativa de estacionar em vaga já ocupada
        estacionar(vagas, 3, "MNO-7890");

        System.out.println();

        // Liberando uma vaga
        liberar(vagas, 5);

        // Exibindo o painel final
        exibirPainel(vagas);
    }
}
