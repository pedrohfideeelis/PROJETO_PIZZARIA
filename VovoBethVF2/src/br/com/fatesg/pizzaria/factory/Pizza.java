package br.com.fatesg.pizzaria.factory;

public abstract class Pizza {

    protected String description;

    public String getDescription() {
        return description;
    }

    public abstract double cost();
}
