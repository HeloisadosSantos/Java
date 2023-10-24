import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;

public class TabbedPaneExemplo extends JFrame{
    //cosntrutor
    public TabbedPaneExemplo() {
        super("Exemplo JTabbedPane");
        JTabbedPane janelaABas = new JTabbedPAne();
        //Ab1 3 botões
        JPanel aba1 = new JPanel();
        aba1.add(new JButton("Botão 1"));
        aba1.add(new JButton("Botão 1"));
        aba1.add(new JButton("Botão 1"));
        aba1.add(new JButton("Botão 1"));
        //aba 2 textfield
        JPanel aba2 = new JPanel ();
        aba2.add(new JTextField ("",20));
        //add abas no JTabbed
        janelasAbas.add("Aba Botões",aba1);
        janelaAba.add("Aba JTextField",aba2);
        this.add();
        
    }
    
}
