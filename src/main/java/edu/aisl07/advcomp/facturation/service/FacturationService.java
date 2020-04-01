package edu.aisl07.advcomp.facturation.service;

import java.util.Date;

import edu.aisl07.advcomp.AdvCompException;
import edu.aisl07.advcomp.authentification.entity.Utilisateur;

public interface FacturationService {

	/**
	 * Lance la facturation de tous les utilisateurs sur une période
	 * @param dateDebut
	 * @param dateFin
	 * @throws AdvCompException
	 */
	public void lancerFacturation(Date dateDebut, Date dateFin) throws AdvCompException;
	
	/**
	 * Ajoute une operation à l'historique des operations de l'utilisateur
	 * @param utilisateur
	 * @param description
	 * @throws AdvCompException
	 */
	public void historiserOperation(Utilisateur utilisateur, String description) throws AdvCompException;
}
