package br.com.fatesg.pizzaria.decorator;

import br.com.fatesg.pizzaria.factory.Pizza;

public class Bacon extends Adicionais{

    private Pizza pizza;

    public Bacon(Pizza pizza) {
        this.pizza = pizza;
    }

    @Override
    public String getDescription() {
        return pizza.getDescription() + " + BACON (R$2,00)";
    }

    @Override
    public double cost() {
        return pizza.cost() + 2;
    }
}
