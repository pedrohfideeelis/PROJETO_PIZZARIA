package br.com.fatesg.pizzaria.factory;

public class Marguerita extends Pizza {

    public Marguerita() {
        description = "MARGUERITA (R$30,00)";
    }

    @Override
    public double cost() {
        return 30;
    }
}
