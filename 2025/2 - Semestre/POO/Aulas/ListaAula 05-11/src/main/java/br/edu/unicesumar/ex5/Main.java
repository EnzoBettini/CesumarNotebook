package br.edu.unicesumar.ex5;

import br.edu.unicesumar.ConexaoBanco;
import br.edu.unicesumar.CriacaoTabelas;
import java.sql.Connection;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        try(Connection conn = ConexaoBanco.getConexao();
            Scanner scan = new Scanner(System.in)) {

            var createTable = new CriacaoTabelas();
            createTable.criarTabela(conn, createTable.ex5);

            var vehicleService = new VeiculoService();
            boolean running = true;

            while(running) {
                imprimirMenu();
                int choice = scan.nextInt();
                scan.nextLine();

                if (choice == 1) {
                    System.out.print("Placa: ");
                    String plate = scan.nextLine();
                    System.out.print("Marca: ");
                    String brand = scan.nextLine();
                    System.out.print("Modelo: ");
                    String model = scan.nextLine();
                    System.out.print("Ano: ");
                    int year = scan.nextInt();
                    vehicleService.adicionarVeiculo(plate, brand, model, year);
                } else if (choice == 2) {
                    vehicleService.mostrarPatio();
                    System.out.println("\n[Aperte Enter]");
                    scan.nextLine();
                } else if (choice == 3) {
                    System.out.print("Digite a placa: ");
                    String searchPlate = scan.nextLine();
                    vehicleService.mostrarPorPlaca(searchPlate);
                    System.out.println("\n[Aperte Enter]");
                    scan.nextLine();
                } else if (choice == 4) {
                    System.out.print("Placa do veículo: ");
                    String updatePlate = scan.nextLine();
                    System.out.print("Ano atualizado: ");
                    int newYear = scan.nextInt();
                    vehicleService.atualizarAno(updatePlate, newYear);
                } else if (choice == 5) {
                    System.out.print("Placa para remover: ");
                    String deletePlate = scan.nextLine();
                    vehicleService.venderVeiculo(deletePlate);
                } else if (choice == 0) {
                    System.out.println("Encerrando...");
                    running = false;
                } else {
                    System.out.println("Opção desconhecida.");
                }
            }

        } catch (Exception error) {
            System.out.println("Erro: " + error.getMessage());
        }
    }

    private static void imprimirMenu() {
        System.out.println("\n========== PÁTIO DE VEÍCULOS ==========");
        System.out.println("1 - Adicionar Veículo");
        System.out.println("2 - Listar Veículos");
        System.out.println("3 - Buscar Veículo por Placa");
        System.out.println("4 - Atualizar Ano");
        System.out.println("5 - Excluir Veículo");
        System.out.println("0 - Sair");
        System.out.println("=======================================");
        System.out.print(">> ");
    }
}
