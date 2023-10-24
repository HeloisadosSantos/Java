// import javax.swing.*;
// import java.awt.*;
// import java.awt.event.ActionEvent;
// import java.awt.event.ActionListener;

// public class CalculadoraConversor extends JFrame {
//     private JTextField valorRealField;
//     private JLabel resultadoLabel;

//     public CalculadoraConversor() {
//         // Configurar a janela
//         setTitle("Conversor de Moeda");
//         setSize(300, 150);
//         setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//         setLocationRelativeTo(null);

//         // Criar painel principal
//         JPanel panel = new JPanel();
//         panel.setLayout(new GridLayout(3, 2));

//         // Labels e campos de texto
//         JLabel realLabel = new JLabel("Valor em Real:");
//         valorRealField = new JTextField();

//         JLabel dolarLabel = new JLabel("Valor em Dólar:");
//         resultadoLabel = new JLabel("");

//         // Botão de conversão
//         JButton converterButton = new JButton("Converter");
//         converterButton.setBackground(Color.green);
//         converterButton.addActionListener(new ActionListener() {
//             @Override
//             public void actionPerformed(ActionEvent e) {
//                 converterMoeda();
//             }
//         });

//         // Adicionar componentes ao painel
//         panel.add(realLabel);
//         panel.add(valorRealField);
//         panel.add(dolarLabel);
//         panel.add(resultadoLabel);
//         panel.add(converterButton);

//         // Adicionar painel à janela
//         add(panel);

//         // Exibir a janela
//         setVisible(true);
//     }

//     private void converterMoeda() {
//         try {
//             // Obter o valor em real a partir do campo de texto
//             double valorReal = Double.parseDouble(valorRealField.getText());

//             // Taxa de conversão (substitua pela taxa atual)
//             double taxaConversao = 5.30;

//             // Converter para dólar
//             double valorDolar = valorReal / taxaConversao;

//             // Exibir o resultado com 2 casas decimais
//             resultadoLabel.setText(String.format("%.2f", valorDolar) + " dólares");
//         } catch (NumberFormatException e) {
//             JOptionPane.showMessageDialog(this, "Digite um valor válido em real.", "Erro", JOptionPane.ERROR_MESSAGE);
//         }
//     }


// }
