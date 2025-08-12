import java.util.List;

public class ContaBancaria {
    double saldo;
    String numeroConta;
    String agencia;
    Pessoa titular;
    Cartao[] cartoes;

    ContaBancaria(double saldo, String numeroConta, String agencia,
                  String nomePessoa, String cpfPessoa, String dataNacimento)
    {
        this.saldo = saldo;
        this.numeroConta = numeroConta;
        this.agencia = agencia;
        titular = new Pessoa(nomePessoa, cpfPessoa, dataNacimento); // composiçãp
    }
}
