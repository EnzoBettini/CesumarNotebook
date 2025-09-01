package Times_e_jogadores;
import java.util.ArrayList;
import java.util.List;

public class Time {
    private String nome;
    private String cidade;
    private List<Jogador> jogadores;

    public Time(String nome, String cidade) {
        this.nome = nome;
        this.cidade = cidade;
        this.jogadores = new ArrayList<>();
    }

    public void adicionarJogador(Jogador jogador) {
        jogadores.add(jogador);
    }

    public void listarJogadores() {
        System.out.println("Time: " + nome + " (" + cidade + ")");
        System.out.println("Jogadores:");
        for (Jogador j : jogadores) {
            System.out.println("- " + j.getNome() + " (" + j.getPosicao() + ")");
        }
    }
}
