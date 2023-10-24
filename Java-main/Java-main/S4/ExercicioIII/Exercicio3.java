package ExercicioIII;


import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.*;

public class Exercicio3 {
    /**
     * Exercicio3 extends JFrame
     */
    public class InnerExercicio3 extends JFrame {

        /**
         * 
         */
        public InnerExercicio3() {
            super("Exercicio 3 - CardLayout");
            JPanel mainPanel = new JPanel();// caixa do super trumph
            CardLayout cl = new CardLayout();
            mainPanel.setLayout(cl);// set do layout
            this.add(mainPanel);// add mainPanel
            // adicionar os cards
            JPanel card1 = new JPanel();
            card1.add(new JLabel("Pagina de Boas Vindas!!"));
            JButton btn1 = new JButton("Login");
            JButton btn2 = new JButton("Cadastro");
            card1.add(btn1);
            card1.add(btn2);
            mainPanel.add(card1, "Home");

            // card1
            JPanel card2 = new JPanel();
            card2.add(new JLabel("Pagina de Boas Vindas!!"));
            JButton btn3 = new JButton("Botão 3");
            JButton btn4 = new JButton("Botão 4 ");
            card2.add(btn3);
            card2.add(btn4);
            mainPanel.add(card2, "Login");

            // card3

            JPanel card3 = new JPanel();
            card3.add(new JLabel("Pagina de Boas Vindas!!"));
            JButton btn5 = new JButton("Botão 5");
            JButton btn6 = new JButton("Botão 6 ");
            card3.add(btn5);
            card3.add(btn6);
            mainPanel.add(card3, "Login");


            this.setDefaultCloseOperation(2);
            this.setBounds(100, 100, 100, 100);
            this.setVisible(true);

            //funcionalidade de but
            btn1.addActionListener(e ->{// espera meu evento acontecer/ouvinte
                //troca do card 
                cl.show(mainPanel,btn1.getText());
            });
            //funcionalidade de but
            btn2.addActionListener(e ->{// espera meu evento acontecer/ouvinte
                //troca do card 
                cl.show(mainPanel,btn1.getText());
            });
            //funcionalidade de but
            btn3.addActionListener(e ->{// espera meu evento acontecer/ouvinte
                //troca do card 
                cl.show(mainPanel,btn1.getText());
            });
            //funcionalidade de but
            btn4.addActionListener(e ->{// espera meu evento acontecer/ouvinte
                //troca do card 
                cl.show(mainPanel,btn1.getText());
            });
            //funcionalidade de but
            btn5.addActionListener(e ->{// espera meu evento acontecer/ouvinte
                //troca do card 
                cl.show(mainPanel,btn1.getText());
            });
            //funcionalidade de but
            btn6.addActionListener(e ->{// espera meu evento acontecer/ouvinte
                //troca do card 
                cl.show(mainPanel,btn1.getText());
            });

        }
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        // TODO Auto-generated method stub
        return super.clone();
    }

    @Override
    public boolean equals(Object obj) {
        // TODO Auto-generated method stub
        return super.equals(obj);
    }

    @Override
    protected void finalize() throws Throwable {
        // TODO Auto-generated method stub
        super.finalize();
    }

    @Override
    public int hashCode() {
        // TODO Auto-generated method stub
        return super.hashCode();
    }

    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return super.toString();
    }
}
