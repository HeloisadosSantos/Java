import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.JTextComponent;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

public class CadastroAgenda extends JPanel {
    private JTextField inputData;
    private JTextField inputHora;
    private JComboBox<String> comboBoxUsuarios; // JComboBox para os usuários
    private JTextField inputDescricao;
    private DefaultTableModel agendaTableModel;
    private JTable agendaTable;
    private List<Agenda> agendas = new ArrayList<>();
    private int linhaSelecionadaAgenda = -1;

    /**
     * 
     */
    public CadastroAgenda() {
        
        agendaTableModel = new DefaultTableModel();
        agendaTableModel.addColumn("Data");
        agendaTableModel.addColumn("Hora");
        agendaTableModel.addColumn("Usuário");
        agendaTableModel.addColumn("Descrição");

        agendaTable = new JTable(agendaTableModel);
        JScrollPane scrollPaneAgenda = new JScrollPane(agendaTable);

        inputData = new JTextField(10);
        inputHora = new JTextField(10);
        comboBoxUsuarios = new JComboBox<>();
        List<Usuario> usuarios;
        for (Usuario usuario : usuarios) {
            comboBoxUsuarios.addItem(usuario.getNome());
        }
        inputDescricao = new JTextField(25);
        JButton cadastrarAgendaButton = new JButton("Agendar");
        JButton atualizarAgendaButton = new JButton("Atualizar");
        JButton apagarAgendaButton = new JButton("Apagar");
        JButton salvarAgendaButton = new JButton("Salvar");

        JPanel inputAgendaPanel = new JPanel();
        inputAgendaPanel.add(new JLabel("Data:"));
        inputAgendaPanel.add(inputData);
        inputAgendaPanel.add(new JLabel("Hora"));
        inputAgendaPanel.add(inputHora);
        inputAgendaPanel.add(new JLabel("Usuário"));
        inputAgendaPanel.add(comboBoxUsuarios);
        inputAgendaPanel.add(new JLabel("Descrição"));
        inputAgendaPanel.add(inputDescricao);
        inputAgendaPanel.add(cadastrarAgendaButton);
        inputAgendaPanel.add(atualizarAgendaButton);
        inputAgendaPanel.add(apagarAgendaButton);
        inputAgendaPanel.add(salvarAgendaButton);

        setLayout(new BorderLayout());
        add(inputAgendaPanel, BorderLayout.NORTH);
        add(scrollPaneAgenda, BorderLayout.CENTER);

        File arquivo = new File("dados.txt");
        if (arquivo.exists()) {
            usuarios = Serializacao.deserializar("dados.txt");
            abrirCadastro();
        } 

        agendaTable.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent evt) {
                linhaSelecionadaAgenda = agendaTable.rowAtPoint(evt.getPoint());
            }
        });

        OperacoesAgenda operacoesAgenda = new OperacoesAgenda(agendas, agendaTableModel, agendaTable);

        cadastrarAgendaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JTextComponent inputNome;
                JTextComponent inputIdade;
                operacoesAgenda.cadastrarUsuario(inputNome.getText(), inputIdade.getText());
                inputNome.setText("");
                inputIdade.setText("");
            }
        });

        atualizarAgendaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                operacoesAgenda.atualizarUsuario(linhaSelecionadaAgenda, inputData.getText(), inputIdade.getText());
            }
        });

        apagarAgendaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                operacoesAgenda.apagarUsuario(linhaSelecionadaAgenda);
            }
        });

        salvarAgendaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                operacoesAgenda.salvarUsuarios();
            }
        });
    }

    private void abrirCadastro() {
        agendaTableModel.setRowCount(0);
        for (Agenda agenda : agendas) {
            agendaTableModel.addRow(new Object[] { agenda.getNome(), agenda.getIdade() });
        }
    }

    
}
