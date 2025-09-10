package Turma_Alunos;

public class Main {
    public static void main(String[] args) {

        Alunos aluno1 =new Alunos("Enzo", 123);
        Alunos aluno2 =new Alunos("filipe", 124);
        Alunos aluno3 =new Alunos("zezin", 125);
        Alunos aluno4 =new Alunos("zezao", 127);

        Turma turma1 = new Turma(3);

        turma1.matricularAluno(aluno1);
        turma1.matricularAluno(aluno2);
        turma1.matricularAluno(aluno3);
        turma1.matricularAluno(aluno4);

        turma1.listarAlunos();

        turma1.buscarAlunoPorRa(123);

        turma1.buscarAlunoPorRa(122);
    }
}
