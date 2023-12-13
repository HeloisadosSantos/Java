package View;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class VendasView extends JPanel {

    private JTextField campoProduto, campoQuantidade, campoPreco;
    private JButton botaoAdicionar, botaoFinalizar;
    private JTextArea areaResultados;
    private List<ItemVenda> itensVenda;

    public VendasView() {
        // Configuração do layout
        setLayout(new BorderLayout());
        itensVenda = new ArrayList<>();

        // Painel de entrada de dados
        JPanel painelEntrada = new JPanel(new GridLayout(3, 2));
        painelEntrada.add(new JLabel("Produto:"));
        campoProduto = new JTextField();
        painelEntrada.add(campoProduto);
        painelEntrada.add(new JLabel("Quantidade:"));
        campoQuantidade = new JTextField();
        painelEntrada.add(campoQuantidade);
        painelEntrada.add(new JLabel("Preço unitário:"));
        campoPreco = new JTextField();
        painelEntrada.add(campoPreco);

        // Botões
        JPanel painelBotoes = new JPanel(new FlowLayout());
        botaoAdicionar = new JButton("Adicionar");
        botaoFinalizar = new JButton("Finalizar");
        painelBotoes.add(botaoAdicionar);
        painelBotoes.add(botaoFinalizar);

        // Área de resultados
        areaResultados = new JTextArea();
        areaResultados.setEditable(false);

        // Adiciona os componentes ao painel principal
        add(painelEntrada, BorderLayout.NORTH);
        add(painelBotoes, BorderLayout.CENTER);
        add(new JScrollPane(areaResultados), BorderLayout.SOUTH);

        // Configuração de eventos
        botaoAdicionar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                adicionarItem();
            }
        });

        botaoFinalizar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                finalizarVenda();
            }
        });
    }

    private void adicionarItem() {
        String produto = campoProduto.getText();
        
        // Verifica se o campo de quantidade não está vazio
        if (campoQuantidade.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Por favor, insira uma quantidade válida.", "Erro", JOptionPane.ERROR_MESSAGE);
            return;
        }
    
        // Verifica se o campo de preço não está vazio
        if (campoPreco.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Por favor, insira um preço válido.", "Erro", JOptionPane.ERROR_MESSAGE);
            return;
        }
    
        try {
            int quantidade = Integer.parseInt(campoQuantidade.getText());
            double precoUnitario = Double.parseDouble(campoPreco.getText());
    
            double total = quantidade * precoUnitario;
            ItemVenda item = new ItemVenda(produto, quantidade, precoUnitario, total);
            itensVenda.add(item);
    
            // Adiciona o item à área de resultados
            areaResultados.append(item.toString() + "\n");
    
            // Limpa os campos de entrada
            campoProduto.setText("");
            campoQuantidade.setText("");
            campoPreco.setText("");
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Por favor, insira valores numéricos válidos para quantidade e preço.", "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void finalizarVenda() {
        double totalVenda = 0.0;

        for (ItemVenda item : itensVenda) {
            totalVenda += item.getTotal();
        }

        // Exibe um resumo da venda
        JOptionPane.showMessageDialog(this, "Venda finalizada!\nTotal: R$ " + totalVenda);
        areaResultados.setText(""); // Limpa a área de resultados após a venda
        itensVenda.clear(); // Limpa a lista de itens da venda
    }

    private static class ItemVenda {
        private String produto;
        private int quantidade;
        private double precoUnitario;
        private double total;

        public ItemVenda(String produto, int quantidade, double precoUnitario, double total) {
            this.produto = produto;
            this.quantidade = quantidade;
            this.precoUnitario = precoUnitario;
            this.total = total;
        }

        public double getTotal() {
            return total;
        }

        @Override
        public String toString() {
            return String.format("%s - Quantidade: %d - Preço Unitário: R$ %.2f - Total: R$ %.2f",
                    produto, quantidade, precoUnitario, total);
        }
    }

    public static void main(String[] args) {
        // Cria e exibe a janela de teste
        JFrame frame = new JFrame("Painel de Vendas");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(new VendasView());
        frame.setSize(400, 300);
        frame.setVisible(true);
    }
}
