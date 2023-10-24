import javax.swing.*;
import java.awt.*;

/**
 * Exercicio1
 */
public class Exercicio1 extends JFrame{

    public Exercicio1(){
        super("Exercicio 1");

        //criando um painel principal
        JPanel mainPanel = new JPanel();

        //setLayout
        CardLayout cardlay = new CardLayout();
        mainPanel.setLayout(cardlay);

        //criar os cards para adc o main
        JPanel cardprim = new JPanel();
        cardprim.add(new JLabel("card1"));

        JPanel cardseg = new JPanel();
        cardseg.add(new JLabel("card2"));

        JPanel cardterc = new JPanel();
        cardterc.add(new JLabel("card 3"));

        /*Criação de componentes */
        JButton btn1Next = new JButton("Next");
        JButton btn2Next = new JButton("Next");
        JButton btn3Next = new JButton("Next");

        cardprim.add(btn1Next);
        cardseg.add(btn2Next);
        cardterc.add(btn3Next);

        //ADICIONANDO CARDS AO PAINEL PRINCIPAL
        mainPanel.add(cardprim);
        mainPanel.add(cardseg);
        mainPanel.add(cardterc);

        //Seteno o Frame
        this.add(mainPanel);
        this.setBounds(100, 100, 300, 300);    
        this.setDefaultCloseOperation(2);
        this.setVisible(true);

        //criar actionListiner para o botão
        btn1Next.addActionListener(e -> {
            cardlay.next(mainPanel);
        });
        btn2Next.addActionListener(e -> {
            cardlay.next(mainPanel);
        });
        btn3Next.addActionListener(e -> {
            cardlay.next(mainPanel);
        });

    }
}