// src/tema08_lista_circular_dupla/q3_desafio/Main.java
package tema08_lista_circular_dupla.q3_desafio;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== QUESTÃO 24: SELETOR DE HERÓIS (DESAFIO) ===\n");

        SeletorHerois seletor = new SeletorHerois();
        seletor.adicionar(new Heroi("Arthur", "Guerreiro"));
        seletor.adicionar(new Heroi("Merlin", "Mago"));
        seletor.adicionar(new Heroi("Gwen", "Arqueira"));
        seletor.adicionar(new Heroi("Lancelot", "Paladino"));

        seletor.exibirOpcoes();

        // 1. Remover a cabeça
        seletor.remover("Arthur");
        seletor.exibirOpcoes();

        // 2. Remover do meio
        seletor.remover("Gwen");
        seletor.exibirOpcoes();

        // 3. Remover todos até esvaziar
        seletor.remover("Merlin");
        seletor.remover("Lancelot");
        seletor.exibirOpcoes();
    }
}
