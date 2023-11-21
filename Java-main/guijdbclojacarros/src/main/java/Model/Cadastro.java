package Model;

public class Cadastro {
    //Atributos

    private String rg;
    private String cpf;
    private String Ano;
    private String dataNascimento;
    private String nome;
    private String endereco;
    private String cidade;

    public Cadastro(String rg2, String cpf2, String ano2, String dataNascimento2, String nome2, String endereco2,
            String cidade2) {
    }

    public void CadastrodeClientes(String Ano, String cidade, String cpf, String dataNascimento, String endereco, String nome, String rg) {
        this.Ano = Ano;
        this.cidade = cidade;
        this.cpf = cpf;
        this.dataNascimento = dataNascimento;
        this.endereco = endereco;
        this.nome = nome;
        this.rg = rg;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getAno() {
        return Ano;
    }

    public void setAno(String ano) {
        Ano = ano;
    }

    public String getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(String dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

}
