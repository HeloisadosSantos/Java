import java.util.ArrayList;
import java.util.List;

import javax.swing.*;
import javax.swing.border.Border;

import java.awt.*;

public class TodoList extends JFrame {
    private JLabel titleLabel;
    private JPanel mainPanel;
    private JTextField taskInputField;
    private JButton addButton;
    private JList<String> taskList;
    private DefaultListModel<String> listModel;
    private JButton deleteButton;
    private JButton markDoneButton;
    private JComboBox<String> filterComboBox;
    private JButton clearCompletedButton;
    private List<Task> tasks;

    public TodoList() {
        super("Lista");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(450, 400);

        mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());

        tasks = new ArrayList<>();
        listModel = new DefaultListModel<>();
        taskList = new JList<>(listModel);

        titleLabel = new JLabel("TAREFAS DO DIA");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 20));
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);

        taskInputField = new JTextField();
        addButton = new JButton("Adicionar");
        deleteButton = new JButton("Excluir");
        markDoneButton = new JButton("Concluir");
        filterComboBox = new JComboBox<>(new String[] { "Todas", "Ativas", "Concluídas" });
        clearCompletedButton = new JButton("Limpar Concluídas");

        JPanel inputPanel = new JPanel(new BorderLayout());
        inputPanel.add(titleLabel, BorderLayout.NORTH);
        inputPanel.setBackground(new Color(255, 102, 204));
        inputPanel.add(taskInputField, BorderLayout.CENTER);
        inputPanel.add(addButton, BorderLayout.EAST);

        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        buttonPanel.add(deleteButton);
        buttonPanel.add(markDoneButton);
        buttonPanel.add(filterComboBox);
        buttonPanel.add(clearCompletedButton);
        buttonPanel.setBackground(new Color(255, 102, 204));

        mainPanel.add(inputPanel, BorderLayout.NORTH);
        mainPanel.add(new JScrollPane(taskList), BorderLayout.CENTER);
        taskList.setBackground(new Color(0, 255, 255));
        mainPanel.add(buttonPanel, BorderLayout.SOUTH);
        mainPanel.setBackground(new Color(255, 102, 204));

        this.add(mainPanel);

        Border roundedBorder = BorderFactory.createLineBorder(new Color(0, 0, 0), 2, true);
        titleLabel.setBorder(roundedBorder);

        addButton.addActionListener(e -> addTask());
    }

    public void run() {
        this.setVisible(true);
    }

    private void addTask() {
        String taskDescription = taskInputField.getText().trim();
        if (!taskDescription.isEmpty()) {
            Task newTask = new Task(taskDescription);
            tasks.add(newTask);
            updateTaskList();
            taskInputField.setText("");
        }
    }

    private void updateTaskList() {
        listModel.clear();
        for (Task task : tasks) {
            listModel.addElement(task.getDescription());
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new TodoList().run();
            }
        });
    }
}
