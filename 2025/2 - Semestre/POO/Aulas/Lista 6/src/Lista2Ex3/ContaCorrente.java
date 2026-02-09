package Lista2Ex3;

public class ContaCorrente extends Conta {

    public ContaCorrente(String titular, double saldo) {
        super(titular, saldo);
    }

    @Override
    public void calcularTaxas() {
        setSaldo(getSaldo() - 15.0);
        System.out.println("Conta Corrente de " + getTitular() + " teve R$ 15,00 descontados. Saldo atual: R$ " + getSaldo());
    }
}

