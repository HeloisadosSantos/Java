package ArrayList;
import java.util.*;

import java.util.HashMap;

public class ExemploHashMap {
    HashMap<String, String> capitalEstado = new HashMap<>();
    HashMap<String, String> nome = new HashMap<>();
    HashMap<Integer, Integer> idade = new HashMap<>();

    //
    public void teste() {
        // incluimdo elementos na lista(chave/valor)
        capitalEstado.put("SP", "São Paulo");
        capitalEstado.put("RJ", "Rio de Janeiro");
        capitalEstado.put("MG", "Minas Gerais");
        capitalEstado.put("ES", "Vitória");

        // Buscando um valor pela chave
        System.out.println(capitalEstado.get("ES"));
        for (String i : capitalEstado.keySet()) {
            System.out.println(i + ":" + capitalEstado.get(i));

        }
    }

    // nome String e idade interger
    public void exercicio1() {
        nome.put("Celia", "60 anos");
        nome.put("Yasmin", "30 anos");
        nome.put("Alice", "10 anos");
        nome.put("Gabizinha", "7 anos");

        System.out.println(nome.get("Nomes e Idades"));
        for (String i : nome.keySet()) {
            System.out.println(i + ":" + nome.get(i));

        }
    }

}
