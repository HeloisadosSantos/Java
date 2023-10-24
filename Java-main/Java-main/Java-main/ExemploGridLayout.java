import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.*;

public class ExemploGridLayout extends JFrame {
    public ExemploGridLayout() {
        super("Janela Principal");
        JPanel painel = new JPanel(); // add um jpanel
        this.add(painel);
        // modificando o layout do painel (Jpanel) flow->Grid
        GridLayout grid = new GridLayout(4, 4);
        painel.setLayout(grid);
        // add dos componentes ao Jpainel
        for (int i = 0; i < 10; i++) {
            painel.add(new JButton("" + i));

            JButton but = new JButton();
            but.setBackground(Color.PINK);
            painel.add(but);
        }
        JButton botao1 = new JButton("X");
        JButton botao2 = new JButton("-");
        JButton botao3 = new JButton("+");
        JButton botao4 = new JButton(",");
        JButton botao5 = new JButton("=");
        JButton botao6 = new JButton("+/-");

        painel.add(botao1);
        painel.add(botao2);
        painel.add(botao3);
        painel.add(botao3);
        painel.add(botao4);
        painel.add(botao5);
        painel.add(botao6);

        // set
        this.setDefaultCloseOperation(2);
        this.pack();
        this.setVisible(true);
    }
}
