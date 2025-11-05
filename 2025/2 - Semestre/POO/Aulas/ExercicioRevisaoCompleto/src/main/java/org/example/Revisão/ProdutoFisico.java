package org.example.Revisão;

public class ProdutoFisico extends ItemVendavel implements Tributavel {
    public Double pesoEmKg;

    public ProdutoFisico(String nome,Double precoBase, Double pesoEmKg) {
        super(nome, precoBase);
        this.pesoEmKg = pesoEmKg;
    }

    @Override
    public void informarTipo() {
        System.out.println("Fisico");
    }

    @Override
    public Double calcularPrecoFinal() {
        return this.precoBase + (this.pesoEmKg * 3.50);
    }

    @Override
    public Double calcularValorImposto() {
        return this.precoBase * 0.05;
    }
}
