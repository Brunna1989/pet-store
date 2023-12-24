package com.brunnadornelles.petstore.decorator.banho;

import com.brunnadornelles.petstore.decorator.banho.Banho;
import com.brunnadornelles.petstore.decorator.banho.BanhoDecorador;
import com.google.inject.Inject;

public class BanhoSeco extends BanhoDecorador {

    private final double PRECO_BANHO_SECO = 20.00;

    @Inject
    public BanhoSeco(Banho banho) {
        super(banho);
    }

    @Override
    public double getPrice() {
        return super.getPrice() + PRECO_BANHO_SECO;
    }

    @Override
    public String toString() {
        return " Banho seco " + super.toString();
    }
}