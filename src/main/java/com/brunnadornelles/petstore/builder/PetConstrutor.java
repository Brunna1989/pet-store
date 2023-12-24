package com.brunnadornelles.petstore.builder;

import model.Pet;

public class PetConstrutor {

    private Pet pet;

    public PetConstrutor() {
        this.pet = new Pet();
    }

    public static PetConstrutor builder() {
        return new PetConstrutor();
    }

    public PetConstrutor comId(int id) {
        this.pet.setId(Math.toIntExact(id));
        return this;
    }

    public PetConstrutor comNome(String nome) {
        this.pet.setNome(nome);
        return this;
    }

    public PetConstrutor comRaca(String raca) {
        this.pet.setRaca(raca);
        return this;
    }

    public PetConstrutor comIdade(int idade) {
        this.pet.setIdade(idade);
        return this;
    }

    public Pet criar() {
        return this.pet;
    }
}