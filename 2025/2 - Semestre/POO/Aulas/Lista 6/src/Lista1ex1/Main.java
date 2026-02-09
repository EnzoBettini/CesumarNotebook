package Lista1ex1;

public class Main {
    public static void main(String[] args) {
        ContaCorrente conta = new ContaCorrente(1000.0);
        SeguroDeVida seguro = new SeguroDeVida();

        System.out.println("Imposto Conta Corrente: R$ " + conta.getValorImposto());
        System.out.println("Imposto Seguro de Vida: R$ " + seguro.getValorImposto());
    }
}
