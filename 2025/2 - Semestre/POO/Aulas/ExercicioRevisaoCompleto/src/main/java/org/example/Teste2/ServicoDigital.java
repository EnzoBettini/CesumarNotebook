package org.example.Teste2;

public class ServicoDigital extends ItemVendavel {
    private int duracaoMeses;

    public ServicoDigital(String nome, double precoBase, int duracaoMeses) {
        super(nome, precoBase, "Digital");
        this.duracaoMeses = duracaoMeses;
    }

    @Override
    public double calcularPrecoFinal() {
        return this.getPrecoBase()  * this.duracaoMeses;
    }

    public int getDuracaoMeses() {
        return duracaoMeses;
    }
}
