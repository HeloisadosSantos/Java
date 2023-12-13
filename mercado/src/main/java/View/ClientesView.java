package View;

import java.util.List;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import Connection.ClientesDAO;
import Controller.ClientesControl;
import Model.Clientes;

import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ClientesView extends JPanel {
    private static final List<Clientes> cliente = null;
    // Atributos
    private JButton cadastrar, editar;
    private JTextField nomeField, enderecoField, telefoneField, cpfField;
    private JTable table;
    private DefaultTableModel tableModel;
    private int linhaSelecionada = -1;

    // Construtor
    public ClientesView() {
        // Entrada de dados
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        add(new JLabel("Cadastro Clientes"));

        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new GridLayout(5, 2));
        inputPanel.add(new JLabel("Nome"));
        nomeField = new JTextField(20);
        inputPanel.add(nomeField);
        inputPanel.add(new JLabel("Endereço"));
        enderecoField = new JTextField(20);
        inputPanel.add(enderecoField);
        inputPanel.add(new JLabel("Telefone"));
        telefoneField = new JTextField(20);
        inputPanel.add(telefoneField);
        inputPanel.add(new JLabel("Cpf"));
        cpfField = new JTextField(20);
        inputPanel.add(cpfField);

        add(inputPanel);

        JPanel botoes = new JPanel();
        cadastrar = new JButton("Cadastrar");
        editar = new JButton("Editar");
        botoes.add(cadastrar);
        botoes.add(editar);
        add(botoes);

        // Tabela de itens
        JScrollPane jSPane = new JScrollPane();
        add(jSPane);

        tableModel = new DefaultTableModel(new Object[][] {}, new String[] { "Nome", "Endereço", "Telefone", "Cpf" });
        table = new JTable(tableModel);
        jSPane.setViewportView(table);

        // Tratamento de tabela
        new ClientesDAO().criaTabela();
        atualizarTabela();

        // Tratamento de Eventos
        table.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent evt) {
                linhaSelecionada = table.rowAtPoint(evt.getPoint());
                if (linhaSelecionada != -1) {
                    nomeField.setText((String) table.getValueAt(linhaSelecionada, 0));
                    enderecoField.setText((String) table.getValueAt(linhaSelecionada, 1));
                    telefoneField.setText((String) table.getValueAt(linhaSelecionada, 2));
                    cpfField.setText((String) table.getValueAt(linhaSelecionada, 3));
                }
            }
        });

        // Operações no banco de dados
        ClientesControl operacoes = new ClientesControl(cliente,tableModel, table);

        // Ação do botão "Cadastrar"
        cadastrar.addActionListener(e -> {
            operacoes.cadastrar(nomeField.getText(), enderecoField.getText(), telefoneField.getText(),
                    cpfField.getText());
            limparCampos();
        });

        // Ação do botão "Editar"
        editar.addActionListener(e -> {
            operacoes.atualizar(nomeField.getText(), enderecoField.getText(), telefoneField.getText(),
                    cpfField.getText());
            limparCampos();
        });
    }

    private void atualizarTabela() {
        List<Clientes> clientes = listarTodos();
        for (Clientes cliente : clientes) {
            tableModel.addRow(new Object[] { cliente.getNome(), cliente.getEndereco(), cliente.getTelefone(),
                    cliente.getCpf() });
        }
    }

    private List<Clientes> listarTodos() {
        return new ClientesDAO().listarTodos();
    }

    private void limparCampos() {
        nomeField.setText("");
        enderecoField.setText("");
        telefoneField.setText("");
        cpfField.setText("");
    }
}
