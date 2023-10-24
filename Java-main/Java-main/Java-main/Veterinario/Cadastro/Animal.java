package Cadastro;

public abstract class Animal {
    //abstract é uma super classe
    //1.criar uma classe separda do App, para depois criar as subclasses.
    //2.Crio os atributos (caracteristicas)
    //3.Crio uma uma aÇão de origem construtor e depois um set e get.


    String nome;
    String idade;
    String proprietario;
    String especie;
    String peso;

    public Animal(String nome, String idade, String proprietario, String especie, String peso) {
        this.nome = nome;
        this.idade = idade;
        this.proprietario = proprietario;
        this.especie = especie;
        this.peso = peso;
    }

    //Assim definimos um construtor explícito/padrão
    public Animal(){

    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getIdade() {
        return idade;
    }

    public void setIdade(String idade) {
        this.idade = idade;
    }

    public String getProprietario() {
        return proprietario;
    }

    public void setProprietario(String proprietario) {
        this.proprietario = proprietario;
    }

    public String getEspecie() {
        return especie;
    }

    public void setEspecie(String especie) {
        this.especie = especie;
    }

    public String getPeso() {
        return peso;
    }

    public void setPeso(String peso) {
        this.peso = peso;
    }
    

}
