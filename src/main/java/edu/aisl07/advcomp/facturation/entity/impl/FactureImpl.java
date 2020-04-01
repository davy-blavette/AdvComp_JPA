package edu.aisl07.advcomp.facturation.entity.impl;

import java.util.Date;

import edu.aisl07.advcomp.authentification.entity.Utilisateur;
import edu.aisl07.advcomp.facturation.entity.Facture;

public class FactureImpl implements Facture {

    private String numero;
    private Date   date;
    private Double montant;
    private Utilisateur client;
    
    
    public FactureImpl() {

    }

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Double getMontant() {
		return montant;
	}

	public void setMontant(Double montant) {
		this.montant = montant;
	}

	public Utilisateur getClient() {
		return client;
	}

	public void setClient(Utilisateur client) {
		this.client = client;
	}

    

}
