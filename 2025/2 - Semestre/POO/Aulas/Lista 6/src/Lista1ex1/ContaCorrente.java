package Lista1ex1;

public class ContaCorrente implements Tributavel {
    private double saldo;

    public ContaCorrente(double saldo) {
        this.saldo = saldo;
    }

    @Override
    public double getValorImposto() {
        return saldo * 0.02; // 2% do saldo
    }
}
