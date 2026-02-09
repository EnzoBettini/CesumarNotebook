package br.edu.unicesumar.ex1;

import br.edu.unicesumar.ConexaoBanco;
import br.edu.unicesumar.CriacaoTabelas;
import java.sql.Connection;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try (var conn = ConexaoBanco.getConexao(); var input = new Scanner(System.in)) {
            var table = new CriacaoTabelas();
            table.criarTabela(conn, table.ex1);

            var service = new ProdutoService();
            boolean running = true;

            while(running) {
                exibirMenu();
                var option = input.nextInt();

                switch(option) {
                    case 1 -> {
                        System.out.print("Informe o nome: ");
                        var name = input.next();
                        System.out.print("Informe o preço: ");
                        var price = input.nextDouble();
                        System.out.print("Informe a quantidade: ");
                        var quantity = input.nextInt();
                        service.adicionarProduto(name, price, quantity);
                    }
                    case 2 -> {
                        service.mostrarProdutos();
                        System.out.println("\nAperte Enter...");
                        input.nextLine();
                        input.nextLine();
                    }
                    case 3 -> {
                        System.out.print("ID para alteração: ");
                        var idProduto = input.nextInt();
                        System.out.print("Preço atualizado: ");
                        var newPrice = input.nextDouble();
                        service.alterarPrecoProduto(idProduto, newPrice);
                    }
                    case 4 -> {
                        System.out.print("ID para exclusão: ");
                        var productId = input.nextInt();
                        service.excluirProduto(productId);
                    }
                    case 0 -> {
                        System.out.println("Encerrando sistema...");
                        running = false;
                    }
                    default -> System.out.println("Opção não reconhecida!");
                }
            }
        } catch (Exception erro) {
            System.out.println(erro.getMessage());
        }
    }

    private static void exibirMenu() {
        System.out.println("\n========== MENU ==========");
        System.out.println("1 - Adicionar Produto");
        System.out.println("2 - Listar Produtos");
        System.out.println("3 - Alterar Preço do Produto");
        System.out.println("4 - Excluir Produto");
        System.out.println("0 - Sair");
        System.out.println("==========================");
        System.out.print("Opção: ");
    }
}
