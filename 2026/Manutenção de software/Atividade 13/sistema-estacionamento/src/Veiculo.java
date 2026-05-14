package br.edu.refactoring.estacionamento;

import java.time.LocalDateTime;

public class Veiculo {

    private String placa;
    private String modelo;
    private String cor;
    private DadosSeguro dadosSeguro;

    public Veiculo(String placa, String modelo, String cor, DadosSeguro dadosSeguro) {
        this.placa = placa;
        this.modelo = modelo;
        this.cor = cor;
        this.dadosSeguro = dadosSeguro;
    }

    public void imprimirDados(LocalDateTime dataHoraEntrada, LocalDateTime dataHoraSaidaPrevista) {
        System.out.println("Veículo: " + modelo);
        System.out.println("Placa: " + placa);
        System.out.println("Cor: " + cor);
        System.out.println("Entrada registrada: " + dataHoraEntrada);
        System.out.println("Saída prevista: " + dataHoraSaidaPrevista);
        System.out.println("Seguro: " + dadosSeguro.getDadosSeguroFormatados());
    }

    public String getPlaca() {
        return placa;
    }

    public String getModelo() {
        return modelo;
    }

    public String getCor() {
        return cor;
    }

    public DadosSeguro getDadosSeguro() {
        return dadosSeguro;
    }
}
