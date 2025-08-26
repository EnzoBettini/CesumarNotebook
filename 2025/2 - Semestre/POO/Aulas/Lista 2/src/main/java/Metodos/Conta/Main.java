package Metodos.Conta;

public class Main {
    public static void main(String[] args) {
        Conta conta = new Conta("123456");

        conta.adicionarSaldo(10);
        System.out.printf("Saldo: %f\n", conta.saldo);
        conta.sacar(1);
        System.out.printf("Saldo: %f\n", conta.saldo);
        conta.sacar(100);
    }
}
