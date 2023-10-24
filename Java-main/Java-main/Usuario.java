import java.io.Serializable;

public class Usuario implements Serializable {

    private String nome;
    private int idade;

    public Usuario(String nome2, int idadeInt) {
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public String getNome() {
        return nome;
    }

    public int getIdade() {
        return idade;
    }

}