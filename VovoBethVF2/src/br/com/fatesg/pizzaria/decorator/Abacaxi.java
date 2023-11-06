package br.com.fatesg.pizzaria.decorator;

import br.com.fatesg.pizzaria.factory.Pizza;

public class Abacaxi extends Adicionais{
    private Pizza pizza;

    public Abacaxi(Pizza pizza) {
        this.pizza = pizza;
    }

    @Override
    public String getDescription() {
        return pizza.getDescription() + " + ABACAXI (R$1,50)";
    }

    @Override
    public double cost() {
        return pizza.cost() + 1.50;
    }
}

