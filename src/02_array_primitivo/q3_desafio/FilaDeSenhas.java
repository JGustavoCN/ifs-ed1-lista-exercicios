// src/02_array_primitivo/q3_desafio/FilaDeSenhas.java
package q3_desafio;

public class FilaDeSenhas {

    private int[] senhas;
    private int quantidade;
    private int proximaSenha;

    /**
     * Cria uma fila de senhas com capacidade inicial de 5.
     */
    public FilaDeSenhas() {
        this.senhas = new int[5];
        this.quantidade = 0;
        this.proximaSenha = 1;
    }

    /**
     * Gera a próxima senha sequencial e a insere no final da fila.
     * Se a fila estiver cheia, exibe uma mensagem e não insere.
     */
    public void chamarProximaSenha() {
        if (quantidade >= senhas.length) {
            System.out.println("[LOTADO] Fila lotada! Capacidade máxima: " + senhas.length + ". Senha " + proximaSenha + " não pode ser emitida.");
            return;
        }

        senhas[quantidade] = proximaSenha;
        System.out.println("[OK] Senha " + proximaSenha + " emitida e inserida na posição " + quantidade + ".");
        quantidade++;
        proximaSenha++;
    }

    /**
     * Gera uma nova senha prioritária e a insere na posição indicada,
     * deslocando todos os elementos subsequentes para a direita.
     *
     * @param posicao Posição onde o prioritário será encaixado (0 a quantidade).
     */
    public void encaixarPrioritario(int posicao) {
        if (quantidade >= senhas.length) {
            System.out.println("[ERRO] Fila cheia! Não é possível encaixar prioritário.");
            return;
        }

        if (posicao < 0 || posicao > quantidade) {
            System.out.println("[ERRO] Posição " + posicao + " inválida! Intervalo válido: 0 a " + quantidade + ".");
            return;
        }

        // Shift para a direita: abre espaço na posição desejada
        int shifts = 0;
        for (int i = quantidade - 1; i >= posicao; i--) {
            senhas[i + 1] = senhas[i];
            shifts++;
        }

        senhas[posicao] = proximaSenha;
        System.out.println("[PRIORITÁRIO] Senha " + proximaSenha + " encaixada na posição " + posicao + ". Shifts: " + shifts);
        quantidade++;
        proximaSenha++;
    }

    /**
     * Remove a senha na posição informada (paciente desistiu),
     * deslocando os elementos restantes para a esquerda.
     *
     * @param posicao Posição da senha a ser removida (0 a quantidade-1).
     */
    public void desistir(int posicao) {
        if (posicao < 0 || posicao >= quantidade) {
            System.out.println("[ERRO] Posição " + posicao + " inválida! Intervalo válido: 0 a " + (quantidade - 1) + ".");
            return;
        }

        int senhaRemovida = senhas[posicao];
        int shifts = 0;

        // Shift para a esquerda: preenche o buraco
        for (int i = posicao; i < quantidade - 1; i++) {
            senhas[i] = senhas[i + 1];
            shifts++;
        }

        // Zera a última posição (agora é lixo)
        senhas[quantidade - 1] = 0;
        quantidade--;

        System.out.println("[DESISTÊNCIA] Senha " + senhaRemovida + " removida da posição " + posicao + ". Shifts: " + shifts);
    }

    /**
     * Redimensiona a fila criando um NOVO array com a nova capacidade
     * e copiando todos os elementos existentes. O array antigo é descartado
     * e ficará elegível para o Garbage Collector da JVM.
     *
     * @param novaCapacidade Nova capacidade desejada para a fila.
     */
    public void redimensionar(int novaCapacidade) {
        if (novaCapacidade < quantidade) {
            System.out.println("[ERRO] Nova capacidade (" + novaCapacidade + ") é menor que a quantidade atual de senhas (" + quantidade + "). Operação cancelada.");
            return;
        }

        int capacidadeAntiga = senhas.length;

        // Cria um NOVO bloco de memória contígua com a nova capacidade
        int[] novoArray = new int[novaCapacidade];

        // Copia elemento por elemento para o novo bloco — custo O(n)
        for (int i = 0; i < quantidade; i++) {
            novoArray[i] = senhas[i];
        }

        // Substitui a referência interna. O array antigo perde todas as referências
        // e se torna elegível para coleta pelo Garbage Collector.
        senhas = novoArray;

        System.out.println("[REDIMENSIONAMENTO] Capacidade alterada de " + capacidadeAntiga + " para " + novaCapacidade + ". " + quantidade + " senhas copiadas para o novo array.");
    }

    /**
     * Exibe todas as senhas na fila e a capacidade total.
     */
    public void exibirFila() {
        System.out.println("\n========= FILA DE ATENDIMENTO =========");
        System.out.println("Capacidade: " + senhas.length + " | Ocupação: " + quantidade);
        System.out.println("-----------------------------------------");

        if (quantidade == 0) {
            System.out.println("  (fila vazia)");
        } else {
            for (int i = 0; i < quantidade; i++) {
                System.out.println("  Posição [" + i + "]: Senha " + senhas[i]);
            }
        }

        System.out.println("=========================================\n");
    }

    public int getQuantidade() {
        return quantidade;
    }

    public int getCapacidade() {
        return senhas.length;
    }
}
