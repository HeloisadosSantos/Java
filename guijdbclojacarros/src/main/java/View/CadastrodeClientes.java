package View;

import java.awt.Color;
import java.awt.GridLayout;
import java.util.List;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

import Controller.CarrosDAO;
import Model.Carros;

public class CadastrodeClientes extends JPanel {

    JComboBox<String> carrosComboBox;
    List<Carros> carros;
    JLabel nomeLabel;
    JLabel valorLabel;

    public CadastrodeClientes() {
        super(new GridLayout(3, 1)); // Use GridLayout para organizar os componentes
        setBackground(Color.BLACK);
        setForeground(Color.WHITE);

        carrosComboBox = new JComboBox<>();
        nomeLabel = new JLabel("Nome: ");
        valorLabel = new JLabel("Valor: ");
        nomeLabel.setForeground(Color.WHITE);
        valorLabel.setForeground(Color.WHITE);

        // Preencha o JComboBox com os Carros
        carros = new CarrosDAO().listarTodos();
        carrosComboBox.addItem("Selecione o Carro");
        for (Carros carro : carros) {
            carrosComboBox.addItem(carro.getMarca() + " " + carro.getModelo() + " " + carro.getPlaca());
        }

        // Adicione os componentes ao painel
        add(carrosComboBox);
        add(nomeLabel);
        add(valorLabel);

        // Adicione um ouvinte de alteração de item para atualizar os rótulos quando um carro for selecionado
        carrosComboBox.addActionListener(e -> {
            if (carrosComboBox.getSelectedIndex() > 0) {
                int selectedIndex = carrosComboBox.getSelectedIndex() - 1; // Desconta o "Selecione o Carro"
                Carros selectedCarro = carros.get(selectedIndex);
                nomeLabel.setText("Nome: " + selectedCarro.getNome());
                valorLabel.setText("Valor: " + selectedCarro.getValor());
            } else {
                // Limpe os rótulos se "Selecione o Carro" for selecionado
                nomeLabel.setText("Nome: ");
                valorLabel.setText("Valor: ");
            }
        });
    }
}
