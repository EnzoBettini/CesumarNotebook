package org.example.ex1;

import java.sql.Connection;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) {
        try (Connection conn = Database.getConnection()) {
            System.out.println("Conexão realizada com sucesso!");
        } catch (RuntimeException | SQLException e) {
            System.err.println("Erro ao conectar ao banco" + e);
        }
    }
}
