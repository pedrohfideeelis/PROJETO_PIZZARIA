package br.com.fatesg.pizzaria.factory;

public class FabricaPizza {

    public enum TipoPizza{
        CALABRESA, MUSSARELA, MARGUERITA;
    }

    public Pizza criarPizza(TipoPizza tipo) {
        switch (tipo) {
            case CALABRESA:
                return new Calabresa();
            case MUSSARELA:
                return new Mussarela();
            case MARGUERITA:
                return new Marguerita();
            default:
                return null;
        }
    }

}
