package BD;

import java.util.ArrayList;
import java.util.List;

public class Livro {
    private String titulo;
    private String autor;
    private List<Avaliacao> avaliacoes;

    public Livro(String titulo, String autor, String comentario, int nota) {
        this.titulo = titulo;
        this.autor = autor;
        this.avaliacoes = new ArrayList<>();
        adicionarAvaliacao(comentario, nota);
    }

    public void adicionarAvaliacao(String comentario, int nota) {
        Avaliacao avaliacao = new Avaliacao(comentario, nota);
        avaliacoes.add(avaliacao);
    }

    public String getTitulo() {
        return titulo;
    }

    public String getAutor() {
        return autor;
    }

    public String getComentario() {
        return avaliacoes.isEmpty() ? "" : avaliacoes.get(0).getComentario();
    }

    public int getNota() {
        return avaliacoes.isEmpty() ? 0 : avaliacoes.get(0).getNota();
    }

    public List<Avaliacao> getAvaliacoes() {
        return avaliacoes;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("Livro: ").append(titulo).append(" (").append(autor).append(")\n");
        builder.append("Avaliações:\n");
        for (Avaliacao avaliacao : avaliacoes) {
            builder.append(avaliacao).append("\n");
        }
        return builder.toString();
    }
}
