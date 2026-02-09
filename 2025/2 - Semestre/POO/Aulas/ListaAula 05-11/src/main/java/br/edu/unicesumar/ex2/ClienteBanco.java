package br.edu.unicesumar.ex2;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import br.edu.unicesumar.ConexaoBanco;

public class ClienteBanco {

    public void inserirCliente(Cliente cliente) {
        String sql = "INSERT INTO cliente (nome, email, telefone) VALUES (?, ?, ?)";

        try(Connection connection = ConexaoBanco.getConexao();
            PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setString(1, cliente.getNome());
            statement.setString(2, cliente.getEmail());
            statement.setString(3, cliente.getTelefone());
            statement.executeUpdate();
            System.out.println("Cliente adicionado ao sistema!");

        } catch (SQLException erro) {
            System.out.println("Falha na inserção: " + erro.getMessage());
        }
    }

    public void listarTodos() {
        String sql = "SELECT * FROM cliente";

        try(Connection connection = ConexaoBanco.getConexao();
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet data = statement.executeQuery()) {

            while (data.next()) {
                int id = data.getInt("id");
                String nome = data.getString("nome");
                String emailCliente = data.getString("email");
                String telefone = data.getString("telefone");

                System.out.printf("ID: %d - Nome: %s - Email: %s - Telefone: %s%n",
                    id, nome, emailCliente, telefone);
            }

        } catch (SQLException erro) {
            System.out.println("Falha ao buscar clientes: " + erro.getMessage());
        }
    }

    public void listarClientePorEmail(String email) {
        String sql = "SELECT * FROM CLIENTE WHERE email = ?";

        try(Connection connection = ConexaoBanco.getConexao();
            PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setString(1, email);
            ResultSet data = statement.executeQuery();

            if(!data.next()) {
                System.out.println("Email não cadastrado.");
            } else {
                do {
                    int idResult = data.getInt("id");
                    String nomeResult = data.getString("nome");
                    String phoneResult = data.getString("telefone");

                    System.out.printf("ID: %d - Nome: %s - Email: %s - Telefone: %s%n",
                        idResult, nomeResult, email, phoneResult);
                } while (data.next());
            }

        } catch (SQLException erro) {
            System.out.println("Erro na busca por email: " + erro.getMessage());
        }
    }

    public void atualizarTelefone(int id, String telefone) {
        String sql = "UPDATE cliente SET telefone = ? WHERE id = ?";

        try(Connection connection = ConexaoBanco.getConexao();
            PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setString(1, telefone);
            statement.setInt(2, id);
            int linhasAfetadas = statement.executeUpdate();

            if (linhasAfetadas > 0) {
                System.out.println("Telefone modificado!");
            } else {
                System.out.println("ID não localizado.");
            }
        } catch (SQLException erro) {
            System.out.println("Erro na atualização: " + erro.getMessage());
        }
    }

    public void removerCliente(int id) {
        String sql = "DELETE FROM cliente WHERE id = ?";

        try(Connection connection = ConexaoBanco.getConexao();
            PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setInt(1, id);
            int deletedRows = statement.executeUpdate();

            if (deletedRows > 0) {
                System.out.println("Cliente excluído!");
            } else {
                System.out.println("ID não localizado.");
            }
        } catch (SQLException erro) {
            System.out.println("Erro ao excluir: " + erro.getMessage());
        }
    }
}
