package Turma_Alunos;

public class ex3_ex5 {
    //ex3
    // Para remover um aluno pelo RA eu teria que:
    // 1. Procurar no array o índice do aluno com esse RA.
    // 2. Deslocar todos os alunos seguintes uma posição para trás.
    // 3. Diminuir o contador proximaPosicaoLivre.
    //
    // Dificuldades usando array:
    // - Arrays têm tamanho fixo, não liberam espaço de verdade.
    // - Erros fáceis ao deslocar elementos e manter o contador correto.

    //ex5
    // O loop deve ir até proximaPosicaoLivre porque só essa parte do array está preenchida.
    // Se usar alunos.length, vai acessar posições nulas e dar NullPointerException ao chamar getNome().
    //porem eu usei length com verificação de ser nulo ou nao kkkkkk
}
