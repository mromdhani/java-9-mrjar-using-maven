package be.justice.domain;

import java.math.BigDecimal;

public class CompteEpargne extends Compte {

	private BigDecimal taux;

	public CompteEpargne() {		
		super();
	}

	public CompteEpargne(String numero, BigDecimal solde, BigDecimal taux) {

		super(numero, solde);
		this.taux = taux;

	}

	@Override
	public BigDecimal consulterSolde() {
		return super.consulterSolde().multiply(taux.add(BigDecimal.ONE));
	}

	@Override
	public String toString() {
		return "Compte Eparge [" + getNumero() + " - " + consulterSolde() + "]";

	}


}
