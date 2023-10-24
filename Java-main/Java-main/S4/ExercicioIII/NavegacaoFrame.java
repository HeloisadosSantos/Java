package ExercicioIII;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class NavegacaoFrame extends JFrame {

    public NavegacaoFrame() {
        super("Página Inicial");

        // Criando os painéis
        JPanel panel2 = new JPanel();
        JPanel panel = new JPanel();

        // Configurando o layout do panel2
        panel2.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 20));

        // Criando e configurando o botão "Entrar"
        JButton botao = new JButton("Entrar");
        botao.setBackground(new Color(255, 102, 204)); // Cor em formato hexadecimal
        botao.setForeground(Color.WHITE);

        // Criando e configurando a imagem de fundo
        JLabel imagemFundo = new JLabel(new ImageIcon("D:\\S4\\img\\rosaa.png"));
        Dimension tamanhoImagem = new Dimension(436, 477); // Altere os valores conforme necessário
        imagemFundo.setPreferredSize(tamanhoImagem);
        imagemFundo.setHorizontalAlignment(SwingConstants.CENTER);

        // Adicionando um ActionListener ao botão "Entrar"
        botao.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Ao clicar no botão, cria uma nova instância de TodoList
                TodoList segundaTela = new TodoList();
                segundaTela.setVisible(true); // Torna a nova tela visível
                dispose(); // Fecha a tela atual (NavegacaoFrame)
            }
        });

        // Adicionando os elementos ao painel principal
        panel.add(imagemFundo);
        panel.add(botao);

        // Adicionando o painel principal ao JFrame
        this.add(panel);

        // Configurações do JFrame
        this.setSize(436, 577);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    public static void main(String[] args) {
        // esse trecho de código está inicializando a interface gráfica do programa, mostrando uma janela chamada
        SwingUtilities.invokeLater(() -> {
            NavegacaoFrame navegacaoFrame = new NavegacaoFrame();
            navegacaoFrame.setVisible(true);
        });
    }
}
