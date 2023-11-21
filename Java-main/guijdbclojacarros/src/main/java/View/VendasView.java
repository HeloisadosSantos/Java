package View;

import java.awt.Component;
import java.util.List;

import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

import Controller.CarrosDAO;
import Model.Carros;

public class VendasView extends JPanel {

    private static final Component CarrosPainel = null;
    JComboBox<String> carrosComboBox;
    List<Carros> carros;

    public VendasView() {
        super();
        carrosComboBox = new JComboBox<>();
        // Preencha o JComboBox com os Carros
        carros = new CarrosDAO().listarTodos();
        carrosComboBox.addItem("Selecione o Carro");
        for (Carros carro : carros) {
            carrosComboBox.addItem(carro.getMarca()
                    + " " + carro.getModelo()
                    + " " + carro.getPlaca());
        }
        add(carrosComboBox);
    }

    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(() -> {
            createAndShowGUI();
        });
    }

    /**
     *
     */
    private static void createAndShowGUI() {
        javax.swing.JFrame frame = new javax.swing.JFrame("Sua Aplicação");

        JTabbedPane tabbedPane = new JTabbedPane();

        // Adicione a primeira aba (outra classe JPanel) aqui
        JPanel carrosJPanel = new CarrosPainel();
        tabbedPane.addTab("Cadastro de Carros", carrosJPanel);

        // Adicione a segunda aba (esta classe JPanel) aqui
        JPanel vendasViwPanel = new VendasView();
        tabbedPane.addTab("Registro de Vendas", vendasViwPanel);

        frame.getContentPane().add(tabbedPane);

        frame.setDefaultCloseOperation(javax.swing.JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);
        frame.setVisible(true);
    }
}
