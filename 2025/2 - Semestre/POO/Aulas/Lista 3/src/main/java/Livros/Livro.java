package Livros;


public class Livro {
    private String titulo;
    private Autor autor;

    public Livro(String titulo, Autor autor) {
        this.titulo = titulo;
        this.autor = autor;
    }

    public void exibirDetalhes() {
        System.out.println("Livro: " + titulo);
        System.out.println("Autor: " + autor.getNome() + " (" + autor.getNacionalidade() + ")");
    }
}

