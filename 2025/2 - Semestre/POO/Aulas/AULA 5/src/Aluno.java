import java.util.ArrayList;
import java.util.List;

public class Aluno {
    Pessoa aluno;
    List<Double> notas = new ArrayList<>();

    Aluno(String nome, int idade){
        this.aluno = new Pessoa(nome, idade);
    }

    double calcularMedia(){
        if(notas.isEmpty()) return 0; // evita divisão por zero
        double soma = 0;
        for(double nota : notas){
            soma += nota;
        }
        return soma / notas.size();
    }

    void adicionarNota(double nota){
        notas.add(nota);
    }
}
