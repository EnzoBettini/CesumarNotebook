package br.edu.unicesumar.ex1;

import br.edu.unicesumar.ConexaoBanco;
import java.sql.*;

public class ProdutoBanco {

    public void inserirProduto(Produto produto) {
        var sql = "INSERT INTO produto (nome, preco, quantidade) VALUES (?, ?, ?)";
        try(var connection = ConexaoBanco.getConexao(); var stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, produto.getNome());
            stmt.setDouble(2, produto.getPreco());
            stmt.setInt(3, produto.getQuantidade());
            stmt.executeUpdate();
            System.out.println("Produto cadastrado com sucesso!");
        } catch (SQLException error) {
            System.out.println("Falha ao inserir: " + error.getMessage());
        }
    }

    public void listarProdutos() {
        var sql = "SELECT * FROM produto";
        try(var connection = ConexaoBanco.getConexao();
            var stmt = connection.prepareStatement(sql);
            var rs = stmt.executeQuery()) {

            while (rs.next()) {
                var productId = rs.getInt("id");
                var productName = rs.getString("nome");
                var preco = rs.getDouble("preco");
                var quantidade = rs.getInt("quantidade");
                System.out.printf("ID: %d - Nome: %s - Preço: %.2f - Quantidade: %d%n",
                    productId, productName, preco, quantidade);
            }
        } catch (SQLException error) {
            System.out.println("Falha ao listar: " + error.getMessage());
        }
    }

    public void updateProduto(int id, double novoPreco) {
        var sql = "UPDATE produto SET PRECO = ? WHERE ID = ?";
        try(var connection = ConexaoBanco.getConexao(); var stmt = connection.prepareStatement(sql)) {
            stmt.setDouble(1, novoPreco);
            stmt.setInt(2, id);
            var rows = stmt.executeUpdate();
            System.out.println(rows > 0 ? "Preço atualizado!" : "ID não encontrado.");
        } catch (SQLException error) {
            System.out.println("Falha ao atualizar: " + error.getMessage());
        }
    }

    public void deletarProduto(int id) {
        var sql = "DELETE FROM produto WHERE id = ?";
        try(var connection = ConexaoBanco.getConexao(); var stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, id);
            var affectedRows = stmt.executeUpdate();
            System.out.println(affectedRows > 0 ? "Produto removido!" : "ID inexistente.");
        } catch (SQLException error) {
            System.out.println("Falha ao deletar: " + error.getMessage());
        }
    }
}
