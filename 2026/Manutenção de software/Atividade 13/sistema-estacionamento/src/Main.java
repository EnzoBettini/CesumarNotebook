package br.edu.refactoring.estacionamento;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class Main {

    public static void main(String[] args) {
        Estacionamento estacionamento = new Estacionamento(
                "ParkTech Centro",
                "12.345.678/0001-90",
                new Endereco(
                        "Avenida Brasil",
                        "1500",
                        "Centro",
                        "Maringá",
                        "PR",
                        "87000-000"));

        Cliente cliente = new Cliente(
                "Mariana Souza",
                "123.456.789-00",
                "(44) 99999-0000",
                4200,
                18,
                true,
                new DadosCobranca(
                        "Banco Acadêmico",
                        "1234",
                        "98765-0",
                        "Pix"));

        Veiculo veiculo = new Veiculo(
                "ABC-1234",
                "Honda Civic",
                "Prata",
                new DadosSeguro(
                        "Seguro Total",
                        "AP-889900",
                        "0800-123-456"));

        Vaga vaga = new Vaga("A12", "Setor Azul", true, true);

        TicketEstacionamento ticket = new TicketEstacionamento(
                "TCK-1001",
                veiculo,
                vaga,
                false,
                LocalDateTime.of(2026, 6, 20, 9, 30),
                LocalDateTime.of(2026, 6, 20, 12, 15));
        ReservaVaga reserva = new ReservaVaga(
                vaga,
                cliente,
                "Mariana Souza",
                LocalDateTime.of(2026, 6, 20, 9, 0));
        RegistroPagamento pagamento = new RegistroPagamento(
                ticket,
                cliente,
                new ValorEstacionamento(new BigDecimal("48.5")));

        estacionamento.imprimirDados();
        System.out.println();

        cliente.imprimirResumo();
        System.out.println();

        veiculo.imprimirDados(ticket.getDataHoraEntrada(), ticket.getDataHoraSaidaPrevista());
        System.out.println();

        ticket.imprimirTicket();
        System.out.println();

        reserva.imprimirReserva();
        System.out.println();

        System.out.println("Minutos de permanência: " + ticket.calcularMinutosPermanencia());
        System.out.println("Desconto do cliente: " + cliente.calcularDesconto() + "%");
        System.out.println("Status da vaga: " + vaga.descreverStatus());
        System.out.println();

        pagamento.imprimirComprovante();
    }
}
