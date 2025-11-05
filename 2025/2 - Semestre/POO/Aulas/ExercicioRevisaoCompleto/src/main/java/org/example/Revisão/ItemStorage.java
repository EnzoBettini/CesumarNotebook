package org.example.Revisão;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ItemStorage {
    public static Connection getConnection(){
        String url = "jdbc:h2:./meubanco_db";
        String user = "sa";
        String password = "";

        try {
            return DriverManager.getConnection(url,user,password);
        } catch (SQLException e) {
            throw new RuntimeException("Falha ao se conectar ao banco", e);
        }
//        try {
//            return DriverManager.getConnection(url,user,password);
//        } catch (SQLException e) {
//            // É uma boa prática imprimir o stack trace para ver a causa real
//            // throw new RuntimeException("Falha ao se conectar ao banco", e);
//
//            // Recomendo fazer isto durante o desenvolvimento:
//            System.err.println("Falha ao conectar. Causa:");
//            e.printStackTrace();
//            throw new RuntimeException("Falha ao se conectar ao banco", e);
//        }
    }
}
