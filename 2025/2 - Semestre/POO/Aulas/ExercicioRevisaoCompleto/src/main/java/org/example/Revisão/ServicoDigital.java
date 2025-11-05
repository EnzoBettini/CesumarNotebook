package org.example.Revisão;

public class ServicoDigital extends ItemVendavel{
    public Integer duracaoMeses;

    public ServicoDigital(String nome, Double precoBase, Integer duracaoMeses) {
        super(nome, precoBase);
        this.duracaoMeses = duracaoMeses;
    }

    @Override
    public Double calcularPrecoFinal() {
        return precoBase * duracaoMeses;
    }

    @Override
    public void informarTipo() {
        System.out.println("Serviço Digital");
    }

    public Integer getDuracaoMeses() {
        return duracaoMeses;
    }
}
