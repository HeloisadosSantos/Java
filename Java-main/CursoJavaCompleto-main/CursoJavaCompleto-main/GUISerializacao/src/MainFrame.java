import javax.swing.JFrame;
import javax.swing.JTabbedPane;

public class MainFrame extends JFrame {
    public MainFrame() {
        super("Aplicação");
        setDefaultCloseOperation(2);
        JTabbedPane abas = new JTabbedPane();
        abas.add("Cadastro Usuário",new CadastroUsuarios());
        add(abas);
    }
}
