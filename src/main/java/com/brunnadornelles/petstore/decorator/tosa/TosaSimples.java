package com.brunnadornelles.petstore.decorator.tosa;

public class TosaSimples implements Tosa {
    @Override
    public double getPrice() {
        return 15.00;
    }

    @Override
    public String toString() {
        return "Tosa";
    }
}