package CalculadoraDioguetes.src;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.border.Border;
import java.awt.Font;

public class CalcIMC extends JFrame {
    private JLabel titleLabel;
    private JLabel pesoLabel;
    private JLabel alturaLabel;
    private JTextField pesoTextField;
    private JTextField alturaTextField;
    private JButton calcularButton;
    private JLabel resultadoLabel;

    public CalcIMC() {
        // Configurações da janela principal
        super("Calculadora de IMC");
        this.setBounds(300, 300, 450, 230);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLayout(new GridLayout(5, 1));

        // Painéis para organizar os componentes
        JPanel painel1 = new JPanel();
        JPanel painel2 = new JPanel();
        JPanel painel3 = new JPanel();
        JPanel painel4 = new JPanel();
        JPanel painel5 = new JPanel();

        // Configuração dos layouts dos painéis
        painel1.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 20));
        painel2.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 5));
        painel3.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 5));
        painel4.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 10));
        painel5.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 10));

        // Criação de rótulos
        titleLabel = new JLabel("CALCULANDO SEU IMC");
        pesoLabel = new JLabel("Peso (em Kilos):");
        alturaLabel = new JLabel("Altura (em metros):");

        // Configuração da fonte para o título
        titleLabel.setFont(new Font("Arial", Font.BOLD, 20));
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);

        // Campos de entrada para peso e altura
        pesoTextField = new JTextField(10);
        alturaTextField = new JTextField(10);

        // Botão para calcular o IMC
        calcularButton = new JButton("Calcular");
        calcularButton.setBackground(new Color(255, 102, 204)); // Azul claro
        calcularButton.setForeground(Color.WHITE); // Texto em branco

        // Adiciona um ouvinte de ação ao botão
        calcularButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

            }
        });

        // Rótulo para exibir o resultado do cálculo
        resultadoLabel = new JLabel("", SwingConstants.CENTER);
        resultadoLabel.setFont(new Font("Arial", Font.BOLD, 18));

        // Adiciona os componentes aos painéis
        painel1.add(titleLabel);
        painel2.add(pesoLabel);
        painel2.add(pesoTextField);
        painel3.add(alturaLabel);
        painel3.add(alturaTextField);
        painel4.add(calcularButton);
        painel5.add(resultadoLabel);

        // Adiciona os painéis à janela principal
        this.add(painel1);
        this.add(painel2);
        this.add(painel3);
        this.add(painel4);
        this.add(painel5);

        // Define uma borda arredondada para os campos de entrada
        Border roundedBorder = BorderFactory.createLineBorder(new Color(255, 102, 204), 2, true);
        pesoTextField.setBorder(roundedBorder);
        alturaTextField.setBorder(roundedBorder);

        // Torna a janela visível
        this.setVisible(true);
    }
}
