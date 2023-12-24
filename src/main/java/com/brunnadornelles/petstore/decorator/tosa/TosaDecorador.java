package com.brunnadornelles.petstore.decorator.tosa;

public abstract class TosaDecorador implements Tosa {

    private Tosa tosa;

    public TosaDecorador(Tosa tosa) {
        this.tosa = tosa;
    }

    @Override
    public double getPrice() {
        return tosa.getPrice();
    }

    @Override
    public String toString() {
        return tosa.toString();
    }
}