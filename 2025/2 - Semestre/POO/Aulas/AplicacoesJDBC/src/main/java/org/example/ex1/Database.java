package org.example.ex1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Database {
    public static Connection getConnection() throws SQLException {
        String url = "jdbc:h2:./loja_db";
        String user = "sa";
        String password = "";
        return DriverManager.getConnection(url, user, password);
    }
    public static void initTable(Connection connection) {
        String sql = "CREATE TABLE IF NOT EXISTS produto (" +
                " id INT AUTO_INCREMENT PRIMARY KEY," +
                " nome VARCHAR(255) NOT NULL," +
                " preco DOUBLE," +
                " quantidade INT" +
                ");";
        try (Statement sttmt = connection.createStatement()) {
            sttmt.execute(sql);
        } catch (SQLException ex) {
            System.err.println("Erro ao inserir produto: " + ex);
        }
    }
}
