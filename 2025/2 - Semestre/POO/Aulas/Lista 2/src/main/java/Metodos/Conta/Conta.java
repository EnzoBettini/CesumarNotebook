package Metodos.Conta;

public class Conta {
    String numeroDaConta;
    double saldo = 0;

    Conta (String numeroDaConta) {
        this.numeroDaConta = numeroDaConta;
    }

    void adicionarSaldo(double saldo) {
        this.saldo += saldo;
    }

    void sacar(double saldo) {
        if (this.saldo >= saldo) {
            this.saldo -= saldo;
        } else {
            System.out.println("Saldo insuficiente");
        }
    }
}
