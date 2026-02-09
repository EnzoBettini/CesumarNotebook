package org.example.Teste2;

public abstract class ItemVendavel {
    private String nome;
    private double precoBase;
    private String tipo;

    public ItemVendavel(String nome, double precoBase, String tipo) {
        this.nome = nome;
        this.precoBase = precoBase;
        this.tipo = tipo;
    }

    public abstract double calcularPrecoFinal();

    public String getNome() {
        return nome;
    }

    public double getPrecoBase() {
        return precoBase;
    }

    public String getTipo() {
        return tipo;
    }

    public double calcularImposto() {
        return 0.0;
    };
}
