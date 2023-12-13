package View;

import javax.swing.JFrame;
import javax.swing.JTabbedPane;

public class PainelPrincipal extends JFrame {

    // criação do tabbedPane para incluir as tabs
    private JTabbedPane jTPane;

    public PainelPrincipal() {
        jTPane = new JTabbedPane();
        add(jTPane);
        // criandos as tabs
        // tab1 Itens
        // tab2 Clientes
        // tab3 Vendas
       ItensView tab1 = new ItensView();
        ClientesView tab2 = new ClientesView();
        VendasView tab3 = new VendasView();
        jTPane.add("Itens", tab1);
        jTPane.add("Clientes", tab2);
        jTPane.add("Vendas", tab3);
        setBounds(100, 100, 600, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    // métodos para tornar a janela visível
    public void run() {
        this.setVisible(true);
    }
}
