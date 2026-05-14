package br.edu.refactoring.estacionamento;

import java.time.Duration;
import java.time.LocalDateTime;

public class TicketEstacionamento {

    private String codigo;
    private Veiculo veiculo;
    private Vaga vaga;
    private boolean perdido;
    private LocalDateTime dataHoraEntrada;
    private LocalDateTime dataHoraSaidaPrevista;

    public TicketEstacionamento(String codigo, Veiculo veiculo, Vaga vaga, boolean perdido,
                                LocalDateTime dataHoraEntrada, LocalDateTime dataHoraSaidaPrevista) {
        this.codigo = codigo;
        this.veiculo = veiculo;
        this.vaga = vaga;
        this.perdido = perdido;
        this.dataHoraEntrada = dataHoraEntrada;
        this.dataHoraSaidaPrevista = dataHoraSaidaPrevista;
    }

    public void imprimirTicket() {
        DataHoraEstacionamento entradaEstacionamento = new DataHoraEstacionamento(dataHoraEntrada);
        String entradaFormatada = entradaEstacionamento.formatarDataHora();

        System.out.println("Ticket: " + codigo);
        System.out.println("Veículo: " + veiculo.getPlaca());
        System.out.println("Vaga: " + vaga.getCodigo());
        System.out.println("Entrada: " + entradaFormatada);

        if (entradaEstacionamento.isHorarioEspecial()) {
            System.out.println("Período: horário especial");
        } else {
            System.out.println("Período: horário regular");
        }

        if (perdido) {
            System.out.println("Situação: ticket perdido");
        } else {
            System.out.println("Situação: ticket regular");
        }
    }

    public long calcularMinutosPermanencia() {
        return Duration.between(dataHoraEntrada, dataHoraSaidaPrevista).toMinutes();
    }

    public String getCodigo() {
        return codigo;
    }

    public Veiculo getVeiculo() {
        return veiculo;
    }

    public Vaga getVaga() {
        return vaga;
    }

    public boolean isPerdido() {
        return perdido;
    }

    public LocalDateTime getDataHoraEntrada() {
        return dataHoraEntrada;
    }

    public LocalDateTime getDataHoraSaidaPrevista() {
        return dataHoraSaidaPrevista;
    }
}
