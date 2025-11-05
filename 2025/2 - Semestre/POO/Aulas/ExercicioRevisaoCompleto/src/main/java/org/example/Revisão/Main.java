package org.example.Revisão;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try (Connection connection = ItemStorage.getConnection()) {
            System.out.println("Conexão estabelecida com sucesso!");
            Statement sttmt = connection.createStatement();
            String sql = "CREATE TABLE IF NOT EXISTS itens (" +
                        "id INT PRIMARY KEY AUTO_INCREMENT," +
                        "nome VARCHAR(255)," +
                        "precoBase DOUBLE," +
                        "tipo VARCHAR(100)," +
                        "precoFinal DOUBLE," +
                        "imposto DOUBLE" +
                        ")";
            sttmt.execute(sql);

            System.out.println("Table criada com sucesso!");

            Scanner sc = new Scanner(System.in);

            System.out.println("Qual o tipo do produto?");
            String tipo = sc.nextLine();

            System.out.println("Qual o nome do produto?");
            String nome = sc.nextLine();

            System.out.println("Digite o preço base do produto");
            Double precoBase = Double.parseDouble(sc.nextLine());

            ItemVendavel produto;

            if (tipo.equals("Fisico")) {
                System.out.println("Digite o peso em KG do produto");
                Double peso = Double.parseDouble(sc.nextLine());
                produto = new ProdutoFisico(nome, precoBase, peso);
            } else {
                System.out.println("Digite a duração em meses do serviço");
                Integer duracao = Integer.parseInt(sc.nextLine());
                produto = new ServicoDigital(nome, precoBase, duracao);
            }

            double imposto = 0.0;
            if (produto instanceof Tributavel) {
                imposto = ((Tributavel) produto).calcularValorImposto();
            }

            String sqlInsert = "INSERT INTO itens (nome, precoBase, tipo, precoFinal, imposto) VALUES(" +
                    "'" + nome + "'" + "," +
                    precoBase + "," +
                    "'" + tipo + "'" + "," +
                    produto.calcularPrecoFinal() + "," +
                    imposto + ");";

            sttmt.execute(sqlInsert);

        } catch (RuntimeException | SQLException e) {
            System.err.println(e.getMessage());
        }
    }
}
