package org.example.Teste2;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ItemStorage {
    private static final String url = "jdbc:h2:./teste2_db";
    private static final String user = "teste";
    private static final String senha = "";

    public static Connection getConnection() {
        try {
            return DriverManager.getConnection(url, user, senha);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void criarTabela() {
        String sql = "CREATE TABLE IF NOT EXISTS item (" +
                "id INT AUTO_INCREMENT PRIMARY KEY," +
                "nome VARCHAR(255)," +
                "preco_base DOUBLE," +
                "tipo VARCHAR(50)," +
                "preco_final DOUBLE," +
                "imposto DOUBLE)";

        try (Connection conn =  getConnection()) {
            Statement sttmt = conn.createStatement();
            sttmt.execute(sql);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public static void salvarItem(ItemVendavel item) {
        String sql = "INSERT INTO item (nome, preco_base, tipo, preco_final, imposto) VALUES (?,?,?,?,?)";

        try (Connection conn = getConnection()) {
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, item.getNome());
            pstmt.setDouble(2, item.getPrecoBase());
            pstmt.setString(3, item.getTipo());
            pstmt.setDouble(4, item.calcularPrecoFinal());
            pstmt.setDouble(5, item.calcularImposto());

            pstmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public static List<String> buscarTodosItens() {
        String sql = "SELECT * FROM item";

        List<String> itens = new ArrayList<>();

        try (Connection conn = getConnection()) {
            Statement sttmt = conn.createStatement();
            ResultSet rs = sttmt.executeQuery(sql);

            while (rs.next()) {
                int id = rs.getInt("id");
                String nome = rs.getString("nome");
                double precoBase = rs.getDouble("preco_base");
                String tipo = rs.getString("tipo");
                double precoFinal = rs.getDouble("preco_final");
                double imposto = rs.getDouble("imposto");
                String itemInfo = String.format("%d, %s, %f, %s, %f, %f",id, nome, precoBase, tipo, precoFinal, imposto);
                itens.add(itemInfo);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return itens;
    }
    public static void atualizarValores(int id, double novoPrecoBase) {
        String sql = "UPDATE item SET preco_base = ? WHERE id = ?";

        try (Connection conn = getConnection()) {
            PreparedStatement psmt = conn.prepareStatement(sql);

            psmt.setDouble(1, novoPrecoBase);
            psmt.setInt(2, id);

            psmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public static void deletarValores(int id) {
        String sql = "DELETE FROM item WHERE id = ?";

        try (Connection conn = getConnection()) {
            PreparedStatement psmt = conn.prepareStatement(sql);

            psmt.setInt(1, id);

            psmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
