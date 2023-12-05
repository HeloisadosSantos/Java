package View;

import javax.swing.JFrame;
import javax.swing.JTabbedPane;

public class JanelaPrincipal extends JFrame {

    private JTabbedPane jTPane;

    public JanelaPrincipal() {
        jTPane = new JTabbedPane();
        add(jTPane);

        // Aba "Carros"
        CarrosPainel tabCarros = new CarrosPainel();
        jTPane.add("Carros", tabCarros);

        // Aba "Vendas"
        VendasView tabVendas = new VendasView();
        jTPane.add("Vendas", tabVendas);

        // Aba "Cadastro"
        CadastrodeClientes tabCadastro = new CadastrodeClientes();
        jTPane.add("Cadastro", tabCadastro);

        setBounds(100, 100, 600, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void run() {
        this.setVisible(true);
    }

    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(() -> {
            new JanelaPrincipal().run();
        });
    }
}
