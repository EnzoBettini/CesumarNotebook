package br.edu.unicesumar.ex4;

public class Filme {
    private int id;
    private String titulo;
    private String diretor;
    private int anoLancamento;

    public Filme(String titulo, String diretor, int anoLancamento) {
        this.titulo = titulo;
        this.diretor = diretor;
        this.anoLancamento = anoLancamento;
    }

    public int getId() { return id; }

    public String getTitulo() { return titulo; }

    public String getDiretor() { return diretor; }

    public int getAnoLancamento() { return anoLancamento; }
}
