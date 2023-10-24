package ArrayList;


import java.util.ArrayList;
//importa todas as listas do java util
import java.util.*;

import javax.swing.JOptionPane;

public class ExemploArrayList {
    // criando o ArryList

    ArrayList<String> carros = new ArrayList<>();
    // Integer é como uma Int
    ArrayList<Integer> numeros = new ArrayList<>();

    public void teste() {

        // add Elementos com o "ADD"
        carros.add("Fusca");
        carros.add("Brasília");
        carros.add("Chevette");
        carros.add("Monza");
        carros.add("Monza");

        // Imprimindo Lista completa
        System.out.println(carros);

        // ordenando a lista (.sor(Collections))
        Collections.sort(carros);
        System.out.println(carros);
        // Reverse inverte a lista
        Collections.reverse(carros);

        // percorrer a lista(for)
        // para ficar um embaixo do outro.
        // método da classe para medir o vetor é o p.size
        for (int i = 0; i < carros.size(); i++) {

            System.out.println(carros.get(i));
        }
        // percorrer a Lista com For-Each
        // 2 string 1 declaração da variavel,2 nome podendo ser o que eu quiser.
        for (String i : carros) {
            // i: valor correspondendo de cada produto

            System.out.println(i);

        }

        // Limpando Lista completa
        carros.clear();
        System.out.println(carros);
    }

    // criar um arraylist de n° inteiros.
    // escrever 5 n° aleatórios - ordenar e imprimir.
    // arendou para
    public void exercicio1() {

        for (int i = 0; i < 10; i++) {
            numeros.add(Integer.parseInt(JOptionPane.showInputDialog("Digite um N° ")));
        }

        Collections.sort(numeros);
        System.out.println(numeros);
    }

}
