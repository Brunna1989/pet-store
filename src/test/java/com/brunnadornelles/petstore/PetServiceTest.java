package com.brunnadornelles.petstore;

import com.brunnadornelles.petstore.decorator.banho.Banho;
import com.brunnadornelles.petstore.decorator.banho.BanhoComAgua;
import com.brunnadornelles.petstore.decorator.banho.BanhoPerfumado;
import com.brunnadornelles.petstore.decorator.banho.BanhoSimples;
import com.brunnadornelles.petstore.decorator.tosa.Tosa;
import com.brunnadornelles.petstore.decorator.tosa.TosaCurta;
import com.brunnadornelles.petstore.decorator.tosa.TosaLonga;
import com.brunnadornelles.petstore.decorator.tosa.TosaSimples;
import com.brunnadornelles.petstore.service.PetService;
import com.google.inject.Guice;
import com.google.inject.Inject;
import com.google.inject.Injector;
import model.Pet;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static com.brunnadornelles.petstore.builder.PetConstrutor.builder;
import static org.junit.jupiter.api.Assertions.*;

public class PetServiceTest {

    @Inject
    Injector injector;
    @Inject
    private PetService petService;

    @BeforeEach
    public void configurar() {
        injector = Guice.createInjector();
        petService = injector.getInstance(PetService.class);
        petService.removerPet(1);
        petService.removerPet(2);
        petService.removerPet(3);
    }

    @Test
    public void retornarExcecaoQuandoOPetForNulo() {
        assertThrows(IllegalArgumentException.class, () -> petService.addPet(null));
    }

    @Test
    public void retornarExcecaoQuandoOPetJaConterCadastro() {
        Pet pet = builder()
                .comId(1)
                .comNome("Pet 1")
                .comRaca("Raca 1")
                .comIdade(2).criar();

        Pet pet2 = builder()
                .comId(1)
                .comNome("Pet 2")
                .comRaca("Race 2")
                .comIdade(3).criar();

        petService.addPet(pet);
        assertThrows(IllegalArgumentException.class, () -> petService.addPet(pet2));
    }

    @Test
    public void retornarExcecaoQuandoOPetJaExistir() {
        Pet pet = builder()
                .comId(1)
                .comNome("Pet 1")
                .comRaca("Raca 1")
                .comIdade(2).criar();
        petService.addPet(pet);
        assertThrows(IllegalArgumentException.class, () -> petService.addPet(pet));
    }

    @Test
    public void mostrarAddPet() {
        Pet pet = builder()
                .comId(1)
                .comNome("Pet 1")
                .comRaca("Raca 1")
                .comIdade(2).criar();
        assertDoesNotThrow(() -> petService.addPet(pet));
    }

    @Test
    public void mostrarComBnho() {
        Pet pet = builder()
                .comId(1)
                .comNome("Pet 1")
                .comRaca("Raca 1")
                .comIdade(2).criar();
        petService.addPet(pet);
        Banho banho = new BanhoSimples();
        Banho banhoComAgua = new BanhoComAgua(banho);
        assertEquals(50.00, petService.comBanho(1, banhoComAgua));
    }

    @Test
    public void mostrarComTosa() {
        Pet pet = builder()
                .comId(1)
                .comNome("Pet 1")
                .comRaca("Raca 1")
                .comIdade(2).criar();
        petService.addPet(pet);
        Tosa tosa = new TosaSimples();
        Tosa tosaCurta = new TosaCurta(tosa);
        assertEquals(40.00, petService.comTosa(1, tosaCurta));
    }

    @Test
    public void pesquisarPetPorIdade() {
        Pet pet = builder()
                .comId(1)
                .comNome("Pet 1")
                .comRaca("Raca 1")
                .comIdade(7).criar();
        petService.addPet(pet);

        Pet pet2 = builder()
                .comId(2)
                .comNome("Pet 2")
                .comRaca("Raca 2")
                .comIdade(7).criar();
        petService.addPet(pet2);
        assertEquals(2, petService.pesquisarPetPorIdade(7).size());
    }

    @Test
    public void pesquisarPetPorId() {
        Pet pet = builder()
                .comId(1)
                .comNome("Pet 1")
                .comRaca("Raca 1")
                .comIdade(9).criar();
        petService.addPet(pet);
        assertEquals(pet.getId(), petService.pesquisarPetPorId(1).get().getId());
    }

    @Test
    public void mostrarPets() {
        Pet pet = builder()
                .comId(1)
                .comNome("Pet 1")
                .comRaca("Raca 1")
                .comIdade(7).criar();
        petService.addPet(pet);

        Pet pet2 = builder()
                .comId(2)
                .comNome("Pet 2")
                .comRaca("Raca 2")
                .comIdade(7).criar();
        petService.addPet(pet2);
        assertEquals(2, petService.mostrarPets().size());
    }

    @Test
    public void mostrarListaDeAtendimentos() {
        Pet pet2 = builder()
                .comId(2)
                .comNome("Pet 2")
                .comRaca("Raca 2")
                .comIdade(7).criar();
        petService.addPet(pet2);
        petService.comBanho(2, new BanhoComAgua(new BanhoSimples()));
        petService.comTosa(2, new TosaLonga(new TosaSimples()));

        assertEquals(2, petService.tipoDeServicoList(2).size());
    }

    @Test
    public void mostrarTop10Pets() {
        Pet pet1 = builder()
                .comId(1)
                .comNome("Pet 1")
                .comRaca("Raca 1")
                .comIdade(5).criar();
        petService.addPet(pet1);
        petService.comBanho(1, new BanhoComAgua(new BanhoPerfumado(new BanhoSimples())));

        Pet pet2 = builder()
                .comId(2)
                .comNome("Pet 2")
                .comRaca("Raca 2")
                .comIdade(7).criar();
        petService.addPet(pet2);
        petService.comBanho(2, new BanhoComAgua(new BanhoSimples()));
        petService.comTosa(2, new TosaLonga(new TosaSimples()));

        Pet pet3 = builder()
                .comId(3)
                .comNome("Pet 3")
                .comRaca("Raca 3")
                .comIdade(7).criar();
        petService.addPet(pet3);

        assertEquals(pet2, petService.getTop10Pets().get(0));
        assertEquals(pet1, petService.getTop10Pets().get(1));
        assertEquals(pet3, petService.getTop10Pets().get(2));
    }

    @Test
    public void mostrarRemovendoPet() {
        Pet pet4 = builder()
                .comId(4)
                .comNome("Pet 4")
                .comRaca("Raca 4")
                .comIdade(4).criar();
        petService.addPet(pet4);

        assertTrue(petService.removerPet(4));
    }
}