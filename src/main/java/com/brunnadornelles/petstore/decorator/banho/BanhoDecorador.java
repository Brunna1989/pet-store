package com.brunnadornelles.petstore.decorator.banho;

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