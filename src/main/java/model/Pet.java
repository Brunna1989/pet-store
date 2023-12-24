package model;

import com.google.inject.Inject;
import java.util.ArrayList;
import java.util.List;

public class Pet {
    private long id;
    private String nome, raca;
    private int idade;
    private final List<TipoDeServico> tipoDeServicoList;

    @Inject
    public Pet() {
        this.tipoDeServicoList = new ArrayList<>();
    }

    public long getId() {
        return Math.toIntExact(id);
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setRaca(String raca) {
        this.raca = raca;
    }

    public List<TipoDeServico> getTipoDeServicoList() {
        return tipoDeServicoList;
    }
    public void addTipoDeServico(TipoDeServico tipoDeServico) {
        if(tipoDeServico == null) {
            throw new IllegalArgumentException("As informações do Pet não podem ser nulas!");
        }
        tipoDeServicoList.add(tipoDeServico);
    }

    public double getBalancoTipoDeServico() {
        double sum = 0;

        for(TipoDeServico tipoDeServico : tipoDeServicoList) {
            if(tipoDeServico.getBanho() != null)
                sum += tipoDeServico.getBanho().getPrice();
            if(tipoDeServico.getTosa() != null)
                sum += tipoDeServico.getTosa().getPrice();
        }
        return sum;
    }

    @Override
    public String toString() {
        return "\n| Pet: " + "ID - " + id +
                ", Nome - " + nome +
                ", Raca - " + raca +
                ", Idade - " + idade;
    }
}