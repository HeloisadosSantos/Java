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

import Controller.CarrosControl;
import Controller.CarrosDAO;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import Model.Carros;

public class CarrosPainel extends JPanel {

    // Atributos(componentes)
    private JButton cadastrar, apagar, editar;
    private JTextField carMarcaField, carModeloField, carAnoField, carPlacaField, carValorField;
    private List<Carros> carros;
    private JTable table;
    private DefaultTableModel tableModel;
    private int linhaSelecionada = -1;

    // Construtor(GUI-JPanel)
    public CarrosPainel() {
        super();

        // entrada de dados
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setBackground(Color.BLACK);
        setForeground(Color.WHITE);

        add(new JLabel("Cadastro Carros"));
        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new GridLayout(5, 2));
        inputPanel.setBackground(Color.BLACK);
        inputPanel.setForeground(Color.WHITE);
        addComponent(inputPanel, new JLabel("Marca"), carMarcaField = createTextField());
        addComponent(inputPanel, new JLabel("Modelo"), carModeloField = createTextField());
        addComponent(inputPanel, new JLabel("Ano"), carAnoField = createTextField());
        addComponent(inputPanel, new JLabel("Placa"), carPlacaField = createTextField());
        addComponent(inputPanel, new JLabel("Valor"), carValorField = createTextField());
        add(inputPanel);

        JPanel botoes = new JPanel();
        botoes.setBackground(Color.BLACK);

        addButtons(botoes);

        add(botoes);

        // tabela de carros
        JScrollPane jSPane = new JScrollPane();
        add(jSPane);
        tableModel = new DefaultTableModel(new Object[][]{}, new String[]{"Marca", "Modelo", "Ano", "Placa", "Valor"});
        table = new JTable(tableModel);
        jSPane.setViewportView(table);

        // Cria o banco de dados caso não tenha sido criado
        new CarrosDAO().criaTabela();

        // incluindo elementos do banco na criação do painel
        atualizarTabela();

        // tratamento de Eventos
        addTableMouseListener();

        // Cria um objeto operacoes da classe CarrosControl para executar operações no
        // banco de dados
        CarrosControl operacoes = new CarrosControl(carros, tableModel, table);

        // Configura a ação do botão "cadastrar" para adicionar um novo registro no
        // banco de dados
        configureCadastrarButton(operacoes);

        // Configura a ação do botão "editar" para atualizar um registro no banco de
        // dados
        configureEditarButton(operacoes);

        // Configura a ação do botão "apagar" para excluir um registro no banco de
        // dados
        configureApagarButton(operacoes);

    }

    private JTextField createTextField() {
        JTextField textField = new JTextField(20);
        textField.setBackground(Color.BLACK);
        textField.setForeground(Color.WHITE);
        textField.setFont(new Font("Arial", Font.PLAIN, 14));
        return textField;
    }

    private void addComponent(JPanel panel, JLabel label, JTextField textField) {
        label.setForeground(Color.WHITE);
        panel.add(label);
        panel.add(textField);
    }

    private void addButtons(JPanel panel) {
        cadastrar = createButton("Cadastrar");
        editar = createButton("Editar");
        apagar = createButton("Apagar");

        panel.add(cadastrar);
        panel.add(editar);
        panel.add(apagar);
    }

    private JButton createButton(String text) {
        JButton button = new JButton(text);
        button.setBackground(Color.RED);
        button.setForeground(Color.WHITE);
        button.setFont(new Font("Arial", Font.PLAIN, 14));
        return button;
    }

    private void addTableMouseListener() {
        table.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent evt) {
                linhaSelecionada = table.rowAtPoint(evt.getPoint());
                if (linhaSelecionada != -1) {
                    carMarcaField.setText((String) table.getValueAt(linhaSelecionada, 0));
                    carModeloField.setText((String) table.getValueAt(linhaSelecionada, 1));
                    carAnoField.setText((String) table.getValueAt(linhaSelecionada, 2));
                    carPlacaField.setText((String) table.getValueAt(linhaSelecionada, 3));
                    carValorField.setText((String) table.getValueAt(linhaSelecionada, 4));
                }
            }
        });
    }

    private void configureCadastrarButton(CarrosControl operacoes) {
        cadastrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                operacoes.cadastrar(carMarcaField.getText(), carModeloField.getText(), carAnoField.getText(),
                        carPlacaField.getText(), carValorField.getText());

                carMarcaField.setText("");
                carModeloField.setText("");
                carAnoField.setText("");
                carPlacaField.setText("");
                carValorField.setText("");
            }
        });
    }

    private void configureEditarButton(CarrosControl operacoes) {
        editar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                operacoes.atualizar(carMarcaField.getText(), carModeloField.getText(), carAnoField.getText(),
                        carPlacaField.getText(), carValorField.getText());

                carMarcaField.setText("");
                carModeloField.setText("");
                carAnoField.setText("");
                carPlacaField.setText("");
                carValorField.setText("");
            }
        });
    }

    private void configureApagarButton(CarrosControl operacoes) {
        apagar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                operacoes.apagar(carPlacaField.getText());

                carMarcaField.setText("");
                carModeloField.setText("");
                carAnoField.setText("");
                carPlacaField.setText("");
                carValorField.setText("");
            }
        });
    }

    // atualizar Tabela de Carros com o Banco de Dados
    private void atualizarTabela() {
        tableModel.setRowCount(0);
        carros = new CarrosDAO().listarTodos();
        for (Carros carro : carros) {
            tableModel.addRow(new Object[]{carro.getMarca(), carro.getModelo(), carro.getAno(), carro.getPlaca(),
                carro.getValor()});
        }
    }
}
