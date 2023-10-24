package ArrayList;
import java.util.*;
import java.util.LinkedList;

    /**
     * InnerLinkedList
     */
    public class ExemploLinkedList  {
        LinkedList <String> pessoas = new LinkedList <>();

        public void teste(){
            //add normalmente
            pessoas.add("Pedro");
            pessoas.add("Maria");
            pessoas.add("joão");

            //add na primeira posição
            pessoas.addFirst("Celia");

            //remove o último nome
            pessoas.removeLast();

            //imprime a Lista
            System.out.println(pessoas);

        }
        
    }

