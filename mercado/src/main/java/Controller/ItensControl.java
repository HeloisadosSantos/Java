package Controller;

import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import Connection.ItensDAO;
import Model.
Itens;

public class ItensControl {

    // Atributos
    private List<Itens> itens;
    private DefaultTableModel tableModel;
    // Construtor
    public ItensControl(List<Itens> item, DefaultTableModel tableModel, JTable table) {
        this.itens = item;
        this.tableModel = tableModel;

    }

    // Método para atualizar a tabela de exibição com dados do banco de dados
    private void atualizarTabela() {
        tableModel.setRowCount(0); // Limpa todas as linhas existentes na tabela
        itens = new ItensDAO().listarTodos();
        // Obtém os Itens atualizados do banco de dados
        for (Itens item : itens) {
            // Adiciona os dados de cada carro como uma nova linha na tabela Swing
            tableModel.addRow(new Object[] { item.getProduto(), item.getQuant(),
                    item.getValor()});
        }
    }

   // Método para cadastrar um novo item no banco de dados
public void cadastrar(String produto, String quant, String valor) {
    try {
        // Verifica se a quantidade e o valor são números válidos
        int quantidade = Integer.parseInt(quant);
        double valorDouble = Double.parseDouble(valor);

        // Chama o método de cadastro na classe ItensDAO
        new ItensDAO().cadastrar(produto, quantidade, valorDouble);

        // Atualiza a tabela de exibição após o cadastro
        atualizarTabela();
    } catch (NumberFormatException e) {
        // Trata a exceção se a quantidade ou o valor não forem números válidos
        JOptionPane.showMessageDialog(null, "Quantidade e valor devem ser números válidos.",
                "Erro de Validação", JOptionPane.ERROR_MESSAGE);
    }
}

    // Método para atualizar os dados de um carro no banco de dados
    public void atualizar(String produto, String quant, String valor ) {
        new ItensDAO().atualizar(produto, quant, valor);
        // Chama o método de atualização no banco de dados
        atualizarTabela(); // Atualiza a tabela de exibição após a atualização
    }

    // Método para apagar um carro do banco de dados
    public void apagar(String produto) {
        new ItensDAO().apagar(produto);
        // Chama o método de exclusão no banco de dados
        atualizarTabela(); // Atualiza a tabela de exibição após a exclusão

        // Cria o banco de dados caso não tenha sido criado
        new ItensDAO().criaTabela();

        // incluindo elementos do banco na criação do painel
        atualizarTabela();
    }
}
