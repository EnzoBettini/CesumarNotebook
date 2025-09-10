package Turma_Alunos;

public class Turma {
    private final Alunos[] alunos;
    private int proximaPosicaoLivre;

    Turma(int quantidadeAlunos) {
        alunos = new Alunos[quantidadeAlunos];
        this.proximaPosicaoLivre = 0;
    }

    public void matricularAluno(Alunos aluno){
        if (this.proximaPosicaoLivre >= alunos.length){
            System.out.println("Turma cheia!");
        } else {
            alunos[this.proximaPosicaoLivre] = aluno;
            this.proximaPosicaoLivre++;
        }
    }

    public void listarAlunos(){
        for (Alunos aluno : this.alunos) {
            if (aluno != null) {
                System.out.println(aluno.getNome());
                System.out.println(aluno.getRa());
                System.out.println();
            }
        }
    }

    public void buscarAlunoPorRa(int ra) {
        boolean encontrou = false;
        for (Alunos aluno : this.alunos) {
            if (aluno != null && aluno.getRa() == ra) {
                System.out.println("Aluno encontrado!");
                System.out.println(aluno.getNome());
                System.out.println(aluno.getRa());
                System.out.println();
                encontrou = true;
                break;
            }
        }
        if (!encontrou) {
            System.out.println("Aluno não encontrado!");
        }
    }
}
