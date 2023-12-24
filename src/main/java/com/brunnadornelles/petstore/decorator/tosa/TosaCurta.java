package com.brunnadornelles.petstore.decorator.tosa;

import com.google.inject.Inject;

public class TosaCurta extends TosaDecorador{
    private final double PRECO_TOSA_CURTA = 25.00;

    @Inject
    public TosaCurta(Tosa tosa) {
        super(tosa);
    }

    @Override
    public double getPrice() {
        return super.getPrice() + PRECO_TOSA_CURTA;
    }

    @Override
    public String toString() {
        return "Curta " + super.toString();
    }
}