package LojaCarrosList;

import java.util.*;

import javax.swing.JOptionPane;

public class App {
    public static void main(String[] args) {
     Carros obj1 = new Carros();
     obj1.Carro();
    // Class Carros - com atributos e os métodos
    //manipular essa classe no app.
   
    List<Carros> listacarros = new ArrayList();
    boolean aberto = true;
    
    while (aberto) {
        int acao = Integer.parseInt(JOptionPane.showInputDialog("Digite um N° "));
        if (acao==1) {
            //1. cadastrar um novo carro
            Carros c = new Carros();
            c.setMarca.JOptionPane.showMessageDialog("Marca do Carro", c, null, acao);
            c.setModelo.JOptionPane.showMessageDialog("Modelo do Carro", c, null, acao);
            c.setAno.JOptionPane.showInputDialog("Ano do Carro");
            c.setCor.JOptionPane.showMessageDialog("Cor do Carro", c, null, acao);

            listacarros.add(c);
        }else if (acao==2) {
            String listar = " ";

            // 2.listar todos os carros cadastrados
            for (Carros carros : listacarros) {
               listar=+carros.getMarca()+" "+carros.getModelo()+"\n";
            }
            JOptionPane.showMessageDialog(null, listacarros, listar);
        }
    }

    //3. Consultar um Carro Cadastrado
    //4. Apagar um carro cadastrados.

    }
}
