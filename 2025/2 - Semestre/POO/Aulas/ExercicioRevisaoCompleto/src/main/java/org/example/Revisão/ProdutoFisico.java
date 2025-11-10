package org.example.Revisão;

public class ProdutoFisico extends ItemVendavel implements Tributavel {
    private double pesoEmKg;

    public ProdutoFisico(String nome, double precoBase, double pesoEmKg) {
        super(nome, precoBase);
        this.pesoEmKg = pesoEmKg;
    }

    @Override
    public String getTipo() {
        return "Fisico";
    }

    @Override
    public double calcularPrecoFinal() {
        return this.precoBase + (this.pesoEmKg * 3.50);
    }

    @Override
    public double calcularImposto() {
        return this.precoBase * 0.05;
    }

    public double getPesoEmKg() {
        return pesoEmKg;
    }
}
