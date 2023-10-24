package ExercicioIII;
import javax.swing.*;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class NavegacaoFrame extends JFrame {
    private JLabel titulo;

    public NavegacaoFrame() {
        super("Pagina Inicial");

        JPanel panel2 = new JPanel();
        JPanel panel = new JPanel();

        panel2.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 20));

        titulo = new JLabel("Bem Vinda!!"); // Inicialize o JLabel

        titulo.setFont(new Font("Arial", Font.BOLD, 30));
        titulo.setHorizontalAlignment(SwingConstants.CENTER);

        JButton botao = new JButton("Login");
        botao.setBackground(new Color(0, 0, 0)); // Corrigido para formato hexadecimal
        botao.setForeground(Color.WHITE);

        JButton botao2 = new JButton("Cadastro");
        botao2.setBackground(new Color(0, 0, 0)); // Corrigido para formato hexadecimal
        botao2.setForeground(Color.WHITE);

        JLabel imagemFundo = new JLabel(new ImageIcon("F:\\ListadeJFrama\\img\\mulher.png"));

        botao.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SegundaTela segundaTela = new SegundaTela();
                segundaTela.setVisible(true);
                dispose();
            }
        });

        botao2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                TerceiraTela terceiraTela = new TerceiraTela();
                terceiraTela.setVisible(true);
                dispose();
            }
        });

        panel.add(imagemFundo);
        panel.add(botao);
        panel.add(botao2);
        panel.add(titulo);

        this.add(panel);
        this.setSize(300, 455);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            NavegacaoFrame navegacaoFrame = new NavegacaoFrame();
            navegacaoFrame.setVisible(true);
        });
    }
}
