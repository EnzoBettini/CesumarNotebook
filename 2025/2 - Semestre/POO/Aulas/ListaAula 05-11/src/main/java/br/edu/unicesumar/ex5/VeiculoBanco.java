package br.edu.unicesumar.ex5;

import br.edu.unicesumar.ConexaoBanco;
import java.sql.*;

public class VeiculoBanco {

    public void inserirVeiculo(Veiculo veiculo) {
        String sql = "INSERT INTO veiculo (placa, marca, modelo, ano) VALUES (?, ?, ?, ?)";

        try(var conn = ConexaoBanco.getConexao();
            var stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, veiculo.getPlaca());
            stmt.setString(2, veiculo.getMarca());
            stmt.setString(3, veiculo.getModelo());
            stmt.setInt(4, veiculo.getAno());
            stmt.executeUpdate();
            System.out.println("Veículo cadastrado!");

        } catch(SQLException ex) {
            System.out.println("Erro no cadastro: " + ex.getMessage());
        }
    }

    public void listarPatio() {
        String sql = "SELECT * FROM veiculo";

        try(var conn = ConexaoBanco.getConexao();
        var stmt = conn.prepareStatement(sql)) {

            var data = stmt.executeQuery();

            if(data.next()) {
                do {
                    String placa = data.getString("placa");
                    String marca = data.getString("marca");
                    String modeloCarro = data.getString("modelo");
                    int anoVeiculo = data.getInt("ano");

                    System.out.printf("Placa: %s - Marca: %s - Modelo: %s - Ano: %d%n",
                            placa, marca, modeloCarro, anoVeiculo);
                } while(data.next());
            } else {
                System.out.println("Nenhum veículo registrado.");
            }

        } catch(SQLException ex) {
            System.out.println("Erro ao consultar: " + ex.getMessage());
        }
    }

    public void buscarPorPlaca(String placa) {
        String sql = "SELECT * FROM veiculo WHERE placa = ?";

        try(var conn = ConexaoBanco.getConexao();
             var stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, placa);
            var data = stmt.executeQuery();

            if(data.next()) {
                String brandName = data.getString("marca");
                String modelName = data.getString("modelo");
                int yearVehicle = data.getInt("ano");

                System.out.printf("Placa: %s - Marca: %s - Modelo: %s - Ano: %d%n",
                        placa, brandName, modelName, yearVehicle);
            } else {
                System.out.printf("Placa %s não encontrada!", placa);
            }

        } catch(SQLException ex) {
            System.out.println("Erro na consulta: " + ex.getMessage());
        }
    }

    public void atualizarAno(String placa, int ano) {
        String sql = "UPDATE veiculo SET ano = ? WHERE placa = ?";

        try(var conn = ConexaoBanco.getConexao();
             var stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, ano);
            stmt.setString(2, placa);

            int rowsUpdated = stmt.executeUpdate();
            System.out.println(rowsUpdated > 0 ? "Ano alterado!" : "Placa não encontrada.");

        } catch(SQLException ex) {
            System.out.println("Erro ao modificar: " + ex.getMessage());
        }
    }

    public void venderVeiculo(String placa) {
        String sql = "DELETE FROM veiculo WHERE placa = ?";

        try(var conn = ConexaoBanco.getConexao();
             var stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, placa);

            int rowsDeleted = stmt.executeUpdate();
            System.out.println(rowsDeleted > 0 ? "Veículo removido!" : "Placa não encontrada.");

        } catch(SQLException ex) {
            System.out.println("Erro ao remover: " + ex.getMessage());
        }
    }
}
