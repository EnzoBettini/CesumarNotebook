package Professores_e_disciplinas;
import java.util.ArrayList;
import java.util.List;

public class Professor {
    private String nome;
    private List<Disciplina> disciplinas;

    public Professor(String nome) {
        this.nome = nome;
        this.disciplinas = new ArrayList<>();
    }

    public void associarDisciplina(Disciplina disciplina) {
        disciplinas.add(disciplina);
    }

    public void listarDisciplinas() {
        System.out.println("Professor: " + nome);
        System.out.println("Disciplinas:");
        for (Disciplina d : disciplinas) {
            System.out.println("- " + d.getNome());
        }
    }
}
