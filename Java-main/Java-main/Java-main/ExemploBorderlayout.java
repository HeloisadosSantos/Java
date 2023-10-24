import javax.swing.*;
import java.awt.*;

public class ExemploBorderlayout extends JFrame {
    public ExemploBorderlayout() {
        super("Janela");

        //add uma janela 
        JPanel painel = new JPanel(new BorderLayout ());
        this.add(painel);

        //add componentes
        //add na parte inferior SOUTH = SUL
        painel.add(new JButton("South"), BorderLayout.SOUTH);
        painel.add(new JButton("WEST"), BorderLayout.WEST);
        painel.add(new JButton("EAST"), BorderLayout.EAST);
        painel.add(new JTextField(25), BorderLayout.NORTH);
        painel.add(new JTextField("CENTER"), BorderLayout.CENTER);

         // set
         this.setDefaultCloseOperation(2);
         this.pack();
         this.setVisible(true);
    }
}
