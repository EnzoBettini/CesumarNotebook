package Professores_e_disciplinas;

public class Main {
    public static void main(String[] args) {
        Professor professor = new Professor("Carlos Silva");

        Disciplina d1 = new Disciplina("Matemática");
        Disciplina d2 = new Disciplina("Programação");

        professor.associarDisciplina(d1);
        professor.associarDisciplina(d2);

        professor.listarDisciplinas();
    }
}
