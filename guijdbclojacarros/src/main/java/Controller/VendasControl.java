package Controller;

import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import Model.Carros;

/**
 * CarrosControl
 */
public class VendasControl {

    // Atributos
    private List<Carros> carros; // Lista de objetos Carros
    private DefaultTableModel tableModel; // Modelo da tabela Swing para exibição dos dados
    private JTable table; // Tabela Swing onde os dados são exibidos

    // Construtor
    public VendasControl(List<Carros> carros, DefaultTableModel tableModel, JTable table) {
        this.carros = carros; // Inicializa a lista de carros
        this.tableModel = tableModel; // Inicializa o modelo da tabela
        this.table = table; // Inicializa a tabela Swing
    }

    // Método para atualizar a tabela de exibição com dados do banco de dados
    private void atualizarTabela() {
        tableModel.setRowCount(0); // Limpa todas as linhas existentes na tabela
        carros = new CarrosDAO().listarTodos(); // Obtém os carros atualizados do banco de dados
        for (Carros carro : carros) {
            // Adiciona os dados de cada carro como uma nova linha na tabela Swing
            tableModel.addRow(new Object[]{carro.getMarca(), carro.getModelo(), carro.getAno(), carro.getPlaca(), carro.getValor()});
        }
    }

    // Método para ação concluída
    private void acaoConcluida(String mensagem) {
        JOptionPane.showMessageDialog(null, mensagem, "Ação Concluída", JOptionPane.INFORMATION_MESSAGE);
    }

    // Método para validar o ano como numérico
    private boolean validarAno(String ano) {
        try {
            Integer.parseInt(ano);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    // Método para validar o valor como double
    private boolean validarValor(String valor) {
        try {
            Double.parseDouble(valor);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    // Método para cadastrar um novo carro no banco de dados
    public void cadastrar(String marca, String modelo, String ano, String placa, String valor) {
        if (!validarAno(ano) || !validarValor(valor)) {
            JOptionPane.showMessageDialog(null, "Dados inválidos. Verifique o ano e o valor.", "Erro de Validação", JOptionPane.ERROR_MESSAGE);
            return;
        }

        new CarrosDAO().cadastrar(marca, modelo, ano, placa, valor);

        // Chama o método de cadastro no banco de dados
        atualizarTabela(); // Atualiza a tabela de exibição após o cadastro

        acaoConcluida("Carro cadastrado com sucesso!");
    }

    // Método para atualizar os dados de um carro no banco de dados
    public void atualizar(String marca, String modelo, String ano, String placa, String valor) {
        int resposta = JOptionPane.showConfirmDialog(null, "Deseja realmente atualizar o carro?", "Confirmação", JOptionPane.YES_NO_OPTION);
        if (resposta == JOptionPane.YES_OPTION) {
            if (!validarAno(ano) || !validarValor(valor)) {
                JOptionPane.showMessageDialog(null, "Dados inválidos. Verifique o ano e o valor.", "Erro de Validação", JOptionPane.ERROR_MESSAGE);
                return;
            }

            new CarrosDAO().atualizar(marca, modelo, ano, placa, valor);
            // Chama o método de atualização no banco de dados
            atualizarTabela(); // Atualiza a tabela de exibição após a atualização

            acaoConcluida("Carro atualizado com sucesso!");
        }
    }

    // Método para apagar um carro do banco de dados
    public void apagar(String placa) {
        int resposta = JOptionPane.showConfirmDialog(null, "Deseja realmente apagar o carro?", "Confirmação", JOptionPane.YES_NO_OPTION);
        if (resposta == JOptionPane.YES_OPTION) {
            new CarrosDAO().apagar(placa);
            // Chama o método de exclusão no banco de dados
            atualizarTabela(); // Atualiza a tabela de exibição após a exclusão

            acaoConcluida("Carro apagado com sucesso!");
        }
    }
}
