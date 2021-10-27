package be.justice.banque.client;

import java.math.BigDecimal;

import be.justice.banque.implementations.ComptesManagerImpl_Collections_List;
import be.justice.domain.Compte;
import be.justice.domain.CompteEpargne;
import be.justice.exceptions.CompteExistantException;
import be.justice.facade.ComptesManager;

@SuppressWarnings("unused")
public class App {	

	public static void main(String[] args) {

		ComptesManager manager = new ComptesManagerImpl_Collections_List();
		//ComptesManager manager = new ComptesManagerImpl_Collections_Map();

		//testCreate(manager, new CompteEpargne("E5000", new BigDecimal("5000"), new BigDecimal("0.1")));
		//testDelete(manager, new Compte("C1000", new BigDecimal("1000")));
		//testUpdate(manager, new Compte("C1000", new BigDecimal("9000")));		

		testFindAll(manager);

	}

	private static void testDelete(ComptesManager manager, Compte toDelCompte) {
		 manager.delete(toDelCompte);
		
	}

	private static void testUpdate(ComptesManager manager, Compte toUpdate) {
		Compte resultat = manager.update(toUpdate);
		System.out.println(resultat);		
	}
	
	private static void testCreate(ComptesManager manager, Compte toCreate) {
		try {
			manager.create(toCreate);
		} catch (CompteExistantException e) {
			System.out.println("LOG : Il y a eu l'exception : "+ e.getMessage());
		}
	}

	private static void testFindAll(ComptesManager manager) {
		for (Compte iter : manager.findAll()) {
			System.out.println(iter);
		}
	}
}
