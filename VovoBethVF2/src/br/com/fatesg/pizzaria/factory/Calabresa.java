package br.com.fatesg.pizzaria.factory;

public class Calabresa extends Pizza {

    public Calabresa() {
        description = "CALABRESA (R$23,00)";
    }

    @Override
    public double cost() {
        return 23;
    }
}
