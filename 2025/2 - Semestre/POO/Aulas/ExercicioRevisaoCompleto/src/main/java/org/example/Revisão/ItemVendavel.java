package org.example.Revisão;

public abstract class ItemVendavel {
    protected String nome;
    protected double precoBase;

    public ItemVendavel(String nome, double precoBase) {
        this.nome = nome;
        this.precoBase = precoBase;
    }

    public abstract double calcularPrecoFinal();
    public abstract String getTipo();

    // Implementação padrão para subclasses que não são tributáveis
    public double calcularImposto() {
        return 0.0;
    }

    public String getNome() {
        return nome;
    }

    public double getPrecoBase() {
        return precoBase;
    }

    public void setPrecoBase(double precoBase) {
        this.precoBase = precoBase;
    }
}
