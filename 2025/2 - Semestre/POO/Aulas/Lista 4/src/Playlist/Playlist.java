package Playlist;

public class Playlist {
    private String nome;
    private Musica[] musicas;
    private int proximaPosicaoLivre;


    Playlist(String nome){
        this.nome = nome;
        this.musicas = new Musica[20];
        this.proximaPosicaoLivre = 0;
    }

    public void adicionarMusica(Musica m){
        if(this.musicas.length <= this.proximaPosicaoLivre){
            System.out.println("Playlist cheia");
        } else {
            this.musicas[proximaPosicaoLivre] = m;
            this.proximaPosicaoLivre++;
        }
    }

    public void listarMusicas(){
        for (Musica m : this.musicas) {
            if(m != null){
                System.out.println(m.getNome());
            }
        }
    }
}
