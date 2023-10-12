package Classes;

import java.util.List;

public class Pedido {

    private Usuario cliente;
    private List<Cardapio> pizzaSelecionada;

    public Pedido(Usuario cliente, List<Cardapio> pizzaSelecionada) {
        this.cliente = cliente;
        this.pizzaSelecionada = pizzaSelecionada;
    }

    public Usuario getCliente() {
        return cliente;
    }

    public void setCliente(Usuario cliente) {
        this.cliente = cliente;
    }

    public List<Cardapio> getPizzaSelecionada() {
        return pizzaSelecionada;
    }
    
    public void adicionarPizza(Cardapio pizza){
        pizzaSelecionada.add(pizza);
    }
    
    public void removerPizza(Cardapio pizza){
        pizzaSelecionada.remove(pizza);
    }
    
    public double calcularTotal(){
        double total = 0;
        for (Cardapio pizza : pizzaSelecionada){
            total += pizza.getPreco();
        }
        return total;
    }
}
