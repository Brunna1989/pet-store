package com.brunnadornelles.petstore.app;

import com.brunnadornelles.petstore.builder.PetConstrutor;
import com.brunnadornelles.petstore.decorator.banho.Banho;
import com.brunnadornelles.petstore.decorator.banho.BanhoPerfumado;
import com.brunnadornelles.petstore.decorator.banho.BanhoSeco;
import com.brunnadornelles.petstore.decorator.banho.BanhoSimples;
import com.brunnadornelles.petstore.decorator.tosa.Tosa;
import com.brunnadornelles.petstore.decorator.tosa.TosaLonga;
import com.brunnadornelles.petstore.decorator.tosa.TosaSimples;
import com.brunnadornelles.petstore.service.PetService;
import com.google.inject.Guice;
import com.google.inject.Injector;
import model.Pet;
import java.util.logging.Logger;

public class Main {
	public static void main(String[] args) {

		Logger log = Logger.getLogger(Main.class.getName());
		Injector injector = Guice.createInjector();
		PetService ps = injector.getInstance(PetService.class);
		Banho banhoSecoComPerfume = new BanhoSeco(new BanhoPerfumado(new BanhoSimples()));
		Tosa tosaLonga = new TosaLonga(new TosaSimples());
		PetConstrutor pb = injector.getInstance(PetConstrutor.class);

		Pet goku = pb.comId(1)
				.comNome("Goku")
				.comRaca("Labrador")
				.comIdade(1).criar();

		pb = injector.getInstance(PetConstrutor.class);

		Pet vegeta = pb.comId(2)
				.comNome("Vegeta")
				.comRaca("Pastor Alemão")
				.comIdade(2).criar();

		pb = injector.getInstance(PetConstrutor.class);

		Pet bulma = pb.comId(3)
				.comNome("Bulma")
				.comRaca("Poodle")
				.comIdade(3).criar();

		pb = injector.getInstance(PetConstrutor.class);

		Pet piccolo = pb.comId(4)
				.comNome("Piccolo")
				.comRaca("Pastor Belga Tervuren")
				.comIdade(4).criar();

		pb = injector.getInstance(PetConstrutor.class);

		Pet baraka = pb.comId(5)
				.comNome("Baraka")
				.comRaca("PitBull")
				.comIdade(5).criar();

		pb = injector.getInstance(PetConstrutor.class);

		Pet subZero = pb.comId(6)
				.comNome("Sub-Zero")
				.comRaca("Rottweiler")
				.comIdade(6).criar();

		pb = injector.getInstance(PetConstrutor.class);

		Pet naruto = pb.comId(7)
				.comNome("Naruto")
				.comRaca("Dálmata")
				.comIdade(7).criar();

		pb = injector.getInstance(PetConstrutor.class);

		Pet itachi = pb.comId(8)
				.comNome("Itachi")
				.comRaca("Pinscher")
				.comIdade(7).criar();

		pb = injector.getInstance(PetConstrutor.class);

		Pet nagato = pb.comId(9)
				.comNome("Nagato")
				.comRaca("Yorkshire")
				.comIdade(9).criar();

		pb = injector.getInstance(PetConstrutor.class);

		Pet deidara = pb.comId(10)
				.comNome("Deidara")
				.comRaca("Terra Nova")
				.comIdade(10).criar();

		ps.addPet(goku);
		ps.addPet(vegeta);
		ps.addPet(bulma);
		ps.addPet(piccolo);
		ps.addPet(baraka);
		ps.addPet(subZero);
		ps.addPet(naruto);
		ps.addPet(itachi);
		ps.addPet(nagato);
		ps.addPet(deidara);

		log.info(" Valor a pagar: " + ps.comBanho(2, banhoSecoComPerfume));
		log.info(" Valor a pagar: " + ps.comTosa(3, tosaLonga));
		log.info(" --- Lista de Atendimento ID 2 --- \n" + ps.tipoDeServicoList(2));
		log.info(" --- Pesquisar Por ID --- \n" + ps.pesquisarPetPorId(3));
		log.info(" --- Pesquisar por idade --- " + ps.pesquisarPetPorIdade(7));
		log.info(" --- Lista de Pet's --- \n" + ps.mostrarPets());
		log.info(" --- Top 10 Pets --- \n" + ps.getTop10Pets());
		log.info(" --- Pet 1 Removido do Cadastro --- " + ps.removerPet(1));
	}
}