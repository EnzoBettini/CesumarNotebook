package br.edu.unicesumar.ex4;

public class FilmeService {
    private final FilmeBanco db = new FilmeBanco();

    public void adicionarFilme(String titulo, String diretor, int anoLancamento) {
        var movie = new Filme(titulo, diretor, anoLancamento);
        db.inserirFilme(movie);
    }

    public void mostrarFilmes() {
        db.listarTodos();
    }

    public void mostrarFilmePorTitulo(String titulo) {
        db.buscarPorTitulo(titulo);
    }

    public void atualizarDiretor(int id, String diretor) {
        db.atualizarDiretor(id, diretor);
    }

    public void excluirFilme(int id) {
        db.removerFilme(id);
    }
}
