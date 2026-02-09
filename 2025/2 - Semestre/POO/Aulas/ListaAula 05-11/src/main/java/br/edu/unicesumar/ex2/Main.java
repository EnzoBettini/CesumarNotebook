package br.edu.unicesumar.ex2;

import br.edu.unicesumar.ConexaoBanco;
import br.edu.unicesumar.CriacaoTabelas;
import java.sql.Connection;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try (Connection conexao = ConexaoBanco.getConexao();
             Scanner scanner = new Scanner(System.in)) {

            CriacaoTabelas tables = new CriacaoTabelas();
            tables.criarTabela(conexao, tables.ex2);

            ClienteService serviceCliente = new ClienteService();
            int opcao;

            do {
                System.out.println("\n******** SISTEMA DE CLIENTES ********");
                System.out.println("1 - Adicionar Cliente");
                System.out.println("2 - Listar Clientes");
                System.out.println("3 - Buscar Cliente por Email");
                System.out.println("4 - Atualizar Telefone do Cliente");
                System.out.println("5 - Excluir Cliente");
                System.out.println("0 - Sair");
                System.out.println("**************************************");
                System.out.print("Digite sua escolha: ");
                opcao = scanner.nextInt();

                if (opcao == 1) {
                    System.out.print("Nome: ");
                    String name = scanner.next();
                    System.out.print("Email: ");
                    String email = scanner.next();
                    System.out.print("Telefone: ");
                    String phone = scanner.next();
                    serviceCliente.adicionarCliente(name, email, phone);
                } else if (opcao == 2) {
                    serviceCliente.mostrarClientes();
                    System.out.println("\nPressione Enter...");
                    scanner.nextLine();
                    scanner.nextLine();
                } else if (opcao == 3) {
                    System.out.print("Informe o email para busca: ");
                    String emailBusca = scanner.next();
                    serviceCliente.buscarClientePorEmail(emailBusca);
                    System.out.println("\nPressione Enter...");
                    scanner.nextLine();
                    scanner.nextLine();
                } else if (opcao == 4) {
                    System.out.println("Informe o ID:");
                    int idCliente = scanner.nextInt();
                    System.out.println("Novo telefone:");
                    String newPhone = scanner.next();
                    serviceCliente.atualizarTelefoneCliente(idCliente, newPhone);
                } else if (opcao == 5) {
                    System.out.println("ID do cliente para exclusão:");
                    int deleteId = scanner.nextInt();
                    serviceCliente.excluirCliente(deleteId);
                } else if (opcao == 0) {
                    System.out.println("Finalizando aplicação...");
                } else {
                    System.out.println("Entrada inválida!");
                }
            } while (opcao != 0);

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
