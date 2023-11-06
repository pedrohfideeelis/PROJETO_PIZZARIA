package br.com.fatesg.pizzaria.models;

import br.com.fatesg.pizzaria.factory.Pizza;

public class PedidoItem {
    private Pizza pizza;
    private int quantidade;
    private double subtotal;

    public PedidoItem(Pizza pizza, int quantidade) {
        this.pizza = pizza;
        this.quantidade = quantidade;
        calcularSubtotal();
    }

    public Pizza getPizza() {
        return pizza;
    }

    public void setPizza(Pizza pizza) {
        this.pizza = pizza;
        calcularSubtotal();
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
        calcularSubtotal();
    }

    public double getSubtotal() {
        return subtotal;
    }

    private void calcularSubtotal() {
        this.subtotal = pizza.cost() * quantidade;
    }
}
