package Times_e_jogadores;

public class Main {
    public static void main(String[] args) {
        Time time = new Time("Flamengo", "Rio de Janeiro");

        Jogador j1 = new Jogador("Pedro", "Atacante");
        Jogador j2 = new Jogador("Arrascaeta", "Meia");

        time.adicionarJogador(j1);
        time.adicionarJogador(j2);

        time.listarJogadores();
    }
}