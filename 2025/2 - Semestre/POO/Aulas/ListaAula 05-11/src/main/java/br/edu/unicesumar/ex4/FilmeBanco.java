package br.edu.unicesumar.ex4;

import br.edu.unicesumar.ConexaoBanco;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class FilmeBanco {

    public void inserirFilme(Filme filme) {
        var sql = "INSERT INTO filme (titulo, diretor, ano_lancamento) VALUES (?, ?, ?)";

        try(var connection = ConexaoBanco.getConexao(); var statement = connection.prepareStatement(sql)) {
            statement.setString(1, filme.getTitulo());
            statement.setString(2, filme.getDiretor());
            statement.setInt(3, filme.getAnoLancamento());
            statement.executeUpdate();
            System.out.println("Filme registrado!");
        } catch(SQLException error) {
            System.out.println("Falha no registro: " + error.getMessage());
        }
    }

    public void listarTodos() {
        var sql = "SELECT * FROM filme";

        try(var connection = ConexaoBanco.getConexao(); var statement = connection.prepareStatement(sql)) {
            var data = statement.executeQuery();

            while(data.next()) {
                var movieId = data.getInt("id");
                var titulo = data.getString("titulo");
                var diretor = data.getString("diretor");
                var anoLancamento = data.getInt("ano_lancamento");

                System.out.printf("ID: %d - Título: %s - Diretor: %s - Ano de Lançamento: %d%n",
                        movieId, titulo, diretor, anoLancamento);
            }
        } catch (SQLException error) {
            System.out.println("Falha ao listar: " + error.getMessage());
        }
    }

    public void buscarPorTitulo(String pesquisa) {
       var sql = "SELECT * FROM filme WHERE LOWER(titulo) LIKE ?";

         try(var connection = ConexaoBanco.getConexao(); var statement = connection.prepareStatement(sql)) {
             statement.setString(1, "%" + pesquisa.toLowerCase() + "%");
             var data = statement.executeQuery();

              if(!data.next()) {
                  System.out.println("Nenhum resultado para: " + pesquisa);
              } else {
                  do {
                      var movieId = data.getInt("id");
                      var title = data.getString("titulo");
                      var director = data.getString("diretor");
                      var year = data.getInt("ano_lancamento");

                      System.out.printf("ID: %d - Título: %s - Diretor: %s - Ano de Lançamento: %d%n",
                              movieId, title, director, year);
                  } while(data.next());
              }
         } catch (SQLException error) {
              System.out.println("Falha na busca: " + error.getMessage());
         }
    }

    public void atualizarDiretor(int id, String novoDiretor) {
        var sql = "UPDATE filme SET diretor = ? WHERE id = ?";

        try(var connection = ConexaoBanco.getConexao(); var statement = connection.prepareStatement(sql)) {
            statement.setString(1, novoDiretor);
            statement.setInt(2, id);

            var affectedRows = statement.executeUpdate();
            System.out.println(affectedRows > 0 ? "Diretor modificado!" : "Filme não encontrado.");
        } catch (SQLException error) {
            System.out.println("Falha ao modificar: " + error.getMessage());
        }
    }

    public void removerFilme(int id) {
        var sql = "DELETE FROM filme WHERE id = ?";

        try(var connection = ConexaoBanco.getConexao(); var statement = connection.prepareStatement(sql)) {
            statement.setInt(1, id);

            var deletedRows = statement.executeUpdate();
            System.out.println(deletedRows > 0 ? "Filme excluído!" : "Filme não encontrado.");
        } catch (SQLException error) {
            System.out.println("Falha na exclusão: " + error.getMessage());
        }
    }
}
