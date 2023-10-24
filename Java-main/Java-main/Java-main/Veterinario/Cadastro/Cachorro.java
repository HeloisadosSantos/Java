package Cadastro;


//Criar uma extenÇão da Classe chefe para as subclasses como esta.

/**
 * Cachorro
 */
public class Cachorro extends Animal {
    String cor;
    String tamanho;


    //caracteristica
    public String getCor() {
        return cor;
    }
    public void setCor(String cor) {
        this.cor = cor;
    }
    public String getTamanho() {
        return tamanho;
    }
    public void setTamanho(String tamanho) {
        this.tamanho = tamanho;
    }
    public String getUltimaVacina() {
        return UltimaVacina;
    }
    public void setUltimaVacina(String ultimaVacina) {
        UltimaVacina = ultimaVacina;
    }
    String UltimaVacina;


    
}
