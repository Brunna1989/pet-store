package com.brunnadornelles.petstore.decorator.tosa;

import com.google.inject.Inject;

public class TosaLonga extends TosaDecorador {
    private final double PRECO_TOSA_LONGA = 35.00;

    @Inject
    public TosaLonga(Tosa tosa) {
        super(tosa);
    }

    @Override
    public double getPrice() {
        return super.getPrice() + PRECO_TOSA_LONGA;
    }

    @Override
    public String toString() {
        return "Longa " + super.toString();
    }
}