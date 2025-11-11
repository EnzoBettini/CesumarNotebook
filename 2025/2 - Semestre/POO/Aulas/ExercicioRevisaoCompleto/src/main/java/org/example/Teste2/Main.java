package org.example.Teste2;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Criar tabela ao iniciar o programa
        ItemStorage.criarTabela();

        boolean continuar = true;

        while (continuar) {
            System.out.println("\n===== MENU =====");
            System.out.println("1. Adicionar Item");
            System.out.println("2. Listar Itens");
            System.out.println("3. Atualizar Preço Base");
            System.out.println("4. Deletar Item");
            System.out.println("5. Sair");
            System.out.print("Escolha uma opção: ");

            int opcao = scanner.nextInt();
            scanner.nextLine(); // Consumir a quebra de linha

            switch (opcao) {
                case 1:
                    adicionarItem(scanner);
                    break;
                case 2:
                    listarItens();
                    break;
                case 3:
                    atualizarPrecoBase(scanner);
                    break;
                case 4:
                    deletarValores(scanner);
                    break;
                case 5:
                    continuar = false;
                    System.out.println("Encerrando o programa...");
                    break;
                default:
                    System.out.println("Opção inválida! Tente novamente.");
            }
        }

        scanner.close();
    }

    private static void adicionarItem(Scanner scanner) {
        System.out.println("\n--- Adicionar Item ---");
        System.out.println("Escolha o tipo:");
        System.out.println("1. Produto Físico");
        System.out.println("2. Serviço Digital");
        System.out.print("Opção: ");

        int tipo = scanner.nextInt();
        scanner.nextLine(); // Consumir a quebra de linha

        System.out.print("Nome do item: ");
        String nome = scanner.nextLine();

        System.out.print("Preço base: R$ ");
        double precoBase = scanner.nextDouble();
        scanner.nextLine(); // Consumir a quebra de linha

        ItemVendavel item;

        if (tipo == 1) {
            System.out.print("Peso em Kg: ");
            double peso = scanner.nextDouble();
            scanner.nextLine(); // Consumir a quebra de linha
            item = new ProdutoFisico(nome, precoBase, peso);
        } else if (tipo == 2) {
            System.out.print("Duração em meses: ");
            int meses = scanner.nextInt();
            scanner.nextLine(); // Consumir a quebra de linha
            item = new ServicoDigital(nome, precoBase, meses);
        } else {
            System.out.println("Tipo inválido!");
            return;
        }

        ItemStorage.salvarItem(item);
    }

    private static void listarItens() {
        System.out.println("\n--- Lista de Itens ---");
        List<String> itens = ItemStorage.buscarTodosItens();

        if (itens.isEmpty()) {
            System.out.println("Nenhum item encontrado.");
        } else {
            for (String item : itens) {
                System.out.println(item);
            }
        }
    }

    private static void atualizarPrecoBase(Scanner scanner) {
        System.out.println("\n--- Atualizar Preço Base ---");
        System.out.print("ID do item: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // Consumir a quebra de linha

        System.out.print("Novo preço base: R$ ");
        double novoPrecoBase = scanner.nextDouble();
        scanner.nextLine(); // Consumir a quebra de linha

        ItemStorage.atualizarValores(id, novoPrecoBase);
    }

    private static void deletarValores(Scanner scanner) {
        System.out.println("\n--- Deletar Item ---");
        System.out.print("ID do item: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // Consumir a quebra de linha

        ItemStorage.deletarValores(id);
    }
}
