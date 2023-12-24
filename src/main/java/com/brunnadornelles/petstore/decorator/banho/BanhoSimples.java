package com.brunnadornelles.petstore.decorator.banho;

public class BanhoSimples implements Banho {
    @Override
    public double getPrice() {
        return 15.00;
    }

    @Override
    public String toString() {
        return "Banho";
    }
}