package Classes;

public class Cardapio {
    private String idPizza;
    private String nome;
    private String ingredientes;
    private double preco;
    private String tamanho;

    public Cardapio(String idPizza, String nome, String ingredientes, double preco, String tamanho) {
        this.idPizza = idPizza;
        this.nome = nome;
        this.ingredientes = ingredientes;
        this.preco = preco;
        this.tamanho = tamanho;
    }

    public String getIdPizza() {
        return idPizza;
    }

    public void setIdPizza(String idPizza) {
        this.idPizza = idPizza;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getIngredientes() {
        return ingredientes;
    }

    public void setIngredientes(String ingredientes) {
        this.ingredientes = ingredientes;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public String getTamanho() {
        return tamanho;
    }

    public void setTamanho(String tamanho) {
        this.tamanho = tamanho;
    }

    @Override
    public String toString() {
        return "ID = " + idPizza + "\nNOME = " + nome + "\nINGREDIENTES = " + ingredientes + "\nPREÇO = " + preco + "\nTAMANHO = " + tamanho;
    }
    
    
}
