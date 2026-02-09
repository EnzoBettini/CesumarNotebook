package br.edu.unicesumar.ex4;

import br.edu.unicesumar.ConexaoBanco;
import br.edu.unicesumar.CriacaoTabelas;
import java.sql.Connection;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try (Connection conexao = ConexaoBanco.getConexao(); Scanner input = new Scanner(System.in)) {

            var tableMaker = new CriacaoTabelas();
            tableMaker.criarTabela(conexao, tableMaker.ex4);

            var movieService = new FilmeService();
            boolean active = true;

            while(active) {
                mostrarOpcoes();
                var opcao = input.nextInt();

                switch(opcao) {
                    case 1:
                        System.out.print("Título: ");
                        var title = input.next();
                        System.out.print("Diretor: ");
                        var director = input.next();
                        System.out.print("Ano: ");
                        var year = input.nextInt();
                        movieService.adicionarFilme(title, director, year);
                        break;
                    case 2:
                        movieService.mostrarFilmes();
                        System.out.println("\nAperte qualquer tecla...");
                        input.nextLine();
                        input.nextLine();
                        break;
                    case 3:
                        System.out.print("Buscar por título: ");
                        var searchTitle = input.next();
                        input.nextLine();
                        movieService.mostrarFilmePorTitulo(searchTitle);
                        System.out.println("\nAperte qualquer tecla...");
                        input.nextLine();
                        input.nextLine();
                        break;
                    case 4:
                        System.out.print("ID: ");
                        var idFilme = input.nextInt();
                        input.nextLine();
                        System.out.print("Diretor atualizado: ");
                        var newDirector = input.nextLine();
                        movieService.atualizarDiretor(idFilme, newDirector);
                        break;
                    case 5:
                        System.out.print("ID para remoção: ");
                        var removeId = input.nextInt();
                        movieService.excluirFilme(removeId);
                        break;
                    case 0:
                        System.out.println("Sistema finalizado.");
                        active = false;
                        break;
                    default:
                        System.out.println("Comando desconhecido!");
                }
            }
        } catch (Exception ex) {
            System.out.println("Erro: " + ex.getMessage());
        }
    }

    private static void mostrarOpcoes() {
        System.out.println("\n*** CATÁLOGO DE FILMES ***");
        System.out.println("1 - Adicionar Filme");
        System.out.println("2 - Listar Filmes");
        System.out.println("3 - Buscar Filme por Título");
        System.out.println("4 - Atualizar Diretor do Filme");
        System.out.println("5 - Excluir Filme");
        System.out.println("0 - Sair");
        System.out.println("**************************");
        System.out.print("> ");
    }
}

