package br.edu.unicesumar.ex3;

import br.edu.unicesumar.ConexaoBanco;
import br.edu.unicesumar.CriacaoTabelas;
import java.sql.Connection;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try(Connection conn = ConexaoBanco.getConexao();
            Scanner reader = new Scanner(System.in)) {

            var tables = new CriacaoTabelas();
            tables.criarTabela(conn, tables.ex3);

            TarefaService taskService = new TarefaService();
            int choice = -1;

            while(choice != 0) {
                System.out.println("\n+++ GERENCIADOR DE TAREFAS +++");
                System.out.println("1 - Adicionar Tarefa");
                System.out.println("2 - Listar Todas as Tarefas");
                System.out.println("3 - Listar Tarefas Pendentes");
                System.out.println("4 - Atualizar Status da Tarefa");
                System.out.println("5 - Excluir Tarefa");
                System.out.println("0 - Sair");
                System.out.println("+++++++++++++++++++++++++++++++");
                System.out.print("Selecione: ");

                choice = reader.nextInt();
                reader.nextLine();

                switch (choice) {
                    case 1 -> {
                        System.out.print("Digite a descrição: ");
                        String description = reader.nextLine();
                        taskService.adicionarTarefa(description);
                    }
                    case 2 -> {
                        taskService.mostrarTarefas();
                        System.out.println("\n[Enter para continuar]");
                        reader.nextLine();
                    }
                    case 3 -> {
                        taskService.mostrarTarefaPendente();
                        System.out.println("\n[Enter para continuar]");
                        reader.nextLine();
                    }
                    case 4 -> {
                        System.out.print("ID da tarefa: ");
                        int idTask = reader.nextInt();
                        taskService.atualizarStatusTarefa(idTask);
                    }
                    case 5 -> {
                        System.out.print("ID para remover: ");
                        int deleteId = reader.nextInt();
                        taskService.excluirTarefa(deleteId);
                    }
                    case 0 -> System.out.println("Programa encerrado.");
                    default -> System.out.println("Escolha inválida!");
                }
            }
        } catch (Exception error) {
            System.out.println("Erro: " + error.getMessage());
        }
    }
}
