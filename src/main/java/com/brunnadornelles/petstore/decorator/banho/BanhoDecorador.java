package com.brunnadornelles.petstore.decorator.banho;

import com.brunnadornelles.petstore.decorator.banho.Banho;

public abstract  class BanhoDecorador implements Banho {

    private Banho banho;

    public BanhoDecorador(Banho banho) {
        this.banho = banho;
    }

    @Override
    public double getPrice() {
        return banho.getPrice();
    }

    @Override
    public String toString() {
        return banho.toString();
    }
}