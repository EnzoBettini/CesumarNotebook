package org.example.Revisão;

public abstract class ItemVendavel {
    public String nome;
    public Double precoBase;

    public ItemVendavel(String nome, Double precoBase) {
        this.nome = nome;
        this.precoBase = precoBase;
    }

    public abstract void informarTipo();
    public abstract Double calcularPrecoFinal();

    public String getNome() {
        return nome;
    }

    public Double getPrecoBase() {
        return precoBase;
    }
}
