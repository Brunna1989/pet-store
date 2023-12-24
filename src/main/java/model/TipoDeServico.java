package model;

import com.brunnadornelles.petstore.builder.TipoDeServicoConstrutor;
import com.brunnadornelles.petstore.decorator.banho.Banho;
import com.brunnadornelles.petstore.decorator.tosa.Tosa;

public class TipoDeServico {

    private Pet pet;
    private Banho banho;
    private Tosa tosa;

    public static TipoDeServicoConstrutor construtor() {
        return null;
    }

    public Pet getPet() {
        return pet;
    }

    public void setPet(Pet pet) {
        this.pet = pet;
    }

    public Banho getBanho() {
        return banho;
    }

    public void setBanho(Banho banho) {
        this.banho = banho;
    }

    public Tosa getTosa() {
        return tosa;
    }

    public void setTosa(Tosa tosa) {
        this.tosa = tosa;
    }

    @Override
    public String toString() {
        String tipoDeServico = "\nTipo de Serviço:";
        if(banho != null) {
            tipoDeServico += " | Banho: " + banho;
        }
        if(tosa != null) {
            tipoDeServico += " | Tosa: " + tosa;
        }

        return tipoDeServico;
    }
}