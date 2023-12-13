package Connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import Model.Clientes;

public class ClientesDAO {
    // atributo
    private Connection connection;
    private List<Clientes> clientes;

    // construtor
    public ClientesDAO() {
        this.connection = ConnectionFactory.getConnection();
    }

    // criar Tabela
    public void criaTabela() {
        String sql = "CREATE TABLE IF NOT EXISTS clientes_mercado (NOME VARCHAR(255),ENDERECO VARCHAR(255),TELEFONE VARCHAR(255),CPF VARCHAR(255) PRIMARY KEY)";
        try (Statement stmt = this.connection.createStatement()) {
            stmt.execute(sql);
            System.out.println("Tabela criada com sucesso.");
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao criar a tabela: " + e.getMessage(), e);
        } finally {
            ConnectionFactory.closeConnection(this.connection);
        }
    }

    // Listar todos os valores cadastrados
    public List<Clientes> listarTodos() {
        PreparedStatement stmt = null;
        // Declaração do objeto PreparedStatement para executar a consulta
        ResultSet rs = null;
        // Declaração do objeto ResultSet para armazenar os resultados da consulta
        clientes = new ArrayList<>();
        // Cria uma lista para armazenar os carros recuperados do banco de dados
        try {
            stmt = connection.prepareStatement("SELECT * FROM clientes_mercado");
            // Prepara a consulta SQL para selecionar todos os registros da tabela
            rs = stmt.executeQuery();
            // Executa a consulta e armazena os resultados no ResultSet
            while (rs.next()) {
                // Para cada registro no ResultSet, cria um objeto Carros com os valores do
                // registro

                Clientes cliente = new Clientes(
                        rs.getString("nome"),
                        rs.getString("endereco"),
                        rs.getString("telefone"),
                        rs.getString("cpf"));
                clientes.add(cliente); // Adiciona o objeto Carros à lista de carros
            }
        } catch (SQLException ex) {
            System.out.println(ex); // Em caso de erro durante a consulta, imprime o erro
        } finally {
            ConnectionFactory.closeConnection(connection, stmt, rs);

            // Fecha a conexão, o PreparedStatement e o ResultSet
        }
        return clientes; // Retorna a lista de carros recuperados do banco de dados
    }

    // Cadastrar Cliente no banco
public void cadastrar(String nome, String endereco, String telefone, String cpf) {
    PreparedStatement stmt = null;
    // Define a instrução SQL parametrizada para cadastrar na tabela
    String sql = "INSERT INTO clientes_mercado (nome, endereco, telefone, cpf) VALUES (?, ?, ?, ?)";
    try {
        stmt = connection.prepareStatement(sql);
        stmt.setString(1, nome);
        stmt.setString(2, endereco);
        stmt.setString(3, telefone);
        stmt.setString(4, cpf);
        stmt.executeUpdate();
        System.out.println("Dados inseridos com sucesso");
    } catch (SQLException e) {
        throw new RuntimeException("Erro ao inserir dados no banco de dados.", e);
    } finally {
        ConnectionFactory.closeConnection(connection, stmt);
    }
}

    // Atualizar dados no banco
    public void atualizar(String nome, String endereco, String telefone, String cpf) {
        PreparedStatement stmt = null;
        // Define a instrução SQL parametrizada para atualizar dados pela placa
        String sql = "UPDATE clientes_mercado SET nome = ?, endereco = ?, telefone = ? WHERE, cpf =?";
        try {
            stmt = connection.prepareStatement(sql);
            stmt.setString(1, nome);
            stmt.setString(2, endereco);
            stmt.setString(3, telefone);
            stmt.setString(4, cpf);
            // placa é chave primaria não pode ser alterada.
            stmt.executeUpdate();
            System.out.println("Dados atualizados com sucesso");
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao atualizar dados no banco de dados.", e);
        } finally {
            ConnectionFactory.closeConnection(connection, stmt);
        }
    }

    // Apagar dados do banco
    public boolean apagarCliente(String cpf) {
        String sql = "DELETE FROM clientes_mercado WHERE cpf = ?";

        try (Connection connection = DriverManager.getConnection(sql);
                PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            // Set the parameter for the prepared statement
            preparedStatement.setString(1, cpf);

            // Execute the deletion
            int rowsDeleted = preparedStatement.executeUpdate();

            // Check if the deletion was successful
            return rowsDeleted > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

}