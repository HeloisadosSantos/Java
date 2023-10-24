package ExercicioIII;

import javax.swing.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TerceiraTela extends JFrame {
    public TerceiraTela() {
        super("Cadastro");

        JPanel panel = new JPanel();

        JButton botao2 = new JButton("Voltar para a Primeira Tela");
        botao2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                NavegacaoFrame primeiraTela = new NavegacaoFrame();
                primeiraTela.setVisible(true);
                dispose(); // Fecha a tela atual
            }
        });

        panel.add(botao2);// Adiciona os botões ao JPanel

        this.add(panel); // Adiciona o JPanel ao JFrame
        this.setSize(300, 455);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }
}
