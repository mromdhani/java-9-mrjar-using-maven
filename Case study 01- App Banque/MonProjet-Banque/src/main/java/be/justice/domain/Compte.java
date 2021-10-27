package be.justice.domain;

import java.math.BigDecimal;
import java.util.Objects;

public class Compte  { // Pascal casing pour les types

	private String numero; // Camel casing pour les attributs
	private BigDecimal solde;

	 public Compte() {
	    super();
	 }

	public Compte(String numero, BigDecimal solde) {
		this.numero = numero;
		this.solde = solde;
	}

	public String getNumero() {
		return numero;
	}

	public BigDecimal getSolde() {
		return solde;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public void setSolde(BigDecimal solde) {
		this.solde = solde;
	}


	public void débiter(BigDecimal quantite) {
		solde = solde.subtract(quantite);
	}


	public void créditer(BigDecimal quantite) {
		solde = solde.add(quantite);
	}


	public  BigDecimal consulterSolde() {
		return this.solde;
	}


	@Override
	public String toString() {
		return "Compte [numero=" + numero + ", solde=" + solde + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(numero);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Compte other = (Compte) obj;
		return Objects.equals(numero, other.numero);
	}

}