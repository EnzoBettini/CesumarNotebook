package Livros;

public class Main {
    public static void main(String[] args) {
        Autor autor = new Autor("Machado de Assis", "Brasileiro");

        Livro livro1 = new Livro("Dom Casmurro", autor);
        Livro livro2 = new Livro("Memórias Póstumas de Brás Cubas", autor);

        livro1.exibirDetalhes();
        System.out.println();
        livro2.exibirDetalhes();
    }
}
