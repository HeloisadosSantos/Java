import javax.swing.*;
import java.awt.*;

public class ExemploFlowLayout {
    int  cont = 0;
    //construtor
    public ExemploFlowLayout() {
        //criei um Frame GridLayout
        JFrame janela1 = new JFrame ("Janela 1");
        //modificar o Layout do Frame
        FlowLayout flow = new FlowLayout();
        janela1.setLayout(flow);
        //criando componentes
        JLabel texto1 = new JLabel ("Informe o n° de Botões");
        //entrada de dados
        JTextField painel1 = new JTextField( "Insira um nº", 25);
        JButton botao1 = new JButton("Enviar");
        //add,
        janela1.add(texto1);
        janela1.add(painel1);
        janela1.add(botao1);
        //criando ação para button
        //espera acontecer
        botao1.addActionListener(e->{
             int quant = Integer.parseInt(painel1.getText());
        for (int i = 0; i < quant; i++){
            janela1.add(new JButton(""+i));
            janela1.pack();
        }
        });
       

        //set Frame
        janela1.setDefaultCloseOperation(2);
        janela1.pack();
        janela1.setVisible(true);
    }
}
