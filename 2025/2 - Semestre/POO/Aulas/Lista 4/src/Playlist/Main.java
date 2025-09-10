package Playlist;

public class Main {
    public static void main(String[] args) {
        Musica musica = new Musica("Boligas");

        Playlist playlist = new Playlist("Boligas playlist");

        playlist.adicionarMusica(musica);

        playlist.listarMusicas();
    }
}
