package View;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.BoxLayout;

import Model.Cadastro;

public class CadastrodeClientes extends JPanel {

    private JButton cadastrar, apagar, editar;
    private JTextField rgField, cpfField, anoField, dataNascimentoField, nomeField, enderecoField, cidadeField;
    private List<Cadastro> cadastros;
    private JTable table;
    private DefaultTableModel tableModel;
    private int linhaSelecionada = -1;

    public CadastrodeClientes() {
        super();

        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        add(new JLabel("Cadastro de Pessoas"));
        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new GridLayout(7, 2));
        inputPanel.add(new JLabel("RG"));
        rgField = new JTextField(20);
        inputPanel.add(rgField);
        inputPanel.add(new JLabel("CPF"));
        cpfField = new JTextField(20);
        inputPanel.add(cpfField);
        inputPanel.add(new JLabel("Ano"));
        anoField = new JTextField(20);
        inputPanel.add(anoField);
        inputPanel.add(new JLabel("Data de Nascimento"));
        dataNascimentoField = new JTextField(20);
        inputPanel.add(dataNascimentoField);
        inputPanel.add(new JLabel("Nome"));
        nomeField = new JTextField(20);
        inputPanel.add(nomeField);
        inputPanel.add(new JLabel("Endereço"));
        enderecoField = new JTextField(20);
        inputPanel.add(enderecoField);
        inputPanel.add(new JLabel("Cidade"));
        cidadeField = new JTextField(20);
        inputPanel.add(cidadeField);
        add(inputPanel);

        JPanel botoes = new JPanel();
        cadastrar = new JButton("Cadastrar");
        editar = new JButton("Editar");
        apagar = new JButton("Apagar");
        botoes.add(cadastrar);
        botoes.add(editar);
        botoes.add(apagar);
        add(botoes);

        JScrollPane jSPane = new JScrollPane();
        add(jSPane);
        tableModel = new DefaultTableModel(new Object[][]{},
                new String[]{"RG", "CPF", "Ano", "Data de Nascimento", "Nome", "Endereço", "Cidade"});
        table = new JTable(tableModel);
        jSPane.setViewportView(table);

        criaTabela();
        atualizarTabela();

        table.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent evt) {
                linhaSelecionada = table.rowAtPoint(evt.getPoint());
                if (linhaSelecionada != -1) {
                    rgField.setText((String) table.getValueAt(linhaSelecionada, 0));
                    cpfField.setText((String) table.getValueAt(linhaSelecionada, 1));
                    anoField.setText((String) table.getValueAt(linhaSelecionada, 2));
                    dataNascimentoField.setText((String) table.getValueAt(linhaSelecionada, 3));
                    nomeField.setText((String) table.getValueAt(linhaSelecionada, 4));
                    enderecoField.setText((String) table.getValueAt(linhaSelecionada, 5));
                    cidadeField.setText((String) table.getValueAt(linhaSelecionada, 6));
                }
            }
        });

        cadastrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cadastrar();
                limparCampos();
                atualizarTabela();
            }
        });

        editar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                editar();
                limparCampos();
                atualizarTabela();
            }
        });

        apagar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                apagar();
                limparCampos();
                atualizarTabela();
            }
        });
    }

    private void criaTabela() {
        cadastros = new ArrayList<>();
    }

    private void cadastrar() {
        Cadastro novoCadastro = new Cadastro(
                rgField.getText(),
                cpfField.getText(),
                anoField.getText(),
                dataNascimentoField.getText(),
                nomeField.getText(),
                enderecoField.getText(),
                cidadeField.getText()
        );
        cadastros.add(novoCadastro);
    }

    private void editar() {
        if (linhaSelecionada != -1) {
            Cadastro cadastroSelecionado = cadastros.get(linhaSelecionada);
            cadastroSelecionado.setRg(rgField.getText());
            cadastroSelecionado.setCpf(cpfField.getText());
            cadastroSelecionado.setAno(anoField.getText());
            cadastroSelecionado.setDataNascimento(dataNascimentoField.getText());
            cadastroSelecionado.setNome(nomeField.getText());
            cadastroSelecionado.setEndereco(enderecoField.getText());
            cadastroSelecionado.setCidade(cidadeField.getText());
        }
    }

    private void apagar() {
        if (linhaSelecionada != -1) {
            cadastros.remove(linhaSelecionada);
            linhaSelecionada = -1;
        }
    }

    private void atualizarTabela() {
        tableModel.setRowCount(0);
        for (Cadastro cadastro : cadastros) {
            tableModel.addRow(new Object[]{cadastro.getRg(), cadastro.getCpf(), cadastro.getAno(),
                cadastro.getDataNascimento(), cadastro.getNome(), cadastro.getEndereco(), cadastro.getCidade()});
        }
    }

    private void limparCampos() {
        rgField.setText("");
        cpfField.setText("");
        anoField.setText("");
        dataNascimentoField.setText("");
        nomeField.setText("");
        enderecoField.setText("");
        cidadeField.setText("");
    }
}
