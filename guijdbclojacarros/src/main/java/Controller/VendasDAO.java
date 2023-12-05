package Controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import Connection.ConnectionFactory;
import Model.Vendas;
import logs.RegistroOperacoes;

public class VendasDAO {

    private Connection connection;
    private List<Vendas> vendas;

    public VendasDAO() {
        this.connection = ConnectionFactory.getConnection();
    }

    public void criaTabela() {
        String sql = "CREATE TABLE IF NOT EXISTS carros_lojacarros (Nome VARCHAR(255), CPF VARCHAR(255), RG VARCHAR(255), Data VARCHAR(255) PRIMARY KEY, CEP VARCHAR(255))";
        try (Statement stmt = this.connection.createStatement()) {
            stmt.execute(sql);
            System.out.println("Tabela criada com sucesso.");
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao criar a tabela: " + e.getMessage(), e);
        } finally {
            ConnectionFactory.closeConnection(this.connection);
        }
    }

    public List<Vendas> listarTodos() {
        PreparedStatement stmt = null;
        ResultSet rs = null;
        vendas = new ArrayList<>();

        try {
            stmt = connection.prepareStatement("SELECT * FROM carros_lojacarros");
            rs = stmt.executeQuery();

            while (rs.next()) {
                Vendas venda = new Vendas(
                        rs.getString("Nome"),
                        rs.getString("CPF"),
                        rs.getString("RG"),
                        rs.getString("Data"),
                        rs.getString("CEP")
                );
                vendas.add(venda);
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        } finally {
            ConnectionFactory.closeConnection(connection, stmt, rs);
        }
        return vendas;
    }

    public void cadastrar(String Nome, String CPF, String RG, String Data, String CEP) {
        try (PreparedStatement stmt = connection.prepareStatement(
                "INSERT INTO carros_lojacarros (Nome, CPF, RG, Data, CEP) VALUES (?, ?, ?, ?, ?)")) {

            stmt.setString(1, Nome);
            stmt.setString(2, CPF);
            stmt.setString(3, RG);
            stmt.setString(4, Data);
            stmt.setString(5, CEP);
            stmt.executeUpdate();

            System.out.println("Dados inseridos com sucesso");
            RegistroOperacoes.registrarOperacao("Carro do Nome: " + Nome + " Cadastrado com Sucesso.");

        } catch (SQLException e) {
            throw new RuntimeException("Erro ao inserir dados no banco de dados.", e);
        }
    }

    public void atualizar(String Nome, String CPF, String RG, String Data, String CEP) {
        try (PreparedStatement stmt = connection.prepareStatement(
                "UPDATE carros_lojacarros SET CPF = ?, RG = ?, Data = ? WHERE Nome = ?")) {

            stmt.setString(1, CPF);
            stmt.setString(2, RG);
            stmt.setString(3, Data);
            stmt.setString(4, Nome);
            stmt.executeUpdate();

            System.out.println("Dados atualizados com sucesso");
            RegistroOperacoes.registrarOperacao("Dados de: " + Nome + " Atualizados com Sucesso.");

        } catch (SQLException e) {
            throw new RuntimeException("Erro ao atualizar dados no banco de dados.", e);
        }
    }

    public void apagar(String Nome) {
        try (PreparedStatement stmt = connection.prepareStatement(
                "DELETE FROM carros_lojacarros WHERE Nome = ?")) {

            stmt.setString(1, Nome);
            stmt.executeUpdate();

            System.out.println("Dado apagado com sucesso");
            RegistroOperacoes.registrarOperacao("Dados de: " + Nome + " Apagados do Banco com Sucesso.");

        } catch (SQLException e) {
            throw new RuntimeException("Erro ao apagar dados no banco de dados.", e);
        }
    }
}
