package org.example.Revisão;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ItemStorage {
    private static final String URL = "jdbc:h2:./meubanco_db";
    private static final String USER = "sa";
    private static final String PASSWORD = "";

    public static Connection getConnection() {
        try {
            return DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (SQLException e) {
            throw new RuntimeException("Falha ao se conectar ao banco", e);
        }
    }

    public static void criarTabela() {
        String sql = "CREATE TABLE IF NOT EXISTS item (" +
                "id INT AUTO_INCREMENT PRIMARY KEY, " +
                "nome VARCHAR(255) NOT NULL, " +
                "preco_base DOUBLE, " +
                "tipo VARCHAR(50), " +
                "preco_final DOUBLE, " +
                "imposto DOUBLE)";

        try (Connection conn = getConnection();
             Statement stmt = conn.createStatement()) {
            stmt.execute(sql);
            System.out.println("Tabela criada com sucesso!");
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao criar tabela", e);
        }
    }

    public static void salvarItem(ItemVendavel item) {
        String sql = "INSERT INTO item (nome, preco_base, tipo, preco_final, imposto) VALUES (?, ?, ?, ?, ?)";

        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, item.getNome());
            pstmt.setDouble(2, item.getPrecoBase());
            pstmt.setString(3, item.getTipo());
            pstmt.setDouble(4, item.calcularPrecoFinal());
            pstmt.setDouble(5, item.calcularImposto());

            pstmt.executeUpdate();
            System.out.println("Item salvo com sucesso!");
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao salvar item", e);
        }
    }

    public static List<String> buscarTodosItens() {
        String sql = "SELECT * FROM item";
        List<String> itens = new ArrayList<>();

        try (Connection conn = getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                int id = rs.getInt("id");
                String nome = rs.getString("nome");
                double precoBase = rs.getDouble("preco_base");
                String tipo = rs.getString("tipo");
                double precoFinal = rs.getDouble("preco_final");
                double imposto = rs.getDouble("imposto");

                String itemInfo = String.format(
                        "ID: %d | Nome: %s | Tipo: %s | Preço Base: R$ %.2f | Preço Final: R$ %.2f | Imposto: R$ %.2f",
                        id, nome, tipo, precoBase, precoFinal, imposto
                );
                itens.add(itemInfo);
            }
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao buscar itens", e);
        }

        return itens;
    }

    public static void atualizarPrecoBase(int id, double novoPrecoBase) {
        String sql = "UPDATE item SET preco_base = ? WHERE id = ?";

        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setDouble(1, novoPrecoBase);
            pstmt.setInt(2, id);

            int rowsAffected = pstmt.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Preço base atualizado com sucesso!");
            } else {
                System.out.println("Item não encontrado.");
            }
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao atualizar preço base", e);
        }
    }

    public static void deletarItem(int id) {
        String sql = "DELETE FROM item WHERE id = ?";

        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, id);

            int rowsAffected = pstmt.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Item deletado com sucesso!");
            } else {
                System.out.println("Item não encontrado.");
            }
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao deletar item", e);
        }
    }
}
