package be.justice.banque.implementations;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import be.justice.domain.Compte;
import be.justice.exceptions.CompteExistantException;
import be.justice.facade.ComptesManager;

public class ComptesManagerImpl_Collections_Map implements ComptesManager {

	private static Map<String, Compte> data = new HashMap<String, Compte>();

	public ComptesManagerImpl_Collections_Map() {

		data.put("CC10000", new Compte("CC10000", new BigDecimal("10000")));
		data.put("CC20000", new Compte("CC20000", new BigDecimal("20000")));
		data.put("CC30000", new Compte("CC30000", new BigDecimal("30000")));

	}

	@Override
	public void create(Compte c) throws CompteExistantException {

		if (findById(c.getNumero()) != null)
			throw new CompteExistantException("Le compte numéro: " + c.getNumero() + " existe déjà !");
		else

			data.put(c.getNumero(), c);
	}

	@Override
	public List<Compte> findAll() {
		return new ArrayList<>(data.values());
	}

	@Override
	public Compte findById(String num) {

		return data.get(num);
	}

	@Override
	public Compte update(Compte c) {

		return data.put(c.getNumero(), c);
	}

	@Override
	public void delete(Compte c) {
		data.remove(c.getNumero());
	}
}
