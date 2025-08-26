package Metodos.Aluno;

public class Main {
    public static void main(String[] args) {
        Aluno aluno = new Aluno("Jose");

        aluno.adicionarNota(5);
        aluno.adicionarNota(6);
        aluno.adicionarNota(7);
        aluno.adicionarNota(8);
        aluno.adicionarNota(9);
        aluno.adicionarNota(9);

        double media = aluno.calcMedia();
        System.out.println(media);
    }
}
