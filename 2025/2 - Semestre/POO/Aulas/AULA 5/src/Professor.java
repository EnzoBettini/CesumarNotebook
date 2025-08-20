import java.util.ArrayList;
import java.util.List;

public class Professor {
    Pessoa professor;
    List<Aluno> alunos = new ArrayList<>();

    Professor(String nome, int idade) {
        professor = new Pessoa(nome, idade);
    }

    void adicionarAluno(Aluno aluno) {
        alunos.add(aluno);
    }

    void adicionarNota(Aluno aluno, double nota){
        if(alunos.contains(aluno)){
            aluno.adicionarNota(nota);
        } else {
            System.out.println("Aluno não está na lista.");
        }
    }
}
