// src/08_lista_circular_dupla/q2_pratica/Musica.java
package q2_pratica;

public class Musica {
    String titulo;
    String artista;

    public Musica(String titulo, String artista) {
        this.titulo = titulo;
        this.artista = artista;
    }

    @Override
    public String toString() {
        return titulo + " - " + artista;
    }
}
