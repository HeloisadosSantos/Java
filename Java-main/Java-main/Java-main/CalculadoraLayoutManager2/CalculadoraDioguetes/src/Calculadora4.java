// import javax.swing.*;
// import java.awt.event.*;

// public class Calculadora4 extends JFrame {
//     //váriaveis de intancia,numeros de 0 a 9
// // private == previne as variaveis de serem alteradas por fora da classe
// //criar com private para nao ser acessada de fora da classe

//     private JButton numero1;
//     private JButton numero2;
//     private JButton numero3;
//     private JButton numero4;
//     private JButton numero5;
//     private JButton numero6;
//     private JButton numero7;
//     private JButton numero8;
//     private JButton numero9;
//     private JButton numero0;
//     private JButton numeroP;
   
//     //botoes de operações matematicas
//     private JButton dividir;
//     private JButton multiplicar;
//     private JButton subtrair;
//     private JButton somar;
//     private JButton igual;
//     //campo de texto para mostrr os resultados
//     private JTextField display;
   
//     private int leitura; //armazenar valor Atual
//     private int memoria; //armazena o resultado
//     private char operacao; //armazena a operaçao
//     //depois atualiza o campo display
   

//     public Calculadora4() {
//         //definir tamanho, titlo e layout
//         this.setTitle("calculadora");
//         this.setBounds(500, 100, 292, 450);
//         this.setDefaultCloseOperation(EXIT_ON_CLOSE);
//         this.getContentPane().setLayout(null);

//         leitura = 0;
//         memoria = 0;
// //definir tamanho do campo de display
//         display = new JTextField();
//         display.setBounds(0, 0, 300, 100);
//         this.add(display);
//         // definir tamnho e lugar de cada botão
//         //FAIXA 01
//         numero7 = new JButton();
//         numero7.setText("7");
//         numero7.setBounds(0, 120, 65, 65);
//         this.add(numero7);
       
//         numero4 = new JButton();
//         numero4.setText("4");
//         numero4.setBounds(0, 190, 65, 65);
//         this.add(numero4);
       
//         numero1 = new JButton();
//         numero1.setText("1");
//         numero1.setBounds(0, 260, 65, 65);
//         this.add(numero1);
       
//         numero0 = new JButton();
//         numero0.setText("0");
//         numero0.setBounds(0, 330, 65, 65);
//         this.add(numero0);
       
//         //FAIXA 02
//         numero8 = new JButton();
//         numero8.setText("8");
//         numero8.setBounds(70, 120, 65, 65);
//         this.add(numero8);
       
//         numero5 = new JButton();
//         numero5.setText("5");
//         numero5.setBounds(70, 190, 65, 65);
//         this.add(numero5);
       
//         numero2 = new JButton();
//         numero2.setText("2");
//         numero2.setBounds(70, 260, 65, 65);
//         this.add(numero2);
       
//         numeroP = new JButton();
//         numeroP.setText(".");
//         numeroP.setBounds(70, 330, 65, 65);
//         this.add(numeroP);
       
//         //FAIXA 03
//         numero9 = new JButton();
//         numero9.setText("9");
//         numero9.setBounds(140, 120, 65, 65);
//         this.add(numero9);
       
//         numero6 = new JButton();
//         numero6.setText("6");
//         numero6.setBounds(140, 190, 65, 65);
//         this.add(numero6);
       
//         numero3 = new JButton();
//         numero3.setText("3");
//         numero3.setBounds(140, 260, 65, 65);
//         this.add(numero3);
       
//         somar = new JButton();
//         somar.setText("+");
//         somar.setBounds(140, 330, 65, 65);
//         this.add(somar);
       
//         //FAIXA 04
//         dividir = new JButton();
//         dividir.setText("/");
//         dividir.setBounds(210, 120, 65, 65);
//         this.add(dividir);
       
//         multiplicar = new JButton();
//         multiplicar.setText("X");
//         multiplicar.setBounds(210, 190, 65, 65);
//         this.add(multiplicar);
       
//         subtrair = new JButton();
//         subtrair.setText("-");
//         subtrair.setBounds(210, 260, 65, 65);
//         this.add(subtrair);
       
//         igual = new JButton();
//         igual.setText("=");
//         igual.setBounds(210, 330, 65, 65);
//         this.add(igual);
       
   
// //event listenner para cada ação dos botoes
//         numero1.addActionListener(new ActionListener() {
//             public void actionPerformed(ActionEvent evt) {
//                 leitura *= 10;
//                 leitura += 1;
//                 display.setText(display.getText() + "1");
//             }
//         });

//         numero2.addActionListener(new ActionListener() {
//             public void actionPerformed(ActionEvent evt) {
//                 leitura *= 10;
//                 leitura += 2;
//                 display.setText(display.getText() + "2");
//             }
//         });
       
//         numero3.addActionListener(new ActionListener() {
//             public void actionPerformed(ActionEvent evt) {
//                 leitura *= 10;
//                 leitura += 3;
//                 display.setText(display.getText() + "3");
//             }
//         });
       
//         numero4.addActionListener(new ActionListener() {
//             public void actionPerformed(ActionEvent evt) {
//                 leitura *= 10;
//                 leitura += 4;
//                 display.setText(display.getText() + "4");
//             }
//         });
       
//         numero5.addActionListener(new ActionListener() {
//             public void actionPerformed(ActionEvent evt) {
//                 leitura *= 10;
//                 leitura += 5;
//                 display.setText(display.getText() + "5");
//             }
//         });
       
//         numero6.addActionListener(new ActionListener() {
//             public void actionPerformed(ActionEvent evt) {
//                 leitura *= 10;
//                 leitura += 6;
//                 display.setText(display.getText() + "6");
//             }
//         });
       
//         numero7.addActionListener(new ActionListener() {
//             public void actionPerformed(ActionEvent evt) {
//                 leitura *= 10;
//                 leitura += 7;
//                 display.setText(display.getText() + "7");
//             }
//         });
       
//         numero8.addActionListener(new ActionListener() {
//             public void actionPerformed(ActionEvent evt) {
//                 leitura *= 10;
//                 leitura += 8;
//                 display.setText(display.getText() + "8");
//             }
//         });
       
//         numero9.addActionListener(new ActionListener() {
//             public void actionPerformed(ActionEvent evt) {
//                 leitura *= 10;
//                 leitura += 3;
//                 display.setText(display.getText() + "9");
//             }
//         });
       
//         numero0.addActionListener(new ActionListener() {
//             public void actionPerformed(ActionEvent evt) {
//                 leitura *= 10;
//                 leitura += 0;
//                 display.setText(display.getText() + "0");
//             }
//         });

//         somar.addActionListener(new ActionListener() {
//             public void actionPerformed(ActionEvent evt) {
//                 operacao = '+';
//                 memoria += leitura;
//                 leitura = 0;
//                 display.setText(memoria + " + ");
//             }
//         });
       
//         subtrair.addActionListener(new ActionListener() {
//             public void actionPerformed(ActionEvent evt) {
//                 operacao = '-';
//                 memoria += leitura;
//                 leitura = 0;
//                 display.setText(memoria + " - ");
//             }
//         });
       
//         multiplicar.addActionListener(new ActionListener() {
//             public void actionPerformed(ActionEvent evt) {
//                 operacao = 'X';
//                 memoria += leitura;
//                 leitura = 0;
//                 display.setText(memoria + " X ");
//             }
//         });
       
//         dividir.addActionListener(new ActionListener() {
//             public void actionPerformed(ActionEvent evt) {
//                 operacao = '/';
//                 memoria += leitura;
//                 leitura = 0;
//                 display.setText(memoria + " / ");
//             }
//         });

//         igual.addActionListener(new ActionListener() {
//             public void actionPerformed(ActionEvent evt) {
//                 switch (operacao) {
//                     case '.': {
//                         memoria = memoria + '.';
//                         break;
//                     }
//                     case '+': {
//                         memoria += leitura;
//                         break;
//                     }
                   
//                     case '-': {
//                         memoria -= leitura;
//                         break;
//                     }
                   
//                     case 'X': {
//                         memoria *= leitura;
//                         break;
//                     }
                   
//                     case '/': {
//                         memoria /= leitura;
//                         break;
//                     }
                   
//                 }
//                 leitura = 0;
//                 display.setText("" + memoria);
//             }
//         });
//     }

//     //tornando visivel ao usuário
//     public static void main(String[] args) {
//         Calculadora4 exemplo = new Calculadora4();
//         exemplo.setVisible(true);
//     }
// }