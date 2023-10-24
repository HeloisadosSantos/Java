//imports
package ExercicioIII;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TodoList extends JFrame {

    // Componentes da interface
    private JLabel titleLabel;
    private JPanel mainPanel;
    private JTextField taskInputField;
    private JButton addButton;
    private JList<String> taskList;
    private DefaultListModel<String> listModel;
    private JButton deleteButton;
    private JButton markDoneButton;
    private JComboBox<String> filterComboBox;
    private JLabel relogioLabel; // Adicionado para o relógio

    private List<Task> tasks; // Lista de tarefas
    // construtor

    public TodoList() {
        super("Lista");

        // Configurações do frame
        this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        this.addWindowListener(new WindowAdapter() {
            @Override
            // aqui estamos colocando um metodo para algo acontecer quando o usuario for
            // fechar a janela
            public void windowClosing(WindowEvent e) {
                showExitConfimationDialog();
            }
        });
        // definindo o tamanho da janela
        this.setSize(450, 400);

        // Inicializa a lista de tarefas
        tasks = new ArrayList<>();

        // Inicializa o modelo da JList
        listModel = new DefaultListModel<>(); // Nesta linha, está sendo criado um novo objeto chamado listModel do tipo
                                              // DefaultListModel.
        taskList = new JList<>(listModel);// Aqui, está sendo criada uma nova instância de JList chamada taskList. Essa
                                          // instância de JList está sendo inicializada com o listModel que foi criado
                                          // anteriorment

        // Configuração do painel principal
        mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());
        mainPanel.setBackground(new Color(255, 102, 204));

        // Configuração do título
        titleLabel = new JLabel("ATIVIDADES");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 20));
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
        Border roundedBorder = BorderFactory.createLineBorder(new Color(0, 0, 0), 2, true);// preto
        titleLabel.setBorder(roundedBorder);

        // === Configuração do campo de entrada de tarefas e botão "Adicionar"
        taskInputField = new JTextField(); // Esta linha de código cria um campo de texto chamado taskInputField.
                                           // Detalhes: JTextField é um componente de interface gráfica em Java Swing
        // que permite ao usuário inserir texto. Neste caso, taskInputField será
        // usado para que o usuário possa digitar uma nova tarefa.
        addButton = new JButton("Adicionar");// Aqui, um botão chamado addButton está sendo criado com o texto
                                             // "Adicionar".

        // Configuração dos botões e ComboBox
        deleteButton = new JButton("Excluir");
        markDoneButton = new JButton("Concluir");
        filterComboBox = new JComboBox<>(new String[] { "Todas", "Ativas", "Concluídas" });

        // Configuração dos painéis
        JPanel inputPanel = new JPanel(new BorderLayout());
        inputPanel.add(titleLabel, BorderLayout.NORTH);
        inputPanel.add(taskInputField, BorderLayout.CENTER);
        inputPanel.add(addButton, BorderLayout.EAST);
        inputPanel.setBackground(new Color(255, 102, 204));// rosa

        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        buttonPanel.add(deleteButton);
        buttonPanel.add(markDoneButton);
        buttonPanel.add(filterComboBox);
        buttonPanel.setBackground(new Color(255, 102, 204));// rosa

        // Configuração da JList
        taskList.setBackground(new Color(173, 216, 230)); // azul

        // Adicionando os componentes ao painel principal
        mainPanel.add(inputPanel, BorderLayout.NORTH);// provavelmente contém elementos de entrada, como campos de texto
                                                      // ou botões que permitem ao usuário inserir informações ou
                                                      // comandos.
        mainPanel.add(new JScrollPane(taskList), BorderLayout.CENTER);// (uma lista de tarefas) está sendo colocada no
                                                                      // centro do mainPanel e, se necessário, terá
                                                                      // barras de rolagem para visualizar todos os
                                                                      // itens, graças ao JScrollPane.
        mainPanel.add(buttonPanel, BorderLayout.SOUTH);

        // Adicionando o JLabel para o relógio
        relogioLabel = new JLabel();
        relogioLabel.setHorizontalAlignment(SwingConstants.RIGHT);
        relogioLabel.setFont(new Font("Arial", Font.PLAIN, 12));
        buttonPanel.add(relogioLabel);

        // ActionListener para atualizar o horário
        ActionListener updateRelogio = new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
                Date agora = new Date();
                relogioLabel.setText(sdf.format(agora));
            }
        };

        // Timer para atualizar o horário a cada segundo
        Timer timer = new Timer(1000, updateRelogio);// indica o tempo em milissegundos. Neste caso, está configurado
                                                     // para 1000 milissegundos, o que equivale a 1 segundo.
        timer.start();// Esta linha inicia o timer, fazendo com que ele comece a contar o tempo e
                      // execute a ação definida a cada 1 segundo (conforme configurado
                      // anteriormente).

        // Configurações do botão "Adicionar"
        addButton.addActionListener(e -> addTask());

        // Configurações do botão "Excluir"
        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedIndex = taskList.getSelectedIndex();
                if (selectedIndex >= 0) {
                    tasks.remove(selectedIndex);
                    updateTaskList();
                }
            }
        });

        // Configurações do botão "Concluir"
        markDoneButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedIndex = taskList.getSelectedIndex();
                if (selectedIndex >= 0) {
                    Task selectedTask = tasks.get(selectedIndex);
                    selectedTask.setCompleted(true);
                    updateTaskList(); // em si é uma instrução que diz ao programa para executar a função chamada
                                      // updateTaskList()
                }
            }
        });

        // Configurações do ComboBox de filtro
        filterComboBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String selectedFilter = (String) filterComboBox.getSelectedItem();
                filterTasks(selectedFilter);
            }
        });

        // Adiciona o painel principal ao JFrame
        this.add(mainPanel);
    }

  private void showExitConfimationDialog() {
    int opcoes = JOptionPane.showConfirmDialog(this,
            "Deseja Sair?",
            "Confirmação",
            JOptionPane.YES_NO_OPTION);

    if (opcoes == JOptionPane.YES_OPTION) {
        System.out.println("FECHANDO SISTEMA..........");
        System.exit(0);
    }
}


    // Filtra as tarefas de acordo com o critério selecionado
    private void filterTasks(String filter) {
        listModel.clear();// Aqui, está sendo limpo o listModel. Isso significa que todos os elementos que
                          // estavam na lista serão removidos.
        for (Task task : tasks) {
            boolean shouldAddTask = false;
            if (filter.equals("Todas")) {
                shouldAddTask = true;
            } else if (filter.equals("Ativas") && !task.isCompleted()) {
                shouldAddTask = true;
            } else if (filter.equals("Concluídas") && task.isCompleted()) {
                shouldAddTask = true;
            }

            if (shouldAddTask) {
                String description = task.getDescription();
                if (task.isCompleted()) {
                    description = "[Concluída] " + description;
                }
                listModel.addElement(description);
            }
        }
    }

    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_SPACE) {

        }
    }

    // Adiciona uma nova tarefa
    private void addTask() {
        String taskDescription = taskInputField.getText().trim();
        if (!taskDescription.isEmpty()) {
            Task newTask = new Task(taskDescription);
            tasks.add(newTask);
            updateTaskList();
            taskInputField.setText("");
        }
    }

    // Atualiza a lista de tarefas na JList
    private void updateTaskList() {
        listModel.clear();
        for (Task task : tasks) { // Itera sobre cada tarefa na lista tasks.
            String description = task.getDescription();
            if (task.isCompleted()) {
                description = "[Concluída] " + description;
            }
            listModel.addElement(description);
        }
    }

    // Inicia a execução da aplicação
    public void run() {
        this.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new TodoList().run();
        });
    }
}
