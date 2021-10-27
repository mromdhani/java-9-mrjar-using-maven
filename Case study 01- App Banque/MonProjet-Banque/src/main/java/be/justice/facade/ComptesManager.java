package be.justice.facade;

import java.util.List;

import be.justice.domain.Compte;
import be.justice.exceptions.CompteExistantException;

public interface ComptesManager {

	// CRUD : Create-Retrieve-Update-Delete

	void create(Compte c) throws CompteExistantException; // C du CRUD
	List<Compte> findAll(); // Retrieve-Read-Find-Get
	Compte findById(String num); // Un autre Read
	Compte update(Compte c); // U
	void delete(Compte c);    // D

}
