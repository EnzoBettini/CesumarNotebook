import java.util.ArrayList;
import java.util.List;

public class Banho {
    String sabao;
    double qtdAgua;
    List<Pessoa> funcionarios = new ArrayList<Pessoa>();
    Cachorro cachorro;

    Banho(String sabao, double qtdAgua, Pessoa funcionario, Cachorro cachorro) {
        this.sabao = sabao;
        this.qtdAgua = qtdAgua;
        this.cachorro = cachorro;
        this.funcionarios.add(funcionario);
    }

    void mostrarDados(){
        System.out.println(sabao);
        System.out.println(qtdAgua);
        System.out.println(cachorro.nome);
        System.out.println(cachorro.dono.nome);
        for (Pessoa funcionario : funcionarios) {
            System.out.println("Funcionário responsável: " + funcionario.nome);
        }
    };
}
