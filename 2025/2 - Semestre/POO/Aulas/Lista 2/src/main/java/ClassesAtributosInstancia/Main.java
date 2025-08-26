package ClassesAtributosInstancia;

public class Main {
    public static void main(String[] args) {
        Livro novo_livro1 = new Livro("Diario de um banana", "Geoffrey Kinney", 2015);
        Livro novo_livro2 = new Livro("Diario de um banana 2", "Geoffrey Kinney", 2016);

        System.out.printf("Nome livro 1 %s, Escritor %s, ano de lancamento %d\n", novo_livro1.titulo, novo_livro1.autor, novo_livro1.anoPublicacao);
        System.out.printf("Nome livro 2 %s, Escritor %s, ano de lancamento %d\n", novo_livro2.titulo, novo_livro2.autor, novo_livro2.anoPublicacao);

        Musica musica1 = new Musica("psychosocial", "Slipknot", 250);
        Musica musica2 = new Musica("im not okay", "my chemichal romance", 250);
        Musica musica3 = new Musica("ignorance", "paramore", 250);

        System.out.printf("Nome: %s -- Artista: %s -- Duracao (s): %d\n\n", musica1.nome, musica1.artista, musica1.duracaoEmSegundos);
        System.out.printf("Nome: %s -- Artista: %s -- Duracao (s): %d\n\n", musica2.nome, musica2.artista, musica2.duracaoEmSegundos);
        System.out.printf("Nome: %s -- Artista: %s -- Duracao (s): %d\n\n", musica3.nome, musica3.artista, musica3.duracaoEmSegundos);
    }
}
