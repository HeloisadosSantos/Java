import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.*;

public class ExercicioGridLayout extends JFrame {
    public ExercicioGridLayout() {
        super("Janela Principal");
        JPanel painel = new JPanel(); // add um jpanel
        this.add(painel);
        // modificando o layout do painel (Jpanel) flow->Grid
        GridLayout grid = new GridLayout(4, 4);
        painel.setLayout(grid);
        // add dos componentes ao Jpainel
        String valores [] = {"7", "8", "9", "X", "4", "5", "6", "-", "1", "2", "3", "+", "+/-", "0", ".", "="};

        for (int i = 0; i < valores.length; i++) {
            painel.add(new JButton(valores[i]));

        }

        // set
        this.setDefaultCloseOperation(2);
        this.pack();
        this.setVisible(true);
    }
}

