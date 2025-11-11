package org.example.Teste2;

public class ProdutoFisico extends ItemVendavel implements Tributavel {
    private double pesoEmKg;

    public ProdutoFisico(String nome, double precoBase, double pesoEmKg) {
        super(nome, precoBase, "Fisíco");
        this.pesoEmKg = pesoEmKg;
    }

    @Override
    public double calcularPrecoFinal() {
        return this.getPrecoBase() + (this.pesoEmKg * 3.5);
    }

    @Override
    public double calcularImposto() {
        return this.getPrecoBase()  * 0.05;
    }

    public double getPesoEmKg() {
        return pesoEmKg;
    }
}
