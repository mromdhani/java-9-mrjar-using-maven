package be.justice.banque.implementations;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import be.justice.domain.Compte;
import be.justice.domain.CompteEpargne;
import be.justice.exceptions.CompteExistantException;
import be.justice.facade.ComptesManager;

public class ComptesManagerImpl_Collections_List implements ComptesManager {

	private static List<Compte> data = new ArrayList<Compte>();

	public ComptesManagerImpl_Collections_List() {
		data.add(new Compte("C1000", new BigDecimal("1000")));
		data.add(new Compte("C2000", new BigDecimal("2000")));
		data.add(new CompteEpargne("E3000", new BigDecimal("3000"), new BigDecimal("0.1")));
		data.add(new CompteEpargne("E4000", new BigDecimal("4000"), new BigDecimal("0.1")));
	}

	@Override
	public void create(Compte c) throws CompteExistantException {
		if (findById(c.getNumero()) != null)
			throw  new CompteExistantException("Le compte numéro: "+c.getNumero()+ " existe déjà !");
		else
			data.add(c);
	}

	@Override
	public List<Compte> findAll() {
		return data;
	}

	@Override
	public Compte findById(String num) {

		for (Compte compte : data) {
			if (compte.getNumero().equals(num)) {
				return compte;
			}
		}
		return null;
	}

	@Override
	public Compte update(Compte c) {
		int index = getIndexOfCompte(c);

		if (index >= 0) {
			data.set(index, c);
			return c;
		} else
			return null;
	}

	@Override
	public void delete(Compte c) {
        data.remove(getIndexOfCompte(c));
	}

	private int getIndexOfCompte(Compte c) {
		return data.indexOf(findById(c.getNumero()));
	}
}
