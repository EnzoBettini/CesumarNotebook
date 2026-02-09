package br.edu.unicesumar.ex3;

import br.edu.unicesumar.ConexaoBanco;
import java.sql.*;

public class TarefaBanco {

    public void inserirTarefa(Tarefa tarefa) {
        String sql = "INSERT INTO tarefa (descricao) VALUES (?)";
        try (var connection = ConexaoBanco.getConexao();
             var stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, tarefa.getDescricao());
            stmt.executeUpdate();
            System.out.println("Tarefa criada!");
        } catch(SQLException ex) {
            System.out.println("Falha ao criar tarefa: " + ex.getMessage());
        }
    }

    public void listarTodos() {
        String sql = "SELECT * FROM tarefa";

        try(var connection = ConexaoBanco.getConexao();
            var stmt = connection.prepareStatement(sql)) {

            ResultSet results = stmt.executeQuery();
            while (results.next()) {
                int taskId = results.getInt("id");
                String desc = results.getString("descricao");
                String status = results.getString("status");

                System.out.printf("ID: %d - Descrição: %s - Status: %s%n", taskId, desc, status);
            }

        } catch (SQLException ex) {
            System.out.println("Falha ao buscar tarefas: " + ex.getMessage());
        }
    }

    public void listarPendentes() {
        String sql = "SELECT * FROM tarefa WHERE status = 'PENDENTE'";

        try(var connection = ConexaoBanco.getConexao();
        var stmt = connection.prepareStatement(sql)) {

            ResultSet results = stmt.executeQuery();
            while (results.next()) {
                int taskId = results.getInt("id");
                String descricao = results.getString("descricao");
                String statusTask = results.getString("status");

                System.out.printf("ID: %d - Descrição: %s - Status: %s%n", taskId, descricao, statusTask);
            }

        } catch(SQLException ex) {
            System.out.println("Falha ao buscar pendentes: " + ex.getMessage());
        }
    }

    public void atualizarStatus(int id) {
        String sql = "UPDATE tarefa SET status = 'CONCLUIDA' WHERE id = ?";
        try(var connection = ConexaoBanco.getConexao();
            var stmt = connection.prepareStatement(sql)) {

            stmt.setInt(1, id);
            int updatedRows = stmt.executeUpdate();

            if (updatedRows > 0) {
                System.out.println("Status modificado!");
            } else {
                System.out.println("Tarefa não localizada.");
            }
        } catch(SQLException ex) {
            System.out.println("Falha ao atualizar: " + ex.getMessage());
        }
    }

    public void removerTarefa(int id) {
        String sql = "DELETE FROM tarefa WHERE id = ?";
        try(var connection = ConexaoBanco.getConexao();
            var stmt = connection.prepareStatement(sql)) {

            stmt.setInt(1, id);
            int removedRows = stmt.executeUpdate();

            if (removedRows > 0) {
                System.out.println("Tarefa deletada!");
            } else {
                System.out.println("Tarefa não localizada.");
            }
        } catch(SQLException ex) {
            System.out.println("Falha ao remover: " + ex.getMessage());
        }
    }
}
