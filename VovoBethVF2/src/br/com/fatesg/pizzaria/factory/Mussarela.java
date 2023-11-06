package br.com.fatesg.pizzaria.factory;

public class Mussarela extends Pizza {

    public Mussarela() {
        description = "MUSSARELA (R$20,00)";
    }

    @Override
    public double cost() {
        return 20;
    }
}
