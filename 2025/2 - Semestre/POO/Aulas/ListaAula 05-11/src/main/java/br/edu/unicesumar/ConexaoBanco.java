package br.edu.unicesumar;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexaoBanco {
    private static final String DATABASE_URL = "jdbc:h2:./exercicios_lista";
    private static final String USER = "sa";
    private static final String PASS = "";

    public static Connection getConexao() {
        try {
            return DriverManager.getConnection(DATABASE_URL, USER, PASS);
        } catch (SQLException error) {
            throw new RuntimeException("Erro na conexão com banco: " + error.getMessage());
        }
    }
}
