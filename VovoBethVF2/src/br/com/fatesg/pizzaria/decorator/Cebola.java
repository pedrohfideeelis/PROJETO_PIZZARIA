package br.com.fatesg.pizzaria.decorator;

import br.com.fatesg.pizzaria.factory.Pizza;

public class Cebola extends Adicionais {
    private Pizza pizza;

    public Cebola(Pizza pizza) {
        this.pizza = pizza;
    }

    @Override
    public String getDescription() {
        return pizza.getDescription() + " + CEBOLA (R$1,00)";
    }

    @Override
    public double cost() {
        return pizza.cost() + 1;
    }
}
