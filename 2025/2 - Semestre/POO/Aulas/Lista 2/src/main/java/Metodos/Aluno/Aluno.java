package Metodos.Aluno;

import java.util.ArrayList;
import java.util.List;

public class Aluno {
    String nome;
    List<Integer> notas =  new ArrayList<Integer>();

    Aluno (String nome) {
        this.nome = nome;
    }

    void adicionarNota(int nota) {
        if (this.notas.size() >= 4) {
            System.out.println("Numero maximo de notas atingido\n");
        } else {
            this.notas.add(nota);
        }
    }

    double calcMedia() {
        int sum = 0;
        for (int i = 0; i < this.notas.size(); i++){
            sum += this.notas.get(i);
        }
        return (double) sum / this.notas.size();
    }
}
