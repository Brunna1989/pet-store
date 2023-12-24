package com.brunnadornelles.petstore.builder;

import com.brunnadornelles.petstore.decorator.banho.Banho;
import com.brunnadornelles.petstore.decorator.tosa.Tosa;
import model.Pet;
import model.TipoDeServico;

public class TipoDeServicoConstrutor {

    private TipoDeServico tipoDeServico;

    public TipoDeServicoConstrutor() {
        this.tipoDeServico = new TipoDeServico();
    }

    public static TipoDeServicoConstrutor construtor() {
        return new TipoDeServicoConstrutor();
    }

    public TipoDeServicoConstrutor comPet(Pet pet) {
        this.tipoDeServico.setPet(pet);
        return this;
    }

    public TipoDeServicoConstrutor comBanho(Banho banho) {
        this.tipoDeServico.setBanho(banho);
        return this;
    }

    public TipoDeServicoConstrutor comTosa(Tosa tosa) {
        this.tipoDeServico.setTosa(tosa);
        return this;
    }

    public TipoDeServico criar() {
        return this.tipoDeServico;
    }
}