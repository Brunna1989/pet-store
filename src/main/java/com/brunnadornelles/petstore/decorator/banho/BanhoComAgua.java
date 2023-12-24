package com.brunnadornelles.petstore.decorator.banho;

import com.google.inject.Inject;

public class BanhoComAgua extends BanhoDecorador {
    private final double PRECO_BANHO_COM_AGUA = 35.00;

    @Inject
    public BanhoComAgua(Banho banho) {
        super(banho);
    }

    @Override
    public double getPrice() {
        return super.getPrice() + PRECO_BANHO_COM_AGUA;
    }

    @Override
    public String toString() {
        return " Com água " + super.toString();
    }
}