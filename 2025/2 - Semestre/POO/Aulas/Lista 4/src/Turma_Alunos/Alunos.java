package Turma_Alunos;

public class Alunos {
    private String nome;
    private int ra;

    Alunos(String nome, int ra) {
        this.nome = nome;
        this.ra = ra;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getRa() {
        return ra;
    }

    public void setRa(int ra) {
        this.ra = ra;
    }
}
