package Lista2Ex3;

public class Main {
    public static void main(String[] args) {
        Conta poupanca = new ContaPoupanca("Enzo Bettini", 1000.0);
        Conta corrente = new ContaCorrente("Ana Silva", 2000.0);

        poupanca.calcularTaxas();
        corrente.calcularTaxas();
    }
}

