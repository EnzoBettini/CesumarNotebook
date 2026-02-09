package Lista1Ex10;

public abstract class Personagem {
    private String nome;
    private int nivel;

    public Personagem(String nome, int nivel) {
        this.nome = nome;
        this.nivel = nivel;
    }

    public String getNome() {
        return nome;
    }

    public int getNivel() {
        return nivel;
    }

    public void atacar() {
        System.out.println(nome + " atacou!");
    }
}
