// import java.awt.*;
// import java.awt.event.*;
// import java.text.*;
// import javax.swing.*;
// import javax.swing.border.*;

// class Calc extends JFrame implements ActionListener {

//     private final static String MAIS = "+";
//     private final static String MENOS = "-";
//     private final static String MULT = "*";
//     private final static String DIV = "/";

//     private JTextField num1TF;
//     private JTextField num2TF;
//     private JComboBox<String> operCBB;
//     private JButton calcBT;
//     private JTextField resultadoTF;

//     private DecimalFormat df = new DecimalFormat("0.00");

//     public Calc() {
//         num1TF = new JTextField(5);
//         num2TF = new JTextField(5);

//         operCBB = new JComboBox<>();
//         operCBB.addItem(MAIS);
//         operCBB.addItem(MENOS);
//         operCBB.addItem(MULT);
//         operCBB.addItem(DIV);
//         operCBB.setBackground(Color.gray);

//         calcBT = new JButton("Calcular");
//         calcBT.setBackground(Color.green);

//         resultadoTF = new JTextField();
//         resultadoTF.setEditable(false);

//         JPanel calcPNL = new JPanel();
//         calcPNL.setLayout(new FlowLayout(FlowLayout.LEFT));
//         calcPNL.add(num1TF);
//         calcPNL.add(operCBB);
//         calcPNL.add(num2TF);
//         calcPNL.add(calcBT);

//         JPanel conteudoPNL = new JPanel();
//         conteudoPNL.setBorder(new TitledBorder("Calculadora aritmética"));
//         conteudoPNL.setLayout(new BorderLayout());
//         conteudoPNL.add(BorderLayout.CENTER, resultadoTF);
//         conteudoPNL.add(BorderLayout.SOUTH, calcPNL);

//         super.setTitle("Calculadora");
//         super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//         super.setContentPane(conteudoPNL);
//         super.pack();
//         super.setLocationRelativeTo(this);

//         calcBT.addActionListener(this);
//     }

//     public void actionPerformed(ActionEvent e) {
//         boolean num1Ok = true;
//         boolean num2Ok = true;

//         double num1 = 0;
//         try {
//             num1 = df.parse(num1TF.getText()).doubleValue();
//         } catch (ParseException ex) {
//             num1Ok = false;
//         }

//         double num2 = 0;
//         try {
//             num2 = df.parse(num2TF.getText()).doubleValue();
//         } catch (ParseException ex) {
//             num2Ok = false;
//         }

//         if (num1Ok && num2Ok) {
//             boolean divZero = false;
//             double result = 0;

//             Object selItem = operCBB.getSelectedItem();
//             if (selItem.equals(MAIS)) {
//                 result = num1 + num2;
//             } else if (selItem.equals(MENOS)) {
//                 result = num1 - num2;
//             } else if (selItem.equals(MULT)) {
//                 result = num1 * num2;
//             } else if (selItem.equals(DIV)) {
//                 if (num2 == 0) {
//                     divZero = true;
//                 } else {
//                     result = num1 / num2;
//                 }
//             }

//             if (divZero) {
//                 String msg = "Operação inválida - divisão por zero!";
//                 JOptionPane.showMessageDialog(this, msg, "Calculadora", JOptionPane.WARNING_MESSAGE);
//             } else {
//                 resultadoTF.setText(df.format(result));
//             }
//         } else {
//             String msg;
//             if (!num1Ok && !num2Ok) {
//                 msg = "Os valores inseridos não são números válidos.";
//             } else if (!num1Ok) {
//                 msg = "O valor \"" + num1TF.getText() + "\" não é um número válido.";
//             } else {
//                 msg = "O valor \"" + num2TF.getText() + "\" não é um número válido.";
//             }
//             JOptionPane.showMessageDialog(this, msg, "Calculadora", JOptionPane.WARNING_MESSAGE);
//         }
//     }

//     public static void main(String[] args) {
//         SwingUtilities.invokeLater(() -> {
//             new Calc().setVisible(true);
//         });
//     }
// }