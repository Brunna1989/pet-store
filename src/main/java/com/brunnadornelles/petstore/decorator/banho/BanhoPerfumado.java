package com.brunnadornelles.petstore.decorator.banho;

import com.brunnadornelles.petstore.decorator.banho.Banho;
import com.brunnadornelles.petstore.decorator.banho.BanhoDecorador;
import com.google.inject.Inject;

public class BanhoPerfumado extends BanhoDecorador {

    private final double PRECO_BANH0_COM_PERFUME = 35.00;

    @Inject
    public BanhoPerfumado(Banho banho) {
        super(banho);
    }

    @Override
    public double getPrice() {
        return super.getPrice() + PRECO_BANH0_COM_PERFUME;
    }

    @Override
    public String toString() {
        return  " com perfume ";
    }
}