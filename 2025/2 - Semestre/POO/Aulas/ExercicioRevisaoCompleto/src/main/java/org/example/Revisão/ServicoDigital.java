package org.example.Revisão;

public class ServicoDigital extends ItemVendavel {
    private int duracaoMeses;

    public ServicoDigital(String nome, double precoBase, int duracaoMeses) {
        super(nome, precoBase);
        this.duracaoMeses = duracaoMeses;
    }

    @Override
    public String getTipo() {
        return "Digital";
    }

    @Override
    public double calcularPrecoFinal() {
        return precoBase * duracaoMeses;
    }

    public int getDuracaoMeses() {
        return duracaoMeses;
    }
}
