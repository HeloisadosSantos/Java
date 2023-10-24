import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;

public class RelogioGUI extends JFrame {
    private JLabel labelRelogio;

    public RelogioGUI() {
        // Configurações do JFrame
        setTitle("Relógio");
        setSize(200, 100);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        // Criação do JLabel
        labelRelogio = new JLabel();
        labelRelogio.setHorizontalAlignment(JLabel.CENTER);
        add(labelRelogio);

        // Configuração do Timer para atualizar o relógio a cada segundo
        Timer timer = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                atualizarRelogio();
            }
        });
        timer.start();
    }

    private void atualizarRelogio() {
        SimpleDateFormat formatoHora = new SimpleDateFormat("HH:mm:ss");
        Date agora = new Date();
        labelRelogio.setText(formatoHora.format(agora));
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new RelogioGUI().setVisible(true);
            }
        });
    }
}
