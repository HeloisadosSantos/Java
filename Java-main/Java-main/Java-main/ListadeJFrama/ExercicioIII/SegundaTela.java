package ExercicioIII;
import javax.swing.*;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SegundaTela extends JFrame {
    private JLabel tituloLabel;
    private JLabel emailLabel;
    private JLabel senhaLabel;
    private JTextField email;
    private JTextField senha;

    public SegundaTela() {
        super("Login");
        this.setBounds(300, 300, 450, 230);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        JPanel painel1 = new JPanel(); // Inicialize o JPanel

        painel1.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 20));

        tituloLabel = new JLabel("LOGIN");
        emailLabel = new JLabel ("E-mail");
        senhaLabel = new JLabel ("Senha");

        tituloLabel.setFont(new Font("Arial", Font.BOLD, 30));
        tituloLabel.setHorizontalAlignment(SwingConstants.CENTER);

        senha = new JTextField(10);
        email = new JTextField(10);
        
        painel1.add(emailLabel);
        painel1.add(email);
        painel1.add(senhaLabel);
        painel1.add(senha); // Adicione o campo de senha

        JButton botaoVoltar = new JButton("Voltar"); // Crie um novo botão para voltar
        botaoVoltar.setBackground(new Color(0, 0, 0));
        botaoVoltar.setForeground(Color.WHITE);

        botaoVoltar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                NavegacaoFrame primeiraTela = new NavegacaoFrame();
                primeiraTela.setVisible(true);
                dispose(); // Fecha a tela atual
            }
        });

        panel.add(botaoVoltar); // Adicione o botão para voltar
        panel.add(tituloLabel);

        this.add(panel);
        this.setSize(300, 455);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }
}
