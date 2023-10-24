import java.util.Collections;

import javax.swing.JOptionPane;

public class Carros {
    //Atributos
    String marca;
    String modele;
    String ano;
    String cor;

    // construtor cheio
    public Carros(String marca, String modele, String ano, String cor) {
        this.marca = marca;
        this.modele = modele;
        this.ano = ano;
        this.cor = cor;
    }
    // construtor vazio
    public Carros() {
    }


//getts and setrs
    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModele() {
        return modele;
    }

    public void setModele(String modele) {
        this.modele = modele;
    }

    public String getAno() {
        return ano;
    }

    public void setAno(String ano) {
        this.ano = ano;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

}


