import java.awt.CardLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Exercicio5 extends JFrame{
    //atributo
    int pontuacao = 0;
    //construtor
    public Exercicio5 () {
        super("Jogando");
        //criar um cardprincipal
        CardLayout cl  =  new CardLayout();
        JPanel mainPanel = new JPanel(cl);// set do layout no construtor
        this.add(mainPanel);//add ao Frame

        //criar os cards
        // card1 - Início
        JPanel card1 = new JPanel();
        card1.add(new JLabel("Início - Aperte Start Para Começar o Jogo"));// colocar imagem no lugar
        JButton but1 = new JButton("Começar");
        card1.add(but1);
        mainPanel.add(card1,"Começar");

        //card2 - Primeira Pergunta
        JPanel card2 = new JPanel();
        card2.add(new JLabel("Quanto é 2000 + 1500 ?"));
        JTextField caixa1 = new JTextField(25);
        card2.add(caixa1);
        JButton but2 = new JButton("Next");
        card2.add(but2);
        mainPanel.add(card2,"P1");

        //card3 - Segunda Pergunta
        JPanel card3 = new JPanel();
        card3.add(new JLabel("Qual é a solução de x² + 5x -14 = 0 ?"));
        JTextField caixa2 = new JTextField(25);
        card3.add(caixa2);
        JButton but3 = new JButton("Next");
        card3.add(but3);
        mainPanel.add(card3,"P2");

        //card5 - Segunda Pergunta
        JPanel card5 = new JPanel();
        card5.add(new JLabel(" Quanto é 3^3 ? "));
        JTextField caixa3 = new JTextField(25);
        card5.add(caixa3);
        JButton but5 = new JButton("Next");
        card5.add(but5);
        mainPanel.add(card5,"P3");
        
        //card6 - Segunda Pergunta
        JPanel card6 = new JPanel();
        card5.add(new JLabel(" Quanto é 3/2 ? "));
        JTextField caixa4 = new JTextField(25);
        card5.add(caixa4);
        JButton but6 = new JButton("Next");
        card5.add(but6);
        mainPanel.add(card6,"P4");

         //card7 - Segunda Pergunta
        JPanel card7 = new JPanel();
        card5.add(new JLabel(" Quanto é π ? "));
        JTextField caixa5 = new JTextField(25);
        card5.add(caixa5);
        JButton but7 = new JButton("Next");
        card5.add(but7);
        mainPanel.add(card7,"P5");

        // card4 - Pontuacao
        JPanel card4 = new JPanel();
        card4.add(new JLabel("Resultado Final"));
        JLabel pontuacaoFinal = new JLabel();
        card4.add(pontuacaoFinal);
        JButton but4 = new JButton("Reiniciar");
        card4.add(but4);     
        mainPanel.add(card4,"Final"); 

        //set do frame
        this.setDefaultCloseOperation(2);
        this.setBounds(200, 200, 300, 300);
        this.setVisible(true);

        //tratamento de eventos
        but1.addActionListener(e->{
            cl.next(mainPanel);
        });
        but2.addActionListener(e->{
            if(caixa1.getText().toUpperCase().equals("3500")){
                pontuacao++;
            }
            caixa1.setText("");
            cl.next(mainPanel);
        });
        but3.addActionListener(e->{
            if(caixa2.getText().toUpperCase().equals("S={2, -7}")){
                pontuacao++;
            }
            caixa2.setText("");
            cl.next(mainPanel);
        });
        but5.addActionListener(e->{
            if(caixa3.getText().toUpperCase().equals("27")){
                pontuacao++;
            }
            caixa3.setText("");
            cl.next(mainPanel);
        });
         but6.addActionListener(e->{
            if(caixa4.getText().toUpperCase().equals("1,5")){
                pontuacao++;
            }
            caixa4.setText("");
            cl.next(mainPanel);
        });
          but7.addActionListener(e->{
            if(caixa5.getText().toUpperCase().equals("3,14")){
                pontuacao++;
            }
            caixa5.setText("");
          
            cl.next(mainPanel);
        });
        but4.addActionListener(e->{
            cl.first(mainPanel);
        });



    }
}
