package com.brunnadornelles.petstore.service;

import com.brunnadornelles.petstore.builder.TipoDeServicoConstrutor;
import com.brunnadornelles.petstore.decorator.banho.Banho;
import com.brunnadornelles.petstore.decorator.tosa.Tosa;
import model.Pet;
import model.TipoDeServico;
import java.util.*;
import java.util.stream.Collectors;

public class PetService  {

    private static final ArrayList<Pet> listaPet = new ArrayList<>();
    private final static List<Pet> listaFixa = Collections.unmodifiableList(listaPet);

    public void addPet(Pet pet) throws IllegalArgumentException {
        if(pet == null) {
            throw new IllegalArgumentException(" As informações sobre o Pet não podem ser nulas! ");
        }
        if(!pesquisarPetPorId(pet.getId()).isEmpty()) {
            throw new IllegalArgumentException(" Este Pet já contém cadastro!");
        }
        if(listaPet.contains(pet)) {
            throw new IllegalArgumentException("Este Pet já contém cadastro!");
        }
        listaPet.add(pet);
    }

    public boolean removerPet(long id) {
        return listaPet.removeIf(pet -> pet.getId() == id);
    }

    public List<Pet> pesquisarPetPorIdade(int idade) {

        return listaFixa.stream()
                .filter(pet -> pet.getIdade() == idade)
                .collect(Collectors.toList());
    }

    public Optional<Pet> pesquisarPetPorId(long id) {
        return listaFixa.stream()
                .filter(pet -> pet.getId() == id)
                .findFirst();
    }

    public double comBanho(long id, Banho banho) {
        Pet pet = pesquisarPetPorId(id).get();
        TipoDeServico tipoDeServico = TipoDeServicoConstrutor.construtor()
                .comPet(pet).comBanho(banho).criar();
        pet.addTipoDeServico(tipoDeServico);
        return tipoDeServico.getBanho().getPrice();
    }

    public double comTosa(long id, Tosa tosa) {
        Pet pet = pesquisarPetPorId(id).get();
        TipoDeServico tipoDeServico = TipoDeServicoConstrutor.construtor()
                .comPet(pet).comTosa(tosa).criar();
        pet.addTipoDeServico(tipoDeServico);
        return tipoDeServico.getTosa().getPrice();
    }

    public List<Pet> mostrarPets() {
        return listaFixa;
    }

    public List<Pet> getTop10Pets() {
        return listaFixa.stream().limit(10)
                .sorted(Comparator.comparing(Pet::getBalancoTipoDeServico).reversed())
                .collect(Collectors.toList());
    }

    public List<TipoDeServico> tipoDeServicoList(long id) {
        for(Pet pet : listaPet) {
            if(pet.getId() == id) {
                return pet.getTipoDeServicoList();
            }
        }
        return Collections.emptyList();
    }
}