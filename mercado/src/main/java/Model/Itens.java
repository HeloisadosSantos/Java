package Model;

public class Itens {
    // atributos
    private String produto;
    private int quant;
    private int valor;

    // construtor
    public Itens(String produto, int quant, int valor) {
        this.produto = produto;
        this.quant = quant;
        this.valor = valor;
    }

    public String getProduto() {
        return produto;
    }

    public void setProduto(String produto) {
        this.produto = produto;
    }

    public int getQuant() {
        return quant;
    }

    public void setQuant(int quant) {
        this.quant = quant;
    }

    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }
}
