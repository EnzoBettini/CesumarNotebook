package Lista2Ex3;

public class ContaPoupanca extends Conta {

    public ContaPoupanca(String titular, double saldo) {
        super(titular, saldo);
    }

    @Override
    public void calcularTaxas() {
        System.out.println("Conta Poupança de " + getTitular() + " não possui taxas.");
    }
}

