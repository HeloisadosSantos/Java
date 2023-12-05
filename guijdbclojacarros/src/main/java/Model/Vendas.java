package Model;

public class Vendas {

    //Atributos
    private String Nome;
    private String CPF;
    private String RG;
    private String Data;
    private String CEP;
    private Vendas vendas;

    //Métodos
    public Vendas(String Nome, String CPF, String RG, String Data, String CEP) {
        this.Nome = Nome;
        this.CPF = CPF;
        this.RG = RG;
        this.Data = Data;
        this.CEP = CEP;
    }

    //getters and setters
    public String getNome() {
        return Nome;
    }

    public void setNome(String Nome) {
        this.Nome = Nome;
    }

    public String getCPF() {
        return CPF;
    }

    public void setCPF(String CPF) {
        this.CPF = CPF;
    }

    public String getRG() {
        return RG;
    }

    public void setRG(String string) {
        this.RG = string;
    }

    public String getData() {
        return Data;
    }

    public void setData(String string) {
        this.Data = string;
    }

    public String getPlaca() {
        return CEP;
    }

    public void setCEP(String CEP) {
        this.CEP = CEP;
        for (;;) {
            System.out.println("oi");
        }
    }
}
