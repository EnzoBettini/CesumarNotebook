package br.edu.refactoring.estacionamento;

import java.time.LocalDateTime;

public class ReservaVaga {

    private Vaga vaga;
    private Cliente cliente;
    private String nomeClienteReserva;
    private LocalDateTime horarioReserva;

    public ReservaVaga(Vaga vaga, Cliente cliente, String nomeClienteReserva, LocalDateTime horarioReserva) {
        this.vaga = vaga;
        this.cliente = cliente;
        this.nomeClienteReserva = nomeClienteReserva;
        this.horarioReserva = horarioReserva;
    }

    public void imprimirReserva() {
        System.out.println("Reserva da vaga: " + vaga.getCodigo());
        System.out.println("Setor: " + vaga.getSetor());
        System.out.println("Cliente da reserva: " + nomeClienteReserva);
        System.out.println("Cliente vinculado: " + cliente.getNome());
        System.out.println("Horário da reserva: " + horarioReserva);
    }

    public Vaga getVaga() {
        return vaga;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public String getNomeClienteReserva() {
        return nomeClienteReserva;
    }

    public LocalDateTime getHorarioReserva() {
        return horarioReserva;
    }
}
