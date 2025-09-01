package Times_e_jogadores;

public class Jogador {
    private String nome;
    private String posicao;

    public Jogador(String nome, String posicao) {
        this.nome = nome;
        this.posicao = posicao;
    }

    public String getNome() {
        return nome;
    }

    public String getPosicao() {
        return posicao;
    }
}
