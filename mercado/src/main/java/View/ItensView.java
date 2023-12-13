package View;

import Connection.ItensDAO;
import java.util.List;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import Controller.ItensControl;
import java.awt.GridLayout;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import Model.Itens;

public class ItensView extends JPanel {
    // Atributos
    private JButton cadastrar, editar;
    private JTextField itemProdutoField, itemQuantField, itemValorField;

    private List<Itens> itens;
    private JTable table;
    private DefaultTableModel tableModel;
    private int linhaSelecionada = -1;

    // Construtor
    public ItensView() {
        // Entrada de dados
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        add(new JLabel("Cadastro Itens"));

        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new GridLayout(5, 2));
        inputPanel.add(new JLabel("Produto"));
        itemProdutoField = new JTextField(20);
        inputPanel.add(itemProdutoField);
        inputPanel.add(new JLabel("Quant"));
        itemQuantField = new JTextField(20);
        inputPanel.add(itemQuantField);
        inputPanel.add(new JLabel("Valor"));
        itemValorField = new JTextField(20);
        inputPanel.add(itemValorField);
        add(inputPanel);

        JPanel botoes = new JPanel();
        cadastrar = new JButton("Cadastrar");
        editar = new JButton("Editar");
        botoes.add(cadastrar);
        botoes.add(editar);
        add(botoes);

        // Tabela de itens
        JScrollPane jScrollPane = new JScrollPane();
        add(jScrollPane);

        tableModel = new DefaultTableModel(new Object[][] {}, new String[] { "Produto", "Quant", "Valor" });
        table = new JTable(tableModel);
        jScrollPane.setViewportView(table);

        // Tratamento de tabela
        // Cria o banco de dados caso não tenha sido criado
        new ItensDAO().criaTabela();
        // Incluindo elementos do banco na criação do painel
        atualizarTabela();

        // Tratamento de Eventos
        table.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent evt) {
                linhaSelecionada = table.rowAtPoint(evt.getPoint());
                if (linhaSelecionada != -1) {
                    itemProdutoField.setText((String) table.getValueAt(linhaSelecionada, 0));
                    itemQuantField.setText((String) table.getValueAt(linhaSelecionada, 1));
                    itemValorField.setText((String) table.getValueAt(linhaSelecionada, 2));
                }
            }
        });

        // Cria um objeto operacoes da classe ItensControl para executar operações no
        // banco de dados
        ItensControl operacoes = new ItensControl(itens, tableModel, table);

        cadastrar.addActionListener(e -> {
            operacoes.cadastrar(itemProdutoField.getText(), itemQuantField.getText(), itemValorField.getText());
            // Limpa os campos de entrada após a operação de cadastro
            limparCamposEntrada();
        });

        // Configura a ação do botão "editar" para atualizar um registro no banco de
        // dados
        editar.addActionListener(e -> {
            operacoes.atualizar(itemProdutoField.getText(), itemQuantField.getText(), itemValorField.getText());
            // Limpa os campos de entrada após a operação de atualização
            limparCamposEntrada();
        });
    }

    private void atualizarTabela() {
        tableModel.setRowCount(0);
        itens = new ItensDAO().listarTodos();
        for (Itens item : itens) {
            tableModel.addRow(new Object[] { item.getProduto(), item.getQuant(), item.getValor() });
        }
    }

    private void limparCamposEntrada() {
        itemProdutoField.setText("");
        itemQuantField.setText("");
        itemValorField.setText("");
    }
}
