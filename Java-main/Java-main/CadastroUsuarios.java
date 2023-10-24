import java.awt.LayoutManager;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.TableModel;

public class CadastroUsuarios extends JFrame {
    private JTextField inputNome;
    private JTextField inputIdade;
    private DefaultTabletModel tableModel;//determina linhas e colunas
    private JTable Table;//mostra as tebelas
    private List<Usuario> usuarios = new ArrayList<>();
    private int linhaSelecionada = -1; // para criar uma linha anterior do 0


    public CadastroUsuarios() {
        super("Cadastro de Usuários");
        setSize(600, 300);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        tableModel = new DefaultTabletModel();
        tableModel.addColumn("Nome");
        tableModel.addColumn("Idade");

        Table = new JTable((TableModel) tableModel);
        JScrollPane scrollPane = new JScrollPane(Table);

        inputNome = new JTextField(20);
        inputIdade = new JTextField(5);
        JButton cadastrarButton = new JButton("Cadastrar");
        JButton atualizarButton = new JButton("Atualizar");
        JButton apagarButton = new JButton("Apagar");
        JButton apagarTodosButton = new JButton("Apagar Todos");
        JButton salvarButton = new JButton("Salvar");

        // Estruturando o frame
        JPanel inputPanel = new JPanel();
        inputPanel.add(new JLabel("Nome:"));
        inputPanel.add(inputNome);
        inputPanel.add(new JLabel("Idade:"));
        inputPanel.add(inputIdade);
        inputPanel.add(cadastrarButton);
        inputPanel.add(atualizarButton);
        inputPanel.add(apagarButton);
        inputPanel.add(apagarTodosButton);
        inputPanel.add(salvarButton);
        //add ao layout
        setLayout((LayoutManager) new BorderLayout());
        add(inputPanel, BorderLayout.NORTH);
        add(scrollPane, BorderLayout.CENTER);
    }
}
